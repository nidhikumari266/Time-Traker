package com.cetpa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.TimeTracker;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.repositories.TimeTrackerRepository;
import com.cetpa.services.IntimeService;
import com.cetpa.util.TimeUtility;

@Service
public class IntimeServiceImpl implements IntimeService
{
	@Autowired
	private TimeTrackerRepository timeTrackerRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void updateTime(int eid) 
	{
		TimeTracker timeTracker=timeTrackerRepository.getTimeTrackerByEid(eid);
		String intime=TimeUtility.getCurrentTime();
		String outtime=timeTracker.getOuttime();
		String totaltime=TimeUtility.getTotalTime(intime,outtime);
		timeTracker.setIntime(intime);
		timeTracker.setTotaltime(totaltime);
		timeTrackerRepository.save(timeTracker);
		employeeRepository.updateStatus(eid,"in");
	}
}
