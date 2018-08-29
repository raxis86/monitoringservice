package com.offsidegaming.monitoringapplication.vo;

import java.io.Serializable;
import java.util.Date;

public class MetersDataType implements Serializable {

    private String gasMeterData;

    private String waterMeterData;

    private String hotWaterMeterData;

    private Date date;

    public String getGasMeterData() {
        return gasMeterData;
    }

    public void setGasMeterData(String gasMeterData) {
        this.gasMeterData = gasMeterData;
    }

    public String getWaterMeterData() {
        return waterMeterData;
    }

    public void setWaterMeterData(String waterMeterData) {
        this.waterMeterData = waterMeterData;
    }

    public String getHotWaterMeterData() {
        return hotWaterMeterData;
    }

    public void setHotWaterMeterData(String hotWaterMeterData) {
        this.hotWaterMeterData = hotWaterMeterData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MetersDataType{" +
                "gasMeterData='" + gasMeterData + '\'' +
                ", waterMeterData='" + waterMeterData + '\'' +
                ", hotWaterMeterData='" + hotWaterMeterData + '\'' +
                ", date=" + date +
                '}';
    }
}