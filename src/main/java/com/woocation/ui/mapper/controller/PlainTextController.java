package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.woocation.ui.mapper.request.PlainTextComponentRequest;
import com.woocation.ui.mapper.service.impl.PlainTextWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/plantext" , produces ="application/json")
public class PlainTextController {

	@Autowired
	private PlainTextWoocationComponent plainTextWoocationComponent;

	@RequestMapping(value ="/")
	public Map<String,Object> generatePlainTextContent(
			@RequestBody PlainTextComponentRequest plainTextComponentRequest) {
		return plainTextWoocationComponent.processRequest(plainTextComponentRequest).getHeadingResponse();
	}

}
