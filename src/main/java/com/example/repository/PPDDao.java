package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Competition;
import com.example.entity.District;
import com.example.entity.Participant;

@Repository
@Transactional
public class PPDDao {
	@Autowired
	private SessionFactory sessionFactory;
  
	public void save(Competition competition) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(competition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
  
	 public Competition getCompetitionById(Long id) {
	        Session session = sessionFactory.getCurrentSession();
	        try {
	            return session.get(Competition.class, id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error getting competition by id: " + e.getMessage());
	        }
	    }

	 public void updateCompetition(Competition competition) {
	        Session session = sessionFactory.getCurrentSession();
	        try {
	            session.update(competition);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error updating competition: " + e.getMessage());
	        }
	    }

	    public void deleteCompetition(Long id) {
	        Session session = sessionFactory.getCurrentSession();
	        try {
	            Competition competition = session.get(Competition.class, id);
	            if (competition != null) {
	                session.delete(competition);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error deleting competition: " + e.getMessage());
	        }
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Competition> getAllCompetition() {
	        Session session = sessionFactory.getCurrentSession();
	        try {
	            return session.createQuery("FROM Competition ORDER BY startDate").list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error getting all competitions: " + e.getMessage());
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
	    
	    public Long getKulaiSchoolsCount() {
	        Session session = sessionFactory.getCurrentSession();
	        String hql = "SELECT COUNT(s) FROM School s WHERE s.district = 'KULAI'";
	        
	        return (Long) session.createQuery(hql).uniqueResult();
	    }
	    
	    
}
