package assignment3.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Utils {
	
	private static Random random = new Random();
	
	public static int getMenuSelection() throws IOException{
		System.out.println("\nWhat do you want to do?");
		System.out.println("1 - Print all people");
		System.out.println("2 - Print all people by a condition");
		System.out.println("3 - Select a person by Id");
		System.out.println("4 - Select a person by Firstname and Lastname");
		System.out.println("5 - Create a new Person");
		System.out.println("0 - Quit the program");
		
		BufferedReader option = new BufferedReader(new InputStreamReader(System.in)); 
		
		int value = 0;
		try {
			value = Integer.parseInt(option.readLine()); 
		} catch (NumberFormatException e) {
			value = 99; //command not found!
		}
		
		return value;
	}
	
	public static int getPersonalMenuSelection() throws IOException{
		System.out.println("\nWhat do you want to do?");
		System.out.println("1 - Read Personal Info"); //personal info (maybe with current weight and height)
		System.out.println("2 - Read Health Profile History"); 
		System.out.println("3 - Update Person");
		System.out.println("4 - Delete Person");
		System.out.println("5 - Create a new HealthProfile");
		System.out.println("6 - Update Health Profile");
		System.out.println("7 - Delete HealthProfile");
		System.out.println("0 - Back the main Menu");
		
		BufferedReader option = new BufferedReader(new InputStreamReader(System.in)); 
		
		int value = 0;
		try {
			value = Integer.parseInt(option.readLine()); 
		} catch (NumberFormatException e) {
			value = 99; //command not found!
		}
		
		return value;
	}
	
	public static String inputString(String string) throws IOException{
		System.out.println("Please write the "+ string);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
    public static Double randBetween(Double start, Double end) {
    	return start + (end - start) * random.nextDouble();
    }
    
    public static String checkCondition(String condition){
		if(Arrays.asList("WEIGHT", "weight", "Weight").contains(condition))
			return "weight";
		else if (Arrays.asList("HEIGHT", "height", "Height").contains(condition))
			return "height";
		else if (Arrays.asList("BMI", "bmi", "Bmi").contains(condition))
			return "bmi";
		
		System.out.println("Sorry! Condition not recognized!");	
		return null;
	}
	
	public static String checkOperator(String operator){
		if((Arrays.asList(">", ">=", "<", "<=", "!=", "<>", "=", "==").contains(operator))){
			if(operator.equals("="))
				return "==";  //convert assignment operator into equivalence operator!
			else if (operator.equals("<>")) //convert different operator!
				return "!=";
			else
				return operator;
		}
		System.out.println("Sorry! Operator not recognized!");	
		return null;
	}
	
	public static String checkValue(String value){
		String parsedValue = null;
		try {
			parsedValue = ""+Double.parseDouble(value);
		} catch (NumberFormatException e) {
			System.out.println("Sorry! Value not recognized!");
			return null;
		}
		return parsedValue;
	}
	
	public static Boolean eval(double personAttribute, String operator, double value){
		if(operator.equals(">"))
			return personAttribute > value;
		else if (operator.equals(">="))
			return personAttribute >= value;
		else if (operator.equals("<"))
			return personAttribute < value;
		else if (operator.equals("<="))
			return personAttribute <= value;
		else if (operator.equals("!="))
			return personAttribute != value;
		else if (operator.equals("=="))
			return personAttribute == value;
		return null;
	}
}
