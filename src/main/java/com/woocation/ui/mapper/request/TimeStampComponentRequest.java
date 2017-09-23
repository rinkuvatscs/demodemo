package com.woocation.ui.mapper.request;

public class TimeStampComponentRequest {

	private String hours;
	private String mintues;
	private String seconds ;
	private String order ;
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMintues() {
		return mintues;
	}
	public void setMintues(String mintues) {
		this.mintues = mintues;
	}
	public String getSeconds() {
		return seconds;
	}
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "TimeStampComponentRequest [hours=" + hours + ", mintues=" + mintues + ", seconds=" + seconds
				+ ", order=" + order + "]";
	}
}
