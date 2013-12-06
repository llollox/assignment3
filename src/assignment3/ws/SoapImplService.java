package assignment3.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "HelloWorldImplService", targetNamespace = "http://ws.introsde/", 
wsdlLocation = "http://localhost:6900/ws/hello?wsdl")

public class SoapImplService extends Service{

  private final static URL HELLOWORLDIMPLSERVICE_WSDL_LOCATION;
  private final static WebServiceException HELLOWORLDIMPLSERVICE_EXCEPTION;
  private final static QName HELLOWORLDIMPLSERVICE_QNAME = new QName("http://ws.introsde/", "HelloWorldImplService");

  static {
	 URL url = null;
	 WebServiceException e = null;
	 try {
		 url = new URL("http://localhost:6900/ws/hello?wsdl");
	 } catch (MalformedURLException ex) {
		 e = new WebServiceException(ex);
	 }

	 HELLOWORLDIMPLSERVICE_WSDL_LOCATION = url;
	 HELLOWORLDIMPLSERVICE_EXCEPTION = e;
  }
 
  public SoapImplService() {
	 super(__getWsdlLocation(), HELLOWORLDIMPLSERVICE_QNAME);
  }

  public SoapImplService(WebServiceFeature... features) {
	 super(__getWsdlLocation(), HELLOWORLDIMPLSERVICE_QNAME, features);
  }

  public SoapImplService(URL wsdlLocation) {
	 super(wsdlLocation, HELLOWORLDIMPLSERVICE_QNAME);
  }

  public SoapImplService(URL wsdlLocation, WebServiceFeature... features) {
	  super(wsdlLocation, HELLOWORLDIMPLSERVICE_QNAME, features);
  }

  public SoapImplService(URL wsdlLocation, QName serviceName) {
	  super(wsdlLocation, serviceName);
  }

  public SoapImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
	  super(wsdlLocation, serviceName, features);
  }

  @WebEndpoint(name = "HelloWorldImplPort")
  public SoapInterface getHelloWorldImplPort() {
	  return super.getPort(new QName("http://ws.introsde/", "HelloWorldImplPort"), SoapInterface.class);
  }

  @WebEndpoint(name = "HelloWorldImplPort")
  public SoapInterface getHelloWorldImplPort(WebServiceFeature... features) {
	  return super.getPort(new QName("http://ws.introsde/", "HelloWorldImplPort"), SoapInterface.class, features);
  }

  private static URL __getWsdlLocation() {
	  if (HELLOWORLDIMPLSERVICE_EXCEPTION!= null) {
		  throw HELLOWORLDIMPLSERVICE_EXCEPTION;
	  }
	  return HELLOWORLDIMPLSERVICE_WSDL_LOCATION;

  }
}