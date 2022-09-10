package com.taxesejour.springproject3.security.service;

import com.taxesejour.springproject3.security.entities.AppRole;
import com.taxesejour.springproject3.security.entities.AppUser;
import com.taxesejour.springproject3.security.repositories.AppRoleRepo;
import com.taxesejour.springproject3.security.repositories.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppServiceImpl implements AppService {
    private AppUserRepo appUserRepo;
    private AppRoleRepo appRoleRepo;
    private PasswordEncoder passwordEncoder;

    public AppServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewAppUser(AppUser appUser) {
        String password=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(password));
        return appUserRepo.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return appRoleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=appUserRepo.findByUsername(username);
        user.getAuthorities().add(appRoleRepo.findByAuthority(roleName));
        appUserRepo.save(user);
    }

    @Override
    public AppUser loadByUsername(String username) {

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listAll() {
        return appUserRepo.findAll();
    }
}
