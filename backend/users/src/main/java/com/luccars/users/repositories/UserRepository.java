package com.luccars.users.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luccars.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  
}
