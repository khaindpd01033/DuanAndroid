package com.example.parser;

public class YeuThich {
	private String Title;
	private String Link;

	public String getTitle() {
		return Title;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public YeuThich(String Time, String link) {

		this.Title = Time;
		this.Link=link;

	}

}
