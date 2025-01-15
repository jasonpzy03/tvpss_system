package com.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Collaboration;

@Repository
public class CollaborationDAO {
	@Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Collaboration collaboration) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(collaboration);
    }
}
