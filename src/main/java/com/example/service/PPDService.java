package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Competition;
import com.example.repository.PPDDao;

@Service
public class PPDService {
	
	@Autowired
	private PPDDao ppdDao;
    public void saveCompetition(Competition competition) {
    	ppdDao.save(competition);
    }

  
}