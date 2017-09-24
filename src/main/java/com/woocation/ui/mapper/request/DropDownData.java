package com.woocation.ui.mapper.request;

import java.util.List;

public class DropDownData {

	private String displayName;
	private String value;
	private List<Object> sectionDatas;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Object> getSectionDatas() {
		return sectionDatas;
	}

	public void setSectionDatas(List<Object> sectionDatas) {
		this.sectionDatas = sectionDatas;
	}

}
