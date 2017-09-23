package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.TimeStampComponentRequest;
import com.woocation.ui.mapper.service.impl.TimeStampWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/timestamp", produces = "application/json")
public class TimeStampController {

	@Autowired
	private TimeStampWoocationComponent timeStampWoocationComponent;

	@RequestMapping(value = "/")
	public Map<String, Object> generateHeadingContent(
			@RequestBody TimeStampComponentRequest timeStampComponentRequest) {
		return timeStampWoocationComponent.processRequest(timeStampComponentRequest).getHeadingResponse();
	}

}
