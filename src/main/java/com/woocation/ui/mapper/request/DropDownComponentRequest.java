package com.woocation.ui.mapper.request;

import java.util.List;

public class DropDownComponentRequest {

	private int order ;
	
	private List<DropDownData> dropDowndatas ;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<DropDownData> getDropDowndatas() {
		return dropDowndatas;
	}

	public void setDropDowndatas(List<DropDownData> dropDowndatas) {
		this.dropDowndatas = dropDowndatas;
	}
	
}
