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
import com.cdsadmin.business.domain.Note;
import com.cdsadmin.business.domain.Transfer;
import com.cdsadmin.business.service.TransferService;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "*")
public class TransferRestController {
	
	@Autowired
	TransferService transferService;
	
	@RequestMapping(value = "/getAllNotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Note> getAllNotes() {
		return transferService.getAllNotes();
	}
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return transferService.getAllCustomers();
	}
	
	@RequestMapping(value = "/addMerger", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addTransfer(@RequestBody Transfer transfer) {
		transferService.addTransfer(transfer);
		return "success";
	}

}
