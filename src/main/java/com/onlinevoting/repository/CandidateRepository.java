package com.onlinevoting.repository;
import com.onlinevoting.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}