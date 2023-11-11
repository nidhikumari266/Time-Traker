package com.cetpa.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.models.TimeTracker;

public interface TimeTrackerRepository extends JpaRepository<TimeTracker,Integer> 
{
	@Query("from TimeTracker where intime='Not in yet' and eid=:arg")
	TimeTracker getTimeTrackerByEid(@Param("arg") int eid);
	List<TimeTracker> findByDate(LocalDate date);
	
	@Query("from TimeTracker where date between:arg1 and:arg2")
	List<TimeTracker> findDateBetweenList(@Param("arg1") LocalDate date1,@Param("arg2") LocalDate date2);
}
