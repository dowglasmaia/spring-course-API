package com.maia.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	private String name;

	private String email;

	private String password;
	
	private Role role;

	private List<Request> requests = new ArrayList<>();

	private List<RequestStage> stages = new ArrayList<>();

}
