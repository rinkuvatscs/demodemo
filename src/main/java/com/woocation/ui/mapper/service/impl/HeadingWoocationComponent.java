package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.HeadingComponentRequest;
import com.woocation.ui.mapper.response.HeadingCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

@Component
public class HeadingWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:true}")
	private boolean isVarsEnable;

	public HeadingCompoonentResponse generateHeadingContent(HeadingComponentRequest headingComponentRequest) {
		HeadingCompoonentResponse headingCompoonentResponse = new HeadingCompoonentResponse();
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TEXT.getMessage(),
				headingComponentRequest.getText());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ICON.getMessage(),
				headingComponentRequest.getIconPath());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				headingComponentRequest.getOrder());
		if (isVarsEnable) {

			ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
					.getApplicationVars(WOOCATION_HEADING_COMPONENT_NAME.getMessage());
			ApplicationVars globalHeadingApplicationVars = applicationVarsServiceImpl
					.getApplicationVars(WOOCATION_GLOBAL_NAME.getMessage());
			if (!StringUtils.isEmpty(componentHeadingApplicationVars)
					&& !StringUtils.isEmpty(componentHeadingApplicationVars.getApplicationVarsContent())) {
				componentHeadingApplicationVars.getApplicationVarsContent()
						.forEach((key, value) -> headingCompoonentResponse.getHeadingResponse().put(key, value));
			}

			if (!StringUtils.isEmpty(globalHeadingApplicationVars)
					&& !StringUtils.isEmpty(globalHeadingApplicationVars.getApplicationVarsContent())) {
				headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_SIZE.getMessage(),
						globalHeadingApplicationVars.getApplicationVarsContent().get(WOOCATION_FONT_SIZE.getMessage()));
			}

		} else {
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
					WOOCATION_HEADING_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
					WOOCATION_HEADING_TYPE_DEFAULT_VALUE.getMessage());
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_SIZE.getMessage(),
					WOOCATION_HEADING_FONT_SIZE_DEFAULT_VALUE.getMessage());
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_COLOR.getMessage(),
					WOOCATION_HEADING_FONT_COLOR_DEFAULT_VALUE.getMessage());
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_STYLE.getMessage(),
					WOOCATION_HEADING_FONT_STYLE_DEFAULT_VALUE.getMessage());
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ICO_HEIGHT.getMessage(),
					WOOCATION_HEADING_ICO_HEIGHT_DEFAULT_VALUE.getMessage());
		}

		return headingCompoonentResponse;
	}

}
