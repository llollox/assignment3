package assignment3.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
	public static int getMenuSelection() throws IOException{
		System.out.println("\nWhat do you want to do?");
		System.out.println("1 - Print all health profiles");
		System.out.println("2 - Print the health profile of a person");
		System.out.println("3 - Print the weight of a person");
		System.out.println("4 - Print the height of a person");
		System.out.println("5 - Print the BMI of a person");
		System.out.println("6 - Print persons specifying a condition");
		System.out.println("0 - Quit the program");
		
		BufferedReader option = new BufferedReader(new InputStreamReader(System.in)); 
		
		int varlue = 0;
		try {
			varlue = Integer.parseInt(option.readLine()); 
		} catch (NumberFormatException e) {
			varlue = 99; //command not found!
		}
		
		return varlue;
	}
	
	public static String inputString(String string) throws IOException{
		System.out.println("Please write the "+ string);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
