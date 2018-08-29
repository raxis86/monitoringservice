package com.offsidegaming.monitoringapplication.services.history;

import com.offsidegaming.monitoringapplication.cg.history.HistoryErrorResponse;
import com.offsidegaming.monitoringapplication.cg.history.HistoryResponse;
import com.offsidegaming.monitoringapplication.cg.history.HistorySuccessResponse;
import com.offsidegaming.monitoringapplication.dao.MeasurementDao;
import com.offsidegaming.monitoringapplication.dao.MeasurementDaoException;
import com.offsidegaming.monitoringapplication.entityes.MeasurementEntity;
import com.offsidegaming.monitoringapplication.services.session.SessionContext;
import com.offsidegaming.monitoringapplication.services.session.SessionContextException;
import com.offsidegaming.monitoringapplication.vo.MetersDataType;

import java.util.ArrayList;
import java.util.List;

public class MeasurementHistoryServiceImpl implements MeasurementHistoryService {

    private MeasurementDao measurementDao;
    private SessionContext sessionContext;

    public MeasurementHistoryServiceImpl(MeasurementDao measurementDao, SessionContext sessionContext) {
        this.measurementDao = measurementDao;
        this.sessionContext = sessionContext;
    }

    @Override
    public HistoryResponse getHistory() {
        List<MeasurementEntity> measurementsEntities;

        try {
            int userId = sessionContext.getUserId();
            measurementsEntities = measurementDao.getMeasurementsByUserId(userId);
        } catch (MeasurementDaoException | SessionContextException e) {
            return new HistoryErrorResponse();
        }

        return buildResponse(measurementsEntities);
    }

    private HistoryResponse buildResponse(List<MeasurementEntity> measurementsEntities) {
        List<MetersDataType> measurements = new ArrayList<>();

        for (MeasurementEntity entity : measurementsEntities) {
            measurements.add(fillMetersData(entity));
        }

        return new HistorySuccessResponse(measurements);
    }

    private MetersDataType fillMetersData(MeasurementEntity entity) {
        MetersDataType metersDataType = new MetersDataType();
        metersDataType.setGasMeterData(entity.getGas());
        metersDataType.setWaterMeterData(entity.getColdWater());
        metersDataType.setHotWaterMeterData(entity.getHotWater());
        metersDataType.setDate(entity.getTime());

        return metersDataType;
    }

}