package com.sj.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

// hello human at root route
@RequestMapping("/")
public class HumanController {
	
	@RequestMapping("")
	public String greeting(@RequestParam(value="name", required = false) String userName, @RequestParam(value="last_name", required = false) String lastName, @RequestParam(value = "times", required = false) String times) {
		int limit = 0;
		System.out.println(userName);
		System.out.println(lastName);
		System.out.println(times);
		if (times ==null) {
			limit = 1;
		}
		else {
			limit = Integer.parseInt(times);
		}
		String greetStatment = new String();
		for(int i = 0; i < limit; i++) {
			if (userName == null) {
				greetStatment+= "Hello Human ";
				System.out.println("This is the first if greetStatment:" + greetStatment);
			}
			else if (lastName == null) {
				greetStatment+= "Hello ";
				greetStatment+= userName;
				greetStatment+= " ";
				System.out.println("This is the else if greetStatment:" + greetStatment);
			}
			else {				
				greetStatment+= "Hello ";
				greetStatment+= userName;
				greetStatment+= " ";
				greetStatment+= lastName;
				greetStatment+= " ";
				System.out.println("This is the final else greetStatment:" + greetStatment);
			}
		}
		return greetStatment;
	}
	
	
//	Sensei Bonus: 
//	include a query parameter that can be any number, and append the greeting to the string repeatedly before you return it to the browser to annoy your human!
}
