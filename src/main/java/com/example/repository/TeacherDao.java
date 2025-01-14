package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.entity.Competition;
import com.example.entity.Participant;
import com.example.entity.User;


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
	    
	    
	    public void joinCompetition(Long competitionId, String username) {
	        Session session = sessionFactory.getCurrentSession();
	        
	        Competition competition = session.get(Competition.class, competitionId);
	        User user = (User) session.createQuery("FROM User WHERE username = :username")
	                                .setParameter("username", username)
	                                .uniqueResult();
	        
	        if (competition != null && user != null) {
	            Participant participant = new Participant();
	            participant.setCompetition(competition);
	            participant.setUser(user);
	            participant.setJoinDate(LocalDateTime.now());
	            
	            session.save(participant);
	            
	            // Update competition participants count
	            competition.setTotalParticipants(competition.getTotalParticipants() + 1);
	            session.update(competition);
	        }
	    }
	    
	    public boolean hasUserJoinedCompetition(Long competitionId, String username) {
	        Session session = sessionFactory.getCurrentSession();
	        String hql = "SELECT COUNT(*) FROM Participant cp WHERE cp.competition.id = :compId AND cp.user.username = :username";
	        Long count = (Long) session.createQuery(hql)
	                                 .setParameter("compId", competitionId)
	                                 .setParameter("username", username)
	                                 .uniqueResult();
	        return count > 0;
	    }

	    public List<Competition> getUserCompetitions(String username) {
	        Session session = sessionFactory.getCurrentSession();
	        String hql = "SELECT cp.competition FROM Participant cp WHERE cp.user.username = :username";
	        return session.createQuery(hql, Competition.class)
	                     .setParameter("username", username)
	                     .getResultList();
	    }
	    
	    
}
