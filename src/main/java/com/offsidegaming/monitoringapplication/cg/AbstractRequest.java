package com.offsidegaming.monitoringapplication.cg;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public abstract class AbstractRequest implements Serializable {
}
