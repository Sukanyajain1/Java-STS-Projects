package com.sj.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}

	@RequestMapping("/today")
	public String todayMessage() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowMessage() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}	
	@RequestMapping("/travel/{location}")
	public String travelMessage(@PathVariable("location") String location) {
		System.out.println("Congratulations! You will soon travel to " + location);
		return "Congratulations! You will soon travel to " + location;
	}	
	@RequestMapping("/lotto/{number}")
	public String lottoMessage(@PathVariable("number") int number) {
		String prediction = new String();
		if (number %2==0) {
			prediction += "You will take a grand journey in the near future, but be wary of tempting offers.";
			System.out.println("Number is 6: " + prediction);
		}
		else{
			prediction += "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";	
			System.out.println("Number is 37: " + prediction);
		}
		return prediction;
	}	
	
}
