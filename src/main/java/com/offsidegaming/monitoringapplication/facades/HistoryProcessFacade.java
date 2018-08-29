package com.offsidegaming.monitoringapplication.facades;

import com.offsidegaming.monitoringapplication.cg.history.HistoryErrorResponse;
import com.offsidegaming.monitoringapplication.cg.history.HistoryResponse;
import com.offsidegaming.monitoringapplication.services.history.MeasurementHistoryService;

public class HistoryProcessFacade extends ProcessFacadeSimpleAbstract<HistoryResponse> {

    private MeasurementHistoryService historyService;

    public HistoryProcessFacade(MeasurementHistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    protected HistoryResponse process() {
        return historyService.getHistory();
    }

    @Override
    protected HistoryResponse getErrorResponse() {
        return new HistoryErrorResponse();
    }
}