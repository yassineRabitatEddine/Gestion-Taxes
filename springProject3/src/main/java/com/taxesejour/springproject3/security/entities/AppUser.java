package com.taxesejour.springproject3.security.entities;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> authorities=new ArrayList<>();

    public AppUser() {
    }
    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<AppRole> authorities) {
        this.authorities = authorities;
    }
}
