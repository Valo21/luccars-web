6package com.luccars.users.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccars.users.entities.User;
import com.luccars.users.exceptions.EntityNotFoundException;
import com.luccars.users.exceptions.ErrorProcessingException;
import com.luccars.users.exceptions.UnsavedEntityException;
import com.luccars.users.services.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserService userService;


	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") UUID userId) throws ErrorProcessingException, EntityNotFoundException {
		User output = userService.findById(userId);
		return new ResponseEntity<User>(output, HttpStatus.OK);
	}

	@GetMapping
		public ResponseEntity<List<User>> findAll() throws ErrorProcessingException {
			List<User> output = userService.findAll();
			return new ResponseEntity<List<User>>(output, HttpStatus.OK);
		}

	@PostMapping
		public ResponseEntity<User> save(@RequestBody User user) throws UnsavedEntityException {
			User output = userService.save(user);
			return new ResponseEntity<User>(output, HttpStatus.OK);
		}

	@PutMapping("/{id}")
		public ResponseEntity<User> update(@PathVariable("id") UUID userId, @RequestBody User user) throws UnsavedEntityException {
			User output = userService.update(userId, user);
			return new ResponseEntity<User>(output, HttpStatus.OK);
		}
}