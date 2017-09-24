package com.woocation.ui.mapper.request;

import java.util.List;

public class InfoVersionFiveRequest {

	private int order ;
	private String textSectionText ;
	
	private  List<InfoVersionFiveContentRequest> infoVersionFiveContentRequests ;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getTextSectionText() {
		return textSectionText;
	}

	public void setTextSectionText(String textSectionText) {
		this.textSectionText = textSectionText;
	}

	public List<InfoVersionFiveContentRequest> getInfoVersionFiveContentRequests() {
		return infoVersionFiveContentRequests;
	}

	public void setInfoVersionFiveContentRequests(List<InfoVersionFiveContentRequest> infoVersionFiveContentRequests) {
		this.infoVersionFiveContentRequests = infoVersionFiveContentRequests;
	}
	
	
	
}
