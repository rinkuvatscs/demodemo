package com.woocation.ui.mapper.response;

import java.util.LinkedHashMap;
import java.util.Map;

public final class HeadingCompoonentResponse {

	private Map<String, Object> headingResponse;

	public HeadingCompoonentResponse() {
		this.headingResponse = new LinkedHashMap<>();
	}

	public Map<String, Object> getHeadingResponse() {
		return headingResponse;
	}

}
