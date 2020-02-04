package com.baina.entity;

public class ApVoter {
	
	
    private int vid;
	
	private String name;
	
	private int age;
	
	private String state;
	
	private String zipcode;

	public ApVoter() {
		
	}

	public ApVoter(int vid, String name, int age, String state, String zipcode) {
		this.vid = vid;
		this.name = name;
		this.age = age;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
	
	
	
	

}
