package com.luccars.products.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.luccars.products.entities.Product;
import com.luccars.products.exceptions.EntityNotFoundException;
import com.luccars.products.exceptions.ErrorProcessingException;
import com.luccars.products.exceptions.UnsavedEntityException;
import com.luccars.products.repositories.ProductRepository;
import com.luccars.products.services.IProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;
  

	@Override
  public Product findById(final UUID productId) throws ErrorProcessingException, EntityNotFoundException {
    try {
      return this.productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    } catch (final EntityNotFoundException e) {
      throw e;
    } catch (final Exception e) {
      log.error("Product findById(\"{}\"): {}", productId, e.getMessage());
      throw new ErrorProcessingException(e.getMessage());
    }
  }

	@Override
  public List<Product> findAll() throws ErrorProcessingException {
    try {
      return this.productRepository.findAll();
    } catch (final Exception e) {
      log.error("Product findAll(): {}", e.getMessage());
      throw new ErrorProcessingException(e.getMessage());
    }
  }


	@Override
  public Product save(final Product product) throws UnsavedEntityException {
    try {
      return this.productRepository.save(product);
    } catch (final Exception e) {
      log.error("Product save(\"{}\"): {}", product.toString(), e.getMessage());
      throw new UnsavedEntityException(e.getMessage());
    }
  }

	@Override
  public Product update(final UUID productId, final Product product) throws UnsavedEntityException {
    try {
      Product prevProduct = this.findById(productId);

      if (product.getName() != null) prevProduct.setName(product.getName());
      if (product.getPrice() != null) prevProduct.setPrice(product.getPrice());
      if (product.getDescription() != null) prevProduct.setDescription(product.getDescription());
      if (product.getStock() != null) prevProduct.setStock(product.getStock());

      return this.productRepository.save(prevProduct);
    } catch (final Exception e) {
      log.error("Product update(\"{}\"): {}", product.toString(), e.getMessage());
      throw new UnsavedEntityException(e.getMessage());
    }
  }

	@Override
    public Page<Product> findAllPaginatedBySearch(final String search, final Pageable pageable)
        throws ErrorProcessingException {
      try {
        return this.productRepository.findAllBySearch(search, pageable);
      } catch (final Exception e) {
        log.error("Product findAllPaginatedBySearch(\"{}\"): {}", search, e.getMessage());
        throw new ErrorProcessingException(e.getMessage());
      }
    }
  }
  
