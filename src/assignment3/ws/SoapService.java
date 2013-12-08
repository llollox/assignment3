package assignment3.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SoapService", targetNamespace = "http://ws.assignment3/", 
wsdlLocation = "http://localhost:6900/ws/people?wsdl")

public class SoapService extends Service{

  private final static URL HELLOWORLDIMPLSERVICE_WSDL_LOCATION;
  private final static WebServiceException HELLOWORLDIMPLSERVICE_EXCEPTION;
  private final static QName HELLOWORLDIMPLSERVICE_QNAME = new QName("http://ws.assignment3/", "SoapImplService");

  static {
	 URL url = null;
	 WebServiceException e = null;
	 try {
		 url = new URL("http://localhost:6900/ws/people?wsdl");
	 } catch (MalformedURLException ex) {
		 e = new WebServiceException(ex);
	 }

	 HELLOWORLDIMPLSERVICE_WSDL_LOCATION = url;
	 HELLOWORLDIMPLSERVICE_EXCEPTION = e;
  }
 
  public SoapService() {
	 super(__getWsdlLocation(), HELLOWORLDIMPLSERVICE_QNAME);
  }

  public SoapService(WebServiceFeature... features) {
	 super(__getWsdlLocation(), HELLOWORLDIMPLSERVICE_QNAME, features);
  }

  public SoapService(URL wsdlLocation) {
	 super(wsdlLocation, HELLOWORLDIMPLSERVICE_QNAME);
  }

  public SoapService(URL wsdlLocation, WebServiceFeature... features) {
	  super(wsdlLocation, HELLOWORLDIMPLSERVICE_QNAME, features);
  }

  public SoapService(URL wsdlLocation, QName serviceName) {
	  super(wsdlLocation, serviceName);
  }
  
  private static URL __getWsdlLocation() {
	  if (HELLOWORLDIMPLSERVICE_EXCEPTION!= null) {
		  throw HELLOWORLDIMPLSERVICE_EXCEPTION;
	  }
	  return HELLOWORLDIMPLSERVICE_WSDL_LOCATION;

  }

  public SoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
	  super(wsdlLocation, serviceName, features);
  }

  @WebEndpoint(name = "SoapImplPort")
  public Soap getSoapImplPort() {
	  return super.getPort(new QName("http://ws.assignment3/", "SoapImplPort"), Soap.class);
  }

  @WebEndpoint(name = "SoapImplPort")
  public Soap getSoapImplPort(WebServiceFeature... features) {
	  return super.getPort(new QName("http://ws.assignment3/", "SoapImplPort"), Soap.class, features);
  }

 
}