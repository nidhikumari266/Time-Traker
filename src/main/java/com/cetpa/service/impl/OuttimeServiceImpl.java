package com.cetpa.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.TimeTracker;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.repositories.TimeTrackerRepository;
import com.cetpa.services.OuttimeService;
import com.cetpa.util.TimeUtility;

@Service
public class OuttimeServiceImpl implements OuttimeService 
{
	@Autowired
	private TimeTrackerRepository timeTrackerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public void insertTimeRecord(TimeTracker timeTracker) 
	{
		timeTracker.setOuttime(TimeUtility.getCurrentTime());
		timeTracker.setIntime("Not in yet");
		timeTracker.setTotaltime("Not applicable");
		timeTracker.setDate(LocalDate.now());
		timeTrackerRepository.save(timeTracker);
		employeeRepository.updateStatus(timeTracker.getEid(),"out");
	}
}
