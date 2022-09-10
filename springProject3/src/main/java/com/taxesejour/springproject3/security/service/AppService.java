package com.taxesejour.springproject3.security.service;



import com.taxesejour.springproject3.security.entities.AppRole;
import com.taxesejour.springproject3.security.entities.AppUser;

import java.util.List;

public interface AppService {
    AppUser addNewAppUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadByUsername(String username);
    List<AppUser> listAll();

}
