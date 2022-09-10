package com.taxesejour.springproject3.security.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppRole {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String authority;

    public AppRole() {
    }

    public AppRole(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
