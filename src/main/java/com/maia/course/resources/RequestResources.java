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
import com.maia.course.service.RequestService;

@RestController
@RequestMapping("/requests")
public class RequestResources {

	@Autowired
	private RequestService service;

	// save
	@PostMapping
	public ResponseEntity<Request> save(@RequestBody Request obj) {
		Request createdRequest = service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id, @RequestBody Request obj) {
		obj.setId(id);
		Request updateRequest = service.update(obj);
		return ResponseEntity.ok(updateRequest);
	}

	// find by ID
	@RequestMapping("/{id}")
	public ResponseEntity<Request> findById(@PathVariable(name = "id") Long id) {
		Request obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	// get Alls
	@GetMapping
	public ResponseEntity<List<Request>> getAlls() {
		List<Request> objs = service.getAll();
		return ResponseEntity.ok(objs);
	}

}
