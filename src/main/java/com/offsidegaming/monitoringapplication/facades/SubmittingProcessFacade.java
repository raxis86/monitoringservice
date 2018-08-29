package com.offsidegaming.monitoringapplication.facades;

import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsErrorResponse;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsRequest;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsResponse;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsValidateErrorResponse;
import com.offsidegaming.monitoringapplication.services.submitting.MeasurementSubmitService;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubmittingProcessFacade extends ProcessFacadeAbstract<SubmitMeasurementsRequest, SubmitMeasurementsResponse> {

    private static final Pattern MEASUREMENTS_REGEXP = Pattern.compile("^[0-9]+\\.[0-9]{2}$");

    private MeasurementSubmitService submitService;

    public SubmittingProcessFacade(MeasurementSubmitService submitService) {
        this.submitService = submitService;
    }

    @Override
    protected void validateRequest(SubmitMeasurementsRequest request) {
        validate(request);
    }

    @Override
    protected SubmitMeasurementsResponse process(SubmitMeasurementsRequest request) {
        return submitService.submit(request);
    }

    @Override
    protected SubmitMeasurementsResponse getErrorResponse(SubmitMeasurementsRequest request) {
        return new SubmitMeasurementsErrorResponse();
    }

    @Override
    protected SubmitMeasurementsResponse getValidateErrorResponse(Exception e) {
        return new SubmitMeasurementsValidateErrorResponse(e.getMessage());
    }

    private void validate(SubmitMeasurementsRequest request) {
        List<String> parameters = Arrays.asList(request.getGasMeasurement(), request.getHotWaterMeasurement(), request.getWaterMeasurement());
        parameters.forEach(this::matching);
    }

    private void matching(String s) {
        Matcher matcher = MEASUREMENTS_REGEXP.matcher(s);
        if (!matcher.matches()) {
            throw new ValidateException("Validate error for: " + s);
        }
    }
}
