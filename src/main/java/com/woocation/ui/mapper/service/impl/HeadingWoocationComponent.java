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

import java.util.HashMap;
import java.util.Map;

@Component
public class HeadingWoocationComponent implements WoocationComponent {

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars}")
	private boolean isVarsEnable;

	public HeadingCompoonentResponse generateHeading(HeadingComponentRequest headingComponentRequest) {
		HeadingCompoonentResponse headingCompoonentResponse;
		if (isVarsEnable) {
			Map<String , Object> response = new HashMap<>();
			ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
					.getApplicationVars(WOOCATION_HEADING_COMPONENT_NAME.getMessage());
			ApplicationVars globalHeadingApplicationVars = applicationVarsServiceImpl
					.getApplicationVars(WOOCATION_GLOBAL_NAME.getMessage());
			if (!StringUtils.isEmpty(componentHeadingApplicationVars)
					&& !StringUtils.isEmpty(componentHeadingApplicationVars.getApplicationVarsContent())) {
					response.
			} else {

			}
		} else {

		}
	}

}
