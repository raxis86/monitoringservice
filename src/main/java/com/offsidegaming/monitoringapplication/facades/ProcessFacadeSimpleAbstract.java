package com.offsidegaming.monitoringapplication.facades;

import com.offsidegaming.monitoringapplication.cg.AbstractResponse;

public abstract class ProcessFacadeSimpleAbstract<Rs extends AbstractResponse> {

    protected abstract Rs process();

    protected abstract Rs getErrorResponse();

    public Rs execute() {
        try {
            return process();
        } catch (Exception e) {
            return getErrorResponse();
        }
    }

}