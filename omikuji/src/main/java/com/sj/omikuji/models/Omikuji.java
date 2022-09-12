package com.sj.omikuji.models;

public class Omikuji {
	private Integer randomNumber;
	private String city;
	private String person;
	private String hobby;
	private String livingThing;
	private String personalMessage;
	
//	CONSTRUCTOR
	public Omikuji (Integer randomNumber, String city, String person, String hobby, String livingThing, String personalMessage) {
		this.randomNumber = randomNumber;
		this.city = city;
		this.person = person;
		this.hobby = hobby;
		this.livingThing = livingThing;
		this.personalMessage = personalMessage;
	}

	
//	GETTERS AND SETTERS
	public Integer getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(Integer randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getLivingThing() {
		return livingThing;
	}

	public void setLivingThing(String livingThing) {
		this.livingThing = livingThing;
	}

	public String getPersonalMessage() {
		return personalMessage;
	}

	public void setPersonalMessage(String personalMessage) {
		this.personalMessage = personalMessage;
	}
	

}
