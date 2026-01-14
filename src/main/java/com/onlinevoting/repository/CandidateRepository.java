package com.onlinevoting.repository;
import com.onlinevoting.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    public List<Candidate> findByStatus(String status);

<<<<<<< HEAD
    public List<Candidate> findByElection_Id(Long electionId);

=======
>>>>>>> 34d207b24ffd2b7fc7a88f2dce6c2cc2d2f70dee
}