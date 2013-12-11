package assignment3.ws;

import java.util.ArrayList;

import javax.jws.WebService;

import assignment3.hibernate.HealthProfileHibernate;
import assignment3.hibernate.PersonHibernate;
import assignment3.model.HealthProfile;
import assignment3.model.HealthProfileHistory;
import assignment3.model.People;
import assignment3.model.Person;

//Service Implementation
@WebService(endpointInterface = "assignment3.ws.Soap")

public class SoapImpl implements Soap {
	
	@Override
	public People getPeople() {
		return new People(PersonHibernate.getPeople());
	}
	
	@Override
	public Person readPerson(Long personId) {
		
		Person person = PersonHibernate.getPerson(personId);
		HealthProfile healthProfile = HealthProfileHibernate.getCurrentPersonHealthProfile(personId);
		if (healthProfile != null)
			person.setHealthProfile(healthProfile);
		return person;
	}
	
	@Override
	public Long createPerson(Person person){
		return PersonHibernate.savePerson(person);
	}
	
	@Override
	public Long updatePerson(Person person){
		return PersonHibernate.updatePerson(person);
	}
	
	@Override
	public Long deletePerson(Long personId){
		return PersonHibernate.deletePerson(personId);
	}

	@Override
	public HealthProfileHistory getHealthProfileHistory(Long personId) {
		return new HealthProfileHistory(HealthProfileHibernate.getPersonHealthProfileHistory(personId));
	}
	
	@Override
	public HealthProfile readHealthProfile(Long hpId) {
		return HealthProfileHibernate.getHealthProfile(hpId);	
	}

	@Override
	public Long createHealthProfile(Long personId, HealthProfile hp) {
		hp.setPerson_id(personId);
		return HealthProfileHibernate.saveHealthProfile(hp);
	}

	@Override
	public Long updateHealthProfile(Long personId, HealthProfile hp) {
		hp.setPerson_id(personId);
		
		if(hp.getHealthprofile_id() != null) // if id is present -> update it
			return HealthProfileHibernate.updateHealthProfile(hp);
		else // no id present -> create it
			return HealthProfileHibernate.saveHealthProfile(hp);
	}

	@Override
	public Long deleteHealthProfile(Long hpId) {
		return HealthProfileHibernate.deleteHealthProfile(hpId);
	}

	@Override
	public HealthProfile readCurrentHealthProfile(Long personId) {
		return HealthProfileHibernate.getCurrentPersonHealthProfile(personId);
	}

	
}
