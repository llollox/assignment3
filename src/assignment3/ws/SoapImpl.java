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

	
}
