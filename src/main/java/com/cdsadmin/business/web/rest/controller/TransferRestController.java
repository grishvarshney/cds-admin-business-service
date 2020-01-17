package com.cdsadmin.business.web.rest.controller;

import com.cdsadmin.business.domain.*;
import com.cdsadmin.business.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    
    @RequestMapping(value = "/getNotesByCustomerTo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomerTo(@RequestParam(required = true) String customerId,
    		@RequestParam(required = true) String systemId) {
        return transferService.getNotesByCustomerTo(customerId, systemId);
    }

    @RequestMapping(value = "/getNotesByCustomerFrom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomerFrom(@RequestParam(required = true) String customerId,
    		@RequestParam(required = true) String systemId) {
        return transferService.getNotesByCustomerFrom(customerId, systemId);
    }

    @RequestMapping(value = "/getNotesByCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotesByCustomer(@RequestParam(required = true) String customerId,
                                         @RequestParam(required = true) String systemId) {
        return transferService.getNotesByCustomer(customerId, systemId);
    }

    @RequestMapping(value = "/addTransfer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/searchTransfer/{systemId}/{customerId}")
    public List<TransferNotes> searchTransfer(@PathVariable("systemId") String systemId,
                                              @PathVariable("customerId") String customerId) {
        List<TransferNotes> ln = transferService.searchTransfer(systemId, customerId);
        return ln;
    }
    
}
