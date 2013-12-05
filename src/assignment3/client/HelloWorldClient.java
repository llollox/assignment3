package assignment3.client;

import java.io.IOException;

import assignment3.utils.Utils;
import assignment3.ws.HelloWorld;
import assignment3.ws.HelloWorldImplService;

public class HelloWorldClient{
    
	public static void main(String[] args) throws IOException {
    	HelloWorldImplService helloService = new HelloWorldImplService();
    	HelloWorld hello = helloService.getHelloWorldImplPort();
    	System.out.println(hello.getHelloWorldAsString("Pinco"));
    	
    	int option_selected = 0;
		do {
			option_selected = Utils.getMenuSelection();
			
			switch (option_selected) {
			case 0:// exit
				System.out.println("\nGoodbye!");
				break;
				
			case 1:// get all people
				System.out.println("Selected option 1 - Get all people!");
				break;
			
			case 2:// readPerson(int id)
				int personId = Integer.parseInt(Utils.inputString("Person Id"));
				System.out.println("Selected option 2 - Read the person with id: "+ personId);
				break;
			
			case 3:// get Weight
				
				break;
				
			case 4:// get Height
			
				break;
			
			case 5:// get BMI
				
				break;
			
			case 6:// get people by condition
				
				break;
				
			default:
				System.out.println("Sorry! Option selected not recognized!");
				System.out.println("Try again!");
				break;
			}
			
		} while (option_selected != 0);
	}
	
}
