package com.cdsadmin.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cdsadmin.business.domain.PurposeType;
import com.google.gson.*;

@Service
public class AdvanceMaintenanceService {
	public List<PurposeType> getAllPurposeTypes(){
		
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/purpose-types";
		final RestTemplate restTemplate = new RestTemplate();
		final String json = restTemplate.getForObject(
	            dataHubEndpointProjects,
	            String.class);
		final JsonArray jarr = new JsonParser().parse(json).getAsJsonArray();
		List<PurposeType> purposeTypeList = new ArrayList<PurposeType>();
		for (int i = 0; i < jarr.size(); i++) {
			final PurposeType purposeType = new PurposeType();
			JsonElement id = jarr.get(i).getAsJsonObject().get("id");
			JsonElement purposeTypeCode = jarr.get(i).getAsJsonObject().get("purposeTypeCode");
			JsonElement purposeTypeDescription = jarr.get(i).getAsJsonObject().get("purposeTypeDescription");
			
			purposeType.setId(id.getAsLong());
			purposeType.setPurposeTypeCode(id instanceof JsonNull ? "" : purposeTypeCode.getAsString());
			purposeType.setPurposeTypeDescription(id instanceof JsonNull ? "" : purposeTypeDescription.getAsString());
			purposeTypeList.add(purposeType);
		}
		/*PurposeType purposeType1 = new PurposeType();
		purposeType1.setPurposeTypeCode("C");
		purposeType1.setPurposeTypeDescription("CMA");
		PurposeType purposeType2 = new PurposeType();
		purposeType2.setPurposeTypeCode("L");
		purposeType2.setPurposeTypeDescription("Liquidity");
		PurposeType purposeType3 = new PurposeType();
		purposeType3.setPurposeTypeCode("M");
		purposeType3.setPurposeTypeDescription("Mortgages");
		PurposeType purposeType4 = new PurposeType();
		purposeType4.setPurposeTypeCode("O");
		purposeType4.setPurposeTypeDescription("Other");
		PurposeType purposeType5 = new PurposeType();
		purposeType5.setPurposeTypeCode("U");
		purposeType5.setPurposeTypeDescription("Urban Development");
		
		purposeTypeList.add(purposeType1);
		purposeTypeList.add(purposeType2);
		purposeTypeList.add(purposeType3);
		purposeTypeList.add(purposeType4);
		purposeTypeList.add(purposeType5);*/
		return purposeTypeList;
	}
	
	public PurposeType updatePurposeType(PurposeType purposeType) {
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/purpose-types";
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(dataHubEndpointProjects, purposeType);
		return purposeType;
		/*final PurposeType json = restTemplate.postForObject(dataHubEndpointProjects, 
				purposeType, PurposeType.class);
		return json;*/
	}
	
	public Long deletePurposeType(Long purposeTypeId) {
		String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/purpose-types/"+purposeTypeId;
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		restTemplate.delete(dataHubEndpointProjects);
		return purposeTypeId;
	}
	
	public PurposeType addPurposeType(PurposeType purposeType) {
		final String dataHubEndpointProjects = "http://localhost:8081/services/cdsdataservice/api/purpose-types";
		final RestTemplate restTemplate = new RestTemplate();
		//return purposeType;
		final PurposeType json = restTemplate.postForObject(dataHubEndpointProjects, 
				purposeType, PurposeType.class);
		return json;
	}
}
