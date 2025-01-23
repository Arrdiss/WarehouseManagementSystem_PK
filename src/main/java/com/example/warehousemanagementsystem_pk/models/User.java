package com.example.warehousemanagementsystem_pk.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Accessors(chain = true)
@Entity
@Table(name = "Users")
@Data
public class User implements UserDetails {

    @Id
    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "PasswordHash")
    private String password;

    @Column(name = "RoleID")
    private Integer RoleId;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // empty - obligatory but not used in this project
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
