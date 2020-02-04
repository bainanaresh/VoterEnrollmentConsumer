package com.baina.router;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

import com.baina.util.VoterUtilityConstants;
import com.javatechie.spring.soap.api.clint.SoapClinet;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;


@Component
public class VoterEnrollmentRouter extends RouteBuilder {

	
	
	@Override
	public void configure() throws Exception {
		from("direct:start")
		.bean(SetBasicInfo.class)
		.bean(SoapClinet.class).end()
		.choice()
		.when(exchange->{
			VoterEnrollment request = exchange.getIn().getBody(VoterEnrollment.class);
			String state=request.getState();
			if(state.equals("telangana")) {
				System.out.println("update******"+state);
				return true;
			}
			return false;
		}).bean(SetTGVoterUpdate.class).end()
		.choice()
		.when(exchange->{
			VoterEnrollment request =VoterUtilityConstants.voteEnrollment;
			System.out.println("*********"+request);
			String state=request.getState();
			if(state.equals("ap")) {
				System.out.println("update******"+state);
				return true;
			}
			return false;
		}).bean(SetAPVoterUpdate.class).end();
		
	}

}
