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
	WOOCATION_ICON_HEIGHT("ico_height"),
	
	WOOCATION_GLOBAL_NAME("global");
	private String message;

	WoocationTypes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
