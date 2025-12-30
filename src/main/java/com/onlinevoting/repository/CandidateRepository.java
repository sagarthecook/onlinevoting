package com.onlinevoting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevoting.model.Candidate;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

}
