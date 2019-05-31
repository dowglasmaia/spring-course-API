package com.maia.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.maia.course.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Met Gettes
@Setter // Met Setters
@AllArgsConstructor // Constructor wiht Args
@NoArgsConstructor // Constructor wihtout Args
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 80, nullable = false)
	private String name;

	@Column(length = 80, nullable = false, unique = true)
	private String email;

	@Column(length = 12, nullable = false)
	private String password;

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user") // 01 usuario pode ter varios Pedidos( 01 p/ *)
	private List<Request> requests = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<RequestStage> stages = new ArrayList<>();

}
