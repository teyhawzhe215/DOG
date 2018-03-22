package com.dog.Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dog.Service.UserService;
import com.dog.entities.User;

@Controller
public class RegisterController {

	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/registerPage" , method = RequestMethod.GET)
	public String home() {
		return "register";
	}

	@RequestMapping(value="/registerAction" , method = RequestMethod.POST)
	public String register(HttpServletRequest request , Model model) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user =new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setTel(request.getParameter("tel"));
		
		logger.info(user.toString());
		
		try {
		
			//userService.save(user);
			model.addAttribute("test","新增成功!");
			model.addAttribute("STATUS","REDIRECT");
			model.addAttribute("name",request.getParameter("name"));
			model.addAttribute("email",request.getParameter("email"));
			model.addAttribute("address",request.getParameter("address"));
			model.addAttribute("tel",request.getParameter("tel"));
			model.addAttribute("sex",request.getParameter("sex"));
			return "register";
			
		}catch(Exception ex) {
			model.addAttribute("test",ex.toString());
			
			model.addAttribute("name",request.getParameter("name"));
			model.addAttribute("email",request.getParameter("email"));
			model.addAttribute("address",request.getParameter("address"));
			model.addAttribute("tel",request.getParameter("tel"));
			model.addAttribute("sex",request.getParameter("sex"));
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
