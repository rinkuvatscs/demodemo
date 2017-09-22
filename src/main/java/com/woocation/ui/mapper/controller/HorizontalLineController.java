package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.HeadingComponentRequest;
import com.woocation.ui.mapper.service.impl.HorizontalWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/horizontalline" , produces ="application/json")
public class HorizontalLineController {

	@Autowired
	private HorizontalWoocationComponent horizontalWoocationComponent;

	@RequestMapping(value ="/")
	public Map<String,Object> generatePlainTextContent(
			@RequestBody HeadingComponentRequest headingComponentRequest) {
		return horizontalWoocationComponent.processRequest(headingComponentRequest).getHeadingResponse();
	}

}
