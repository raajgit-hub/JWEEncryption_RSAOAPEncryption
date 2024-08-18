package com.c1b.negativefile.model;

public class NegativeFileResponse {
    String riskValue;
    String threatId;
    String threatGroup;
	public void setRiskValue(String riskValue) {
		this.riskValue = riskValue;
	}
	public void setThreatId(String threatId) {
		this.threatId = threatId;
	}
	public String setThreatGroup(String threatGroup) {
		this.threatGroup = threatGroup;
		
		return "{\"riskValue\":\"343\",\"threatId\":\"25\",\"threatGroup\":\"fraud\" }";
	}
    
}