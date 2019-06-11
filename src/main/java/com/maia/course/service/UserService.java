package com.maia.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.course.domain.User;
import com.maia.course.repository.UserRepository;
import com.maia.course.service.util.HashUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// Save
	public User save(User obj) {
		try {
			String hash = HashUtil.getSecuretHash(obj.getPassword());
			obj.setPassword(hash);
			return repository.save(obj);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Operação Falhou" + e.getMessage());
		}

	}

	// update
	public User update(User obj) {
		String hash = HashUtil.getSecuretHash(obj.getPassword());
		obj.setPassword(hash);

		return repository.save(obj);
	}

	// getById
	public User getById(Long id) {
		Optional<User> result = repository.findById(id);
		return result.get();
	}

	// List
	public List<User> listAll() {
		List<User> users = repository.findAll();
		return users;
	}

	// Login
	public User login(String email, String password) {
		password = HashUtil.getSecuretHash(password);
		Optional<User> result = repository.login(email, password);
		return result.get();
	}

}
