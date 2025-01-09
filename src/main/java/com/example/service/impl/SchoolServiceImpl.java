package com.example.service.impl;

import com.example.entity.School;
import com.example.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Override
    public List<School> getAllSchools() {
        // Simulating data retrieval
        List<School> schools = new ArrayList<>();
        schools.add(new School("1", "SEKOLAH KEBANGSAAN 1", "Smartphone; External Mic; Monopod; Ring Light", 1));
        schools.add(new School("2", "SEKOLAH KEBANGSAAN 2", "Webcam; Tripod; External Mic; Mobile Lighting", 2));
        schools.add(new School("3", "SEKOLAH KEBANGSAAN 3", "Camera; Tripod; External Mic; Mobile Lighting", 3));
        return schools;
    }
}