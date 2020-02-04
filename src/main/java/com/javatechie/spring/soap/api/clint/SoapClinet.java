package com.javatechie.spring.soap.api.clint;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.baina.util.VoterUtilityConstants;
import com.javatechie.spring.soap.api.voterreg.VoterDetails;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;

@Component
public class SoapClinet {

	@Autowired(required = true)
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public VoterDetails getVoterDetails(VoterEnrollment request) {
		template = new WebServiceTemplate(marshaller);
		VoterDetails details = (VoterDetails) template.marshalSendAndReceive("http://localhost:8081/ws", request);
		System.out.println(details);
		return details;
	}

	@Handler
	public void process(Exchange exchange) {

		VoterEnrollment request = exchange.getIn().getBody(VoterEnrollment.class);

		VoterDetails response = getVoterDetails(request);

		/* exchange.getIn().setBody(response); */
		VoterUtilityConstants.voterDetails=response;
		exchange.setProperty("voterResponse", response);

	}

}
