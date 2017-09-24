package com.woocation.ui.mapper.request;

import java.util.List;

public class InfoTextVersionSixRequest {

	private int order ;
	
	private String iconSectionUrl;
	
	private String textSectionText;
	
	private String descriptionText;
	
	private String valueSectionText ;
	
	private List<InfoVersionSixContentRequest> infoVersionSixContentRequests;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getIconSectionUrl() {
		return iconSectionUrl;
	}

	public void setIconSectionUrl(String iconSectionUrl) {
		this.iconSectionUrl = iconSectionUrl;
	}

	public String getTextSectionText() {
		return textSectionText;
	}

	public void setTextSectionText(String textSectionText) {
		this.textSectionText = textSectionText;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public String getValueSectionText() {
		return valueSectionText;
	}

	public void setValueSectionText(String valueSectionText) {
		this.valueSectionText = valueSectionText;
	}

	public List<InfoVersionSixContentRequest> getInfoVersionSixContentRequests() {
		return infoVersionSixContentRequests;
	}

	public void setInfoVersionSixContentRequests(List<InfoVersionSixContentRequest> infoVersionSixContentRequests) {
		this.infoVersionSixContentRequests = infoVersionSixContentRequests;
	}
	
	
	
}
