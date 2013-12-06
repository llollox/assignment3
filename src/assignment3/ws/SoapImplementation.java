package assignment3.ws;

import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.ws.HelloWorld")

public class SoapImplementation implements SoapInterface {

@Override

public String getHelloWorldAsString(String name) {

return "Hello World JAX-WS " + name;

}

}
