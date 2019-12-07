package com.maia.course.resources.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ApiError implements Serializable {
	private static final long serialVersionUID = 1L;

		
	private int codigo;
	private String msg;
	private Date date;

	public ApiError() {
		
	}

	public ApiError(int codigo, String msg, Date date) {
		super();
		this.codigo = codigo;
		this.msg = msg;
		this.date = date;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodiog(int codigo) {
		this.codigo = codigo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
