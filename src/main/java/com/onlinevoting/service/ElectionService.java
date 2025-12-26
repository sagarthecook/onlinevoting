package com.onlinevoting.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.onlinevoting.dto.ElectionResponseDto;
import com.onlinevoting.enums.Status;
import com.onlinevoting.model.Election;
import com.onlinevoting.repository.ElectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;
    private final ObjectMapper objectMapper;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
        this.objectMapper = new ObjectMapper();
        // Configure ObjectMapper to handle LocalDate properly
        this.objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
    }

    public Election saveElection(String election) {
        try {
            // Convert JSON string to Election object
            Election electionObject = objectMapper.readValue(election, Election.class);
            electionObject.setActive(true);
            electionObject.setStatus(Status.PENDING.getDisplayName());
            // Save the election object to database
            return electionRepository.save(electionObject);
            
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse election JSON: " + e.getMessage(), e);
        }
    } 

    public List<ElectionResponseDto> getAllElections() {
        return electionRepository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public List<ElectionResponseDto> getElectionsByStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status parameter is required.");
        }

        String normalizedStatus = normalizeStatus(status);

        return electionRepository.findAll().stream()
            .filter(e -> normalizedStatus.equalsIgnoreCase(e.getStatus()))
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    private String normalizeStatus(String status) {
        for (Status s : Status.values()) {
            if (s.getDisplayName().equalsIgnoreCase(status)) {
                return s.getDisplayName();
            }
        }
        throw new IllegalArgumentException("Invalid status. Allowed values: Pending, Approved, Rejected");
    }

    private ElectionResponseDto toDto(Election election) {
        return new ElectionResponseDto(
            election.getElectionId(),
            election.getElectionName(),
            election.getElectionDate(),
            election.getResultDate(),
            election.getCountry() != null ? election.getCountry().getId() : null,
            election.getState() != null ? election.getState().getId() : null,
            election.getCity() != null ? election.getCity().getId() : null,
            election.getOfficer() != null ? election.getOfficer().getId() : null,
            election.getStatus()
        );
    }
}