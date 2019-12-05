package com.maia.course.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maia.course.domain.Usuario;
import com.maia.course.repository.UserRepository;
import com.maia.course.service.util.HashUtil;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	// Save
	public Usuario save(Usuario obj) {
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
	public Usuario update(Usuario obj) {
		String hash = HashUtil.getSecuretHash(obj.getPassword());
		obj.setPassword(hash);
		return repository.save(obj);
	}

	// getById
	public Usuario getById(Long id) {
		Optional<Usuario> result = repository.findById(id);
		return result.get();
	}

	// List
	public List<Usuario> listAll() {
		List<Usuario> users = repository.findAll();
		return users;
	}

	// Login
	public Usuario login(String email, String password) {
		password = HashUtil.getSecuretHash(password);
		Optional<Usuario> result = repository.login(email, password);
		return result.get();
	}

	/* Retorna usuario para autenticação - */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> result = repository.findByEmail(username);
		
		if(!result.isPresent()) throw new UsernameNotFoundException("Usuario não encontrado para o email: "+username);
		
		Usuario user = result.get();
		
		List<GrantedAuthority>authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		
		User usS = new User(user.getEmail(), user.getPassword(), authorities);
		
		return usS;
	}

}
