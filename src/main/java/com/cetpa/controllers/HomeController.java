package com.cetpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//-----    http://localhost:8080/time-tracker 
@Controller
@RequestMapping("time-tracker")
public class HomeController 
{
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
}
