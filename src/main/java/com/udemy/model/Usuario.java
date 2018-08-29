package com.udemy.model;

public class Usuario {

	private int id;
	private String usuario;
	private String pwd;
	private ROLE rol;
	private Puesto puesto;
	private String status;

	public Usuario() {
	}

	public Usuario(int id, String usuario, String pwd, ROLE rol, Puesto puesto, String status) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pwd = pwd;
		this.rol = rol;
		this.puesto = puesto;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public ROLE getRol() {
		return rol;
	}

	public void setRol(ROLE rol) {
		this.rol = rol;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
