package com.onlinevoting.service;

import com.onlinevoting.dto.CandidateResponseDTO;
import com.onlinevoting.enums.Status;
import com.onlinevoting.model.Candidate;
import com.onlinevoting.repository.CandidateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
                                                        
@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ObjectMapper objectMapper;
    private final ElectionService electionService;
    private final PartyService partyService;

    public CandidateService(CandidateRepository candidateRepository , ElectionService electionService, PartyService partyService) {
        this.candidateRepository = candidateRepository;
        this.electionService = electionService;
        this.partyService = partyService;
        this.objectMapper = new ObjectMapper();
        // Configure ObjectMapper to handle LocalDate properly
        this.objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
    }
  
    public Candidate saveCandidate(String candidate) {
       try{ Candidate candidateObj = objectMapper.readValue(candidate, Candidate.class);
        candidateObj.setActive(true);
        candidateObj.setStatus(Status.PENDING.getDisplayName());
    
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
                .map(this::toDto)
                .collect(Collectors.toList());
       
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
                candidate.getStatus()
        );
    }
}

