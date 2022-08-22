package com.spring1.evaluation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring1.evaluation.domain.Employee;


public interface IEmployeeRepo extends JpaRepository<Employee, Long>{
	
	@Query(value = "select e from Employee e where e.firstName=:name")
	List<Employee> findByStudentName(@Param("name") String name);
}