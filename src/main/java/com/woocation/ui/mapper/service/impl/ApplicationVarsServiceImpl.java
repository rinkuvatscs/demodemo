package com.woocation.ui.mapper.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.woocation.ui.mapper.repository.ApplicationVarsRepository;
import com.woocation.ui.mapper.request.ApplicationVars;
import com.woocation.ui.mapper.service.ApplicationVarsService;

@Service
public class ApplicationVarsServiceImpl implements ApplicationVarsService {

	@Autowired
	private ApplicationVarsRepository applicationVarsRepository;

	@Override
	public ApplicationVars addApplicationVars(ApplicationVars applicationVars) {

		ApplicationVars applicationVarsLocal = applicationVarsRepository
				.findByApplicationVarName(applicationVars.getApplicationVarName());
		if (applicationVarsLocal == null) {
			return applicationVarsRepository.save(applicationVars);
		} else {
			return putValues(applicationVarsLocal, applicationVars.getApplicationVarsContent());
		}
	}

	private ApplicationVars putValues(ApplicationVars applicationVars, Map<String, String> values) {
		values.forEach((key, value) -> applicationVars.getApplicationVarsContent().put(key, value));
		return applicationVars;
	}

	@Override
	public ApplicationVars getApplicationVars(String componentName) {
		if (!StringUtils.isEmpty(componentName)) {
			return applicationVarsRepository.findByApplicationVarName(componentName);
		}
		return null;

	}

}
