package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdsadmin.business.domain.PurposeType;
import com.cdsadmin.business.service.AdvanceMaintenanceService;



@RestController
@RequestMapping("/advancemaintenance")
@CrossOrigin(origins = "*")
public class AdvanceMaintenanceRestController {
	
	@Autowired
	AdvanceMaintenanceService advanceMaintenanceService;
	
	@RequestMapping(value = "/getAllPurposeTypes", method = RequestMethod.GET)
	public List<PurposeType> getPurposeTypes() {
		return advanceMaintenanceService.getAllPurposeTypes();
	}
	
	@RequestMapping(value = "/updatePurposeType", method = RequestMethod.POST)
	@ResponseBody
	public PurposeType updatePurposeType(@RequestBody PurposeType purposeType) {
		return advanceMaintenanceService.updatePurposeType(purposeType);
		//return null;
	}
	
	@RequestMapping(value = "/deletePurposeType", method = RequestMethod.DELETE)
	@ResponseBody
	public Long deletePurposeType(@RequestParam(required = false) String purposeTypeId) {
		return advanceMaintenanceService.deletePurposeType(Long.parseLong(purposeTypeId));
		//return null;
	}
	
	/*@RequestMapping(value = "/addPurposeType", method = RequestMethod.POST)
	@ResponseBody
	public PurposeType addPurposeType(@RequestBody PurposeType purposeType) {
		return advanceMaintenanceService.addPurposeType(purposeType);
		//return null;
	}*/
	
	@RequestMapping(value = "/addPurposeType", method = RequestMethod.POST)
	//@ResponseBody
	public String addPurposeType(@RequestParam(required = false) String purposeTypeCode,
			@RequestParam(required = false) String purposeTypeDescription) {
		PurposeType purposeType = new PurposeType();
		PurposeType responseObj = new PurposeType();
		
		String response;
		try {
			purposeType.setPurposeTypeCode(purposeTypeCode);
			purposeType.setPurposeTypeDescription(purposeTypeDescription);
			responseObj =  advanceMaintenanceService.addPurposeType(purposeType);
			response = responseObj.toString();
			
		}catch(Exception e) {
			response = "Error";
		}
		
		return response;
	}
	

}
