package com.cetpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.TimeTracker;
import com.cetpa.repositories.TimeTrackerRepository;
import com.cetpa.services.DatewiseReportService;

@Service
public class DatewiseReportServiceImpl implements DatewiseReportService 
{
	@Autowired
	private TimeTrackerRepository timeTrackerRepository;

	public List<TimeTracker> getCurrentDateList() 
	{
		return timeTrackerRepository.findByDate(LocalDate.now());
	}
	public List<TimeTracker> getAnyDateList(String date) 
	{
		LocalDate cdate=LocalDate.parse(date);
		return timeTrackerRepository.findByDate(cdate);
	}
	public List<TimeTracker> getDateBetweenList(String date1, String date2) 
	{
		LocalDate cdate1=LocalDate.parse(date1);
		LocalDate cdate2=LocalDate.parse(date2);
		return timeTrackerRepository.findDateBetweenList(cdate1, cdate2);
	}
}
