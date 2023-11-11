package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Employee;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public List<Employee> getList(String status) 
	{
		return employeeRepository.findByStatus(status);
	}
}
