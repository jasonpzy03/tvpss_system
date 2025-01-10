package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.TeacherDao;
import com.example.entity.Competition;

@Service
public class TeacherService {
	  @Autowired
	    private TeacherDao teacherDao;

	    @Transactional
	    public List<Competition> getAllCompetitions() {
	        return teacherDao.findAll();
	    }
	    
	    @Transactional
	    // Method to get a competition by its ID
	    public Competition getCompetitionById(Long competitionId) {
	        return teacherDao.findById(competitionId);
	    }
}
