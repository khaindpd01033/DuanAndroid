package com.example.parser;

public class History {
	private String Title;
	private String Link;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public History(String Time,String link) {

		this.Title = Time;
		this.Link = link ;

	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

}
