package com.luccars.products.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luccars.products.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

	/**
  * Returns a {@link Page} of the {@link Product} type that match the search.
  * 
  * @param pageable {@link Pageable}
  * @param search   Text to search within the attributes of the {@link Product} entity
  * @return {@link Page} of the {@link Product}
  */
  @Query("select p from Product p where p.name like %?1%")
  Page<Product> findAllBySearch(String search, Pageable pageable);
}
