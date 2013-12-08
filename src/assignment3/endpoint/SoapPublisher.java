package assignment3.endpoint;
import javax.xml.ws.Endpoint;

import assignment3.ws.SoapImpl;

//Endpoint publisher

public class SoapPublisher{
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:6900/ws/people", new SoapImpl());
	}
}
