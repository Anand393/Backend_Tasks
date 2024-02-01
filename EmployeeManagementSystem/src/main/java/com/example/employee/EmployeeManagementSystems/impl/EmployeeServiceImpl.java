 package com.example.employee.EmployeeManagementSystems.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.EmployeeManagementSystems.model.Employee;
import com.example.employee.EmployeeManagementSystems.repository.EmployeeRepo;
import com.example.employee.EmployeeManagementSystems.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepo employeeRepo; 

	
	
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
		// TODO Auto-generated constructor stub
	} 



	@Override
	public Employee addEmployee(Employee employee) {
		
		
	    Employee  emp = employeeRepo.save(employee);
		return emp;
	}
	
	

	@Override
	public String removeEmployee(int id) {
		
		
		employeeRepo.deleteById(id);
		return "Employee deleted Successfully !!";
	}

	@Override
	public List<Employee> getAllEmployee() {

        List<Employee> emp = employeeRepo.findAll();
		return emp;
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
	
	    Optional<Employee> emp = employeeRepo.findById(id);
	    
	    if(emp.isPresent()) {
	    	
	    	return emp;
	    	
	    } else {
	    	
	    	return null;
	    }
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
	    Employee existing_employee = employeeRepo.findById(id).orElse(null);
	        
	    if(existing_employee != null) {	   
	        	existing_employee.setId(id);
	        	existing_employee.setName(employee.getName());
	        	existing_employee.setEmail(employee.getEmail());
	        	existing_employee.setDepartment(employee.getDepartment());
	        	existing_employee.setJoiningDate(employee.getJoiningDate());
	            return  employeeRepo.save(existing_employee);
	    	}else  {
	        	return null;
	      }
	    }
	
	
}
