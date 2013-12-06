package assignment3.ws;

import javax.jws.WebMethod;

import javax.jws.WebParam;

import javax.jws.WebResult;

import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.xml.ws.Action;

@WebService(name = "HelloWorld", targetNamespace = "http://ws.introsde/")

@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface SoapInterface {

 @WebMethod

 @WebResult(partName = "return")

 @Action(input = "http://ws.introsde/HelloWorld/getHelloWorldAsStringRequest", 

 output = "http://ws.introsde/HelloWorld/getHelloWorldAsStringResponse")

 public String getHelloWorldAsString(@WebParam(name = "arg0", partName = "arg0") String arg0);

}