package com.offsidegaming.monitoringapplication.rest;

import com.offsidegaming.monitoringapplication.cg.history.HistoryResponse;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsRequest;
import com.offsidegaming.monitoringapplication.cg.submitting.SubmitMeasurementsResponse;
import com.offsidegaming.monitoringapplication.facades.ProcessFacadeAbstract;
import com.offsidegaming.monitoringapplication.facades.ProcessFacadeSimpleAbstract;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/monitoring/service/")
@Produces(APPLICATION_JSON + ";charset=UTF-8")
@Consumes(APPLICATION_JSON)
public class MonitoringApplicationRest {

    private ProcessFacadeAbstract<SubmitMeasurementsRequest, SubmitMeasurementsResponse> submitFacade;
    private ProcessFacadeSimpleAbstract<HistoryResponse> historyFacade;

    public MonitoringApplicationRest(ProcessFacadeAbstract<SubmitMeasurementsRequest, SubmitMeasurementsResponse> submitFacade,
                                     ProcessFacadeSimpleAbstract<HistoryResponse> historyFacade) {
        this.submitFacade = submitFacade;
        this.historyFacade = historyFacade;
    }

    @POST
    @Path("submit")
    public SubmitMeasurementsResponse submit(final SubmitMeasurementsRequest request) {
        return submitFacade.execute(request);
    }

    @POST
    @Path("history")
    public HistoryResponse getHistory() {
        return historyFacade.execute();
    }
}