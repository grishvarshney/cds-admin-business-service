package com.cdsadmin.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdsadmin.business.domain.Customer;
import com.cdsadmin.business.domain.Merger;
import com.cdsadmin.business.domain.Note;

@Service
public class MergerService {
	
	public List<Note> getAllNotes(){
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes";
		final RestTemplate restTemplate = new RestTemplate();
		List<Note> notes = new ArrayList<Note>();
		notes = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            List.class);
		return notes;
	}
	
	public List<Customer> getAllCustomers(){
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customers";
		final RestTemplate restTemplate = new RestTemplate();
		List<Customer> customers = new ArrayList<Customer>();
		customers = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            List.class);
		return customers;
	}
	
	public Merger addMerger(Merger merger) {
		//final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/mergers";
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergers";
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		final Merger json = restTemplate.postForObject(dataHubEndpointProjects, 
				merger, Merger.class);
		return json;
	}

}
