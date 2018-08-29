package com.offsidegaming.monitoringapplication.facades;

import com.offsidegaming.monitoringapplication.cg.AbstractRequest;
import com.offsidegaming.monitoringapplication.cg.AbstractResponse;

public abstract class ProcessFacadeAbstract<Rq extends AbstractRequest, Rs extends AbstractResponse> {

    protected abstract void validateRequest(Rq request);

    protected abstract Rs process(Rq request);

    protected abstract Rs getErrorResponse(Rq request);

    protected abstract Rs getValidateErrorResponse(Exception e);

    public Rs execute(Rq request) {
        try {
            validateRequest(request);
            return process(request);
        } catch (ValidateException e) {
            return getValidateErrorResponse(e);
        } catch (Exception e) {
            return getErrorResponse(request);
        }
    }
}