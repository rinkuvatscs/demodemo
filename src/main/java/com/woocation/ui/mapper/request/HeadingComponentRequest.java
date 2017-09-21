package com.woocation.ui.mapper.request;

public class HeadingComponentRequest {

	private String text;
	private String iconPath;
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
