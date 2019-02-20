package com.ashish.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashish.model.Studentdb;
import com.ashish.service.StudentdbService;



@Controller
public class StudentController {
	@Autowired
	private StudentdbService studentService;
	
	@RequestMapping(value= {"/","/index"})
	public String setupForm(Map<String, Object> map){
		Studentdb student = new Studentdb();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudents());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Studentdb student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Studentdb studentResult = new Studentdb();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getStudentid());
			studentResult = new Studentdb();
			break;
		case "search":
			Studentdb searchedStudent = studentService.getStudent(student.getStudentid());
			studentResult = searchedStudent!=null ? searchedStudent : new Studentdb();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudents());
		return "student";
	}
	

}
