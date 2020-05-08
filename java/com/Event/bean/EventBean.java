package com.Event.bean;

public class EventBean {

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventaddress() {
		return eventaddress;
	}

	public void setEventaddress(String eventaddress) {
		this.eventaddress = eventaddress;
	}

	private int eventid;
	private String eventname;
	private String eventaddress;
	private String eventDate;

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

}

