package com.mattmottle.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmottle.relationships.models.License;
import com.mattmottle.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	LicenseRepository licenseRepository;
	
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense. isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
}
