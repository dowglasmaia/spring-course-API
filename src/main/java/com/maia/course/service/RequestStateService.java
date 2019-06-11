package com.maia.course.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.course.domain.RequestStage;
import com.maia.course.domain.enums.RequestState;
import com.maia.course.repository.RequestRepository;
import com.maia.course.repository.RequestStageRepository;

@Service
public class RequestStateService {

	@Autowired
	private RequestStageRepository repository;

	@Autowired
	private RequestRepository requestRepository;

	// save
	public RequestStage save(RequestStage obj) {
		obj.setRealizationDate(new Date());
		RequestStage createdStage = repository.save(obj);

		Long requestId = obj.getRequest().getId();
		RequestState state = obj.getState();

		//requestRepository.updateStatus(requestId, state); // atualiza o estagio do Pedido

		return createdStage;
	}

	// getById
	public RequestStage findById(Long id) {
		Optional<RequestStage> result = repository.findById(id);
		return result.get();
	}

	// list
	public List<RequestStage> getAll() {
		List<RequestStage> list = repository.findAll();
		return list;
	}

	// list By id Request
	public List<RequestStage> getAllByRequestId(Long requestId) {
		List<RequestStage> stages = repository.findAllByRequestId(requestId);
		return stages;
	}

}
