package com.woocation.ui.mapper.service.impl;

import static com.woocation.ui.mapper.constants.WoocationTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.request.DropDownComponentRequest;
import com.woocation.ui.mapper.response.WoocationCompoonentResponse;
import com.woocation.ui.mapper.service.WoocationComponent;

@Component
public class DropDownWoocationComponent implements WoocationComponent {

	

	@Autowired
	private ApplicationVarsServiceImpl applicationVarsServiceImpl;

	@Value("${enable.applications.vars:false}")
	private boolean isVarsEnable;

	
	public WoocationCompoonentResponse processRequest(DropDownComponentRequest dropDownComponentRequest) {
		WoocationCompoonentResponse headingCompoonentResponse = new WoocationCompoonentResponse();
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_ORDER.getMessage(),
				dropDownComponentRequest.getOrder());
		if (isVarsEnable) {
			processForGlobalVars(headingCompoonentResponse);
			processForComponentVars(headingCompoonentResponse);
		} else {
			componentDefaultConfiguraions(headingCompoonentResponse,dropDownComponentRequest);
		}
		return headingCompoonentResponse ;
	}
	
	private void processForComponentVars(WoocationCompoonentResponse headingCompoonentResponse) {
		ApplicationVars componentHeadingApplicationVars = applicationVarsServiceImpl
				.getApplicationVars(WOOCATION_DROP_DOWN_COMPONENT_NAME.getMessage());
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
	
	private void componentDefaultConfiguraions(WoocationCompoonentResponse headingCompoonentResponse , DropDownComponentRequest dropDownComponentRequest) {
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DISPLAY_NAME.getMessage(),
				WOOCATION_DROP_DOWN_DISPLAY_NAME_DEFAULT_VALUE);
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_TYPE.getMessage(),
				WOOCATION_DROP_DOWN_TYPE_DEFAULT_VALUE.getMessage());
		headingCompoonentResponse.getHeadingResponse().put(WOOCATION_DROPDOWN_DATA.getMessage() , processDropdownData(dropDownComponentRequest));
	}
	
	
	private List<Object> processDropdownData(DropDownComponentRequest dropDownComponentRequest){
		List<Object> dropDownDatas = new ArrayList<>();
		Map<String,Object> processDropDownData = new HashMap<>();
		dropDownComponentRequest.getDropDowndatas().forEach(dropDownData -> {
			processDropDownData.put(WOOCATION_DISPLAY_NAME.getMessage() , dropDownData.getDisplayName());
			processDropDownData.put(WOOCATION_VALUE.getMessage() , dropDownData.getValue());
			processDropDownData.put(WOOCATION_SECTION_DATA.getMessage() , dropDownData.getSectionDatas());
			dropDownDatas.add(processDropDownData);
		});
		
		return dropDownDatas ;
	}
}
