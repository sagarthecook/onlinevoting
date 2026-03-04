package com.onlinevoting.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinevoting.model.UserRole;

@Repository
public interface UserRoleRepository extends ListCrudRepository<UserRole, Long> {
    public List<UserRole> findByIsActiveTrue();
}
