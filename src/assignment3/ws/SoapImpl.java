package assignment3.ws;

import java.util.ArrayList;

import javax.jws.WebService;

import assignment3.hibernate.HealthProfileHibernate;
import assignment3.hibernate.PersonHibernate;
import assignment3.model.HealthProfile;
import assignment3.model.Person;

//Service Implementation
@WebService(endpointInterface = "assignment3.ws.Soap")

public class SoapImpl implements Soap {
	@Override

	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
	
	public ArrayList<Person> getPeople() {
		return PersonHibernate.getPeople();
	}
	
	public Person getPerson(Long personId) {
		return PersonHibernate.getPerson(personId);
	}
	
	public Person savePerson(Person person){
		return PersonHibernate.savePerson(person);
	}
	
	public Person updatePerson(Person person){
		return PersonHibernate.updatePerson(person);
	}
	
	public Person deletePerson(Long personId){
		return PersonHibernate.deletePerson(personId);
	}

	@Override
	public ArrayList<HealthProfile> getPersonHealthProfileHistory(Long personId) {
		return HealthProfileHibernate.getPersonHealthProfileHistory(personId);
	}
}
