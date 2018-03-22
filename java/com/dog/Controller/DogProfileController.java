package com.dog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dog.Service.DogClassService;

@Controller
public class DogProfileController {

	@Autowired
	private DogClassService dogClassService;
	
	@RequestMapping(value="/DogProfilePage" , method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("dogClass",dogClassService.getDogClass());
		
		return "uploadDogProfile";
	}
	
}
