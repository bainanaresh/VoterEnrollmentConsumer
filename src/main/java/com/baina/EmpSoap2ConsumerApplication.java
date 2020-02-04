package com.baina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baina.entity.Voter;
import com.baina.service.VoterRegisterService;
import com.baina.util.VoterUtilityConstants;
import com.javatechie.spring.soap.api.voterreg.VoterDetails;
import com.javatechie.spring.soap.api.voterreg.VoterEnrollment;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.*")
public class EmpSoap2ConsumerApplication {
	
	@Autowired
	private VoterRegisterService service;

	public static void main(String[] args) {
		SpringApplication.run(EmpSoap2ConsumerApplication.class, args);
	}
	
	@GetMapping("/aa")
	public String getdet() {
		return "welcome to java";
	}
	
	@PostMapping("/getvoterStatus")
	public VoterDetails getDetails(@RequestBody VoterEnrollment voter) {
		VoterUtilityConstants.operation_flag="create";
		System.out.println(voter.getName());
		return service.getDetails(voter);
	}

	@GetMapping("/voterlist")
	public ResponseEntity<List<Voter>> getAllVoters(){
		List<Voter> vlist=service.getVoterList();
		return new ResponseEntity<List<Voter>>(vlist,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> getUpdatedDetails(@PathVariable int id) {
		VoterUtilityConstants.operation_flag="update";
		VoterUtilityConstants.id_flag=id;
		String udetails=service.getVoterUpdatedDetails(id);
		return new ResponseEntity<String>(udetails,HttpStatus.OK);
	}
	
}
