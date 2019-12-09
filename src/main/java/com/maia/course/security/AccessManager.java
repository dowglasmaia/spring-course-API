package com.maia.course.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.maia.course.domain.Usuario;
import com.maia.course.exceptions.NotFoundException;
import com.maia.course.repository.UserRepository;

@Component("accessManager")
public class AccessManager {

	@Autowired
	private UserRepository repository;
	
	//retorna o Usuario presente no token
	public boolean isUsuario(Long id) {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Usuario> result = repository.findByEmail(email);
		
		if(!result.isPresent()) throw new NotFoundException("Usuário não encontrado para o e-mail :" + email);
		
		Usuario user = result.get();
		
		return user.getId() == id;		
	}
	
	
}
