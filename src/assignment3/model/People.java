package assignment3.model;

import java.util.ArrayList;

public class People {
	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	private ArrayList<Person> people;

	public People(ArrayList<Person> people) {
		super();
		this.people = people;
	}
	
	public People(){
		
	}
}
