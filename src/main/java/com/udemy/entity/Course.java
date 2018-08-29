package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name = "id_course")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "hours")
	private int hours;

//	@OneToMany
//	@JoinColumn(name="id_categoria")
//	private Category category;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="categoria_id", referencedColumnName="id_categoria")
//	private Category categoria;
	
	
	//casi 1
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="categoria_id", foreignKey = @ForeignKey(name = "FK_COURSE"))
//	@JoinColumns({
//	    @JoinColumn(name="categoria_id", referencedColumnName="id_categoria"),
//	    @JoinColumn(name="id_categoria", referencedColumnName="categoria_id")
//	})
//	private Category categoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoria_id", foreignKey = @ForeignKey(name = "FK_COURSE"))
	private Category categoria;
	
	public Course() {
	}

	public Course(int id, String name, String description, int price, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
}
