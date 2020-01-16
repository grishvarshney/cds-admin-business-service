package com.cdsadmin.business.service;

import com.cdsadmin.business.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MergerService {

    final RestTemplate restTemplate = new RestTemplate();

    public List<Note> getAllNotes() {
        final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/notes";
        final RestTemplate restTemplate = new RestTemplate();
        List<Note> notes = new ArrayList<Note>();
        notes = restTemplate.getForObject(
            dataHubEndpointProjects,
            List.class);
        return notes;
    }

    public Merger addMerger(Merger merger) {
        final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergers";
        final RestTemplate restTemplate = new RestTemplate();
        //return purposeType;
        final Merger json = restTemplate.postForObject(dataHubEndpointProjects,
            merger, Merger.class);
        return json;
    }


    public List<MergerNotes> searchMerger(String systemId, String customerId) {
        String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/systems/" + systemId;

        final Systems systems = restTemplate.getForObject(dataHubEndpointProjects,
            Systems.class);
        Long mergerId = systems.getMerger() == null ? null : systems.getMerger().getId();
        dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/mergersByCustFromOrTo/" + customerId;

        ResponseEntity<Merger[]> response = restTemplate.getForEntity(dataHubEndpointProjects, Merger[].class);
        Merger[] mergers = response.getBody();

        List<Merger> mergerList = new ArrayList<>();

        for (Merger merger : mergers) {
            if (merger.getId() == mergerId) {
                mergerList.add(merger);
            }
        }
        List<MergerNotes> mergerNotesList = new ArrayList<>();
        if (mergerList != null && !mergerList.isEmpty()) {
            for (Merger merger : mergerList) {
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
        }

        return mergerNotesList;
    }

}
