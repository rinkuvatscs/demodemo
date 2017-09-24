package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.InfoTextVersionFourRequest;
import com.woocation.ui.mapper.service.impl.InfoVersionFourWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/infotextversionfour", produces = "application/json")
public class InfoTextVersionFourController {

	@Autowired
	private InfoVersionFourWoocationComponent infoVersionFourWoocationComponent;

	@RequestMapping(value = "/")
	public Map<String, Object> generatePlainTextContent(
			@RequestBody InfoTextVersionFourRequest infoTextVersionFourRequest) {
		return infoVersionFourWoocationComponent.processRequest(infoTextVersionFourRequest).getHeadingResponse();
	}

}
