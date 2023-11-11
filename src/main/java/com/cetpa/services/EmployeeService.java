package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	List<Employee> getList(String status);
}
