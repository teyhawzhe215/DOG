package com.dog.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dog.Service.DogProfileService;
import com.dog.entities.DogProfileLeftJoinDogClass;

@Controller
public class ShowDogController {

	
	private static final Logger logger = LoggerFactory.getLogger(ShowDogController.class);
	

	@Autowired
	DogProfileService dogProfileService;
	
	 
	
	@RequestMapping(value="/showDog" , method = RequestMethod.GET)
	public ModelAndView home(Model model) throws IOException {
		
		List<DogProfileLeftJoinDogClass> list = dogProfileService.getList();
	 
		
		model.addAttribute("list",list);
		
		return  new ModelAndView("showDog");
	}


	

	
	
	
	
}
