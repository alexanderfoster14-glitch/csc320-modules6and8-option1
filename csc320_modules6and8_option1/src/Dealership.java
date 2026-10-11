//Option 1 - Automobile Class

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Dealership {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInStream = null;	//File input stream
		FileOutputStream fileOutStream = null;	//File output stream
		String fileLocation;	//File location that can be passed to fileInStream and fileOutStream
		PrintWriter outFS = null;	//Output file writer
		Scanner scnr = new Scanner(System.in);	//Scanner object
		Scanner inFS = null;	//Scanner object for file stream
		String currLine;	//Temp variable used for checking the current line
		String currWord;	//Temp variable used for checking the current word
		String currMake;	//Current vehicle Make
		String currModel;	//Current vehicle Model
		String currColor;	//Current vehicle Color
		int currYear;		//Current vehicle Year
		int currMileage;	//Current vehicle Mileage
		String currVIN;		//Current vehicle VIN
		ArrayList Automobiles = new ArrayList();	//ArrayList that will be used to store each automobile
		int functionSelection;	//User input on which option to select for engaging with inventory
		int i;	//integer for use in for loops
		int vehicleNumber;	//used to get the vehicle listing number within the Automobiles ArrayList
		String vehicleAttribute;	//used to get the attribute to change about a specific vehicle
		
		//File location on Laptop:
			//C:\\Users\\alexa\\OneDrive\\Desktop\\Code\Vehicle Inventory.txt
		
		//File location on Desktop;
			//C:\\Users\\Alex\\Desktop\\Coding\\csc320-modules6and8-option1\\csc320_modules6and8_option1\\Vehicle Inventory.txt
		
		fileLocation = "C:\\Users\\alexa\\OneDrive\\Desktop\\Code\\Vehicle Inventory.txt";
		System.out.println("Opening file location."); //Sends console update
		
		//Open the file to a new input stream that reads the full file and creates an ArrayList of Automobile objects
		System.out.println("Opening the existing Vehicle Inventory file \"Vehicle Inventory.txt\"\n");
		fileInStream = new FileInputStream(fileLocation);
		inFS = new Scanner(fileInStream);
		
		//System.out.println("testing");	//Test line
		
		//Skip the initial file description info
		currLine = inFS.nextLine();	//skips the first line
		while (!currLine.equals("Vehicle VIN: VIN")) {
			//System.out.println("Entering while(while) loop");	//Testing if we get to this line
			currLine = inFS.nextLine();
		}
		
		while(inFS.hasNext()) {
			//System.out.println("Entering while loop");	//Testing
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "Make:"
			currMake = inFS.next();			//Vehicle Make
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "Model"
			currModel = inFS.next();		//Vehicle Model
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "Color"
			currColor = inFS.next();		//Vehicle Color
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "Year"
			currYear = inFS.nextInt();		//Vehicle Year
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "Mileage"
			currMileage = inFS.nextInt();	//Vehicle Mileage
			currWord = inFS.next();			//Skips the word "Vehicle"
			currWord = inFS.next();			//Skips the word "VIN"
			currVIN = inFS.next();			//Vehicle VIN
			
			//System.out.println(currMake + " " + currModel + " " + currColor + " " + currYear + " " + currMileage + " " + currVIN);	//Testing
			
			//Create a new Automobile
			Automobiles.add(new Automobile(currMake, currModel, currColor, currYear, currMileage, currVIN));	//Adds a new automobile element
			//System.out.println("End of while loop");	//Testing
		}
		
		//Close the file once it's been read into a string
		inFS.close();
		
		//Print directions for user
		System.out.println("Vehicles loaded into ArrayList successfully.\n\n"
				+ "Type number below to interact with inventory(1, 2, 3, 4):\n"
				+ "1: Add a new vehicle\n"
				+ "2: List vehicle information\n"
				+ "3: Remove a vehicle\n"
				+ "4: Update a vehicle attributes\n"
				+ "5: Display full vehicle invenotry\n"
				+ "6: End functoin selection\n"
				//Search function?
				//Exit function?
				+ "Number: ");
		
		functionSelection = scnr.nextInt();	//get user input on which option to select
		
		while (functionSelection != 6) {
			if (functionSelection == 1) {
				//Print confirmation and instructions
				System.out.println("You entered 1.\n"
						+ "Enter the items below to add a new vehicle.");
				System.out.println("Vehicle Make: ");
				currMake = scnr.next();
				System.out.println("Vehicle Model: ");
				currModel = scnr.next();
				System.out.println("Vehicle Color: ");
				currColor = scnr.next();
				System.out.println("Vehicle Year: ");
				currYear = scnr.nextInt();
				System.out.println("Vehicle Mileage: ");
				currMileage = scnr.nextInt();
				System.out.println("Vehicle VIN: ");
				currVIN = scnr.next();
				//Add a vehicle to Automobiles ArrayList
				Automobiles.add(new Automobile(currMake, currModel, currColor, currYear, currMileage, currVIN));
			} else if (functionSelection == 2) {
				System.out.println("You entered 2");
				//List vehicle information of a selected vehicle
			} else if (functionSelection == 3) {
				System.out.println("You entered 3");
				//Delete a vehicle from the ArrayList Automobiles
			} else if (functionSelection == 4) {
				System.out.println("You entered 4");
				//Update a vehicle attributes
				System.out.println("Enter the #Number associated with the vehicle to be modified: ");
				vehicleNumber = scnr.nextInt();
				System.out.println("Enter the attribute to change (\"Make\", \"Model\", \"Color\", \"Year\", \"Mileage\", or \"VIN\": ");
				vehicleAttribute = scnr.next();
				
			} else if (functionSelection == 5) {
				System.out.println("You entered 5.\n"
						+ "Full vehicle inventory listed below.\n");
				for (i = 0; i < Automobiles.size(); ++i) {
					System.out.print("#" + (i+1) + ": ");
					System.out.print(((Automobile) Automobiles.get(i)).getMake() + " ");
					System.out.print(((Automobile) Automobiles.get(i)).getModel() + " ");
					System.out.print(((Automobile) Automobiles.get(i)).getColor() + " ");
					System.out.print(((Automobile) Automobiles.get(i)).getYear() + " ");
					System.out.print(((Automobile) Automobiles.get(i)).getMileage() + " ");
					System.out.print(((Automobile) Automobiles.get(i)).getVIN() + " ");
					System.out.print("\n");
				}
			}
			functionSelection = scnr.nextInt();
		}
		
		/*
		//Writing to the file
		fileOutStream = new FileOutputStream(fileLocation, true);
			//File name already written for ease of testing
		outFS = new PrintWriter(fileOutStream);
		outFS.close();
		*/
	}
}
/*		
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