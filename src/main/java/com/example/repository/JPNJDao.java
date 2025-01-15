package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Competition;
import com.example.entity.Participant;
import com.example.entity.School;

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
	    
	    public void saveCompetition(Competition competition) {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(competition);
	        } catch (Exception e) {
	            throw new RuntimeException("Database error while saving competition", e);
	        }
	    }
	    
	    public void updateCompetition(Competition competition) {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            session.update(competition);
	        } catch (Exception e) {
	            throw new RuntimeException("Database error while updating competition", e);
	        }
	    }

	    public void deleteCompetition(Long id) {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            Competition competition = session.get(Competition.class, id);
	            if (competition != null) {
	                session.delete(competition);
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("Database error while deleting competition", e);
	        }
	    }
	    
	    public Competition getCompetitionById(Long id) {
	        try {
	            Session session = sessionFactory.getCurrentSession();
	            return session.get(Competition.class, id);
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    public List<Participant> getAllParticipants() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery(
	            "FROM Participant cp " +
	            "JOIN FETCH cp.competition " +
	            "JOIN FETCH cp.user " +
	            "ORDER BY cp.joinDate DESC", Participant.class)
	            .getResultList();
	    }
	   
	    
	    public Map<String, Long> getSchoolsByStudioLevel() {
	        Session session = sessionFactory.getCurrentSession();
	        
	        String hql = "SELECT s.studioLevel, COUNT(s) FROM School s " +
	                     "WHERE s.studioLevel IS NOT NULL " +
	                     "GROUP BY s.studioLevel";
	                     
	        List<Object[]> results = session.createQuery(hql).getResultList();
	        
	        Map<String, Long> statistics = new HashMap<>();
	        for (Object[] result : results) {
	            String studioLevel = (String) result[0];
	            Long count = (Long) result[1];
	            statistics.put(studioLevel, count);
	        }
	        
	        return statistics;
	    }
	    
	    public Map<String, Long> getSchoolsByTVPSSVersion() {
	        Session session = sessionFactory.getCurrentSession();
	        
	        String hql = "SELECT s.tvpssVersion, COUNT(s) FROM School s " +
	                     "WHERE s.tvpssVersion IS NOT NULL " +
	                     "GROUP BY s.tvpssVersion";
	                     
	        List<Object[]> results = session.createQuery(hql).getResultList();
	        
	        Map<String, Long> statistics = new HashMap<>();
	        for (Object[] result : results) {
	            String version = (String) result[0];
	            Long count = (Long) result[1];
	            statistics.put(version, count);
	        }
	        
	        return statistics;
	    }
	    
	    public Long getTotalSchools() {
	        Session session = sessionFactory.getCurrentSession();
	        return (Long) session.createQuery("SELECT COUNT(s) FROM School s").uniqueResult();
	    }
}
