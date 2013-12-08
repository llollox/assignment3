package assignment3.client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import assignment3.hibernate.PersonHibernate;
import assignment3.model.Person;
import assignment3.utils.Utils;
import assignment3.ws.Soap;
import assignment3.ws.SoapImpl;
import assignment3.ws.SoapService;

public class SoapClient{
	
	public static Person selectedPerson = null;
	public static Soap soapInterface = new SoapService().getSoapImplPort();
    
	public static Person getSelectedPerson() {
		return selectedPerson;
	}

	public static void setSelectedPerson(Person selectedPerson) {
		SoapClient.selectedPerson = selectedPerson;
	}
	

	public static void main(String[] args) throws IOException, ParseException {
    	
    	int option_selected = 0;
		do {
			option_selected = Utils.getMenuSelection();
			
			switch (option_selected) {
			case 0:// exit
				System.out.println("\nGoodbye!");
				break;
				
			case 1:// Print all people
				ArrayList<Person> people = soapInterface.getPeople();
				for (Person person : people) {
					System.out.println(person);
				}
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
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					Person p = soapInterface.getPerson(personId);
					if (p != null){
						SoapClient.setSelectedPerson(p);
						personalMenu();
					} else {
						System.out.println("\nPerson not found!");
					}
					
				} catch (Exception e) {
					option_selected = 99; //string not recognized
				}
				
				break;
			
			case 4:// Create a new Person
				try {
					String firstname = Utils.inputString("Firstname");
					String lastname = Utils.inputString("Lastname");
					Date birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(Utils.inputString("birthdate (dd-mm-yyyy)"));
					
					Person p = soapInterface.savePerson(new Person(firstname, lastname, birthdate));
					
					System.out.println("\n"+p);
				} catch (Exception e) {
					option_selected = 99; //string not recognized
				}
				break;

			case 5:// Update Person
				try {
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					Person updatedPerson = soapInterface.getPerson(personId);
					
					String updatedFirstname = Utils.inputString("Firstname");
					String updatedLastname = Utils.inputString("Lastname");
					Date updatedBirthdate = new SimpleDateFormat("dd-MM-yyyy").parse(Utils.inputString("birthdate (dd-mm-yyyy)"));
					
					updatedPerson.setFirstname(updatedFirstname);
					updatedPerson.setLastname(updatedLastname);
					updatedPerson.setBirthdate(updatedBirthdate);
					
					System.out.println("\nPerson Modified: "+soapInterface.updatePerson(updatedPerson));
				
				} catch (Exception e) {
					option_selected = 99; //string not recognized
				}
				break;
				
			case 6: //Delete Person
				try {
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					System.out.println("\nPerson Deleted: "+soapInterface.deletePerson(personId));
				} catch (Exception e) {
					//option_selected = 99; //string not recognized
				}
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
				
				case 0:
					selectedPerson = null;
					break;	
				
				case 1:
					System.out.println("Selected option 1 - Read Current Health Profile!");
					break;
				
				case 2:
					System.out.println("Selected option 2 - Read Health Profile History!");
					System.out.println(soapInterface.getPersonHealthProfileHistory(
							SoapClient.getSelectedPerson().getPerson_id()));
					break;
				
				case 3:
					System.out.println("Selected option 3 - Create new HealthProfile!");
					break;
				
				case 4:
				
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
					
				case 5:
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
					
				case 6:
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
