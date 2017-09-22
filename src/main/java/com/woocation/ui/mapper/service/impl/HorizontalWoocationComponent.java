package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.HeadingComponentRequest;
import com.woocation.ui.mapper.request.HorizontalComponentRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

@Component
public class HorizontalWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(HorizontalComponentRequest horizontalComponentRequest) {
		WoocationCompoonentResponse headingCompoonentResponse = new WoocationCompoonentResponse();
		
		processContentPlacement(horizontalComponentRequest , headingCompoonentResponse);
		
		if (isVarsEnable) {
			processForGlobalVars(headingCompoonentResponse);
			processForComponentVars(headingCompoonentResponse);
		} else {
			plainTextDefaultConfiguraions(headingCompoonentResponse);
		}

		return headingCompoonentResponse;
	}
	
	private void processContentPlacement(HorizontalComponentRequest horizontalComponentRequest , WoocationCompoonentResponse headingCompoonentResponse) {
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				horizontalComponentRequest.getOrder());
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

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_PLAINTEXT_COMPONENT_NAME.getMessage());
			if (!StringUtils.isEmpty(componentHeadingApplicationVars)
				&& !StringUtils.isEmpty(componentHeadingApplicationVars.getApplicationVarsContent())) {
			componentHeadingApplicationVars.getApplicationVarsContent()
					.forEach((key, value) -> headingCompoonentResponse.getHeadingResponse().put(key, value));
		}
	}
	
	private void plainTextDefaultConfiguraions(WoocationCompoonentResponse headingCompoonentResponse) {
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_PLAINTEXT_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_PLAINTEXT_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ALIGN_TEXT.getMessage(),
				WOOCATION_PLAINTEXT_ALIGN_TEXT_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_PADDING.getMessage(),
				WOOCATION_PLAINTEXT_PADDING_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_PLAINTEXT_FONT_SIZE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_PLAINTEXT_FONT_COLOR_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_PLAINTEXT_FONT_STYLE_DEFAULT_VALUE.getMessage());
	}
}
