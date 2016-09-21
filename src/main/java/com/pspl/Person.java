package com.pspl;

import java.time.LocalDate;

/**
 * Created by shwetaswarnkar on 16/08/16.
 */
public class Person {
	public enum Sex {
		MALE ,FEMALE
	}

	String name;
	LocalDate birthDate;
	Sex gender;
	int age;

	public Person(String name, LocalDate birthDate, Sex gender, int age) {
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Sex getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
