package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.InfoTextVersionSevenRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class InfoVersionSevenWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(InfoTextVersionSevenRequest infoTextVersionSevenRequest) {
		WoocationCompoonentResponse woocationCompoonentResponse = new WoocationCompoonentResponse();
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				infoTextVersionSevenRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(woocationCompoonentResponse);
			processForComponentVars(woocationCompoonentResponse);
		} else {
			componentDefaultConfiguraions(woocationCompoonentResponse, infoTextVersionSevenRequest);
		}
		return woocationCompoonentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_INFO_TEXT_SEVEN_COMPONENT_NAME.getMessage());
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
			InfoTextVersionSevenRequest infoTextVersionSevenRequest) {

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_BG_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_WIDTH_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_PADDING_DEFAULT_VALUE.getMessage());

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TEXT_SECTION.getMessage(),
				processTextSection(infoTextVersionSevenRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_VALUE_SECTION.getMessage(),
				processValueSection(infoTextVersionSevenRequest));

	}

	private Map<String, Object> processTextSection(InfoTextVersionSevenRequest infoTextVersionSevenRequest) {
		Map<String, Object> textMap = new HashMap<>();
		textMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionSevenRequest.getTextSectionText());
		textMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_TEXT_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_TEXT_SECTION_FONT_COLOR_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_TEXT_SECTION_FONT_SIZE_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_TEXT_SECTION_FONT_STYLE_DEFAULT_VALUE.getMessage());

		return textMap;
	}

	private Map<String, Object> processValueSection(InfoTextVersionSevenRequest infoTextVersionSevenRequest) {
		Map<String, Object> valueMap = new HashMap<>();

		valueMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_WIDTH_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_ALIGN_ITEMS.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_ALIGN_ITEMS_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_VALUE_TYPE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_VALUE_TYPE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_SCORE.getMessage(), processScore(infoTextVersionSevenRequest));
		valueMap.put(WOOCATION_TOTAL.getMessage(), processTotal(infoTextVersionSevenRequest));
		return valueMap;
	}

	private Map<String, Object> processScore(InfoTextVersionSevenRequest infoTextVersionSevenRequest) {
		Map<String, Object> scoreMap = new HashMap<>();
		scoreMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionSevenRequest.getScoreText());
		scoreMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_SCORE_FONT_COLOR_DEFAULT_VALUE.getMessage());
		scoreMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_SCORE_FONT_SIZE_DEFAULT_VALUE.getMessage());
		scoreMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_SCORE_FONT_STYLE_DEFAULT_VALUE.getMessage());
		return scoreMap;
	}

	private Map<String, Object> processTotal(InfoTextVersionSevenRequest infoTextVersionSevenRequest) {
		Map<String, Object> totalMap = new HashMap<>();
		totalMap.put(WOOCATION_TEXT.getMessage(), infoTextVersionSevenRequest.getTotalText());
		totalMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_TOTAL_FONT_COLOR_DEFAULT_VALUE.getMessage());
		totalMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_TOTAL_FONT_SIZE_DEFAULT_VALUE.getMessage());
		totalMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_INFO_TEXT_SEVEN_VALUE_SECTION_TOTAL_FONT_STYLE_DEFAULT_VALUE.getMessage());
		return totalMap;
	}

}
