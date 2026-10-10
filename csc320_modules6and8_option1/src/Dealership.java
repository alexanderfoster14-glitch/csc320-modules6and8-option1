//Option 1 - Automobile Class

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Dealership {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInStream = null; //File input stream
		FileOutputStream fileOutStream = null; //File output stream
		PrintWriter outFS = null; //Output file writer
		Scanner scnr; //Scanner object for getting user inputs
		Scanner inFS = null; //Scanner object for file stream
		
		System.out.println("Type full file location."
				+ "\n Example: C:/Temp Files/Vehicle Inventory.txt"); //directions for user
		
		//For ease of testing
		fileOutStream = new FileOutputStream("C:/Temp Files/Vehicle Inventory.txt", true);
			//File name already written for ease of testing
		outFS = new PrintWriter(fileOutStream);
		
		//outFS.println("Testing writing to a file"); //Test to confirm lines are written and added to the text file
		
		//Open the file to a new input stream that reads the full file and creates an ArrayList of Automobile objects
		System.out.println("Opening the existing Vehicle Inventory file \"Vehicle Inventory.txt\"");
		fileInStream = new FileInputStream("C:/Temp Files/Vehicle Inventory.txt");
		inFS = new Scanner(fileInStream);
		
		while(inFS.hasNext()) {
			
			
		}
		
		fileInStream.close();
		outFS.close();
		
	}
}
/*		
		//required attributes
		private String make;
		private String model;
		private String color;
		private int year;
		private int mileage;
		

		//use Try...Catch constructs for all methods
		//unless noted, methods should return a Success or Failure message
			//Failure message defined in "catch"
		
		//Methods below
		//1: Create an additional class to call your automobile class
			//(e.g., Main or AutomobileInventory). Include a try..catch
			//construct and print it to the console.
		lesson on creating a class - Module 8
		
		//2: Call automobile class with parameterized constructor
			//(e.g., "make, model, color, year, mileage").
			//Then call the method to list the values.
			//Loop through the array and print to the screen.
		call class? - Module 8
		
		//3: Call the remove vehicle method to clear the variables.
			//Print the return value.
		public String RemoveVehicle(String make, String model,
				String color, int year) {
			if (values match a current vehicle) {
				remove vehicle info (by setting each value to 0);
			}
			else {
				return message indicating mismatch (vehicle info not in system);
			}
		}
		
		//4: Add a new vehicle.
			//Print the return value.
			//Call the list method and print the new vehicle information to the screen.
		public String AddVehicle(String make, String model,
				String color, int year) {
			get user input for each value {
				input for make
					print request for make;
					scanner for input;
				input for model
					print request for model;
					scanner for input;
				input for color
					print request for color;
					scanner for input;
				input for year
					print request for year;
					scanner for input;
				input for milage
					print request for mileage;
					scanner for input;
				return all elements in one array? return each item as separate method?
			}
			print new vehicle info to screen {
				print make;
				print model;
				print color;
				print year;
				print mileage;
			}
		}
		
		//5: Update the vehicle.
			//Print the return value.
			//Call the listing method and print the information to the screen.
		public String VehicleListing (String make, String model,
				String color, int year) {
			get currently listed vehicle info from user {
				input for make
					print request for make;
					scanner for input;
				input for model
					print request for model;
					scanner for input;
				input for color
					print request for color;
					scanner for input;
				input for year
					print request for year;
					scanner for input;
				input for milage
					print request for mileage;
					scanner for input;
				}
				
			get user input on which value to update {
				output request for which 
				if input == element name ("make", "model", "color", "year", "mileage") {
					update element {
						get input on updated value;
						return updated array?						
					}
				}
				return updated element(s) or array?
			}
		}
		
		//6: Display a message asking if the user wants to print the information to a
			//file (Y or N).
			//Use a scanner to capture the response. If "Y", print the file to a
			//predefined location (e.g., C:\Temp\Autos.txt).
			//Note: you may want to create a method to print the information in the
			//main class.
			//If "N", indicate that a file will not be printed.
		public <file type?> updateFileInfo (String <aary?> vehicle info) {
			request from use "Do you want to print the information to a file?"
			scanner for user input as "Y" or "N"
			if "Y" {
				update a file; code to update a file?
			}
			if "N" {
				break; end this request
			}
			return; return file? return void?
		}
		
		//expected methods:
		public <return type?> getVehicleInfo {
			get currently listed vehicle info from user for each element {
				input for make
					print request for make;
					scanner for input;
				input for model
					print request for model;
					scanner for input;
				input for color
					print request for color;
					scanner for input;
				input for year
					print request for year;
					scanner for input;
				input for milage
					print request for mileage;
					scanner for input;
			}
			
		}
		
	}
}

/*
Expected vehicle info formatting:

Vehicle #: as element # in an ArrayList
Vehicle Make as a String
Vehicle Model as a String
Vehicle Color as String
Vehicle Year as XXXX
Vehicle Mileage as XXX,XXX

*/