package com.offsidegaming.monitoringapplication.dao;

public class MeasurementDaoException extends Exception {

    public MeasurementDaoException(Throwable cause) {
        super("Save to database error", cause);
    }

}