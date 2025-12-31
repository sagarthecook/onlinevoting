package com.onlinevoting.repository;
import com.onlinevoting.model.Candidate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
 
     public List<Candidate> findByStatus(String status);

}