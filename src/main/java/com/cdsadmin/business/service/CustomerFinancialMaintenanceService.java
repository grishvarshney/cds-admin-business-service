package com.cdsadmin.business.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdsadmin.business.domain.CustomerFinancial;

@Service
public class CustomerFinancialMaintenanceService {
	public List<CustomerFinancial> getAllCustomerFinancials() {
		List<CustomerFinancial> customerFinancialList = new ArrayList<CustomerFinancial>();
		//CustomerFinancialList customerFinancialList;
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customer-financials";
		final RestTemplate restTemplate = new RestTemplate();
		customerFinancialList = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            List.class);
		
		//List<CustomerFinancial> allCustomerFinancial = customerFinancialList.getCustomerFinancialList();
		return customerFinancialList;
    }
	
	public CustomerFinancial updateCustomerFinancial(CustomerFinancial customerFinancial) {
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customer-financials";
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(dataHubEndpointProjects, customerFinancial);
		return customerFinancial;
	}
	
	public CustomerFinancial addCustomerFinancial(CustomerFinancial customerFinancial) {
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customer-financials";
		final RestTemplate restTemplate = new RestTemplate();
		customerFinancial = restTemplate.postForObject(dataHubEndpointProjects, customerFinancial, CustomerFinancial.class);
		return customerFinancial;
	}
	
	public Long deleteCustomerFinancial(Long customerFinancialId) {
		String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customer-financials/"+customerFinancialId;
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		restTemplate.delete(dataHubEndpointProjects);
		return customerFinancialId;
	}

}
