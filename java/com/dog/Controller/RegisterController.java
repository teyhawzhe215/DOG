package com.dog.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dog.Service.UserService;
import com.dog.entities.User;

@Controller
public class RegisterController {

	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/registerPage" , method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("register","user",new User());
	}

	@RequestMapping(value="/registerAction" , method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user , Model model) {
		
	
		
		logger.info(user.toString());
		
		try {
		
			userService.save(user);
			model.addAttribute("test", "註冊成功!!!");
			model.addAttribute("STATUS", "REDIRECT");
			return "register";
		}catch(Exception ex) {
			model.addAttribute("test",ex.toString());
			
		
			return "register";
		}
	}
	
	@RequestMapping(value="/validationEmailAction" , method = RequestMethod.POST)
	@ResponseBody  
	public  Map<Object,Object> validationEmail(@RequestParam("email") String email){
		
		User user=userService.getUser(email);
		
		
		
		Map<Object,Object> message = new HashMap<Object,Object>();
			message.put("KEY", "N");
		if(user!=null) {
			message.put("KEY", "Y");	
		}
		
		
		return message;
		
	}
	
	
	
	
}
