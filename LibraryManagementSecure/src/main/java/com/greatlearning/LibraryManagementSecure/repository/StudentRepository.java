package com.greatlearning.LibraryManagementSecure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.LibraryManagementSecure.entity.Student;

public interface StudentRepository extends JpaRepository<com.greatlearning.LibraryManagementSecure.entity.Student, Integer> {

	List<Student> findByNameContainsAndCountryContainsAllIgnoreCase(String name,String country);
	
}
