package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="id_categoria")
	private int idCategoria;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="description")
	private String description;
	
	//Casi 1
//	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Course> courses;
	
//	@OneToMany(mappedBy = "categoria")
//	private Set<Course> courses;
	
}
