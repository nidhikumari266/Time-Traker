package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Employee;
import com.cetpa.models.TimeTracker;
import com.cetpa.services.EmployeeService;
import com.cetpa.services.IntimeService;
import com.cetpa.services.OuttimeService;

@Controller
@RequestMapping("time-tracker/in-time")
public class IntimeController 
{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private IntimeService intimeService;
	
	@RequestMapping("")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList("out");
		model.addAttribute("elist",employeeList);
		return "time/in/employee-list";
	}
	@RequestMapping("record")
	public String recordTime(int eid)
	{
		intimeService.updateTime(eid);
		return "time/in/record-success";
	}
}
