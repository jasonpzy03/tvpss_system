package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Competition;
import com.example.repository.JPNJDao;

@Service
@Transactional
public class JPNJService {
	@Autowired
    private JPNJDao jpnjDao;

    public List<Competition> getAllCompetitions() {
        return jpnjDao.getAllCompetitions();
    }

    public List<Competition> getUpcomingCompetitions() {
        return jpnjDao.getUpcomingCompetitions(); 
    } 

    public List<Competition> getOngoingCompetitions() {
        return jpnjDao.getOngoingCompetitions();
    }

    public List<Competition> getCompetitionsByDistrict(String district) {
        return jpnjDao.getCompetitionsByDistrict(district);
    }

}
