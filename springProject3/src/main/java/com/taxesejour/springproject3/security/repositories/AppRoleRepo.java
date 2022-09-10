package com.taxesejour.springproject3.security.repositories;

import com.taxesejour.springproject3.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByAuthority(String authority);
}
