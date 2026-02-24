package com.onlinevoting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWinnerDTO {

    private String candidateName;
    private String partyName;
    private Long votesReceived;
    private Long totalVotes;
    private Double votePercentage;
    private Boolean isWinner;
    private String electionName;

}
