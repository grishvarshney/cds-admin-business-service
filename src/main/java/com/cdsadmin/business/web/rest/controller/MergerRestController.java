package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import com.cdsadmin.business.domain.MergerNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "/addMerger", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addMerger(@RequestBody Merger merger) {
		mergerService.addMerger(merger);
		return "success";
	}

    @GetMapping(value = "/searchMerger/{systemId}/{customerId}")
    public  List<MergerNotes>  searchMerger(@PathVariable("systemId") String systemId ,
                               @PathVariable("customerId") String customerId) {
        List<MergerNotes>  ln = mergerService.searchMerger(systemId, customerId);
        return ln;
    }

}
