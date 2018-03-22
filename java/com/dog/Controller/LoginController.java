package com.dog.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value="/loginPage" , method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	@RequestMapping(value="/loginAction" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String email , @RequestParam String password , HttpSession session) {
		
		Map<String, Object> profile = new ModelMap();

		try {
			
			List<Map<String, Object>> user=us.getUser(email,password);
			
			if(user.size()>0) {
				
				Iterator itr = user.iterator();
				
				while(itr.hasNext()){
					Object[] obj = (Object[]) itr.next();
					
					for(int i=0;i<obj.length;i++) {
						System.out.println(String.valueOf(obj[i]));
					}
					
				}
				
			
				
				profile.put("STATUS1", "SUCCESS");	
				//session.setAttribute("USER", user);
				//session.setAttribute("LOGIN", "OK");
						
				return new ModelAndView("login",profile);
				
				
			}else {
				profile.put("STATUS1", "ERROR");
				profile.put("MESSAGE", "密碼錯誤!");
				return new ModelAndView("login",profile);
			}
			
			
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
			profile.put("STATUS1", "ERROR");
			profile.put("MESSAGE", "密碼錯誤!");
			return new ModelAndView("login",profile);
		}
		
		
		
	}
	
	@RequestMapping(value="/session" , method = RequestMethod.POST)
	public String getSession(HttpSession session) {
		
		System.out.println(session.getAttributeNames());
		
		return "login";
	}
	
}
