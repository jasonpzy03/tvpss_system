package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Transactional
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }
}

