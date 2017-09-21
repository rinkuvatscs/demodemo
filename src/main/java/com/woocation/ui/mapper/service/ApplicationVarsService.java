package com.woocation.ui.mapper.service;


import com.woocation.ui.mapper.request.ApplicationVars;

public interface ApplicationVarsService {

	ApplicationVars addApplicationVars(ApplicationVars applicationVars) ;
	
   ApplicationVars getApplicationVars(String componentName) ;	

}
