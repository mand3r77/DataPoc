package com.uscs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uscs.model.DriverVO;

public class UpdateController {

	
	@RequestMapping(value = "/updateDataInfo",method = RequestMethod.GET)
	public ModelAndView auditInfo(Model model , HttpSession httpSession, 
			@RequestParam("driverNumber")Long driverNumber
			){
		
		System.out.println("test");
			
		return null;
	}
	
}
