package com.greatlearning.LibraryManagementSecure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="student")
@Getter
@Setter
public class Student {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="department")
	private String department;
	
	
	@Column(name="country")
	private String country;

	public Student()
	{
		
	}

	public Student(String name, String category, String author) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

	public void setName(String name2) {
		// TODO Auto-generated method stub
		this.name=name2;
	}

	public void setCategory(String department2) {
		// TODO Auto-generated method stub
		this.department=department2;
	}

	public void setAuthor(String country2) {
		// TODO Auto-generated method stub
		this.country=country2;
	}
	
	
}











