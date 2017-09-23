package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.ImageWithBackgroundComponentRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class ImageWithBackgroundComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(
			ImageWithBackgroundComponentRequest imageWithBackgroundComponentRequest) {
		WoocationCompoonentResponse woocationComponentResponse = new WoocationCompoonentResponse();
		 woocationComponentResponse.getHeadingResponse().put(WOOCATION_IMAGE_URL.getMessage(),
				imageWithBackgroundComponentRequest.getImageUrl());
		woocationComponentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				imageWithBackgroundComponentRequest.getOrder());
		if (isVarsEnable) {
			//TODO 
			processForGlobalVars(woocationComponentResponse);
			processForComponentVars(woocationComponentResponse);
		} else {
			imageLayoutDefaultConfiguraions(woocationComponentResponse , imageWithBackgroundComponentRequest);
		}
		return woocationComponentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_IMAGE_WITH_BACKGROUND_COMPONENT_NAME.getMessage());
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
			headingCompoonentResponse.getHeadingResponse().put(WOOCATION_FONT_STYLE.getMessage(),
					globalHeadingApplicationVars.getApplicationVarsContent().get(WOOCATION_FONT_STYLE.getMessage()));
		}
	}

	private void imageLayoutDefaultConfiguraions(WoocationCompoonentResponse woocationCompoonentResponse , ImageWithBackgroundComponentRequest imageWithBackgroundComponentRequest) {

		
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_TYPE_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_IMAGE_HEIGHT.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_IMAGE_HEIGHT_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_IMAGE_BG.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_IMAGE_BG_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ICO_WIDTH.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_ICO_WIDTH_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_ICO_HEIGHT.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_ICO_HEIGHT_DEFAULT_VALUE.getMessage());
		
		Map<String, Object> overlayMap = new HashMap<>();
		overlayDefaultConfigurations(imageWithBackgroundComponentRequest , overlayMap);
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_OVERLAY.getMessage() , overlayMap);
	}

	private void layoutDefaultConfigurations(ImageWithBackgroundComponentRequest imageWithBackgroundComponentRequest,
			Map<String, Object> responseMap) {
		responseMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_FONT_SIZE_DEFAULT_VALUE.getMessage());
		responseMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_FONT_SIZE_DEFAULT_VALUE.getMessage());
		responseMap.put(WOOCATION_TEXT_ALIGN.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_FONT_SIZE_DEFAULT_VALUE.getMessage());
		responseMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_IMAGE_WITH_BACKGROUND_FONT_SIZE_DEFAULT_VALUE.getMessage());

	}
	
	private void overlayDefaultConfigurations(ImageWithBackgroundComponentRequest imageWithBackgroundComponentRequest,
			Map<String, Object> overlayMap) {
		
		overlayMap.put(WOOCATION_POSITION.getMessage(), WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_POSITION_DEFAULT_VALUE.getMessage());
		overlayMap.put(WOOCATION_BG_COLOR.getMessage(), WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_BG_COLOR_DEFAULT_VALUE.getMessage());
		overlayMap.put(WOOCATION_LAYOUT_TYPE.getMessage(), WOOCATION_IMAGE_WITH_BACKGROUND_OVERLAY_LAYOUT_TYPE_DEFAULT_VALUE.getMessage());
		
		Map<String, Object> layoutMap = new HashMap<>();
		layoutMap.put(WOOCATION_TEXT.getMessage() , imageWithBackgroundComponentRequest.getText());
		layoutDefaultConfigurations(imageWithBackgroundComponentRequest , layoutMap);
		overlayMap.put(WOOCATION_LAYOUT.getMessage() , layoutMap);
		
	}
}
