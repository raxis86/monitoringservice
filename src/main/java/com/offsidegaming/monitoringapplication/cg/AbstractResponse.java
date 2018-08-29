package com.offsidegaming.monitoringapplication.cg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.offsidegaming.monitoringapplication.vo.Status;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public abstract class AbstractResponse implements Serializable {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}