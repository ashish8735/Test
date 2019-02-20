package com.ashish.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashish.dao.StudentdbDao;
import com.ashish.model.Studentdb;

@Repository
public class StudentDaoImpl implements StudentdbDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Studentdb student) {
session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Studentdb student) {
session.getCurrentSession().update(student);
	}

	@Override
	public void delete(int studentid) {
session.getCurrentSession().delete(getStudent(studentid));
	}

	@Override
	public Studentdb getStudent(int studentid) {
		return (Studentdb)session.getCurrentSession().get(Studentdb.class,studentid);
	}

	@Override
	public List getAllStudents() {
		return session.getCurrentSession().createQuery("from Studentdb").list();
	}

}
