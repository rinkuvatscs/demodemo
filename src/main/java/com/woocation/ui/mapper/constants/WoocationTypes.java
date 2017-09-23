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
	WOOCATION_IMAGE_WITH_BACKGROUND_DISPLAY_NAME_DEFAULT_VALUE("Image With Background"),
	WOOCATION_IMAGE_WITH_BACKGROUND_TYPE_DEFAULT_VALUE("image"),
	WOOCATION_IMAGE_WITH_BACKGROUND_IMAGE_HEIGHT_DEFAULT_VALUE("180px"),
	WOOCATION_IMAGE_WITH_BACKGROUND_IMAGE_BG_DEFAULT_VALUE("#1ed3e0"),
	WOOCATION_IMAGE_WITH_BACKGROUND_ICO_WIDTH_DEFAULT_VALUE("100px"),
	WOOCATION_IMAGE_WITH_BACKGROUND_ICO_HEIGHT_DEFAULT_VALUE("100px"),
	WOOCATION_IMAGE_WITH_BACKGROUND_FONT_SIZE_DEFAULT_VALUE("16px"),
	WOOCATION_IMAGE_WITH_BACKGROUND_FONT_COLOR_DEFAULT_VALUE("#ffffff"),
	WOOCATION_IMAGE_WITH_BACKGROUND_TEXT_ALIGN_DEFAULT_VALUE("center"),
	WOOCATION_IMAGE_WITH_BACKGROUND_FONT_STYLE_DEFAULT_VALUE("bold"),
	WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_POSITION_DEFAULT_VALUE("bottom"),
	WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_BG_COLOR_DEFAULT_VALUE("none"),
	WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_LAYOUT_TYPE_DEFAULT_VALUE("simple"),
	
	
	/**
	 * TimeStamp Component Level 
	 */
	WOOCATION_TIMESTAMP_COMPONENT_NAME("Timestamp"),
	WOOCATION_TIMESTAMP_DISPLAY_NAME_DEFAULT_VALUE("Timestamp"),
	WOOCATION_TIMESTAMP_TYPE_DEFAULT_VALUE("timestamp"),
	WOOCATION_TIMESTAMP_BG_COLOR_DEFAULT_VALUE("rgba(134,145,155,.05)"),
	WOOCATION_TIMESTAMP_PADDING_DEFAULT_VALUE("5px 15px"),
	WOOCATION_TIMESTAMP_COLOR_DEFAULT_VALUE("#33adf"),
	WOOCATION_TIMESTAMP_FONT_SIZE_DEFAULT_VALUE("36px"),
	WOOCATION_TIMESTAMP_COLON_SIZE_DEFAULT_VALUE("36px"),
	WOOCATION_TIMESTAMP_COLON_MARGIN_DEFAULT_VALUE("0px 5px"),
	WOOCATION_TIMESTAMP_LBL_SIZE_DEFAULT_VALUE("13px"),
	WOOCATION_TIMESTAMP_LBL_COLOR_DEFAULT_VALUE("#33adff"),
	
	
	/**
	 * SVG Image Component
	 */
	
	WOOCATION_SVG_IMAGE_COMPONENT_NAME("SVG Image"),
	WOOCATION_SVG_IMAGE_DISPLAY_NAME_DEFAULT_VALUE("SVG Image"),
	WOOCATION_SVG_IMAGE_TYPE_DEFAULT_VALUE("svg-image"),
	WOOCATION_SVG_IMAGE_WIDTH_DEFAULT_VALUE("50px"),
	WOOCATION_SVG_IMAGE_HEIGHT_DEFAULT_VALUE("50px"),
	WOOCATION_SVG_IMAGE_PADDING_DEFAULT_VALUE("5px"),
	WOOCATION_SVG_IMAGE_COLOR_DEFAULT_VALUE("#ff0000"),
	
	
	
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
	WOOCATION_TEXT_ALIGN("text_align"),
	WOOCATION_POSITION("position"),
	WOOCATION_BG_COLOR("bg_color"),
	WOOCATION_LAYOUT_TYPE("layout_type"),
	WOOCATION_LAYOUT("layout"),
	WOOCATION_OVERLAY("overlay"),
	WOOCATION_IMAGE_HEIGHT("image_height"),
	WOOCATION_IMAGE_BG("image_bg"),
	WOOCATION_ICO_WIDTH("ico_width"),
	WOOCATION_HOURS("hours"),
	WOOCATION_MINTUES("mins"),
	WOOCATION_SECONDS("seconds"),
	WOOCATION_COLON_SIZE("colon_size"),
	WOOCATION_COLON_MARGIN("colon_margin"),
	WOOCATION_LBL_SIZE("lbl_size"),
	WOOCATION_LBL_COLOR("lbl_color"),
	WOOCATION_WIDTH("width"),
	WOOCATION_GLOBAL_NAME("Global");
	
	private String message;

	WoocationTypes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
