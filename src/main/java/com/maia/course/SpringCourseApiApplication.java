package com.maia.course;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maia.course.domain.Request;
import com.maia.course.domain.RequestStage;
import com.maia.course.domain.Usuario;
import com.maia.course.domain.enums.RequestState;
import com.maia.course.domain.enums.Role;
import com.maia.course.service.RequestService;
import com.maia.course.service.RequestStateService;
import com.maia.course.service.UserService;

@SpringBootApplication
public class SpringCourseApiApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private RequestStateService stateService;

	@Autowired
	private RequestService requestService;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u = new Usuario(null, "Dowglas Maia", "dowglasmaia@live.com", "123456789", Role.ADMINISTRADOR);
		userService.save(u);

		Request rq1 = new Request(null, "Vendas", "Vendas Avista", new Date(System.currentTimeMillis()),
				RequestState.OPEN, u);
		requestService.save(rq1);

		Request rq2 = new Request(null, "Vendas", "Vendas Avista", new Date(), RequestState.OPEN, u);
		requestService.save(rq2);

		RequestStage st1 = new RequestStage(null, "Lista", new Date(), RequestState.OPEN, rq1, u);
		stateService.save(st1);
		
		RequestStage st2 = new RequestStage(null, "Em Separação", new Date(), RequestState.OPEN, rq2, u);
		stateService.save(st2);

		rq1.getStages().add(st1);
		rq2.getStages().add(st2);

		u.getRequests().add(rq1);
		u.getRequests().add(rq1);

	}

}
