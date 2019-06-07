package com.maia.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maia.course.domain.Request;
import com.maia.course.domain.RequestStage;
import com.maia.course.domain.User;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	/* Buscar por nome*/
	public User findByDescription( String name);
	
	/*Buscar todos os Pedidos com base no Id do Usuario*/
	public List<Request>findAllByUserId(Long id);
	
	/* ATUALIZANDO O ESTATDO DO PEDIDO*/
	@Query("UPDATE Request SET state = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestStage state);
		
	



}
