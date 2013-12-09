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
	public Person getPerson(Long personId) {
		return PersonHibernate.getPerson(personId);
	}
	
	@Override
	public Person savePerson(Person person){
		return PersonHibernate.savePerson(person);
	}
	
	@Override
	public Person updatePerson(Person person){
		return PersonHibernate.updatePerson(person);
	}
	
	@Override
	public Person deletePerson(Long personId){
		return PersonHibernate.deletePerson(personId);
	}

	@Override
	public HealthProfileHistory getPersonHealthProfileHistory(Long personId) {
		return new HealthProfileHistory(HealthProfileHibernate.getPersonHealthProfileHistory(personId));
	}
	
	@Override
	public HealthProfile getHealthProfile(Long hpId) {
		return HealthProfileHibernate.getHealthProfile(hpId);	
	}

	@Override
	public HealthProfile saveHealthProfile(HealthProfile hp) {
		return HealthProfileHibernate.saveHealthProfile(hp);
	}

	@Override
	public HealthProfile updateHealthProfile(HealthProfile hp) {
		return HealthProfileHibernate.updateHealthProfile(hp);
	}

	@Override
	public HealthProfile deleteHealthProfile(Long hpId) {
		return HealthProfileHibernate.deleteHealthProfile(hpId);
	}

	@Override
	public HealthProfile getCurrentHealthProfile(Long personId) {
		return HealthProfileHibernate.getCurrentPersonHealthProfile(personId);
	}

	
}
