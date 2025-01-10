package com.example.repository;

import com.example.entity.CrewApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewApplicationRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCrewApplication(CrewApplication application) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(application);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public List<CrewApplication> getAllCrewApplications() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from CrewApplication", CrewApplication.class).list();
        }
    }
}
