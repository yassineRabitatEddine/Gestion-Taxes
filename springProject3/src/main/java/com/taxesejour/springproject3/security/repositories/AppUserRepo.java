package com.taxesejour.springproject3.security.repositories;

import com.taxesejour.springproject3.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
