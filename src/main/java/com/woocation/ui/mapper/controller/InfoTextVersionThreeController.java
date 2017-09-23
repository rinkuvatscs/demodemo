package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.InfoTextVersionThreeRequest;
import com.woocation.ui.mapper.service.impl.InfoVersionThreeWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/infotextversionthree", produces = "application/json")
public class InfoTextVersionThreeController {

	@Autowired
	private InfoVersionThreeWoocationComponent infoVersionThreeWoocationComponent;

	@RequestMapping(value = "/")
	public Map<String, Object> generatePlainTextContent(
			@RequestBody InfoTextVersionThreeRequest infoTextVersionThreeRequest) {
		return infoVersionThreeWoocationComponent.processRequest(infoTextVersionThreeRequest).getHeadingResponse();
	}

}
