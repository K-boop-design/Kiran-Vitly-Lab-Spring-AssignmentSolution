package com.greatlearning.LibraryManagementSecure.service;

import java.util.List;



import com.greatlearning.LibraryManagementSecure.entity.Student;


public interface StudentService {
	public List<com.greatlearning.LibraryManagementSecure.entity.Student> findAll();

	public com.greatlearning.LibraryManagementSecure.entity.Student findById(int theId);

	public void save(com.greatlearning.LibraryManagementSecure.entity.Student theStudent);

	public void deleteById(int theId);

	public List<com.greatlearning.LibraryManagementSecure.entity.Student> searchBy(String name, String country);

}
