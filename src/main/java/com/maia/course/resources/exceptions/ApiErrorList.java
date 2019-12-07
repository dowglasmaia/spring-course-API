package com.maia.course.resources.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiErrorList extends ApiError implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> errors = new ArrayList<>();

	public ApiErrorList() {

	}

	public ApiErrorList(int codigo, String msg, Date date, List<String> errors) {
		super(codigo, msg, date);
		this.errors = errors;
	}

}
