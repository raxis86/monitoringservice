package com.offsidegaming.monitoringapplication.cg.history;

import com.offsidegaming.monitoringapplication.vo.Status;

public class HistoryErrorResponse extends HistoryResponse {

    public HistoryErrorResponse() {
        Status status = new Status();
        status.setMessage("Error");
        status.setCode(1);

        setStatus(status);
    }
}