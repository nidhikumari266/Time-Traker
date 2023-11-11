package com.cetpa.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	List<Employee> findByStatus(String status);
	
	@Modifying
	@Transactional
	@Query("update Employee set status=:arg1 where eid=:arg2")
	void updateStatus(@Param("arg2") int eid,@Param("arg1") String status);
}
