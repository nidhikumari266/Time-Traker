package com.cetpa.services;

import java.util.List;

import com.cetpa.models.TimeTracker;

public interface DatewiseReportService 
{
	List<TimeTracker> getCurrentDateList();
	List<TimeTracker> getAnyDateList(String date);
	List<TimeTracker> getDateBetweenList(String date1, String date2);
}
