package com.est;

/**
 * @author estevam
 */
public class Person {

	private long id;
	private String firstname;
	private String lastname;
	private String description;
	
	public Person(){}
	
	public Person(long id, String firstname, String lastname, String description) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
