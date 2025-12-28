package com.onlinevoting.dto;

import com.onlinevoting.model.Party;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {
    private Long partyId;
    private String partyName;
    
    public static PartyDto from(Party party) {
        return new PartyDto(
            party.getPartyId(),
            party.getPartyName());
}
}