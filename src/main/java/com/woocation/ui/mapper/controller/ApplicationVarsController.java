package com.woocation.ui.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.service.ApplicationVarsService;

@RestController
@RequestMapping(value = "/woocation/ui/global/vars" , produces ="application/json")
public class ApplicationVarsController {

	@Autowired
	ApplicationVarsService applicationVarsServiceimpl;

	@RequestMapping(value = "/" , method = RequestMethod.POST)
	ApplicationVars addGlobalVars(@RequestBody ApplicationVars applicationVars) {
		return applicationVarsServiceimpl.addApplicationVars(applicationVars);
	}

}