package com.onlinevoting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinevoting.dto.CandidateResponseDTO;
import com.onlinevoting.enums.Status;
import com.onlinevoting.model.Candidate;
import com.onlinevoting.repository.CandidateRepository;
import com.onlinevoting.util.UserContextHelper;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import java.io.IOException;
                                                        
@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ObjectMapper objectMapper;
    private final ElectionService electionService;
    private final PartyService partyService;
    private final EmailService emailService;
    private UserContextHelper userContextHelper;

    public CandidateService(CandidateRepository candidateRepository , ElectionService electionService, 
        PartyService partyService, EmailService emailService, UserContextHelper userContextHelper) {
        this.candidateRepository = candidateRepository;
        this.electionService = electionService;
        this.partyService = partyService;
        this.emailService = emailService;
        this.userContextHelper = userContextHelper;
        this.objectMapper = new ObjectMapper();
        // Configure ObjectMapper to handle LocalDate properly
        this.objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
    }
  
    public Candidate saveCandidate(String candidate) {
       try { 
        Candidate candidateObj = objectMapper.readValue(candidate, Candidate.class);
        candidateObj.setActive(false);
        candidateObj.setStatus(Status.PENDING.getDisplayName());
        candidateObj.setEmailId(userContextHelper.getCurrentUserEmail());
        return candidateRepository.save(candidateObj);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse candidate JSON: " + e.getMessage(), e);
        }
    }

    public List<CandidateResponseDTO> getCandidatebyStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status parameter is required.");
        }

        return candidateRepository.findByStatus(status).stream()
                .map(this::toDto).toList();
    }
    

    public void updateStatusOfcandidate(Long candidateId, String status,String noteForStatus) {
         Candidate candidate = candidateRepository.findById(candidateId)
                 .orElseThrow(() -> new IllegalArgumentException("Candidate not found with id: " + candidateId));        
         candidate.setStatus(status);
         candidate.setActive(Boolean.TRUE);
         candidate.setNoteForStatus(noteForStatus);
         candidateRepository.save(candidate);
        
        // Send email notification using template
        sendStatusUpdateEmail(candidate, status, noteForStatus);
    }

    private void sendStatusUpdateEmail(Candidate candidate, String status, String noteForStatus) {
        try {
            emailService.sendEmailWithTemplate(
                candidate.getEmailId(),
                "Candidate Application Status Update",
                "candidate_status_update.ftl",
                createEmailTemplateData(candidate, status, noteForStatus)
            );
        } catch (MessagingException | IOException | TemplateException e) {
            // Log the error but don't fail the status update
            throw new RuntimeException("Failed to send status update email: " + e.getMessage(), e);
        }
    }

    private java.util.Map<String, Object> createEmailTemplateData(Candidate candidate, String status, String noteForStatus) {
        java.util.Map<String, Object> templateData = new java.util.HashMap<>();
        templateData.put("candidateFirstName", candidate.getFirstName());
        templateData.put("candidateMiddleName", candidate.getMiddleName());
        templateData.put("candidateLastName", candidate.getLastName());
        templateData.put("candidateEmail", candidate.getEmailId());
        templateData.put("status", status);
        templateData.put("noteForStatus", noteForStatus);
        templateData.put("statusUpdateDate", java.time.LocalDateTime.now().toString());
        templateData.put("applicationDate", candidate.getCreatedDate() != null ? candidate.getCreatedDate().toString() : java.time.LocalDateTime.now().toString());
        
        if (candidate.getParty() != null) {
            templateData.put("partyName", candidate.getParty().getName());
        }
        if (candidate.getElection() != null) {
            templateData.put("electionName", candidate.getElection().getElectionName());
        }
        
        return templateData;
    }
    
     private CandidateResponseDTO toDto(Candidate candidate) {
        String partyName = candidate.getParty().getId() != null ? candidate.getParty().getName().toString() : null;
        String electionName = candidate.getElection() != null ? candidate.getElection().getElectionName() : null;
        return new CandidateResponseDTO(
               candidate.getId(),
                candidate.getFirstName(),
                candidate.getMiddleName(),
                candidate.getLastName(),
                candidate.getOccupation(),
                candidate.getIncome(),
                partyName,
                electionName,
                candidate.getStatus(),
                candidate.getEmailId(),
                candidate.getNoteForStatus(),
                candidate.getDob() != null ? candidate.getDob().toString() : null
        );
    }
}

