package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.OutSchoolRecording;

@Repository
public class OutSchoolRecordingDAO {
	@Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(OutSchoolRecording outschoolrecording) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(outschoolrecording);
    }
    
    @Transactional
    public List<OutSchoolRecording> findByTvpssInformationId(Long tvpssInformationId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM OutSchoolRecording WHERE tvpss_information_id = :tvpssInformationId";
        Query<OutSchoolRecording> query = session.createQuery(hql, OutSchoolRecording.class);
        query.setParameter("tvpssInformationId", tvpssInformationId);
        return query.list();
    }
}
