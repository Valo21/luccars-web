package com.luccars.products.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.luccars.products.utils.SearchPagination;
import com.luccars.products.entities.Product;
import com.luccars.products.exceptions.EntityNotFoundException;
import com.luccars.products.exceptions.ErrorProcessingException;
import com.luccars.products.exceptions.UnsavedEntityException;
import com.luccars.products.services.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@Autowired
	IProductService productService;


	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") UUID productId) throws ErrorProcessingException, EntityNotFoundException {
		Product output = productService.findById(productId);
		return new ResponseEntity<Product>(output, HttpStatus.OK);
	}

	@GetMapping
		public ResponseEntity<List<Product>> findAll() throws ErrorProcessingException {
			List<Product> output = productService.findAll();
			return new ResponseEntity<List<Product>>(output, HttpStatus.OK);
		}

	@PostMapping
		public ResponseEntity<Product> save(@RequestBody Product product) throws UnsavedEntityException {
			Product output = productService.save(product);
			return new ResponseEntity<Product>(output, HttpStatus.OK);
		}

	@PutMapping("/{id}")
		public ResponseEntity<Product> update(@PathVariable("id") UUID productId, @RequestBody Product product) throws UnsavedEntityException {
			Product output = productService.update(productId, product);
			return new ResponseEntity<Product>(output, HttpStatus.OK);
		}

	@GetMapping("/page-all-by-search")
	public ResponseEntity<Page<Product>> findAllPaginatedBySearch(
			@RequestParam(required = false) String search,
			Pageable pageable) {

		Page<Product> output = productService.findAllPaginatedBySearch(search, pageable);
		return ResponseEntity.ok(output);
	}
}