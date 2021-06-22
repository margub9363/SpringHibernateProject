package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
//	@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: Inside the default constructor");
	}

//	define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService thefortuneService) {
		System.out.println("TennisCoach: Inside setFortuneService() method");
		fortuneService = thefortuneService;
	}
	*/
	
	
	/*
//	AnyMethod
	@Autowired
	public void doSomeCrazyStuff(FortuneService thefortuneService) {
		System.out.println("TennisCoach: Inside doSomeCrazyStuff() method");
		fortuneService = thefortuneService;
	}
	*/

	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */
	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
