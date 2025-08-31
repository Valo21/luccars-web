package com.luccars.users.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luccars.users.entities.User;
import com.luccars.users.exceptions.EntityNotFoundException;
import com.luccars.users.exceptions.ErrorProcessingException;
import com.luccars.users.exceptions.UnsavedEntityException;
import com.luccars.users.repositories.UserRepository;
import com.luccars.users.services.IUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;
  

	@Override
  public User findById(final UUID userId) throws ErrorProcessingException, EntityNotFoundException {
    try {
      return this.userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    } catch (final EntityNotFoundException e) {
      throw e;
    } catch (final Exception e) {
      log.error("User findById(\"{}\"): {}", userId, e.getMessage());
      throw new ErrorProcessingException(e.getMessage());
    }
  }

	@Override
  public List<User> findAll() throws ErrorProcessingException {
    try {
      return this.userRepository.findAll();
    } catch (final Exception e) {
      log.error("User findAll(): {}", e.getMessage());
      throw new ErrorProcessingException(e.getMessage());
    }
  }

	@Override
  public User save(final User user) throws UnsavedEntityException {
    try {
      return this.userRepository.save(user);
    } catch (final Exception e) {
      log.error("User save(\"{}\"): {}", user.toString(), e.getMessage());
      throw new UnsavedEntityException(e.getMessage());
    }
  }

	@Override
  public User update(final UUID userId, final User user) throws UnsavedEntityException {
    try {
      User prevUser = this.findById(userId);

      if (user.getFirstName() != null) prevUser.setFirstName(user.getFirstName());
      if (user.getLastName() != null) prevUser.setLastName(user.getLastName());
      if (user.getEmail() != null) prevUser.setEmail(user.getEmail());
      if (user.getAddress() != null) prevUser.setAddress(user.getAddress());

      return this.userRepository.save(prevUser);
    } catch (final Exception e) {
      log.error("User update(\"{}\"): {}", user.toString(), e.getMessage());
      throw new UnsavedEntityException(e.getMessage());
    }
  }
  }
  
