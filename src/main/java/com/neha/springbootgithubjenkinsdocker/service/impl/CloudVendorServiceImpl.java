package com.neha.springbootgithubjenkinsdocker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neha.springbootgithubjenkinsdocker.exception.CloudVendorNotFoundException;
import com.neha.springbootgithubjenkinsdocker.model.CloudVendor;
import com.neha.springbootgithubjenkinsdocker.repository.CloudVendorRepository;
import com.neha.springbootgithubjenkinsdocker.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		if(cloudVendorRepository.findById(vendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud vendor id not found");
		return cloudVendorRepository.findById(vendorId).get();
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Updated with success";
	}

	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "Deleted with success";
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

	public List<CloudVendor> getByVendorName(String vendorName) {
		return cloudVendorRepository.findByVendorName(vendorName);
	}
}
