package com.javatpoint.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.javatpoint.demo.model.Employee;
import com.javatpoint.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
    @RequestMapping("/")  
    public String index(){  
        return"index";  
    }
    
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Employee());  
        return "empform";   
    }
    
   /* @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Employee emp){    
        employeeService.addEmployee(emp);    
        return "redirect:/viewemp";//will redirect to viewemp request mapping    
    }*/
    
    @RequestMapping(value="/save", method=RequestMethod.POST)  
    public String save(Employee emp){  
        employeeService.addEmployee(emp); 
        return "redirect:/viewemp";
    } 
    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Employee> list= employeeService.getEmployees();   
        m.addAttribute("list",list);  
        return "viewemp";    
    }
    
    @RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Employee emp= employeeService.getStudent(id) ;   
        m.addAttribute("emp",emp);  
        return "empeditform";    
    }
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee emp){  
    	employeeService.employeeUpdate(emp);    
        return "redirect:/viewemp";    
    }
    
    
    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        employeeService.employeeDelete(id);
        return "redirect:/viewemp";    
    }
}
