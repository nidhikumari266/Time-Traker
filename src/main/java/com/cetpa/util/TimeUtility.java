package com.cetpa.util;

import java.time.LocalTime;

public class TimeUtility 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		String time=lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
		return time;
	}

	public static String getTotalTime(String intime, String outtime) 
	{
		int intimes=convertToSecond(intime);
		int outtimes=convertToSecond(outtime);
		int total=intimes-outtimes;
		int h=total/3600;
		int s=total%3600;
		int m=s/60;
		s=s%60;
		String time=h+"hr & "+m+"min & "+s+"sec";
		return time;
	}
	private static int convertToSecond(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*60*60+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
}