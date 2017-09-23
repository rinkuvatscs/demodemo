package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.InfoTextVersionFourRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoVersionFourWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(InfoTextVersionFourRequest infoTextVersionFourRequest) {
		WoocationCompoonentResponse woocationCompoonentResponse = new WoocationCompoonentResponse();
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				infoTextVersionFourRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(woocationCompoonentResponse);
			processForComponentVars(woocationCompoonentResponse);
		} else {
			componentDefaultConfiguraions(woocationCompoonentResponse, infoTextVersionFourRequest);
		}
		return woocationCompoonentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_INFO_TEXT_FOUR_COMPONENT_NAME.getMessage());
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
			InfoTextVersionFourRequest infoTextVersionFourRequest) {

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_BG_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_WIDTH_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_PADDING_DEFAULT_VALUE.getMessage());

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TEXT_SECTION.getMessage(),
				processTextSection(infoTextVersionFourRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_VALUE_SECTION.getMessage(),
				processValueSection(infoTextVersionFourRequest));

	}

	private Map<String, Object> processTextSection(InfoTextVersionFourRequest infoTextVersionFourRequest) {
		Map<String, Object> textMap = new HashMap<>();
		textMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionFourRequest.getTextSectionText());
		textMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_TEXT_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_TEXT_SECTION_FONT_COLOR_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_TEXT_SECTION_FONT_SIZE_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_TEXT_SECTION_FONT_STYLE_DEFAULT_VALUE.getMessage());

		return textMap;
	}

	private Map<String, Object> processValueSection(InfoTextVersionFourRequest infoTextVersionFourRequest) {
		Map<String, Object> valueMap = new HashMap<>();
		valueMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_ALIGN_ITEMS.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_ALIGN_ITEMS_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_VALUE_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_VALUE_TYPE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_FONT_COLOR_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_FONT_SIZE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_FONT_STYLE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_POPUP_BG_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_POPUP_BG_COLOR_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_MENU_ITEMS_PADDING.getMessage(),
				WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_MENU_ITEMS_PADDING_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_CONTENT.getMessage(), processForContent(infoTextVersionFourRequest));
		return valueMap;
	}

	private Map<String, Object> processForContent(InfoTextVersionFourRequest infoTextVersionFourRequest) {
		Map<String, Object> responseMap = new HashMap<>();
		List<Map<String, Object>> contentList = new ArrayList<>();
		infoTextVersionFourRequest.getInfoVersionFourContentRequests().forEach(infoTextVersionRequest -> {
			Map<String, Object> contentMap = new HashMap<>();
			contentMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionRequest.getText());
			contentMap.put(WOOCATION_ICON.getMessage(), infoTextVersionRequest.getIcon());
			contentMap.put(WOOCATION_FONT_COLOR.getMessage(),
					WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_CONTENT_FONT_COLOR_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_FONT_SIZE.getMessage(),
					WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_CONTENT_FONT_SIZE_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_FONT_STYLE.getMessage(),
					WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_CONTENT_FONT_STYLE_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_ICO_WIDTH.getMessage(),
					WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_CONTENT_ICO_WIDTH_DEFAULT_VALUE.getMessage());
			contentMap.put(WOOCATION_ICO_HEIGHT.getMessage(),
					WOOCATION_INFO_TEXT_FOUR_VALUE_SECTION_CONTENT_ICO_HEIGHT_DEFAULT_VALUE.getMessage());
			contentList.add(contentMap);
		});
		if (!contentList.isEmpty()) {
			responseMap.put(WOOCATION_CONTENT.getMessage(), contentList);
		}
		return responseMap;
	}

}
