package com.luccars.products.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.luccars.products.entities.Product;
import com.luccars.products.exceptions.EntityNotFoundException;
import com.luccars.products.exceptions.ErrorProcessingException;
import com.luccars.products.exceptions.UnsavedEntityException;

public interface IProductService {


	/**
  * Retrieves an entity {@link Product} by its identifier
  * 
  * @param productId Identifier  {@link Product}
  * @return {@link Product} with the given id 
	* @throws ErrorProcessingException
	* @throws EntityNotFoundException
  */
  Product findById(UUID productId) throws ErrorProcessingException, EntityNotFoundException;

	/**
  * Returns all instances of the type {@link Product} 
  * 
  * @return all entities {@link Product} 
	* @throws ErrorProcessingException
  */
  List<Product> findAll() throws ErrorProcessingException;

	/**
	 * Saves a given entity {@link Product}
	 * 
	 * @param product {@link Product}
	 * @return the saved entity 
	* @throws UnsavedEntityException
	 */
  Product save(Product product) throws UnsavedEntityException;

	/**
  * Updates a given entity {@link Product}
  * 
  * @param product {@link Product}
  * @return the updated entity 
	* @throws UnsavedEntityException
  */
  Product update(UUID productId, Product product) throws UnsavedEntityException;

	/**
  * Returns a {@link Page} of the {@link Product} type that match the search.
  * 
  * @param pageable {@link PageRequest}
  * @param search   Text to search within the attributes of the {@link Product} entity
  * @return {@link Page} of the {@link Product} 
	* @throws ErrorProcessingException
  */
  Page<Product> findAllPaginatedBySearch(String search, Pageable pageable) throws ErrorProcessingException;
}
