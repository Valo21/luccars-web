package com.luccars.users.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luccars.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  
}
