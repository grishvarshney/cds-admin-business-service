package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import com.cdsadmin.business.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdsadmin.business.service.TransferService;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "*")
public class TransferRestController {
    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(MergerRestController.class);

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

    @RequestMapping(value = "/getNotesByCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomer(@RequestParam(required = true) String customerId,
    		@RequestParam(required = true) String systemId) {
        return transferService.getNotesByCustomer(customerId, systemId);
    }

	@RequestMapping(value = "/addMerger", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addTransfer(@RequestBody Transfer transfer) {
		transferService.addTransfer(transfer);
		return "success";
	}

    @RequestMapping(value = "/undoTransfer", method = RequestMethod.DELETE)
    public void undoMerger(@RequestBody TransferListWrapper transferListWrapper) {
        int version = 1;
        if (logger.isDebugEnabled()) {
            logger.debug("Undoing the Transfer");
            logger.debug("data: '" + transferListWrapper + "'");
        }

        try {
            switch (version) {
                case 1:
                    if (logger.isDebugEnabled())
                        logger.debug("In version 1");
                    transferService.undoTransfer(transferListWrapper.getTransferList());
                    break;
                default:
                    throw new Exception("Unsupported version: " + version);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("End Undo Transfer");
        }
    }

}
