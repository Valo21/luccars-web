package com.luccars.users.services;

import java.util.List;
import java.util.UUID;
  
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import com.luccars.users.entities.User;
import com.luccars.users.exceptions.EntityNotFoundException;
import com.luccars.users.exceptions.ErrorProcessingException;
import com.luccars.users.exceptions.UnsavedEntityException;

public interface IUserService {


	/**
  * Retrieves an entity {@link User} by its identifier
  * 
  * @param userId Identifier  {@link User}
  * @return {@link User} with the given id 
	* @throws ErrorProcessingException
	* @throws EntityNotFoundException
  */
  User findById(UUID userId) throws ErrorProcessingException, EntityNotFoundException;

	/**
  * Returns all instances of the type {@link User} 
  * 
  * @return all entities {@link User} 
	* @throws ErrorProcessingException
  */
  List<User> findAll() throws ErrorProcessingException;

	/**
	 * Saves a given entity {@link User}
	 * 
	 * @param user {@link User}
	 * @return the saved entity 
	* @throws UnsavedEntityException
	 */
  User save(User user) throws UnsavedEntityException;

	/**
  * Updates a given entity {@link User}
  * 
  * @param user {@link User}
  * @return the updated entity 
	* @throws UnsavedEntityException
  */
  User update(User user) throws UnsavedEntityException;
}
