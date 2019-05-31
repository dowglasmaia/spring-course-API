package com.maia.course.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maia.course.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RequestStage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 80, nullable = false)
	private String description;

	@Column(length = 20, name = "realization_date", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date realizationDate;

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;

	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private Request request;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
