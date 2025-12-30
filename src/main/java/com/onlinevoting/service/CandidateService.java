package com.onlinevoting.service;

import com.onlinevoting.model.Candidate;
import com.onlinevoting.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
  
    public Candidate saveCandidate(Candidate candidate) {
        candidate.setActive(true);
        return candidateRepository.save(candidate);
    }
}

