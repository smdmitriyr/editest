package com.ediweb.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {

    private Integer id;
    @JsonProperty("trade_point_id")
    private Integer tradePointId;
    @JsonProperty("agent_id")
    private Integer agentId;
    @JsonProperty("day_of_week")
    private Integer dayOfWeek;
    @JsonProperty("visit_date")
    private String visitDate;

    public Integer getTradePointId() {
        return tradePointId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTradePointId(Integer tradePointId) {
        this.tradePointId = tradePointId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void refill(Route route) {
        this.agentId = route.getAgentId();
        this.tradePointId = route.getTradePointId();
        this.dayOfWeek = route.getDayOfWeek();
        this.visitDate = route.getVisitDate();
    }
}
