package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.CircularProgressComponentRequest;
import com.woocation.ui.mapper.service.impl.CircularProgressBarWoocationComponent;

@RestController
@RequestMapping(value = "/woocation/ui/circularprogrssbar" , produces ="application/json")
public class CircularProgressBarController {

	@Autowired
	private CircularProgressBarWoocationComponent circularProgressBarWoocationComponent ;

	@RequestMapping(value ="/")
	public Map<String,Object> generateHeadingContent(
			@RequestBody CircularProgressComponentRequest circularProgressComponentRequest) {
		return circularProgressBarWoocationComponent.processRequest(circularProgressComponentRequest).getHeadingResponse();
	}

}
