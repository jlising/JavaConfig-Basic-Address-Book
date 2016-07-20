package com.addressbook.dto;

import java.util.List;

import com.addressbook.entities.Gender;

public class PersonInfo {
	private String id;
	
	private String lastname;
	
	private String firstname;
	
	private String middlename;
	
	private String suffix;
	
	private String prefix;
	
	private List<ContactInfo> contact;
	
	public List<ContactInfo> getContact() {
		return contact;
	}

	public void setContact(List<ContactInfo> contact) {
		this.contact = contact;
	}

	private Gender gender;

	private String birthdate;

	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
