package assignment3.endpoint;

import javax.xml.ws.Endpoint;

import assignment3.ws.SoapImpl;

//Endpoint publisher

public class SoapPublisher {
	public static void main(String[] args) {

		String URL = "http://localhost:6900/ws/people";

		Endpoint.publish(URL, new SoapImpl());

		System.out.println("Service is running on: " + URL);
	}
}
