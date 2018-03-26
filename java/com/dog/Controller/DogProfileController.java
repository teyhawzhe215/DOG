package com.dog.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.engine.jdbc.BlobProxy;
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
    private HttpServletRequest request;  
	
	@Autowired
	private HttpSession session;
	
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
	public String saveDogProfile(@ModelAttribute DogProfile dogProfile ,Model model , @RequestParam MultipartFile image) throws IOException {
		
		
		
		if(!image.isEmpty()) {
			
		
			String rootPath = System.getProperty("catalina.home");
			
			File dir = new File(rootPath + File.separator + "tmpFiles");

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
			String fileName = formatter.format(date)+image.getOriginalFilename();
			String filePath = dir.getAbsolutePath()+"/" + fileName;
			   
			
			System.out.println("filePath   " + filePath);
			
			image.transferTo(new File(filePath));  
			   
			dogProfile.setDogImage(fileName);
			   
		}else {
			
			System.out.println("沒有圖片!");
			
		}
		
		System.out.println(dogProfile.toString());
		
		System.out.println("sieze="+image.getSize());
	
		dogProfileService.sava(dogProfile);
		
		return "redirect:/showDog";

	}
	
}
