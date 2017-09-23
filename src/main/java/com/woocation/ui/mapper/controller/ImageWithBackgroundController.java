package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.ImageWithBackgroundComponentRequest;
import com.woocation.ui.mapper.service.impl.ImageWithBackgroundComponent;

@RestController
@RequestMapping(value = "/woocation/ui/imagewithbackground", produces = "application/json")
public class ImageWithBackgroundController {

	@Autowired
	private ImageWithBackgroundComponent imageWithBackgroundComponent;

	@RequestMapping(value = "/")
	public Map<String, Object> generateImageWithBackgroundContent(
			@RequestBody ImageWithBackgroundComponentRequest imageWithBackgroundComponentRequest) {
		return imageWithBackgroundComponent.processRequest(imageWithBackgroundComponentRequest).getHeadingResponse();
	}

}
