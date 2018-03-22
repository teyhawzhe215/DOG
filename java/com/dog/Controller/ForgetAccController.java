package com.dog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgetAccController {
	
	@RequestMapping(value="/forgetAccPage" , method = RequestMethod.GET)
	public String home() {
		return "forgetAcc";
	}
	
	
}
