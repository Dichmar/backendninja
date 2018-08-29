package com.udemy.model;

public enum ROLE {
	
	ADMIN_NORMAL(1, "Administrador normal"),
	ADMIN_SECRETARIA(2, ""),
	ADMIN_ROOT(3, "");
	
	private ROLE(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	int id;
	String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
