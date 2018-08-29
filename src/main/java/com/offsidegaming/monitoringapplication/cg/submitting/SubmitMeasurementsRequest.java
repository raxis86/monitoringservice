package com.offsidegaming.monitoringapplication.cg.submitting;

import com.offsidegaming.monitoringapplication.cg.AbstractRequest;

public class SubmitMeasurementsRequest extends AbstractRequest {

    private String gasMeasurement;

    private String waterMeasurement;

    private String hotWaterMeasurement;

    public String getGasMeasurement() {
        return gasMeasurement;
    }

    public String getWaterMeasurement() {
        return waterMeasurement;
    }

    public String getHotWaterMeasurement() {
        return hotWaterMeasurement;
    }

    @Override
    public String toString() {
        return "SubmitMeasurementsRequest{" +
                "gasMeasurement='" + gasMeasurement + '\'' +
                ", waterMeasurement='" + waterMeasurement + '\'' +
                ", hotWaterMeasurement='" + hotWaterMeasurement + '\'' +
                '}';
    }
}