package com.woocation.ui.mapper.constants;

public enum WoocationTypes {

	/**
	 * Heading Component Label default values
	 */
	WOOCATION_HEADING_COMPONENT_NAME("Heading") ,
	WOOCATION_HEADING_DISPLAY_NAME_DEFAULT_VALUE("Heading") ,
	WOOCATION_HEADING_TYPE_DEFAULT_VALUE("heading") ,
	WOOCATION_HEADING_TEXT_DEFAULT_VALUE("Default Content of Heading") ,
	WOOCATION_HEADING_FONT_SIZE_DEFAULT_VALUE("15px") ,
	WOOCATION_HEADING_FONT_COLOR_DEFAULT_VALUE("#0b3450") ,
	WOOCATION_HEADING_FONT_STYLE_DEFAULT_VALUE("bold") ,
	WOOCATION_HEADING_ICON_DEFAULT_VALUE("http://www.esseltek.com/wp-content/uploads/2016/06/icons-34.png") ,
	WOOCATION_HEADING_ICO_HEIGHT_DEFAULT_VALUE("25px") ,

	
	
	/**
	 * PlainText Component Default Values
	 */
	WOOCATION_PLAINTEXT_COMPONENT_NAME("PlainText") ,
	WOOCATION_PLAINTEXT_DISPLAY_NAME_DEFAULT_VALUE("Plain Text") ,
	WOOCATION_PLAINTEXT_TYPE_DEFAULT_VALUE("plain-text") ,
	WOOCATION_PLAINTEXT_TEXT_DEFAULT_VALUE("<b>4</b> health alerts to be aware of") ,
	WOOCATION_PLAINTEXT_ALIGN_TEXT_DEFAULT_VALUE("center"),
	WOOCATION_PLAINTEXT_PADDING_DEFAULT_VALUE("5px 15px") ,
	WOOCATION_PLAINTEXT_FONT_SIZE_DEFAULT_VALUE("15px") ,
	WOOCATION_PLAINTEXT_FONT_COLOR_DEFAULT_VALUE("#69737b") ,
	WOOCATION_PLAINTEXT_FONT_STYLE_DEFAULT_VALUE("") ,
	

	/**
	 *  Image With Background Component
	 */
	
	WOOCATION_IMAGE_WITH_BACKGROUND_COMPONENT_NAME("Image With Background"),
	
	
	/**
	 * Insight Level keys
	 */
	WOOCATION_DISPLAY_NAME("displayName"),
	WOOCATION_ORDER("order"),
	WOOCATION_TYPE("type"),
	WOOCATION_TEXT("text"),
	WOOCATION_FONT_SIZE("font_size"),
	WOOCATION_FONT_COLOR("font_color"),
	WOOCATION_FONT_STYLE("font_style"),
	WOOCATION_ICON("icon"),
	WOOCATION_ICO_HEIGHT("ico_height"),
	WOOCATION_ALIGN_TEXT("align_text"),
	WOOCATION_PADDING("padding"),
	WOOCATION_HEIGHT("height"),
	WOOCATION_COLOR("color"),
	WOOCATION_IMAGE_URL("image_url"),
	WOOCATION_GLOBAL_NAME("Global");
	private String message;

	WoocationTypes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
