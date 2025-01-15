package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Competition;
import com.example.entity.Participant;
import com.example.repository.PPDDao;

@Service
public class PPDService {
	
	@Autowired
	private PPDDao ppdDao;
	
    public void saveCompetition(Competition competition) {
    	ppdDao.save(competition);
    }

    public Competition getCompetitionById(Long id) {
        try {
            return ppdDao.getCompetitionById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateCompetition(Competition competition) {
        try {
            ppdDao.updateCompetition(competition);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update competition: " + e.getMessage());
        }
    }


    public void deleteCompetition(Long id) {
        try {
            ppdDao.deleteCompetition(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete competition: " + e.getMessage());
        }
    }
    
    public List<Competition> getAllCompetitions() {
        try {
            return ppdDao.getAllCompetition();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return empty list instead of null
        }
    }
    
    @Transactional(readOnly = true)
    public List<Participant> getAllParticipants() {
        return ppdDao.getAllParticipants();
    }

    public Long getKulaiSchoolsCount() {
        return ppdDao.getKulaiSchoolsCount();
    }
}