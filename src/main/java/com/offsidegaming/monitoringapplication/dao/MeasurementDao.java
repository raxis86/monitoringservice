package com.offsidegaming.monitoringapplication.dao;

import com.offsidegaming.monitoringapplication.entityes.MeasurementEntity;

import java.util.List;

public interface MeasurementDao {

    List<MeasurementEntity> getMeasurementsByUserId(int userId) throws MeasurementDaoException;

    void addMeasurement(MeasurementEntity measurement) throws MeasurementDaoException;

}