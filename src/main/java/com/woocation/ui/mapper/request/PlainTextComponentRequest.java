package com.woocation.ui.mapper.request;

import com.woocation.ui.mapper.constants.WoocationTypes;

public class PlainTextComponentRequest {

	private String text = WoocationTypes.WOOCATION_PLAINTEXT_TEXT_DEFAULT_VALUE.getMessage();
	private int order ;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "PlainTextComponentRequest [text=" + text + ", order=" + order + "]";
	}


	

}
