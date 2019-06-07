package com.maia.course.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maia.course.domain.User;
import com.maia.course.domain.enums.Role;

/* 
 * Class para Realizar os Teste da CAMADA de Repositorio do Usuario.
 * */

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;

	// save
	@Test
	void AsaveTest() {

		User u = new User(null, "Dowglas", "dowglasmaia@live", "123", Role.ADMINISTRADOR);
		User newUser = repository.save(u);

		assertThat(newUser.getId()).isEqualTo(2L); // testa para verifiar se o id é 1
	}

/*	// update
	@Test
	void updateTest() {
		User u = new User(1L, "Dowglas Maia", "maia@live.com", "123", Role.ADMINISTRADOR);
		User newUser = repository.save(u);

		assertThat(newUser.getName()).isEqualTo("Dowglas Maia"); // verifica se ouve a atualização para o nome: Dowglas
																	// Maia
	}

	// findBy ID
	@Test
	void getByIdTest() {
		Optional<User> result = repository.findById(1L);

		User user = result.get();
		assertThat(user.getPassword()).isEqualTo("123");
	}

	// Lista All
	@Test
	void listaTest() {
		List<User> lista = repository.findAll();

		assertThat(lista.size()).isEqualTo(1);

	}

	 // login 
	@Test
	void loginTest() {
		Optional<User> result = repository.login("dowglasmaia@live.com", "123");
		User loggedUser = result.get();

		assertThat(loggedUser.getId()).isEqualTo(1L);
	}
*/
}
