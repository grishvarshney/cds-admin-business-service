package com.cdsadmin.business.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdsadmin.business.domain.CustomerFinancial;
import com.cdsadmin.business.service.CustomerFinancialMaintenanceService;

@RestController
@RequestMapping("/customerfinancial")
public class CustomerFinancialMaintenanceRestController {
	@Autowired
	CustomerFinancialMaintenanceService customerFinancialMaintenanceService;
	
	@RequestMapping(value = "/getAllCustomerFinancials", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CustomerFinancial> getAllCustomerFinancials() {
		return customerFinancialMaintenanceService.getAllCustomerFinancials();
	}
	
	@RequestMapping(value = "/updateCustomerFinancial", method = RequestMethod.POST)
	@ResponseBody
	public CustomerFinancial updateCustomerFinancial(@RequestBody CustomerFinancial customerFinancial) {
		return customerFinancialMaintenanceService.updateCustomerFinancial(customerFinancial);
	}
	
	@RequestMapping(value = "/addCustomerFinancial", method = RequestMethod.POST)
	@ResponseBody
	public CustomerFinancial addCustomerFinancial(@RequestBody CustomerFinancial customerFinancial) {
		return customerFinancialMaintenanceService.addCustomerFinancial(customerFinancial);
	}
}
