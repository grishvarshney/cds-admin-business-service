package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdsadmin.business.domain.Note;
import com.cdsadmin.business.service.MergerService;

@RestController
@RequestMapping("/merger")
public class MergerRestController {
	
	@Autowired
	MergerService mergerService;
	
	@RequestMapping(value = "/getAllNotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Note> getAllNotes() {
		return mergerService.getAllNotes();
	}

}
