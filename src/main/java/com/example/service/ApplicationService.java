package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CrewApplication;
import com.example.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public String getApplicationStatus(String icNo, String email) {
        CrewApplication application = applicationRepository.findByIcNoAndEmail(icNo, email);
        if (application != null) {
            return "Your application status is: " + application.getStatus();
        }
        return "Application not found. Please check your IC number and email.";
    }

    public void saveApplication(CrewApplication application) {
        applicationRepository.save(application);
    }
}

