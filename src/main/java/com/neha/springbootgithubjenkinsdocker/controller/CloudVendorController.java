package com.neha.springbootgithubjenkinsdocker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neha.springbootgithubjenkinsdocker.model.CloudVendor;
import com.neha.springbootgithubjenkinsdocker.response.ResponseHandler;
import com.neha.springbootgithubjenkinsdocker.service.CloudVendorService;

@RestController
@RequestMapping("cloudvendor")
public class CloudVendorController {
	CloudVendorService cloudVendorService;
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Requested vendor details are: ", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
	}

//	@GetMapping("{vendorName}")
//	public ResponseEntity<Object> getCloudVendorDetailsByName(@PathVariable("vendorName") String vendorName) {
//		return ResponseHandler.responseBuilder("Requested vendor details are: ", HttpStatus.OK, cloudVendorService.getByVendorName(vendorName));
//	}

	@GetMapping
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();
	}

	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud vendor created sucessfully";
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud vendor updated sucessfully";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud vendor deleted sucessfully";
	}
}
