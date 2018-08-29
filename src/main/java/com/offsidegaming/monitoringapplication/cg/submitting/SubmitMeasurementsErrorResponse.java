package com.offsidegaming.monitoringapplication.cg.submitting;

import com.offsidegaming.monitoringapplication.vo.Status;

public class SubmitMeasurementsErrorResponse extends SubmitMeasurementsResponse {

    public SubmitMeasurementsErrorResponse() {
        Status status = new Status();
        status.setCode(1);
        status.setMessage("Error when submitting measurements");

        setStatus(status);
    }

}