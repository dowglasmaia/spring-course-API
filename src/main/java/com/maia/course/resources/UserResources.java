package com.maia.course.resources;

import java.util.List;

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

import com.maia.course.domain.Request;
import com.maia.course.domain.User;
import com.maia.course.domain.dto.UserLoginDTO;
import com.maia.course.service.RequestService;
import com.maia.course.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResources {

	@Autowired
	private UserService service;

	@Autowired
	private RequestService reqService;

	// save
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User obj) {
		User createdUser = service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody User user) {
		user.setId(id);
		User updateUser = service.update(user);
		return ResponseEntity.ok(updateUser);
	}

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User user = service.getById(id);
		return ResponseEntity.ok(user);
	}

	// list
	@GetMapping
	public ResponseEntity<List<User>> getAlls() {
		List<User> users = service.listAll();
		return ResponseEntity.ok(users);

	}

	// login
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDTO user) {
		User loggedUser = service.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}

	// find request for id user
	@GetMapping("/{id}/requests")
	public ResponseEntity<List<Request>> listAllRequestByIdUser(@PathVariable(name = "id") Long id) {
		List<Request> list = reqService.getAllByUser(id);
		return ResponseEntity.ok(list);

	}

}
