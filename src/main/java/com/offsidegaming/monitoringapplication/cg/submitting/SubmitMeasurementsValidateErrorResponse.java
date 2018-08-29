package com.offsidegaming.monitoringapplication.cg.submitting;

import com.offsidegaming.monitoringapplication.vo.Status;

public class SubmitMeasurementsValidateErrorResponse extends SubmitMeasurementsResponse {

    public SubmitMeasurementsValidateErrorResponse(String message) {
        Status status = new Status();
        status.setCode(3);
        status.setMessage(message);

        setStatus(status);
    }

}