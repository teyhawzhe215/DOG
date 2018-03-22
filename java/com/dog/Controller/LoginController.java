package com.dog.Controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dog.Service.UserService;
import com.dog.entities.User;

import ch.qos.logback.classic.Logger;

@Controller
public class LoginController {

	@Autowired
	private UserService us ;
	
	@RequestMapping(value="/loginPage" ,  method = {RequestMethod.GET , RequestMethod.POST })
	public String home() {
		return "login";
	}
	
	@RequestMapping(value="/loginAction" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String email , @RequestParam String password , HttpSession session) {
		
		Map<String, Object> profile = new ModelMap();

		try {
			
			Map<String, Object> user=us.getUser(email,password);
			
			if(user!=null) {
				
				System.out.println("有資料的說:");
				
			
				for(String index : user.keySet()) {
					session.setAttribute(index,  user.get(index));
					System.out.println(index  +   " , "  +user.get(index));
				}
				
				profile.put("STATUS", "SUCCESS");	
				profile.put("MESSAGE", "登入成功!");
				session.setAttribute("USER", user);
				session.setAttribute("LOGIN", "OK");
						
				return new ModelAndView("redirect:/loginPage",profile);		
			}else {
				profile.put("STATUS1", "ERROR");
				profile.put("MESSAGE", email);
				profile.put("EMAIL", "密碼錯誤!");
				return new ModelAndView("login",profile);
			}
			
			
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
			profile.put("STATUS", "ERROR");
			profile.put("MESSAGE", "密碼錯誤!");
			profile.put("EMAIL", email);
			return new ModelAndView("login",profile);
		}
		
		
		
	}
	
	@RequestMapping(value="/session" , method = RequestMethod.GET)
	public String getSession(HttpSession session) {
		
		Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            System.out.println(s + " == " + session.getAttribute(s));
        }
        
		return "login";
	}
	
}
