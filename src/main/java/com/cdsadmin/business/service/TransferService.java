package com.cdsadmin.business.service;

import com.cdsadmin.business.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransferService {

    final RestTemplate restTemplate = new RestTemplate();

    public List<Note> getAllNotes() {
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes";
        final RestTemplate restTemplate = new RestTemplate();
        List<Note> notes = new ArrayList<Note>();
        notes = restTemplate.getForObject(
            dataHubEndpointProjects,
            List.class);
        return notes;
    }
    
    public List<Note> getNotesByCustomerTo(String customerId, String systemId){
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/transfer/getNotesByCustomerTo/"+customerId+"/"+systemId;
        //final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/transfer/getNotesByCustomerTo/"+customerId+"/"+systemId;

        final RestTemplate restTemplate = new RestTemplate();
        List<Note> notes = new ArrayList<Note>();
        notes = restTemplate.getForObject(
            dataHubEndpointProjects,
            List.class);
        return notes;
    }

    public List<Note> getNotesByCustomerFrom(String customerId, String systemId){
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/transfer/getNotesByCustomerFrom/"+customerId+"/"+systemId;
        //final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/transfer/getNotesByCustomerFrom/"+customerId+"/"+systemId;
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

    public List<Customer> getAllCustomers() {
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customers";
        final RestTemplate restTemplate = new RestTemplate();
        List<Customer> customers = new ArrayList<Customer>();
        customers = restTemplate.getForObject(
            dataHubEndpointProjects,
            List.class);
        return customers;
    }


    public Transfer addTransfer(Transfer transfer) {
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/transfers";
        //final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/transfers";
        final RestTemplate restTemplate = new RestTemplate();
        //return purposeType;
        List<String> noteIds = transfer.getNoteIds();
        Set<Note> notes = new HashSet<>();
        for (String noteId : noteIds) {
            Note note = new Note();
            note.setId(Long.parseLong(noteId));
            notes.add(note);
        }
        transfer.setNotes(notes);
        final Transfer json = restTemplate.postForObject(dataHubEndpointProjects,
            transfer, Transfer.class);
        return json;
    }

    public List<TransferNotes> searchTransfer(String systemId, String customerId) {
        String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/systems/" + systemId;

        final Systems systems = restTemplate.getForObject(dataHubEndpointProjects,
            Systems.class);
        dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/transfersByCustFromOrTo/" + customerId + "/" + systems.getId();

        ResponseEntity<Transfer[]> response = restTemplate.getForEntity(dataHubEndpointProjects, Transfer[].class);
        Transfer[] transfers = response.getBody();

        List<TransferNotes> transferNotesList = new ArrayList<>();
        for (Transfer transfer : transfers) {
            dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/getNotesByTransfer/" + transfer.getId();

            ResponseEntity<Note[]> responseNote = restTemplate.getForEntity(dataHubEndpointProjects, Note[].class);
            Note[] notes = responseNote.getBody();

            for (Note note : notes) {
                TransferNotes ms = new TransferNotes();
                dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customers/" + transfer.getCustomerFrom();
                final Customer customerFr = restTemplate.getForObject(dataHubEndpointProjects,
                    Customer.class);

                dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/customers/" + transfer.getCustomerTo();
                final Customer customerT = restTemplate.getForObject(dataHubEndpointProjects,
                    Customer.class);

                ms.setCustomerFrom(customerFr);
                ms.setCustomerTo(customerT);
                ms.setNoteNo(note.getNoteNo());
                ms.setIndustry(note.getIndustry());
                ms.setEffectiveDate(note.getEffectiveDate());
                ms.setInstrumentType(note.getInstrumentType());
                ms.setTransferId(transfer.getId());
                ms.setNoteId(note.getId());
                transferNotesList.add(ms);

            }

        }

        return transferNotesList;
    }

	public void undoTransfer(List<TransferWrapper> transferList) {
        final RestTemplate restTemplate = new RestTemplate();
        for (final TransferWrapper transferWrapper : transferList) {
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
