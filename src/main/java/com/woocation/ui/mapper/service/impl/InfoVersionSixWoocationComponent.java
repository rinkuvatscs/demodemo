package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.InfoTextVersionSixRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoVersionSixWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(InfoTextVersionSixRequest infoTextVersionSixRequest) {
		WoocationCompoonentResponse woocationCompoonentResponse = new WoocationCompoonentResponse();
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				infoTextVersionSixRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(woocationCompoonentResponse);
			processForComponentVars(woocationCompoonentResponse);
		} else {
			componentDefaultConfiguraions(woocationCompoonentResponse, infoTextVersionSixRequest);
		}
		return woocationCompoonentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_INFO_TEXT_SIX_COMPONENT_NAME.getMessage());
		if (!StringUtils.isEmpty(componentHeadingApplicationVars)
				&& !StringUtils.isEmpty(componentHeadingApplicationVars.getApplicationVarsContent())) {
			componentHeadingApplicationVars.getApplicationVarsContent()
					.forEach((key, value) -> headingCompoonentResponse.getHeadingResponse().put(key, value));
		}
	}

	private void processForGlobalVars(WoocationCompoonentResponse headingCompoonentResponse) {

		ApplicationVars globalHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_GLOBAL_NAME.getMessage());
		if (!StringUtils.isEmpty(globalHeadingApplicationVars)
				&& !StringUtils.isEmpty(globalHeadingApplicationVars.getApplicationVarsContent())) {
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
					globalHeadingApplicationVars.getApplicationVarsContent().get(WOOCATION_PADDING.getMessage()));
		}
	}

	private void componentDefaultConfiguraions(WoocationCompoonentResponse headingCompoonentResponse,
			InfoTextVersionSixRequest infoTextVersionSixRequest) {

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_INFO_TEXT_SIX_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SIX_BG_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SIX_WIDTH_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
				WOOCATION_INFO_TEXT_SIX_PADDING_DEFAULT_VALUE.getMessage());

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ICON_SECTION.getMessage() ,processIconSection(infoTextVersionSixRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TEXT_SECTION.getMessage(),
				processTextSection(infoTextVersionSixRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DESC.getMessage() ,processDescSection(infoTextVersionSixRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_VALUE_SECTION.getMessage(),
				processValueSection(infoTextVersionSixRequest));

	}
	
	private Map<String, Object> processIconSection(InfoTextVersionSixRequest infoTextVersionSixRequest){
		Map<String, Object> iconMap = new HashMap<>();
		iconMap.put(WOOCATION_URL.getMessage() , infoTextVersionSixRequest.getIconSectionUrl());
		iconMap.put(WOOCATION_ICO_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SIX_ICON_SECTION_ICO_WIDTH_DEFAULT_VALUE.getMessage());
		iconMap.put(WOOCATION_ICO_HEIGHT.getMessage(),
				WOOCATION_INFO_TEXT_SIX_ICON_SECTION_ICO_HEIGHT_DEFAULT_VALUE.getMessage());
		return iconMap;
	}

	private Map<String, Object> processTextSection(InfoTextVersionSixRequest infoTextVersionSixRequest) {
		Map<String, Object> textMap = new HashMap<>();
		textMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionSixRequest.getTextSectionText());
		textMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SIX_TEXT_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SIX_TEXT_SECTION_FONT_COLOR_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_TEXT_SECTION_FONT_SIZE_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_TEXT_SECTION_FONT_STYLE_DEFAULT_VALUE.getMessage());

		return textMap;
	}
	
	private Map<String, Object> processDescSection(InfoTextVersionSixRequest infoTextVersionSixRequest){
		Map<String, Object> iconMap = new HashMap<>();
		iconMap.put(WOOCATION_TEXT.getMessage() , infoTextVersionSixRequest.getDescriptionText());
		iconMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SIX_DESC_FONT_COLOR_DEFAULT_VALUE.getMessage());
		iconMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_DESC_FONT_SIZE_DEFAULT_VALUE.getMessage());
		iconMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_DESC_FONT_STYLE_DEFAULT_VALUE.getMessage());

		return iconMap;
	}

	private Map<String, Object> processValueSection(InfoTextVersionSixRequest infoTextVersionSixRequest) {
		Map<String, Object> valueMap = new HashMap<>();
		valueMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionSixRequest.getValueSectionText());
		valueMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_ALIGN_ITEMS.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_ALIGN_ITEMS_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_VALUE_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_VALUE_TYPE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_FONT_COLOR_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_FONT_SIZE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_FONT_STYLE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_POPUP_BG_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_POPUP_BG_COLOR_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_MENU_ITEMS_PADDING.getMessage(),
				WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_MENU_ITEMS_PADDING_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_CONTENT.getMessage(), processForContent(infoTextVersionSixRequest));
		return valueMap;
	}

	private Map<String, Object> processForContent(InfoTextVersionSixRequest infoTextVersionSixRequest) {
		Map<String, Object> responseMap = new HashMap<>();
		List<Map<String, Object>> contentList = new ArrayList<>();
		infoTextVersionSixRequest.getInfoVersionSixContentRequests().forEach(infoTextVersionRequest -> {
			Map<String, Object> contentMap = new HashMap<>();
			contentMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionRequest.getText());
			contentMap.put(WOOCATION_ICON.getMessage(), infoTextVersionRequest.getIcon());
			contentMap.put(WOOCATION_FONT_COLOR.getMessage(),
					WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_CONTENT_FONT_COLOR_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_FONT_SIZE.getMessage(),
					WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_CONTENT_FONT_SIZE_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_FONT_STYLE.getMessage(),
					WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_CONTENT_FONT_STYLE_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_ICO_WIDTH.getMessage(),
					WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_CONTENT_ICO_WIDTH_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_ICO_HEIGHT.getMessage(),
					WOOCATION_INFO_TEXT_SIX_VALUE_SECTION_CONTENT_ICO_HEIGHT_DEFAULT_VALUE.getMessage());
			contentList.add(contentMap);
		});
		if (!contentList.isEmpty()) {
			responseMap.put(WOOCATION_CONTENT.getMessage(), contentList);
		}
		return responseMap;
	}

}
