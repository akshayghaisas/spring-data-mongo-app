package com.spring.data.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.mongo.domain.InstanceDetails;
import com.spring.data.mongo.domain.InstanceDetailsCustomRepository;
import com.spring.data.mongo.domain.InstanceDetailsVO;
import com.spring.data.mongo.domain.UpdateDetails;

@RequestMapping("/instancedetails")
@RestController
public class InstanceDetailsController {

	@Autowired
	private InstanceDetailsCustomRepository repoImpl;

	@PostMapping(value = "/addnewinstance", consumes = "application/json")
	public ResponseEntity<InstanceDetails> addNewInstance(@RequestBody InstanceDetailsVO details) {

		InstanceDetails instanceDetails = this.repoImpl.addNewInstance(details);

		return new ResponseEntity<>(instanceDetails, HttpStatus.OK);
	}

	@GetMapping(value = "/getSingleInstanceDetails/{instanceName}")
	public ResponseEntity<InstanceDetails> getSingleInstanceDetails(@PathVariable("instanceName") String instanceName) {

		InstanceDetails details = this.repoImpl.getInstanceDetails(instanceName);

		return new ResponseEntity<>(details, HttpStatus.OK);
	}

	@PostMapping(value = "/updateinstancestatus", consumes = "application/json")
	public ResponseEntity<Integer> updateInstanceStatus(@RequestBody UpdateDetails details) {
		int result = this.repoImpl.updateInstanceStatus(details.getInstanceName(), details.getStatus());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
