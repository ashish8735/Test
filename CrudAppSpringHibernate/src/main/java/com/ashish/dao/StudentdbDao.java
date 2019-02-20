package com.ashish.dao;

import java.util.List;

import com.ashish.model.Studentdb;

public interface StudentdbDao {
	public void add(Studentdb student);
	public void edit(Studentdb student);
	public void delete(int studentid);
	public Studentdb getStudent(int studentid);
	public List getAllStudents();
}
