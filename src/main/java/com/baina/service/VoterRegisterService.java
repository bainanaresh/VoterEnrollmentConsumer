package com.baina.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.baina.entity.ApVoter;
import com.baina.entity.TelanganaVoter;
import com.baina.entity.Voter;
import com.javatechie.spring.soap.api.voterreg.VoterDetails;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;

@Service
public class VoterRegisterService {

	/*
	 * @Autowired(required = true) private SoapClinet clint;
	 */

	@Produce("direct:start")
	private ProducerTemplate template;

	private RestTemplate restTemplate;

	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}

	public VoterDetails getDetails(VoterEnrollment voter) {
		System.out.println(voter.getName());

		/* VoterEnrollment ve=new VoterEnrollment(); */

		return template.requestBody(voter, VoterDetails.class);
		/* return clint.getVoterDetails(voter); */
	}

	public List<Voter> getVoterList() {
		// TODO Auto-generated method stub
		List<Voter> vlist = restTemplate.getForObject("http://localhost:8081/voterlist", List.class);

		return vlist;
	}

	public String getVoterUpdatedDetails(int id) {
		String uri = "http://localhost:8081/update/" + id;
		System.out.println("**********"+uri);
		String updation = restTemplate.getForObject(uri, String.class);
		System.out.println("**********"+uri);
		return updation;
	}

	public VoterDetails storeTgVoter(TelanganaVoter request) {
		
		String uri = "http://localhost:8081/tg/save";
		System.out.println("**********"+uri);
		System.out.println("**********"+restTemplate);
		return restTemplate.postForObject(uri, request,VoterDetails.class);

	}

	public VoterDetails storeApVoter(ApVoter request) {
		String uri = "http://localhost:8081/ap/save";
		System.out.println("**********"+uri);
		return restTemplate.postForObject(uri, request,VoterDetails.class);

	}
}
