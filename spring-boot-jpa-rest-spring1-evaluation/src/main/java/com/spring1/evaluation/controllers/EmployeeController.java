package com.spring1.evaluation.controllers;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.evaluation.domain.Employee;
import com.spring1.evaluation.service.EmployeeServiceImpl;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/e")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;


	@PostMapping("/EMP")
	public ResponseEntity<String> insertEmployee(@RequestBody Employee Employee) {
		System.out.println("save Employee..");
		service.save(Employee);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("/EMP")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.listAll();
		return list;
	}
	
	/*@GetMapping("/EMPBY")
	
	public List<Employee> getAllEmployeeBYname(@RequestParam(value = "name", required = true) String name) {
		List<Employee> list = service.listByname();
		List<Employee> list1=new ArrayList<Employee>();
		for(Employee e:list)
		{
			if(e.getFirstName().equals(name))
			{
				list1.add(e);
			}
		}
		
		return list1;
	}*/
	@GetMapping("/EMPN/{name}")
	public List<Employee> findByStudentName(@PathVariable("name") String name){
		return  service.findByName(name);
	}

	@DeleteMapping("/EMP/{id}")
	public ResponseEntity<String> updateEmployeeById(@PathVariable("id") long id) {
		service.delete(id);
		return new ResponseEntity<String>("DELETE-SUCCESSFULLY", HttpStatus.OK);
	}

	@DeleteMapping("/EMP")
	public ResponseEntity<String> updateEmployee() {
		List<Employee> list = service.listAll();
		for (Employee p : list) {
			service.delete(p.getId());
		}
		return new ResponseEntity<String>("DELETE-SUCCESSFULLY", HttpStatus.OK);
	}
	
	@GetMapping("/EMP/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		Employee list = service.get(id);
		return list;
		
	}
	
		


	@PutMapping("/EMP/{id}")
	public ResponseEntity<Object> updateEmployeeById(@PathVariable("id") long id, @RequestBody Employee Employee) {
		Optional<Employee> op = service.update(id);
		if (op.isPresent()) {
			Employee st = op.get();
			st.setFirstName(Employee.getFirstName());
			st.setLastName(Employee.getLastName());
			st.setEmail(Employee.getEmail());
			st.setNumber(Employee.getNumber());

			service.save(st);
			return new ResponseEntity<Object>(st, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("NOT FOUND", HttpStatus.NOT_FOUND);
		}
	}

}