package com.onlinevoting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponseDTO {
    private Long Id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String occupation;
    private String income;
    private String party;
    private String election;
    private String status;


}
