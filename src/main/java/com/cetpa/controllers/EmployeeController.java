package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Employee;
import com.cetpa.services.EmployeeService;

@Controller
@RequestMapping("time-tracker/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("add")
	public String getAddEmployeeView()
	{
		return "employee/add-employee";
	}
	@RequestMapping("save")
	public String saveRecord(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "employee/save-success";
	}
}
