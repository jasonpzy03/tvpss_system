package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CrewApplication;
import com.example.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository; // Your JPA repository

    public String getApplicationStatus(String icNo, String email) {
        // Query the database for the application status
        CrewApplication application = applicationRepository.findByIcNoAndEmail(icNo, email);
        
        if (application != null) {
            return "Your application status is: " + application.getStatus(); // Assuming you have a status field
        } else {
            return "Application not found. Please check your IC number and email.";
        }
    }
    
    public void saveApplication(CrewApplication application) {
        applicationRepository.save(application); // This should work as long as everything is set up correctly
    }

}
