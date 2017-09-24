	package com.woocation.ui.mapper.request;

import java.util.List;

public class PersonaItemWoocationRequest {

	private int order ;
	private String labelText ;
	
	private List<PersonaItemData> personaItemsData;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public List<PersonaItemData> getPersonaItemsData() {
		return personaItemsData;
	}

	public void setPersonaItemsData(List<PersonaItemData> personaItemsData) {
		this.personaItemsData = personaItemsData;
	}
	
	
}
