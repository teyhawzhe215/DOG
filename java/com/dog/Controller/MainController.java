package com.dog.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	@Autowired
	HttpServletResponse response;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
}
