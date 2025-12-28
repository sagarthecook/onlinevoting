package com.onlinevoting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinevoting.dto.ElectionResponseDto;
import com.onlinevoting.model.Election;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {

    public List<Election> findByStatus(String status);

    @Query("SELECT new com.onlinevoting.dto.ElectionResponseDto(" +
      "e.electionId, e.electionName, e.status) " +
    "FROM Election e WHERE e.status = :status")
    List<ElectionResponseDto> findElectionIdAndNameByStatus(String status);


}
