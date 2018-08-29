package com.offsidegaming.monitoringapplication.entityes;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MEASUREMENTS", schema = "PUBLIC", catalog = "PUBLIC")
public class MeasurementEntity {
    private int id;
    private Integer userId;
    private String gas;
    private String coldWater;
    private String hotWater;
    private Date time;

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "GAS")
    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    @Basic
    @Column(name = "COLD_WATER")
    public String getColdWater() {
        return coldWater;
    }

    public void setColdWater(String coldWater) {
        this.coldWater = coldWater;
    }

    @Basic
    @Column(name = "HOT_WATER")
    public String getHotWater() {
        return hotWater;
    }

    public void setHotWater(String hotWater) {
        this.hotWater = hotWater;
    }

    @Basic
    @Column(name = "TIME")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementEntity that = (MeasurementEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (gas != null ? !gas.equals(that.gas) : that.gas != null) return false;
        if (coldWater != null ? !coldWater.equals(that.coldWater) : that.coldWater != null) return false;
        if (hotWater != null ? !hotWater.equals(that.hotWater) : that.hotWater != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (gas != null ? gas.hashCode() : 0);
        result = 31 * result + (coldWater != null ? coldWater.hashCode() : 0);
        result = 31 * result + (hotWater != null ? hotWater.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
