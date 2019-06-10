package com.maia.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.course.domain.RequestStage;
import com.maia.course.service.RequestStateService;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResources {

	@Autowired
	private RequestStateService service;

	// save
	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody RequestStage obj) {
		RequestStage createdObj = service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdObj);

	}

	// get by id
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
		RequestStage obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}
