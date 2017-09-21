package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.HeadingComponentRequest;
import com.woocation.ui.mapper.service.impl.HeadingWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/heading" , produces ="application/json")
public class HeadingController {

	@Autowired
	private HeadingWoocationComponent headingWoocationComponent;

	@RequestMapping(value ="/")
	public Map<String,Object> generateHeadingContent(
			@RequestBody HeadingComponentRequest headingComponentRequest) {
		return headingWoocationComponent.generateHeadingContent(headingComponentRequest).getHeadingResponse();
	}

}
