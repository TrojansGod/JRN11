package com.spring1.evaluation.service;

import java.util.List;

import java.util.Optional;

import com.spring1.evaluation.domain.Employee;

public interface EmployeeService {
	public List<Employee> listAll();
	public void delete(long id) ;
	public Optional<Employee> update(long id);
	public void save(Employee emp);
	public Employee get(long id);
	public List<Employee> findByName(String name);
}
