package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Employee;
import com.cetpa.models.TimeTracker;
import com.cetpa.services.EmployeeService;
import com.cetpa.services.OuttimeService;

@Controller
@RequestMapping("time-tracker/out-time")
public class OuttimeController 
{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private OuttimeService outtimeService;
	
	@RequestMapping("")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList("in");
		model.addAttribute("elist",employeeList);
		return "time/out/employee-list";
	}
	@RequestMapping("record")
	public String recordTime(TimeTracker timeTracker)
	{
		outtimeService.insertTimeRecord(timeTracker);
		return "time/out/record-success";
	}
}
