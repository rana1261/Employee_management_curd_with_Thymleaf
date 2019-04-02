package com.javatpoint.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javatpoint.demo.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List <Employee>getEmployees(){
		List <Employee>employee=new ArrayList<>();
		employeeRepository.findAll().forEach(employee::add);
		return employee;
		
	}
	
	 public void addEmployee(Employee emp){  
		 employeeRepository.save(emp) ;
		    }
	 
	 public Employee getStudent(Integer id){  
	     return employeeRepository.findById(id).get();
	    } 
	 
	 public void employeeUpdate(Employee emp){  
		 employeeRepository.save(emp) ;
	    }
	 
	 public void employeeDelete(Integer id){ 
		 employeeRepository.deleteById(id);
		  
	    }
}
