package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method  doMyStartupStuff");
	}
	
//	add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method  doMyCleanupStuff");
	}
}
