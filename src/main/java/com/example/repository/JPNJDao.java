package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Competition;

@Repository
public class JPNJDao {
	  @Autowired
	    private SessionFactory sessionFactory;

	    @SuppressWarnings("unchecked")
	    public List<Competition> getAllCompetitions() {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            return session.createQuery("FROM Competition ORDER BY startDate").list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Competition> getUpcomingCompetitions() {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            return session.createQuery(
	                "FROM Competition WHERE status = 'Upcoming' ORDER BY startDate")
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
	    }

	    @SuppressWarnings("unchecked")
	    public List<Competition> getOngoingCompetitions() {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            return session.createQuery(
	                "FROM Competition WHERE status = 'Ongoing' ORDER BY startDate")
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Competition> getCompetitionsByDistrict(String district) {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            Query<Competition> query = session.createQuery(
	                "FROM Competition WHERE district = :district ORDER BY startDate");
	            query.setParameter("district", district);
	            return query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>();
	        }
	    }

}
