package com.onlinevoting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevoting.dto.AddressRequestDTO;
import com.onlinevoting.dto.ApiResponse;
<<<<<<< HEAD

@RestController
@RequestMapping("/v1/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
=======
import com.onlinevoting.model.Address;


@RestController
@RequestMapping("/v1/address")
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
public class AddressController {

    private final com.onlinevoting.service.AddressService addressService;
    public AddressController(com.onlinevoting.service.AddressService addressService) {
        this.addressService = addressService;
    }
    

    @PostMapping(path = "/", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<ApiResponse<Long>> createAddress(@RequestBody AddressRequestDTO address) {
        Long id = addressService.saveAddress(address);
        ApiResponse<Long> response = new ApiResponse<>(true, id,null, "Address created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
