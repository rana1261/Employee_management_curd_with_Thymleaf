package com.javatpoint.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
