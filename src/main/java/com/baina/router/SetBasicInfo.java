package com.baina.router;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.stereotype.Component;

import com.baina.util.VoterUtilityConstants;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;

@Component
public class SetBasicInfo {
	
	@Handler
	public void process(Exchange exchange) {
		exchange.setProperty("flag",VoterUtilityConstants.operation_flag);
		exchange.setProperty("id_flag",VoterUtilityConstants.id_flag);
		VoterEnrollment enroll=exchange.getIn().getBody(VoterEnrollment.class);
		/* exchange.setProperty("enroll", enroll); */
		VoterUtilityConstants.voteEnrollment=enroll;
		
	}

}
