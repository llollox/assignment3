package assignment3.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import assignment3.model.HealthProfile;
import assignment3.model.Person;

@WebService(name = "SoapService", targetNamespace = "http://ws.assignment3/")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface Soap {
	@WebMethod
	@WebResult(partName = "return")
	
	public Person getPerson(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public ArrayList<Person> getPeople();
	
	public Person savePerson(@WebParam(name = "arg0", partName = "arg0") Person arg0);
	
	public Person updatePerson(@WebParam(name = "arg0", partName = "arg0") Person arg0);
	
	public Person deletePerson(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public ArrayList<HealthProfile> getPersonHealthProfileHistory(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public HealthProfile getHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public HealthProfile saveHealthProfile(@WebParam(name = "arg0", partName = "arg0") HealthProfile arg0);
	
	public HealthProfile updateHealthProfile(@WebParam(name = "arg0", partName = "arg0") HealthProfile arg0);
	
	public HealthProfile deleteHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0);

}