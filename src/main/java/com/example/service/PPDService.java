package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Competition;
import com.example.repository.CompetitionDAO;

@Service
public class PPDService {
	
	@Autowired
	private CompetitionDAO competitionDAO;
    public void saveCompetition(Competition competition) {
    	competitionDAO.save(competition);
    }

  
}