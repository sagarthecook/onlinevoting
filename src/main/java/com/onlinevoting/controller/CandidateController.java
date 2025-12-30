package com.onlinevoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.model.Candidate;
import com.onlinevoting.service.CandidateService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(path="/v1/candidate_form", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<Object>> createCandidate(@RequestBody @Valid Candidate candidate) {
        candidateService.saveCandidate(candidate);
        ApiResponse<Object> response = new ApiResponse<>(true, "Candidate created successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
