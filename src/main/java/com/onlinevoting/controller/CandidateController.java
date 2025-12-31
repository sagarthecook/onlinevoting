package com.onlinevoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.CandidateResponseDto;
import com.onlinevoting.dto.ElectionResponseDto;
import com.onlinevoting.model.Candidate;
import com.onlinevoting.service.CandidateService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(path="/v1/candidate_form", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<Object>> createCandidate(@RequestBody @Valid String candidate) {
        candidateService.saveCandidate(candidate);
        ApiResponse<Object> response = new ApiResponse<>(true, "Candidate created successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/v1/candidate_form/findbystatus", produces = { "application/json" })
    public ResponseEntity<ApiResponse<List<CandidateResponseDto>>> getCandidatesByStatus(@RequestParam String status) {
        List<CandidateResponseDto> candidates = candidateService.getCandidatebyStatus(status);
        ApiResponse<List<CandidateResponseDto>> response = new ApiResponse<>(true, candidates, null);
        return ResponseEntity.ok(response);
    }
    





}
