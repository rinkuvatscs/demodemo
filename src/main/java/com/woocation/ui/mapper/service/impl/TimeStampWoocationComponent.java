package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.TimeStampComponentRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

@Component
public class TimeStampWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(TimeStampComponentRequest headingComponentRequest) {
		WoocationCompoonentResponse headingCompoonentResponse = new WoocationCompoonentResponse();
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_HOURS.getMessage(),
				headingComponentRequest.getHours());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_MINTUES.getMessage(),
				headingComponentRequest.getMintues());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_SECONDS.getMessage(),
				headingComponentRequest.getSeconds());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				headingComponentRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(headingCompoonentResponse);
			processForComponentVars(headingCompoonentResponse);
		} else {
			headingDefaultConfiguraions(headingCompoonentResponse);
		}

		return headingCompoonentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_TIMESTAMP_COMPONENT_NAME.getMessage());
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
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_SIZE.getMessage(),
					globalHeadingApplicationVars.getApplicationVarsContent().get(WOOCATION_FONT_SIZE.getMessage()));
		}
	}

	private void headingDefaultConfiguraions(WoocationCompoonentResponse headingCompoonentResponse) {
		
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_TIMESTAMP_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_TIMESTAMP_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_TIMESTAMP_BG_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
				WOOCATION_TIMESTAMP_PADDING_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_COLOR.getMessage(),
				WOOCATION_TIMESTAMP_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_TIMESTAMP_FONT_SIZE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_COLON_SIZE.getMessage(),
				WOOCATION_TIMESTAMP_COLON_SIZE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_COLON_MARGIN.getMessage(),
				WOOCATION_TIMESTAMP_COLON_MARGIN_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_LBL_SIZE.getMessage(),
				WOOCATION_TIMESTAMP_LBL_SIZE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_LBL_COLOR.getMessage(),
				WOOCATION_TIMESTAMP_LBL_COLOR_DEFAULT_VALUE.getMessage());
	}
}
