package com.woocation.ui.mapper.request;

import java.util.List;

public class InfoTextVersionThreeRequest {

	private String order ;
	private String textSectionText;
	private List<String> content ;
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTextSectionText() {
		return textSectionText;
	}
	public void setTextSectionText(String textSectionText) {
		this.textSectionText = textSectionText;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	
	
}
