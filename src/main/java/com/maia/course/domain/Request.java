package com.maia.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maia.course.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 80, nullable = false)
	private String subect;

	@Column(length = 80, nullable = false)
	private String description;

	@Column(length = 50, nullable = false, name = "creation_date")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date creationDate;

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;

	@ManyToOne // Varions Pedidos para UM Usuario
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "request")
	private List<RequestStage> states = new ArrayList<>();

	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Request(Long id, String subect, String description, Date creationDate, RequestState state, User user) {
		super();
		this.id = id;
		this.subect = subect;
		this.description = description;
		this.creationDate = creationDate;
		this.state = state;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubect() {
		return subect;
	}

	public void setSubect(String subect) {
		this.subect = subect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<RequestStage> getStates() {
		return states;
	}

	public void setStates(List<RequestStage> states) {
		this.states = states;
	}

}
