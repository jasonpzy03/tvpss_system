package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.CrewApplication;

public interface ApplicationRepository extends JpaRepository<CrewApplication, Long> {
    CrewApplication findByIcNoAndEmail(String icNo, String email);


}
