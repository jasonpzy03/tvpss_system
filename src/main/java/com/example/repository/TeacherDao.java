package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.entity.Competition;

@Repository
public class TeacherDao {
	 @Autowired
	    private SessionFactory sessionFactory;

	    public List<Competition> findAll() {
	    	  Session session = sessionFactory.getCurrentSession();
	            String hql = "FROM Competition c " +
	                        "WHERE c.status IN ('UPCOMING', 'ONGOING') " +
	                        "AND c.endDate >= current_date " +
	                        "ORDER BY c.startDate ASC";
	            
	            return session.createQuery(hql, Competition.class)
	                         .getResultList();
	    }

	    // Fetch competition by ID
	    public Competition findById(Long competitionId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(Competition.class, competitionId);  // Hibernate's get method
	    }
}
