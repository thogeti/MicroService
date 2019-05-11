package com.praveen.moviecatalogservice.models;

public class CatlogItem {
	private String name;

	private String desc;
	private int rate;


	public CatlogItem(String name, String desc, int rate) {
		super();
		this.name = name;
		this.desc = desc;
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}

}
