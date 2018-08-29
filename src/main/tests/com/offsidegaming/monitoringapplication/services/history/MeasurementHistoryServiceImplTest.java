package com.offsidegaming.monitoringapplication.services.history;

import com.offsidegaming.monitoringapplication.cg.history.HistoryResponse;
import com.offsidegaming.monitoringapplication.dao.MeasurementDao;
import com.offsidegaming.monitoringapplication.dao.MeasurementDaoException;
import com.offsidegaming.monitoringapplication.entityes.MeasurementEntity;
import com.offsidegaming.monitoringapplication.services.session.SessionContext;
import com.offsidegaming.monitoringapplication.services.session.SessionContextException;
import com.offsidegaming.monitoringapplication.vo.MetersDataType;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MeasurementHistoryServiceImplTest {

    private static final int USER_ID = 1111;
    private static final String GAS = "333.44";
    private static final String WATER = "222.44";
    private static final String HOT_WATER = "111.22";

    private MeasurementDao measurementDao;
    private SessionContext sessionContext;
    private MeasurementHistoryService historyService;

    @Before
    public void setUp() throws Exception {
        measurementDao = mock(MeasurementDao.class);
        sessionContext = mock(SessionContext.class);

        when(measurementDao.getMeasurementsByUserId(USER_ID)).thenReturn(getEntitiesList());
        when(sessionContext.getUserId()).thenReturn(USER_ID);

        historyService = new MeasurementHistoryServiceImpl(measurementDao, sessionContext);
    }

    @Test
    public void shouldReturnHistory() {
        HistoryResponse response = historyService.getHistory();

        assertEquals(0, response.getStatus().getCode());

        List<MetersDataType> metersDataTypes = response.getMeasurements();

        assertNotNull(metersDataTypes);

        MetersDataType metersDataType = metersDataTypes.get(0);
        assertEquals(GAS, metersDataType.getGasMeterData());
        assertEquals(WATER, metersDataType.getWaterMeterData());
        assertEquals(HOT_WATER, metersDataType.getHotWaterMeterData());
    }

    @Test
    public void shouldReturnErrorResponseIfNoUserSession() throws SessionContextException {
        when(sessionContext.getUserId()).thenThrow(SessionContextException.class);
        HistoryResponse response = historyService.getHistory();

        assertEquals(1, response.getStatus().getCode());
    }

    @Test
    public void shouldReturnErrorResponseIfDaoException() throws MeasurementDaoException {
        when(measurementDao.getMeasurementsByUserId(USER_ID)).thenThrow(MeasurementDaoException.class);
        HistoryResponse response = historyService.getHistory();

        assertEquals(1, response.getStatus().getCode());
    }

    private List<MeasurementEntity> getEntitiesList() {
        MeasurementEntity measurementEntity = new MeasurementEntity();
        measurementEntity.setColdWater(WATER);
        measurementEntity.setHotWater(HOT_WATER);
        measurementEntity.setGas(GAS);

        return Collections.singletonList(measurementEntity);
    }
}