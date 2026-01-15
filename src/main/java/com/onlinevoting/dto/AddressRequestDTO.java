package com.onlinevoting.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {
    
    private String street;
    private Long cityId;
    private Long stateId;
    private String zipCode;
    private Long countryId;
<<<<<<< HEAD
=======
    private Boolean isActive;
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
}