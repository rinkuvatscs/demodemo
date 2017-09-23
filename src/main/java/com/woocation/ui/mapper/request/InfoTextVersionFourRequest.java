package com.woocation.ui.mapper.request;

import java.util.List;

public class InfoTextVersionFourRequest {

	private int order ;
	private String textSectionText ;
	private String valueSectionText;
	private List<InfoVersionFourContentRequest> infoVersionFourContentRequests ;
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
	public String getValueSectionText() {
		return valueSectionText;
	}
	public void setValueSectionText(String valueSectionText) {
		this.valueSectionText = valueSectionText;
	}
	public List<InfoVersionFourContentRequest> getInfoVersionFourContentRequests() {
		return infoVersionFourContentRequests;
	}
	public void setInfoVersionFourContentRequests(List<InfoVersionFourContentRequest> infoVersionFourContentRequests) {
		this.infoVersionFourContentRequests = infoVersionFourContentRequests;
	}
	
	
}
