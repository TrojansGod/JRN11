package com.spring1.evaluation.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.evaluation.domain.Employee;
import com.spring1.evaluation.repository.IEmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private IEmployeeRepo repo;
	

	public List<Employee> listAll() {
		return repo.findAll();
	}
	public List<Employee> listByname() {
		return repo.findAll();
	}

	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByStudentName(name);
	}
	public void save(Employee emp) {
		repo.save(emp);
	}

	public Employee get(long id) {
		return repo.findById(id).get();
	}
	

	public void delete(long id) {
		repo.deleteById(id);
	}
	public Optional<Employee> update(long id)
	{
		 return repo.findById(id);
	}
}
