package com.example.inside.security;

import com.example.inside.model.Sender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class JwtUser implements UserDetails {

    private final Sender sender;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Sender sender, Collection<? extends GrantedAuthority> authorities) {
        this.sender = sender;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return sender.getPassword();
    }

    @Override
    public String getUsername() {
        return sender.getUsername();
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