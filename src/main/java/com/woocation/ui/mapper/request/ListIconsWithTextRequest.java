package com.woocation.ui.mapper.request;

import java.util.List;

public class ListIconsWithTextRequest {

	private int order ;
	
	private List<ListIconData> listsIconDatas;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<ListIconData> getListsIconDatas() {
		return listsIconDatas;
	}

	public void setListsIconDatas(List<ListIconData> listsIconDatas) {
		this.listsIconDatas = listsIconDatas;
	}
	
	
}
