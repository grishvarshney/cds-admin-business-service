package com.cdsadmin.business.service;

import com.cdsadmin.business.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class MergerService {


    final RestTemplate restTemplate = new RestTemplate();


    public List<MergerNotes> searchMerger(String systemId, String customerId) {
        String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/systems/" + systemId;

        final Systems systems = restTemplate.getForObject(dataHubEndpointProjects,
            Systems.class);
        dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergersByCustFromOrTo/" + customerId + "/" + systems.getId();

        ResponseEntity<Merger[]> response = restTemplate.getForEntity(dataHubEndpointProjects, Merger[].class);
        Merger[] mergers = response.getBody();

        List<MergerNotes> mergerNotesList = new ArrayList<>();
        for (Merger merger : mergers) {
            dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/getNotesByMerger/" + merger.getId();

            ResponseEntity<Note[]> responseNote = restTemplate.getForEntity(dataHubEndpointProjects, Note[].class);
            Note[] notes = responseNote.getBody();

            for (Note note : notes) {
                MergerNotes ms = new MergerNotes();
                dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/customers/" + merger.getCustomerFrom();
                final Customer customerFr = restTemplate.getForObject(dataHubEndpointProjects,
                    Customer.class);

                dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/customers/" + merger.getCustomerTo();
                final Customer customerT = restTemplate.getForObject(dataHubEndpointProjects,
                    Customer.class);

                ms.setCustomerFrom(customerFr);
                ms.setCustomerTo(customerT);
                ms.setNoteNo(note.getNoteNo());
                ms.setIndustry(note.getIndustry());
                ms.setEffectiveDate(note.getEffectiveDate());
                ms.setInstrumentType(note.getInstrumentType());
                mergerNotesList.add(ms);

            }

        }

        return mergerNotesList;
    }

    public List<Note> getAllNotes() {
        final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/notes";
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

    public Merger addMerger(Merger merger) {
        //final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/mergers";
        final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergers";
        final RestTemplate restTemplate = new RestTemplate();
        //return purposeType;
        final Merger json = restTemplate.postForObject(dataHubEndpointProjects,
            merger, Merger.class);
        return json;
    }


    public void undoMerger(List<String> mergerLists) {
        final RestTemplate restTemplate = new RestTemplate();
        for (final String merger : mergerLists) {
            final String dataHubEndpointProjects = "http://cds-admin-dataservice-dev.pj7ps6ybg9.us-east-1.elasticbeanstalk.com/services/cdsdataservice/api/mergers/" + merger;
            restTemplate.delete(dataHubEndpointProjects, Void.class);
        }
    }
}
