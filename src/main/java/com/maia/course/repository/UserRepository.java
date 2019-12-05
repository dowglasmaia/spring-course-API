package com.maia.course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maia.course.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	/* Buscar por nome*/
	public Usuario findByName( String name);
	
	/* Buscar por email*/
	public Optional<Usuario> findByEmail( String email);
	
	/* Buscar por email e senha =  neste caso para fazer o login*/
	public Usuario findByEmailAndPassword(String email, String senha);
	
	/* Buscar por email e senha =  neste caso para fazer o login */
	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
	public Optional<Usuario> login(String email, String password);



}
