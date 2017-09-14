package com.uscs.controller;



import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uscs.model.AuditInfoVO;
import com.uscs.model.DriverVO;
import com.uscs.model.ReturnAuditVO;
import com.uscs.service.AuditService;
import com.uscs.service.DriverService;


@Controller
public class MainController {
	
	@Inject
	DriverService driverService;
	
	@Inject
	AuditService auditService;
	
	@RequestMapping("/")
	public ModelAndView index(Model model){
		
		ModelAndView indexView = new ModelAndView("index");	
		return indexView;
	}
		
	
	@RequestMapping("/auditInfo")
	public ModelAndView auditInfo(Model model){
		
		ModelAndView auditView = new ModelAndView("audit");	
		return auditView;
	}
	
	
	@RequestMapping("/updateData")
	public ModelAndView updateData(Model model, HttpSession session ){
		DriverVO driver = driverService.getDriver();
		ModelAndView updateView = new ModelAndView("update");	
		updateView.addObject("driverVO", driver);
		session.setAttribute("originalObject", driver);
		return updateView;
	}
	
	@RequestMapping(value = "/updateDataInfo",method = RequestMethod.GET)
	public ModelAndView auditInfo(Model model , HttpSession session, 
			@RequestParam("driverNumber")String driverNumber,
			@RequestParam("driverID")String driverID,
			@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName,
			@RequestParam("contactNumber")String contactNumber,
			@RequestParam("birthDate")String birthDate,
			@RequestParam("issueFlag")String issueFlag,
			@RequestParam("createTS")String createTS,
			@RequestParam("createUsr")String createUsr,
			@RequestParam("updateTS")String updateTS,
			@RequestParam("updateUsr")String updateUsr
			) throws ParseException{
		
		DriverVO originalDriver = (DriverVO)session.getAttribute("originalObject");
		DriverVO currentDriver = new DriverVO();
		currentDriver.setDriverNumber(driverNumber);
		currentDriver.setDriverID(driverID);
		currentDriver.setFirstName(firstName);
		currentDriver.setLastName(lastName);
		currentDriver.setContactNumber(contactNumber);
		currentDriver.setBirthDate(birthDate);
		currentDriver.setIssueFlag(issueFlag);
		currentDriver.setCreateTS(createTS);
		currentDriver.setCreateUsr(createUsr);
		currentDriver.setUpdateTS(updateTS);
		currentDriver.setUpdateUsr(updateUsr);
		
		
		auditService.writeAuditInfo(driverService.compareObject(originalDriver, currentDriver));
		List<ReturnAuditVO> myList = auditService.readAuditInfo();
		ModelAndView indexView = new ModelAndView("index");			
		return indexView;
	}
	/*@RequestMapping(value ="/updateDataInfo", method = RequestMethod.GET)
	public ModelAndView auditInfo(Model model , HttpSession httpSession,BindingResult bindingResult ,DriverVO driverVO){
		
		System.out.println("test");
			
		return null;
	}*/
}
