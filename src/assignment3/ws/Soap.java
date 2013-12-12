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
	public Person readPerson(@WebParam(name = "personId", partName = "personId") Long personId);
	
	@WebMethod
	public People getPeople();
	
	public Long createPerson(@WebParam(name = "p", partName = "p") Person p);
	
	public Long updatePerson(@WebParam(name = "p", partName = "p") Person p);
	
	public Long deletePerson(@WebParam(name = "personId", partName = "personId") Long personId);
	
	public HealthProfileHistory getHealthProfileHistory(@WebParam(name = "personId", partName = "personId") Long personId);
	
	public HealthProfile readCurrentHealthProfile(@WebParam(name = "personId", partName = "personId") Long personId);
	
	public HealthProfile readHealthProfile(@WebParam(name = "hpId", partName = "hpId") Long hpId);
	
	public Long createHealthProfile(@WebParam(name = "personId", partName = "personId") Long personId, @WebParam(name = "hp", partName = "hp") HealthProfile hp);
	
	public Long updateHealthProfile(@WebParam(name = "personId", partName = "personId") Long personId, @WebParam(name = "hp", partName = "hp") HealthProfile hp);
	
	public Long deleteHealthProfile(@WebParam(name = "hpId", partName = "hpId") Long hpId);

}