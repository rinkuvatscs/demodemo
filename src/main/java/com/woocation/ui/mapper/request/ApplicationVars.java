package com.woocation.ui.mapper.request;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicationVars")
public class ApplicationVars {

	@Id
	private String id ;
	
	@Indexed(unique = true)
	private String applicationVarName;
	
	public String getApplicationVarName() {
		return applicationVarName;
	}

	public void setApplicationVarName(String applicationVarName) {
		this.applicationVarName = applicationVarName;
	}

	private Map<String,String> applicationVarsContent ;

	
	public Map<String, String> getApplicationVarsContent() {
		return applicationVarsContent;
	}

	public void setApplicationVarsContent(Map<String, String> applicationVarsContent) {
		this.applicationVarsContent = applicationVarsContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
