package com.onlinevoting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.model.Country;
import com.onlinevoting.service.CountryService;

@RestController
@RequestMapping("/v1/country")
<<<<<<< HEAD
@CrossOrigin(origins = "*", allowedHeaders = "*")
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/list", produces = { "application/json" })
    public ResponseEntity<ApiResponse<List<Country>>> getCountries() {
        return ResponseEntity.ok(new ApiResponse<>(true, countryService.getAll(), null));
    }
    
}
