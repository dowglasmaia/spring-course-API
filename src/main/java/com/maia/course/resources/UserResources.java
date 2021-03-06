package com.maia.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.course.domain.Request;
import com.maia.course.domain.Usuario;
import com.maia.course.domain.dto.UserLoginDTO;
import com.maia.course.security.JwtManager;
import com.maia.course.service.RequestService;
import com.maia.course.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired private UserService service;
	@Autowired private RequestService reqService;
	@Autowired private AuthenticationManager authManager;
	@Autowired private JwtManager jwtmanager;
	

	@Secured("ROLE_ADMINISTRADOR")
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario obj) {
		Usuario createdUser = service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id, @RequestBody Usuario user) {
		user.setId(id);
		Usuario updateUser = service.update(user);
		return ResponseEntity.ok(updateUser);
	}

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		Usuario user = service.getById(id);
		return ResponseEntity.ok(user);
	}

	// list
	@GetMapping
	public ResponseEntity<List<Usuario>> getAlls() {
		List<Usuario> users = service.listAll();
		return ResponseEntity.ok(users);

	}

	// login
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginDTO user) {
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());		
		Authentication auth = authManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(auth);	
		
		User userSS = (User) auth.getPrincipal();
		
		String email = userSS.getUsername();
		List<String> roles = userSS.getAuthorities()
							.stream()
							.map(authority -> authority.getAuthority())
							.collect(Collectors.toList());
		
		String jwt = jwtmanager.createToken(email, roles);		
		return ResponseEntity.ok(jwt);
	}

	// find request for id user
	@GetMapping("/{id}/requests")
	public ResponseEntity<List<Request>> listAllRequestByIdUser(@PathVariable(name = "id") Long id) {
		List<Request> list = reqService.getAllByUser(id);
		return ResponseEntity.ok(list);

	}

	

}
