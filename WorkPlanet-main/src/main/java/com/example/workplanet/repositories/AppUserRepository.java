package com.example.workplanet.repositories;

import com.example.workplanet.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// JpaRepository Används för CRUD Funktionalitet
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findAppUserByUsername(String username);


}
