package com.example.service;

import com.example.entity.School;
import com.example.repository.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolDAO schoolDAO; // Inject the SchoolDAO

    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
    }

    public School findSchoolById(Long id) {
        return schoolDAO.findById(id);
    }

    public void saveSchool(School school) {
        schoolDAO.saveSchool(school); // Use DAO to save the school
    }
}
