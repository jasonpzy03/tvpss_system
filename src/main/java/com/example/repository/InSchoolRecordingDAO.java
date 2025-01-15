package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.InSchoolRecording;

@Repository
public class InSchoolRecordingDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(InSchoolRecording inschoolrecording) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(inschoolrecording);
    }
    
    @Transactional
    public List<InSchoolRecording> findByTvpssInformationId(Long tvpssInformationId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM InSchoolRecording WHERE tvpss_information_id = :tvpssInformationId";
        Query<InSchoolRecording> query = session.createQuery(hql, InSchoolRecording.class);
        query.setParameter("tvpssInformationId", tvpssInformationId);
        return query.list();
    }
}
