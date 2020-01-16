package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdsadmin.business.domain.Customer;
import com.cdsadmin.business.domain.Merger;
import com.cdsadmin.business.domain.Note;
import com.cdsadmin.business.service.MergerService;

@RestController
@RequestMapping("/merger")
@CrossOrigin(origins = "*")
public class MergerRestController {
	
	@Autowired
	MergerService mergerService;
	
	@RequestMapping(value = "/getAllNotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Note> getAllNotes() {
		return mergerService.getAllNotes();
	}
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return mergerService.getAllCustomers();
	}
	
	@RequestMapping(value = "/addMerger", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addMerger(@RequestBody Merger merger) {
		mergerService.addMerger(merger);
		return "success";
	}

}
