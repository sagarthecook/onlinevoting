package com.onlinevoting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.onlinevoting.dto.PartyDto;
import com.onlinevoting.model.Party;
import com.onlinevoting.repository.PartyRepository;

@Service
public class PartyService {

    private final PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party Save(Party party) {
        if (party.getIsActive() == null) {
            party.setActive(Boolean.TRUE); 
        }
        return partyRepository.save(party);
    }
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }
}
