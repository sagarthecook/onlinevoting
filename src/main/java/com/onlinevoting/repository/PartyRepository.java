package com.onlinevoting.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.onlinevoting.model.Party;

public interface PartyRepository extends ListCrudRepository<Party, Long> {
}
