package assignment3.client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import assignment3.model.HealthProfile;
import assignment3.model.Person;
import assignment3.utils.Utils;
import assignment3.ws.Soap;
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
				
				for (Person person : soapInterface.getPeople().getPeople()) {
					System.out.println(person);
				}
				break;
			
			case 2:// Select a person by Id
				try {
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					Person p = soapInterface.readPerson(personId);
					
					SoapClient.setSelectedPerson(p);
					personalMenu();
					
				} catch (Exception e) {
					System.out.println("\nPerson not found!");
				}
				
				break;
			
			case 3:// Create a new Person
				try {
					String firstname = Utils.inputString("Firstname");
					String lastname = Utils.inputString("Lastname");
					Date birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(Utils.inputString("birthdate (dd-mm-yyyy)"));
					
					Long personId = soapInterface.createPerson(new Person(firstname, lastname, birthdate));
					
					System.out.println("\nPerson Created with Success! Id : "+personId);
				} catch (Exception e) {
					System.out.println("\nSorry! Some problems occurs during create person!");
				}
				break;

			case 4:// Update Person
				try {
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					Person person = soapInterface.readPerson(personId);
					
					String firstname = Utils.inputString("Firstname");
					String lastname = Utils.inputString("Lastname");
					Date birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(Utils.inputString("birthdate (dd-mm-yyyy)"));
					
					person.setFirstname(firstname);
					person.setLastname(lastname);
					person.setBirthdate(birthdate);
					
					System.out.println("\nPerson Modified with Success! Id : "+soapInterface.updatePerson(person));
				
				} catch (Exception e) {
					System.out.println("\nSorry! Some problems occurs during update person!");
				}
				break;
				
			case 5: //Delete Person
				try {
					Long personId = Long.parseLong(Utils.inputString("Person Id"));
					soapInterface.deletePerson(personId); // if exception occurs the catch will be executed!
					System.out.println("\nPerson Deleted with Success!");
				} catch (Exception e) {
					System.out.println("\nSorry! Some problems occurs during delete person!");
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
				
				case 0: // Back to main menu
					selectedPerson = null;
					break;	
				
				case 1: // Read CURRENT Health Profile
					try {
						HealthProfile hp = soapInterface.readCurrentHealthProfile(SoapClient.getSelectedPerson().getPerson_id());
						System.out.println(hp);
					} catch (Exception e) {
						System.out.println("\nHealthProfile not found!");
					}
					break;
				
				case 2: // Read Health Profile History
					try {
						for (HealthProfile hp : soapInterface.getHealthProfileHistory(
								SoapClient.getSelectedPerson().getPerson_id()).getHealthProfileHistory()) {
							System.out.println(hp);
						}
					} catch (Exception e) {
						System.out.println("\nSorry! Some problems occurs during get health profile history!");
					}
					break;
				
				case 3: // Create new Health Profile!
					try{
						Double weight = Double.parseDouble(Utils.inputString("Weight"));
						Double height = Double.parseDouble(Utils.inputString("Height"));
						int steps = Integer.parseInt(Utils.inputString("Steps"));
						int calories = ((Double) ((double) steps * Utils.randBetween(0.03,0.04))).intValue();
						Date date = new Date();
						
						HealthProfile hp = new HealthProfile(weight, height, date, steps, calories);
						System.out.println("\nHealthProfile Created with Success! Id : "+ 
								soapInterface.createHealthProfile(SoapClient.getSelectedPerson().getPerson_id(),hp));		
						
					} catch (Exception e) {
						System.out.println("\nSorry! Some problems occurs during create new health profile!");
					}
					break;
				
				case 4: // Update Health Profile
				
					try {
						Long healthProfileId = Long.parseLong(Utils.inputString("Health Profile Id"));
						HealthProfile hp = soapInterface.readHealthProfile(healthProfileId);
						
						Double weight = Double.parseDouble(Utils.inputString("Weight"));
						Double height = Double.parseDouble(Utils.inputString("Height"));
						Date date = new SimpleDateFormat("dd-MM-yyyy").parse(Utils.inputString("date (dd-mm-yyyy)"));
						int steps = Integer.parseInt(Utils.inputString("Steps"));
						int calories = ((Double) ((double) steps * Utils.randBetween(0.03,0.04))).intValue();
						
						hp.setWeight(weight);
						hp.setHeight(height);
						hp.setDate(date);
						hp.setSteps(steps);
						hp.setCalories(calories);
						
						System.out.println("\nHealthProfile Updated with Success! Id : "+
								soapInterface.updateHealthProfile(SoapClient.getSelectedPerson().getPerson_id(), hp));
					} catch (Exception e) {
						System.out.println("\nSorry! Some problems occurs during update new health profile!");
					}
							
					break;
					
				case 5:  // Delete Health Profile
					try {
						Long healthProfileId = Long.parseLong(Utils.inputString("Health Profile Id"));
						soapInterface.deleteHealthProfile(healthProfileId);
						System.out.println("\nHealthProfile Deleted with Success!");
					} catch (Exception e) {
						System.out.println("\nSorry! Some problems occurs during delete new health profile!");
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
