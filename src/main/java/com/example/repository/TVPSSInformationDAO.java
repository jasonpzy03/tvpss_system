package com.example.repository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.TVPSSInformation;

@Repository
public class TVPSSInformationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(TVPSSInformation tvpssinformation) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tvpssinformation);
    }

    @Transactional(readOnly = true)
    public List<TVPSSInformation> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TVPSSInformation", TVPSSInformation.class).list();
    }
    
    @Transactional(readOnly = true)
    public TVPSSInformation findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TVPSSInformation.class, id);
    }
}
