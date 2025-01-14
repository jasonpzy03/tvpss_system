package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Competition;
import com.example.entity.Participant;
import com.example.repository.JPNJDao;

@Service
@Transactional
public class JPNJService {
	@Autowired
    private JPNJDao jpnjDao;
	
	public void createCompetition(Competition competition) {
		jpnjDao.saveCompetition(competition);
	}
	    
	public void updateCompetition(Competition competition) {
	    jpnjDao.updateCompetition(competition);
	}
	    
	public void deleteCompetition(Long id) {
	    jpnjDao.deleteCompetition(id);
	 
	}

    public List<Competition> getAllCompetitions() {
        return jpnjDao.getAllCompetitions();
    }

    public List<Competition> getUpcomingCompetitions() {
        return jpnjDao.getUpcomingCompetitions(); 
    } 

    public List<Competition> getOngoingCompetitions() {
        return jpnjDao.getOngoingCompetitions();
    }

    public Competition getCompetitionById(Long id) {   
    	return jpnjDao.getCompetitionById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Participant> getAllParticipants() {
        return jpnjDao.getAllParticipants();
    }
  
}
