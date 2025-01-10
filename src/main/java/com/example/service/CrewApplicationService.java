package com.example.service;

import com.example.entity.CrewApplication;
import com.example.repository.CrewApplicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrewApplicationService {

    @Autowired
    private CrewApplicationDAO crewApplicationDAO;

    @Transactional
    public void submitApplication(CrewApplication application) {
    	crewApplicationDAO.saveCrewApplication(application);
    }

    public List<CrewApplication> getAllApplications() {
        return crewApplicationDAO.getAllCrewApplications();
    }
    
    public CrewApplication findApplicationByIcNoAndEmail(String icNo, String email) {
        return crewApplicationDAO.findByIcNoAndEmail(icNo, email);
    }
}