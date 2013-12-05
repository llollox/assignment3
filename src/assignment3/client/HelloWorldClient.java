package assignment3.client;

import assignment3.ws.HelloWorld;
import assignment3.ws.HelloWorldImplService;

public class HelloWorldClient{
    
	public static void main(String[] args) {
    	HelloWorldImplService helloService = new HelloWorldImplService();
    	HelloWorld hello = helloService.getHelloWorldImplPort();
    	System.out.println(hello.getHelloWorldAsString("Pinco"));
    }
	
}
