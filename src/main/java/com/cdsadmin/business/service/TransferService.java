package com.cdsadmin.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdsadmin.business.domain.Note;
import com.cdsadmin.business.domain.Transfer;

@Service
public class TransferService {

	public List<Note> getAllNotes(){
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/notes";
		final RestTemplate restTemplate = new RestTemplate();
		List<Note> notes = new ArrayList<Note>();
		notes = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            List.class);
		return notes;
	}

	public Transfer addTransfer(Transfer transfer) {
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergers";
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		final Transfer json = restTemplate.postForObject(dataHubEndpointProjects,
				transfer, Transfer.class);
		return json;
	}

	public void undoTransfer(List<String> transferIds) {
        final RestTemplate restTemplate = new RestTemplate();
        for (final String transferId: transferIds) {
            final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/transfers/" + transferId;
            restTemplate.delete(dataHubEndpointProjects, Void.class);
        }
    }


}
