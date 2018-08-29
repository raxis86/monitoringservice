package com.offsidegaming.monitoringapplication.dao;

import com.offsidegaming.monitoringapplication.utils.HibernateSessionFactory;
import com.offsidegaming.monitoringapplication.entityes.MeasurementEntity;
import org.hibernate.Session;

import java.util.List;

public class MeasurementDaoImpl implements MeasurementDao {

    @Override
    public List<MeasurementEntity> getMeasurementsByUserId(int userId) throws MeasurementDaoException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            List<MeasurementEntity> entities = session.createQuery(
                    " SELECT m "
                            + " from MeasurementEntity m "
                            + " where m.userId = :userId ",
                    MeasurementEntity.class
            ).setParameter("userId", userId).list();

            session.getTransaction().commit();

            return entities;
        } catch (Exception e) {
            throw new MeasurementDaoException(e);
        }
    }

    @Override
    public void addMeasurement(MeasurementEntity measurement) throws MeasurementDaoException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(measurement);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new MeasurementDaoException(e);
        }
    }
}