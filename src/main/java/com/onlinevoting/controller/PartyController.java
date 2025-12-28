package com.onlinevoting.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.PartyDto;
import com.onlinevoting.model.Party;
import com.onlinevoting.service.PartyService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartyController {

    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping(path = "/v1/party", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<Object>> createParty(@RequestBody @Valid Party party) {
        partyService.save(party);ApiResponse<Object> response = new ApiResponse<>(true, "Party created successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/v1/party", produces = "application/json")
    public ResponseEntity<ApiResponse<List<PartyDto>>> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        List<PartyDto> partyDtos = parties.stream().map(PartyDto::from).toList();
        ApiResponse<List<PartyDto>> response = new ApiResponse<>(true, partyDtos, null);
        return ResponseEntity.ok(response);
    }
    

}
