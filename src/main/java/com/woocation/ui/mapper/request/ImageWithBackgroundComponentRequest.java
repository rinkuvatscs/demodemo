package com.woocation.ui.mapper.request;

import com.woocation.ui.mapper.constants.WoocationTypes;

public class ImageWithBackgroundComponentRequest {

	private String text = WoocationTypes.WOOCATION_HEADING_TEXT_DEFAULT_VALUE.getMessage();
	private String imageUrl = WoocationTypes.WOOCATION_HEADING_ICON_DEFAULT_VALUE.getMessage();;
	private int order;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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
		return "ImageWithBackgroundComponentRequest [text=" + text + "]" + "order=" + order + "]";
	}

}
