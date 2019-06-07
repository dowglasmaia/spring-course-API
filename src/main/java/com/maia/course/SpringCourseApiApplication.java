package com.maia.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maia.course.domain.User;
import com.maia.course.domain.enums.Role;
import com.maia.course.repository.UserRepository;
import com.maia.course.service.UserService;

@SpringBootApplication
public class SpringCourseApiApplication implements CommandLineRunner {

	@Autowired
	private UserService userRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u = new User(null, "Dowglas Maia", "dowglasmaia@live.com", "123", Role.ADMINISTRADOR);
		userRepository.update(u);
		System.out.println("Usuario: " + u.getName() +"," + "senha do usuario: " + u.getPassword());		

	}

}
