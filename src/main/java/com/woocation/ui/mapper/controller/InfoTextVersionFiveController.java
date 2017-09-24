package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.InfoVersionFiveRequest;
import com.woocation.ui.mapper.service.impl.InfoTextFiveWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/infotextversionfive", produces = "application/json")
public class InfoTextVersionFiveController {

	@Autowired
	private InfoTextFiveWoocationComponent infoTextFiveWoocationComponent;

	@RequestMapping(value = "/")
	public Map<String, Object> generateContent(
			@RequestBody InfoVersionFiveRequest infoVersionFiveRequest) {
		return infoTextFiveWoocationComponent.processRequest(infoVersionFiveRequest).getHeadingResponse();
	}

}
