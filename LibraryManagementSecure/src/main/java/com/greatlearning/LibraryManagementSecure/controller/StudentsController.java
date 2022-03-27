package com.greatlearning.LibraryManagementSecure.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.LibraryManagementSecure.entity.Student;
import com.greatlearning.LibraryManagementSecure.service.StudentService;




@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		

		
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);
		

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		
		Student theStudent = studentService.findById(theId);


		
		theModel.addAttribute("Student", theStudent);


		return "Student-form";			
	}


	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentid") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if(id!=0)
		{
			theStudent=studentService.findById(id);
			theStudent.setName(name);
			theStudent.setCategory(department);
			theStudent.setAuthor(country);
		}
		else
			theStudent=new Student(name, department, country);
		
		studentService.save(theStudent);


		
		return "redirect:/students/list";

	}

	

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		
		studentService.deleteById(theId);

		
		return "redirect:/students/list";

	}


	@RequestMapping("/search")
	public String search(@RequestParam("name") String name,
			@RequestParam("country") String country,
			Model theModel) {

	

		if (name.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/books/list";
		}
		else {
			
			List<Student> theStudents =
					studentService.searchBy(name, country);

			
			theModel.addAttribute("Students", theStudents);

			
			return "list-Students";
		}

	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}


















