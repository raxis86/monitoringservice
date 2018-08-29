package com.offsidegaming.monitoringapplication.cg.history;

import com.offsidegaming.monitoringapplication.cg.AbstractResponse;
import com.offsidegaming.monitoringapplication.vo.MetersDataType;

import java.util.List;

public class HistoryResponse extends AbstractResponse {

    private List<MetersDataType> measurements;

    public void setMeasurements(List<MetersDataType> measurements) {
        this.measurements = measurements;
    }

    public List<MetersDataType> getMeasurements() {
        return measurements;
    }

    @Override
    public String toString() {
        return "HistoryResponse{" +
                "measurements=" + measurements +
                '}';
    }
}