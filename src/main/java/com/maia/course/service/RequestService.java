package com.maia.course.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.course.domain.Request;
import com.maia.course.domain.enums.RequestState;
import com.maia.course.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;

	// save
	public Request save(Request obj) {
		obj.setState(RequestState.OPEN);
		obj.setCreationDate(new Date());
		Request createdRequest = repository.save(obj);
		return createdRequest;
	}

	// update
	public Request update(Request obj) {
		Request updateRequest = repository.save(obj);
		return updateRequest;
	}

	// getById
	public Request findById(Long id) {
		Optional<Request> result = repository.findById(id);
		return result.get();
	}

	// list
	public List<Request> getAll() {
		List<Request> list = repository.findAll();
		return list;
	}

	// list by user
	public List<Request> getAllByUser(Long userId) {
		List<Request> requests = repository.findAllByUserId(userId);
		return requests;

	}

}
