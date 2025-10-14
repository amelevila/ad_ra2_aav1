package com.ra2.Aav1.model;

public class Customer {
	private long id;
	private String firstName, lastName;
	private int age, year;
	private String cicle;
	
	public Customer() {
		
	}
	
	public Customer(long id, String firstName, String lastName, int age, int year, String cicle) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.year = year;
		this.cicle = cicle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCicle() {
		return cicle;
	}

	public void setCicle(String cicle) {
		this.cicle = cicle;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", year="
				+ year + ", cicle=" + cicle + "]";
	}
	
}