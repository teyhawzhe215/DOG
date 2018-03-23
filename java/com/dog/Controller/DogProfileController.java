package com.dog.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dog.Service.DogClassService;
import com.dog.Service.DogProfileService;
import com.dog.entities.DogProfile;

@Controller
public class DogProfileController {

	@Autowired
	private DogClassService dogClassService;
	
	@Autowired
	private DogProfileService dogProfileService;
	
	@RequestMapping(value="/DogProfilePage" , method = RequestMethod.GET)
	public String home(Model model) {
		
		
		DogProfile dogProfile = new DogProfile();
		dogProfile.setDogCounter(0);
		dogProfile.setDogUploadUser("user");
		dogProfile.setDogUser("user1");
		
		model.addAttribute("dogClass",dogClassService.getDogClass());
		model.addAttribute("dogProfile",dogProfile);

		return "uploadDogProfile";
	}
	
	@RequestMapping(value="/saveDogProfile" , method = RequestMethod.POST )
	public String saveDogProfile(@ModelAttribute DogProfile dogProfile , @RequestParam MultipartFile image ,Model model) {
		
		System.out.println(dogProfile.toString());
		
	
		System.out.println("sieze="+image.getSize());
		 
		try {
			dogProfile.setDogImage(image.getBytes());
			dogProfileService.sava(dogProfile);
			
			return "redirect:/DogProfilePage";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			
			
			e.printStackTrace();
			System.out.println(e);
		}
		model.addAttribute("dogProfile", dogProfile);
		return "uploadDogProfile";
	}
	
}
