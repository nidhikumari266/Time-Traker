package com.cetpa.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.TimeTracker;
import com.cetpa.services.DatewiseReportService;

@Controller
@RequestMapping("time-tracker/reports/datewise")
public class DatewiseReportController 
{
	@Autowired
	private DatewiseReportService datewiseReportService;
	
	@RequestMapping("")
	public String getChooseDateView(Model model)
	{
		model.addAttribute("cdate",LocalDate.now());
		return "reports/datewise/choose-date";
	}
	@RequestMapping("current-date")
	public String getCurrentDateReportView(Model model)
	{
		List<TimeTracker> currentDateReposrList=datewiseReportService.getCurrentDateList();
		model.addAttribute("list",currentDateReposrList);
		return "reports/datewise/current-date";
	}
	@RequestMapping("any-date")
	public String getAnyDateReportView(Model model,String date)
	{
		List<TimeTracker> anyDateReposrList=datewiseReportService.getAnyDateList(date);
		model.addAttribute("list",anyDateReposrList);
		model.addAttribute("date",date);
		return "reports/datewise/any-date";
	}
	@RequestMapping("date-between")
	public String getDateBetweenReportView(Model model,String date1,String date2)
	{
		List<TimeTracker> dateBetweenReposrList=datewiseReportService.getDateBetweenList(date1,date2);
		model.addAttribute("list",dateBetweenReposrList);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "reports/datewise/date-between";
	}
}
