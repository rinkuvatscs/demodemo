package com.woocation.ui.mapper.request;

import com.woocation.ui.mapper.constants.WoocationTypes;

public class HeadingComponentRequest {

	private String text = WoocationTypes.WOOCATION_HEADING_TEXT_DEFAULT_VALUE.getMessage();
	private String iconPath = WoocationTypes.WOOCATION_HEADING_ICON_DEFAULT_VALUE.getMessage();;
	private int order ;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "HeadingComponentRequest [text=" + text + ", iconPath=" + iconPath + ", order=" + order + "]";
	}

	

}
