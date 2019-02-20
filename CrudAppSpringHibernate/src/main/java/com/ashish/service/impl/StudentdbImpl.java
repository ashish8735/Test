package com.ashish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.dao.StudentdbDao;
import com.ashish.model.Studentdb;
import com.ashish.service.StudentdbService;

@Service
public class StudentdbImpl implements StudentdbService {

	@Autowired
	private StudentdbDao studentDao;
@Transactional
public void add(Studentdb student) {
studentDao.add(student);
	}

@Transactional
	public void edit(Studentdb student) {
studentDao.edit(student);
	}

@Transactional
	public void delete(int studentid) {
studentDao.delete(studentid);
	}

@Transactional
	public Studentdb getStudent(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentid);
	}

@Transactional
	public List getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

}
