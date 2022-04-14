package com.example.workplanet.security;

import com.example.workplanet.entities.AppUser;
import com.example.workplanet.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByUsername(username).orElseThrow();

        return new User(appUser.getUsername(), appUser.getPassword(), List.of());
    }


}
