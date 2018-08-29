package com.offsidegaming.monitoringapplication.services.submitting;

import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsRequest;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsResponse;

public interface MeasurementSubmitService {

    SubmitMeasurementsResponse submit(SubmitMeasurementsRequest request);
}
