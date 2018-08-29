package com.offsidegaming.monitoringapplication.cg.submitting;

import com.offsidegaming.monitoringapplication.vo.Status;

public class SubmitMeasurementsSuccessResponse extends SubmitMeasurementsResponse {

    public SubmitMeasurementsSuccessResponse() {
        Status status = new Status();
        status.setCode(0);
        status.setMessage("Measurements was submitted");

        setStatus(status);
    }
}