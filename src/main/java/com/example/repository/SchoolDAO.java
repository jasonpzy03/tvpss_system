package com.example.repository;

import com.example.entity.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // Save a school entity
    public void saveSchool(School school) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(school);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    // Retrieve all school entities
    public List<School> getAllSchools() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from School", School.class).list();
        }
    }

    // Find a school by ID
    public School findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(School.class, id); // Retrieves the school by ID
        }
    }
}
