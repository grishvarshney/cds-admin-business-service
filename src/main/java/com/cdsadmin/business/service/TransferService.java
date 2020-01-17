package com.cdsadmin.business.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cdsadmin.business.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {

	public List<Note> getAllNotes(){
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes";
		final RestTemplate restTemplate = new RestTemplate();
		List<Note> notes = new ArrayList<Note>();
		notes = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            List.class);
		return notes;
	}

    public List<Note> getNotesByCustomer(String customerId, String systemId){
        //final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes";
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/getNotesByCustomer/"+customerId+"/"+systemId;
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


	public Transfer addTransfer(Transfer transfer) {
		//final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/mergers";
		final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/mergers";
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		List<String> noteIds = transfer.getNoteIds();
		Set<Note> notes = new HashSet<>();
		for(String noteId : noteIds) {
			Note note = new Note();
			note.setId(Long.parseLong(noteId));
			notes.add(note);
		}
		transfer.setNotes(notes);
		final Transfer json = restTemplate.postForObject(dataHubEndpointProjects,
				transfer, Transfer.class);
		return json;
	}

    public void undoMerger(List<MergersWrapper> mergerLists) {
        final RestTemplate restTemplate = new RestTemplate();
        for (final MergersWrapper merger : mergerLists) {
            final String dataHubNotesEndpoint = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes/" + Long.parseLong(merger.getNoteId());
            final String dataHubNoteUpdateEndpoint = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes/";
            final Note note = restTemplate.getForObject(dataHubNotesEndpoint, Note.class);
            if (note.getId() == Long.parseLong(merger.getNoteId())) {
                note.setMerger(null);
                restTemplate.put(dataHubNoteUpdateEndpoint, note);
            }
        }
    }

	public void undoTransfer(List<TransferWrapper> transferList) {
        final RestTemplate restTemplate = new RestTemplate();
        for (final TransferWrapper transferWrapper: transferList) {
            final String dataHubNotesEndpoint = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes/" + Long.parseLong(transferWrapper.getNoteId());
            final String dataHubNoteUpdateEndpoint = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes/";
            final Note note = restTemplate.getForObject(dataHubNotesEndpoint, Note.class);
            if (note.getId() == Long.parseLong(transferWrapper.getNoteId())) {
                note.setTransfer(null);
                restTemplate.put(dataHubNoteUpdateEndpoint, note);
            }
        }
    }
}
