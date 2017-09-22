package com.woocation.ui.mapper.response;

import java.util.LinkedHashMap;
import java.util.Map;

public final class WoocationCompoonentResponse {

	private Map<String, Object> headingResponse;

	public WoocationCompoonentResponse() {
		this.headingResponse = new LinkedHashMap<>();
	}

	public Map<String, Object> getHeadingResponse() {
		return headingResponse;
	}

}
