package com.woocation.ui.mapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.SimpleImageRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;
import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleImageWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	public WoocationCompoonentResponse processRequest(SimpleImageRequest simpleImageRequest) {
		WoocationCompoonentResponse woocationComponentResponse = new WoocationCompoonentResponse();
		woocationComponentResponse.getHeadingResponse().put(WOOCATION_IMAGE_URL.getMessage(),
				simpleImageRequest.getImageUrl());
		woocationComponentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				simpleImageRequest.getOrder());
		if (isVarsEnable) {
			// TODO
			processForGlobalVars(woocationComponentResponse);
			processForComponentVars(woocationComponentResponse);
		} else {
			imageLayoutDefaultConfiguraions(woocationComponentResponse, simpleImageRequest);
		}
		return woocationComponentResponse;
	}

	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_SIMPLE_IMAGE_COMPONENT_NAME.getMessage());
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

	private void imageLayoutDefaultConfiguraions(WoocationCompoonentResponse woocationCompoonentResponse,
			SimpleImageRequest simpleImageRequest) {

		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_SIMPLE_IMAGE_DISPLAY_NAME_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_SIMPLE_IMAGE_TYPE_DEFAULT_VALUE.getMessage());
		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_IMAGE_HEIGHT.getMessage(),
				WOOCATION_SIMPLE_IMAGE_IMAGE_HEIGHT_DEFAULT_VALUE.getMessage());

		woocationCompoonentResponse.getHeadingResponse().put(WOOCATION_OVERLAY.getMessage(),
				overlayDefaultConfigurations(simpleImageRequest));
	}
	private Map<String, Object> overlayDefaultConfigurations(SimpleImageRequest simpleImageRequest) {
		Map<String, Object> overlayMap = new HashMap<>();
		overlayMap.put(WOOCATION_POSITION.getMessage(),
				WOOCATION_SIMPLE_IMAGE_OVERLAY_POSITION_DEFAULT_VALUE.getMessage());
		overlayMap.put(WOOCATION_BG_COLOR.getMessage(),
				WOOCATION_SIMPLE_IMAGE_OVERLAY_BG_COLOR_DEFAULT_VALUE.getMessage());
		overlayMap.put(WOOCATION_LAYOUT_TYPE.getMessage(),
				WOOCATION_SIMPLE_IMAGE_OVERLAY_LAYOUT_TYPE_DEFAULT_VALUE.getMessage());

		overlayMap.put(WOOCATION_LAYOUT.getMessage(), layoutDefaultConfigurations(simpleImageRequest));

		return overlayMap;

	}

	private Map<String, Object> layoutDefaultConfigurations(SimpleImageRequest simpleImageRequest) {
		Map<String, Object> layoutMap = new HashMap<>();
		layoutMap.put(WOOCATION_TEXT.getMessage(), simpleImageRequest.getLayoutText());
		layoutMap.put(WOOCATION_FONT_SIZE.getMessage(),
				WOOCATION_SIMPLE_IMAGE_FONT_SIZE_DEFAULT_VALUE.getMessage());
		layoutMap.put(WOOCATION_FONT_COLOR.getMessage(),
				WOOCATION_SIMPLE_IMAGE_FONT_COLOR_DEFAULT_VALUE.getMessage());
		layoutMap.put(WOOCATION_TEXT_ALIGN.getMessage(),
				WOOCATION_SIMPLE_IMAGE_TEXT_ALIGN_DEFAULT_VALUE.getMessage());
		layoutMap.put(WOOCATION_FONT_STYLE.getMessage(),
				WOOCATION_SIMPLE_IMAGE_FONT_STYLE_DEFAULT_VALUE.getMessage());
		return layoutMap;

	}

	
}
