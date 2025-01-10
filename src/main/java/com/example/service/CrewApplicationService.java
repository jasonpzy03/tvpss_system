package com.example.service;

import com.example.entity.CrewApplication;
import com.example.repository.CrewApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrewApplicationService {

    @Autowired
    private CrewApplicationRepository crewApplicationRepository;

    @Transactional
    public void submitApplication(CrewApplication application) {
        crewApplicationRepository.saveCrewApplication(application);
    }

    public List<CrewApplication> getAllApplications() {
        return crewApplicationRepository.getAllCrewApplications();
    }
}
