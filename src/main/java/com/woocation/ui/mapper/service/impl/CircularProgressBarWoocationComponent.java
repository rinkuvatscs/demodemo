package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.CircularProgressComponentRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class CircularProgressBarWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(
			CircularProgressComponentRequest circularProgressComponentRequest) {
		WoocationCompoonentResponse woocationCompoonentResponse = new WoocationCompoonentResponse();
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				circularProgressComponentRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(woocationCompoonentResponse);
			processForComponentVars(woocationCompoonentResponse);
		} else {
			componentDefaultConfiguraions(woocationCompoonentResponse, circularProgressComponentRequest);
		}
		return woocationCompoonentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_CIRCULAR_PROGRESS_BAR_COMPONENT_NAME.getMessage());
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
			CircularProgressComponentRequest circularProgressComponentRequest) {

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_BG_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_WIDTH_DEFAULT_VALUE.getMessage());

		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_LABEL.getMessage(),
				processLabel(circularProgressComponentRequest));
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PROGESS_BAR.getMessage(),
				processProgressBar(circularProgressComponentRequest));

	}

	private Map<String, Object> processLabel(CircularProgressComponentRequest circularProgressComponentRequest) {
		Map<String, Object> textMap = new HashMap<>();
		textMap.put(WOOCATION_TEXT.getMessage(), circularProgressComponentRequest.getLabelText());
		textMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_LABEL_FONT_COLOR_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_LABEL_FONT_SIZE_DEFAULT_VALUE.getMessage());
		textMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_LABEL_FONT_STYLE_DEFAULT_VALUE.getMessage());

		return textMap;
	}

	private Map<String, Object> processProgressBar(CircularProgressComponentRequest circularProgressComponentRequest) {
		Map<String, Object> valueMap = new HashMap<>();

		valueMap.put(WOOCATION_TEXT.getMessage(), circularProgressComponentRequest.getProgressBarText());
		valueMap.put(WOOCATION_WIDTH.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_WIDTH_DEFAULT_VALUE.getMessage());

		valueMap.put(WOOCATION_STROKE_WIDTH.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_STROKE_WIDTH_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_PROGRESS_STROKE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_PROGRESS_STROKE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_REMAINING_STROKE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_REMAINING_STROKE_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_TEXT_COLOR.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_TEXT_COLOR_DEFAULT_VALUE.getMessage());
		valueMap.put(WOOCATION_TEXT_SIZE.getMessage(),
				WOOCATION_CIRCULAR_PROGRESS_BAR_PROGRESS_BAR_TEXT_SIZE_DEFAULT_VALUE.getMessage());
		return valueMap;
	}
}
