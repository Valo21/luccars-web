package com.luccars.users.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luccars.users.utils.SearchPagination;
import com.luccars.users.entities.User;
import com.luccars.users.exceptions.EntityNotFoundException;
import com.luccars.users.exceptions.ErrorProcessingException;
import com.luccars.users.exceptions.UnsavedEntityException;
import com.luccars.users.services.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	IUserService userService;


	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") UUID userId) throws ErrorProcessingException, EntityNotFoundException {
		User salida = userService.findById(userId);
		return new ResponseEntity<User>(salida, HttpStatus.OK);
	}

	@GetMapping("/find-all")
		public ResponseEntity<List<User>> findAll() throws ErrorProcessingException {
			List<User> salida = userService.findAll();
			return new ResponseEntity<List<User>>(salida, HttpStatus.OK);
		}

	@PostMapping
		public ResponseEntity<User> save(@RequestBody User user) throws UnsavedEntityException {
			User salida = userService.save(user);
			return new ResponseEntity<User>(salida, HttpStatus.OK);
		}

	@PutMapping
		public ResponseEntity<User> update(@RequestBody User user) throws UnsavedEntityException {
			User salida = userService.update(user);
			return new ResponseEntity<User>(salida, HttpStatus.OK);
		}
}