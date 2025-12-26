package com.onlinevoting.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectionResponseDto {
    private Long electionId;
    private String electionName;
    private LocalDate electionDate;
    private LocalDate resultDate;
    private Long countryId;
    private Long stateId;
    private Long cityId;
    private Long officerId;
    private String status;
}
