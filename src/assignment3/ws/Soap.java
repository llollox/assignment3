package assignment3.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import assignment3.model.HealthProfile;
import assignment3.model.HealthProfileHistory;
import assignment3.model.People;
import assignment3.model.Person;

@WebService(name = "SoapService", targetNamespace = "http://ws.assignment3/")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface Soap {
	@WebMethod
	@WebResult(partName = "return")
	public Person readPerson(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	@WebMethod
	public People getPeople();
	
	public Long createPerson(@WebParam(name = "arg0", partName = "arg0") Person arg0);
	
	public Long updatePerson(@WebParam(name = "arg0", partName = "arg0") Person arg0);
	
	public Long deletePerson(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public HealthProfileHistory getHealthProfileHistory(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public HealthProfile readCurrentHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public HealthProfile readHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0);
	
	public Long createHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0, @WebParam(name = "arg1", partName = "arg1") HealthProfile arg1);
	
	public Long updateHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0, @WebParam(name = "arg1", partName = "arg1") HealthProfile arg1);
	
	public Long deleteHealthProfile(@WebParam(name = "arg0", partName = "arg0") Long arg0);

}