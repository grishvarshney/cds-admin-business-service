package com.cdsadmin.business.web.rest.controller;

import java.util.List;


import com.cdsadmin.business.domain.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cdsadmin.business.service.MergerService;

@RestController
@RequestMapping("/merger")
@CrossOrigin(origins = "*")
public class MergerRestController {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(MergerRestController.class);


    @Autowired
    MergerService mergerService;

    @RequestMapping(value = "/getAllNotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getAllNotes() {
        return mergerService.getAllNotes();
    }

    @RequestMapping(value = "/getNotesByCustomerTo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomerTo(@RequestParam(required = true) String customerId,
    		@RequestParam(required = true) String systemId) {
        return mergerService.getNotesByCustomerTo(customerId, systemId);
    }

    @RequestMapping(value = "/getNotesByCustomerFrom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomerFrom(@RequestParam(required = true) String customerId,
    		@RequestParam(required = true) String systemId) {
        return mergerService.getNotesByCustomerFrom(customerId, systemId);
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


    @GetMapping(value = "/searchMerger/{systemId}/{customerId}")
    public  List<MergerNotes>  searchMerger(@PathVariable("systemId") String systemId ,
                                            @PathVariable("customerId") String customerId) {
        List<MergerNotes>  ln = mergerService.searchMerger(systemId, customerId);
        return ln;
    }


    @RequestMapping(value = "/undoMerger", method = RequestMethod.DELETE)
    public void undoMerger(@RequestBody MergersListWrapper mergersListWrapper) {
        int version = 1;
        if (logger.isDebugEnabled()) {
            logger.debug("Undoing the Merger");
            logger.debug("data: '" + mergersListWrapper + "'");
        }

        try {
            switch (version) {
                case 1:
                    if (logger.isDebugEnabled())
                        logger.debug("In version 1");
                    mergerService.undoMerger(mergersListWrapper.getMergerList());
                    break;
                default:
                    throw new Exception("Unsupported version: " + version);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("End Undo Merger");
        }
    }

}
