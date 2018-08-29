package com.offsidegaming.monitoringapplication.cg.history;

import com.offsidegaming.monitoringapplication.vo.MetersDataType;
import com.offsidegaming.monitoringapplication.vo.Status;

import java.util.List;

public class HistorySuccessResponse extends HistoryResponse {

    public HistorySuccessResponse(List<MetersDataType> measurements) {
        Status status = new Status();
        status.setMessage("Ok");
        status.setCode(0);

        setStatus(status);
        setMeasurements(measurements);
    }
}