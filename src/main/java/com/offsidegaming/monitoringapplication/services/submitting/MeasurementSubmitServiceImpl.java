package com.offsidegaming.monitoringapplication.services.submitting;

import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsErrorResponse;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsRequest;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsResponse;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsSuccessResponse;
import com.offsidegaming.monitoringapplication.dao.MeasurementDao;
import com.offsidegaming.monitoringapplication.dao.MeasurementDaoException;
import com.offsidegaming.monitoringapplication.entityes.MeasurementEntity;
import com.offsidegaming.monitoringapplication.services.session.SessionContext;
import com.offsidegaming.monitoringapplication.services.session.SessionContextException;

import java.sql.Date;
import java.time.LocalDate;

public class MeasurementSubmitServiceImpl implements MeasurementSubmitService {

    private MeasurementDao measurementDao;
    private SessionContext sessionContext;

    public MeasurementSubmitServiceImpl(MeasurementDao measurementDao, SessionContext sessionContext) {
        this.measurementDao = measurementDao;
        this.sessionContext = sessionContext;
    }

    @Override
    public SubmitMeasurementsResponse submit(SubmitMeasurementsRequest request) {

        try {
            int userId = sessionContext.getUserId();
            measurementDao.addMeasurement(getMeasurementEntity(request, userId));
        } catch (SessionContextException | MeasurementDaoException e) {
            return new SubmitMeasurementsErrorResponse();
        }

        return new SubmitMeasurementsSuccessResponse();
    }

    private MeasurementEntity getMeasurementEntity(SubmitMeasurementsRequest request, int userId) {
        MeasurementEntity entity = new MeasurementEntity();

        entity.setUserId(userId);
        entity.setColdWater(request.getWaterMeasurement());
        entity.setHotWater(request.getHotWaterMeasurement());
        entity.setGas(request.getGasMeasurement());
        entity.setTime(Date.valueOf(LocalDate.now()));

        return entity;
    }
}