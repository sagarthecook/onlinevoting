package com.onlinevoting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.BaseDTO;
import com.onlinevoting.service.StateService;

@RestController
<<<<<<< HEAD
@RequestMapping("/v1/states")
@CrossOrigin(origins = "*", allowedHeaders = "*")    
=======
@RequestMapping("/v1/states")    
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }
    
    @GetMapping(path = "/by-country/{countryId}", produces = { "application/json" })
    public ResponseEntity<ApiResponse<List<BaseDTO>>> getStatesByCountryId(@PathVariable Long countryId) {
        return ResponseEntity.ok(new ApiResponse<>(true, stateService.getStatesByCountryId(countryId), null));
    }

}
