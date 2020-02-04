package com.baina.router;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baina.entity.TelanganaVoter;
import com.baina.service.VoterRegisterService;
import com.javatechie.spring.soap.api.voterreg.VoterDetails;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;

@Component
public class SetTGVoterUpdate {
	
	@Autowired
	private VoterRegisterService service;
	
	@Handler
	public void process(Exchange exchange) {
		
		VoterDetails enrollment=(VoterDetails) exchange.getProperty("voterResponse");
		TelanganaVoter tv=new TelanganaVoter();
		tv.setVid(enrollment.getId());
		tv.setName(enrollment.getName());
		tv.setAge(enrollment.getAge());
		tv.setState(enrollment.getState());
		tv.setZipcode(enrollment.getZipcode());
		
		VoterDetails response=service.storeTgVoter(tv);
		
		
		exchange.getIn().setBody(response);
		
	}
	
}
