package com.dog.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dog.Service.UserService;
import com.dog.entities.User;

@Controller
public class RegisterController2 {

	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController2.class);
	
	
	@Autowired
	UserService userService;
	
 
	
	@RequestMapping(value="/registerPage2" , method = RequestMethod.GET)
	public ModelAndView home() {
		return  new ModelAndView("register2","user",new User());
	}


	

	
	
	
	
}
