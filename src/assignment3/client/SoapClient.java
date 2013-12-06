package assignment3.client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import assignment3.utils.Utils;
import assignment3.ws.SoapInterface;
import assignment3.ws.SoapImplService;

public class SoapClient{
    
	public static void main(String[] args) throws IOException, ParseException {
    	SoapImplService helloService = new SoapImplService();
    	SoapInterface hello = helloService.getHelloWorldImplPort();
    	System.out.println(hello.getHelloWorldAsString("Pinco"));
    	
    	int option_selected = 0;
		do {
			option_selected = Utils.getMenuSelection();
			
			switch (option_selected) {
			case 0:// exit
				System.out.println("\nGoodbye!");
				break;
				
			case 1:// Print all people
				System.out.println("Selected option 1 - Print all people!");
				break;
			
			case 2:// Print all people by a condition
				String condition = Utils.checkCondition(Utils.inputString("Condition (weight / height / bmi)"));
				String operator = Utils.checkOperator(Utils.inputString("Operator ( > / >= / < / ...)"));
				String value = Utils.checkValue(Utils.inputString("Value"));
				
				if((condition != null) && (operator != null)  && (value != null)){
					
					//SEARCH PEOPLE BY CONDITIONS
					
					System.out.println("Selected option 2 - Print all people where " + condition + " " + operator + " " + value);
				}
				else{
					option_selected = 99; //some strings not recognized
				}
				
				
				break;
			
			case 3:// Select a person by Id
				try {
					int personId = Integer.parseInt(Utils.inputString("Person Id"));
					System.out.println("Selected option 3 - Select Person ("+ personId +")");
					
					//SET SELECTED PERSON
					
					personalMenu();
				} catch (Exception e) {
					option_selected = 99; //string not recognized
				}
				
				break;
				
			case 4:// Select a person by Firstname and Lastname
				String selectFirstname = Utils.inputString("Firstname");
				String selectLastname = Utils.inputString("Lastname");
				System.out.println("Selected option 4 - Select Person ("+ selectFirstname + ", " + selectLastname +")");
				
				//SET SELECTED PERSON
				
				personalMenu();
				break;
			
			case 5:// Create a new Person
				String firstname = Utils.inputString("Firstname");
				String lastname = Utils.inputString("Lastname");
				String birthdate = Utils.inputString("birthdate (dd-mm-YYYY)");
				System.out.println("Selected option 3 - Create Person: "+ firstname + " " + lastname + " - " + birthdate);
				break;
				
			default:
				System.out.println("Sorry! Option selected not recognized!");
				System.out.println("Try again!");
				break;
			}
			
		} while (option_selected != 0);
	}
	
	public static void personalMenu() throws IOException, ParseException{
		int option_selected = 0;
		do {
			option_selected = Utils.getPersonalMenuSelection();
			switch (option_selected) {
			
				case 1:
					System.out.println("Selected option 1 - Read Personal Info!");
					break;
				
				case 2:
					System.out.println("Selected option 2 - Read Health Profile History!");
					break;
				
				case 3:
					String firstname = Utils.inputString("Firstname");
					String lastname = Utils.inputString("Lastname");
					String birthdate = Utils.inputString("birthdate (dd-mm-YYYY)");
					System.out.println("Selected option 3 - Update Person with new values:" + firstname + " " + lastname + ": " + birthdate);
					break;
					
				case 4:
					System.out.println("Selected option 4 - Delete Person");
					option_selected = 0; //back to main menu
					break;
				
				case 5:
				
					try {
						Double weight = Double.parseDouble(Utils.inputString("Weight"));
						Double height = Double.parseDouble(Utils.inputString("Height"));
						int steps = Integer.parseInt(Utils.inputString("Steps"));
						int calories = ((Double) ((double) steps * Utils.randBetween(0.03,0.04))).intValue();
						Date date = new Date();
						System.out.println("Selected option 5 - Create a new HealthProfile ("+weight +" " + height + " " + date.getTime() + " - " + steps + " -> " + calories + ")");
					} catch (Exception e) {
						option_selected = 99; //string not recognized
					}
							
					break;
					
				case 6:
					try {
						Double updatedWeight = Double.parseDouble(Utils.inputString("Weight"));
						Double updatedHeight = Double.parseDouble(Utils.inputString("Height"));
						Date updatedDate = new SimpleDateFormat("dd-mm-YYYY").parse(Utils.inputString("Date (dd-mm-YYYY)"));
						int updatedSteps = Integer.parseInt(Utils.inputString("Steps"));
		                int updatedCalories = ((Double) ((double) updatedSteps * Utils.randBetween(0.03,0.04))).intValue();
						
						System.out.println("Selected option 5 - Create a new HealthProfile ("+updatedWeight +" " + 
								updatedHeight + " " + updatedDate.getTime() + " - " + updatedSteps + " -> " + updatedCalories);
					} catch (Exception e) {
						option_selected = 99; //string not recognized
					}
					break;
					
				case 7:
					try {
						int healthProfileId = Integer.parseInt(Utils.inputString("Health Profile Id"));
						System.out.println("Selected option 7 - Delete Health Profile (" + healthProfileId + ")");
						option_selected = 0; //back to main menu
					} catch (Exception e) {
						option_selected = 99; //string not recognized
					}
					break;
				
				default:
					System.out.println("Sorry! Option selected not recognized!");
					System.out.println("Try again!");
				break;
			}
		} while(option_selected != 0);
	}
	
}
