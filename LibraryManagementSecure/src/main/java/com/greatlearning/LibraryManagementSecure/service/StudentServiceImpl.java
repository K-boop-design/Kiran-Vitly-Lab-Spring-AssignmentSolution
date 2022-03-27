package com.greatlearning.LibraryManagementSecure.service;



import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatlearning.LibraryManagementSecure.entity.Student;
import com.greatlearning.LibraryManagementSecure.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;





@Service
public class StudentServiceImpl implements StudentService {


	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theBook) {
		// TODO Auto-generated method stub
		studentRepository.save(theBook);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
		
	}

	@Override
	public List<Student> searchBy(String name, String country) {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.findByNameContainsAndCountryContainsAllIgnoreCase(name, country);
		return students;
	}





}