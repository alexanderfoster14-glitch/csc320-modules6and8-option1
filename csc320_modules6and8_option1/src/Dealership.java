//Option 1 - Automobile Class

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.StringIndexOutOfBoundsException;
import java.lang.IndexOutOfBoundsException;

public class Dealership {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInStream = null;	//File input stream
		String fileLocation;	//File location that can be passed to fileInStream and fileOutStream
		PrintWriter outFS = null;	//Output file writer
		Scanner scnr = new Scanner(System.in);	//Scanner object
		Scanner inFS = null;	//Scanner object for file stream
		String currLine;	//Temp variable used for checking the current line
		String currMake;	//Current vehicle Make
		String currModel;	//Current vehicle Model
		String currColor;	//Current vehicle Color
		int currYear;		//Current vehicle Year
		int currMileage;	//Current vehicle Mileage
		String currVIN;		//Current vehicle VIN
		ArrayList<Automobile> Automobiles = new ArrayList<>();	//ArrayList that will be used to store each automobile
		int i;	//integer for use in for loops
		String updateYesOrNo;	//Used to ask if user would like to update the file with changes made
		
		//File location on Laptop:
			//C:/Users/alexa/OneDrive/Desktop/Code/Vehicle Inventory.txt
		
		//File location on Desktop;
			//C:/Users/Alex/Desktop/Coding/csc320-modules6and8-option1/Vehicle Inventory.txt
		
		fileLocation = "C:/Users/alexa/OneDrive/Desktop/Code/Vehicle Inventory.txt";
		
		//Try to open file and create new FileInputStream
		try {
			fileInStream = new FileInputStream(fileLocation);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File could not be found. Check variable \"fileLocation\" and try again."
					+ "Program will now exit to ensure existing file formatting does not get corrupted");
			System.exit(1);
			System.out.println("This should never print");
		}
		
		//Create a new scanner that gets input from file
		inFS = new Scanner(fileInStream);
		
		//Sends console update confirming file has been found and opened
		System.out.println("Opening file location.");
		
		//Start reading from file, creating an ArrayList that can be manipulated.
		//Skip the initial file description info		
		try {
			currLine = inFS.nextLine();	//skips the first line
			while (!currLine.equals("Vehicle VIN: VIN")) {
				//System.out.println("Entering while(while) loop");	//Testing if we get to this line
				currLine = inFS.nextLine();
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("Error reading file. File contents are not formatted properly. Verify wording within file is correct default layout.\n"
					+ "Program will now exit to ensure existing file formatting does not get corrupted");
			System.exit(1);
			System.out.println("This should never print");
		}
		
		try {
			while(inFS.hasNext()) {
				currLine = inFS.nextLine();					//Skip separating blank like
				currLine = inFS.nextLine();					//Vehicle Make, full line of text
				currMake = currLine.substring(14).strip();	//Sets currMake to full string name, potentially more than 1 word in length
				currLine = inFS.nextLine();					//Vehicle Model, full line of text
				currModel = currLine.substring(15).strip();	//Sets currModel to full string name, potentially more than 1 word in length
				currLine = inFS.nextLine();					//Vehicle Color, full line of text
				currColor = currLine.substring(15).strip();	//Sets currColor to full string name, potentially more than 1 word in length
				currLine = inFS.nextLine();						//Vehicle Year, full line of text
				String currYearString = currLine.substring(14).strip();	//currYearString temporary to create an int
				currYear = Integer.parseInt(currYearString);	//Casts the <string> currYear to an int type
				currLine = inFS.nextLine();					//Vehicle Color, full line of text
				String currMileageString = currLine.substring(17).strip();	//currMileageString temporary to create an int
				currMileage = Integer.parseInt(currMileageString);	//Casts the <string> currMileage to an int type
				currLine = inFS.nextLine();					//Vehicle Color, full line of text
				currVIN = currLine.substring(13).strip();	//Sets currVin to full string name, strips beginning words and whitespace
	
				//Create a new Automobile
				Automobiles.add(new Automobile(currMake, currModel, currColor, currYear, currMileage, currVIN));	//Adds a new automobile element
			}
		}
		
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Error reading information from file. File contents are not formatted properly."
					+ " Verify wording within file is correct default layout.\n"
					+ "Program will now exit to ensure existing file formatting does not get corrupted");
			System.exit(1);
			System.out.println("This should never print");
		}
		
		//Close the file once it's been read into an ArrayList
		System.out.println("Vehicle Inventory successfully loaded into ArrayList\n");
		inFS.close();
		
		//Print directions for user
		printInstructions();
		
		//main loop for functionality
		functionLoop(Automobiles);

		//Ask if file should be updated
		System.out.println("Would you like to update the vehicle inventory file with any changes made? Enter \"Y\" or \"N\"");
		updateYesOrNo = scnr.next();
		if (updateYesOrNo.equals("Y")) {
			//fileOutStream = new FileOutputStream(fileLocation);	//Not needed
			outFS = new PrintWriter(fileLocation);
			//Writing to the file
			outFS.print("Vehicle Inventory\n"
					+ "\n"
					+ "Vehicle Make: Make\n"
					+ "Vehicle Model: Model\n"
					+ "Vehicle Color: Color\n"
					+ "Vehicle Year: Year\n"
					+ "Vehicle Mileage: Mileage\n"
					+ "Vehicle VIN: VIN\n"
					+ "\n");
			for (i = 0; i < Automobiles.size(); ++i) {
				outFS.println("Vehicle Make: " + ((Automobile) Automobiles.get(i)).getMake());
				outFS.println("Vehicle Model: " + ((Automobile) Automobiles.get(i)).getModel());
				outFS.println("Vehicle Color: " + ((Automobile) Automobiles.get(i)).getColor());
				outFS.println("Vehicle Year: " + ((Automobile) Automobiles.get(i)).getYear());
				outFS.println("Vehicle Mileage: " + ((Automobile) Automobiles.get(i)).getMileage());
				outFS.println("Vehicle VIN: " + ((Automobile) Automobiles.get(i)).getVIN());
				if (i < Automobiles.size()-1) {
					outFS.println("");
				}
			}
			outFS.close();
		} else {
			System.out.println("Program exited.");
			System.exit(1);
		}

	}

	public static void printInstructions() {
		System.out.print("Type number below to interact with inventory(1, 2, 3, 4, 5, 6):\n"
				+ "1: Add a new vehicle\n"
				+ "2: List vehicle information\n"
				+ "3: Remove a vehicle\n"
				+ "4: Update a vehicle attributes\n"
				+ "5: Display full vehicle invenotry\n"
				+ "6: End function selection\n"
				+ "Number:");
	}
	
	public static int getFunctionality() {
		int numberChoice = -1;
		Scanner scnr = new Scanner(System.in);
		try {
			numberChoice = scnr.nextInt();	//get user input on which option to select
		}
		catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException at user input for inventory interaction selection.");
		}
		return numberChoice;
		
	}
	
	public static int getVehicleNumber() {
		int numberChoice = -1;
		Scanner scnr = new Scanner(System.in);
		try {
			numberChoice = scnr.nextInt();	//get user input on which option to select
		}
		catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException at user input for vehicle selection.");
			System.out.println("Vehicle selected does not exist. Reenter vehicle selection.");
			numberChoice = getVehicleNumber();
		}
		return numberChoice;
	}
	
	public static void functionLoop(ArrayList<Automobile> Automobiles) {
		int functionSelection;	//User input on which option to select for engaging with inventory
		
		functionSelection = getFunctionality();	//get user input on which option to select
		
		while (functionSelection != 6) {
			if (functionSelection == 1) {
				functionality1 (Automobiles);
			} else if (functionSelection == 2) {
				functionality2 (Automobiles);
			} else if (functionSelection == 3) {
				functionality3 (Automobiles);
			} else if (functionSelection == 4) {
				functionality4 (Automobiles);
			} else if (functionSelection == 5) {
				functionality5 (Automobiles);
			} else if (functionSelection < 1 || functionSelection > 6) {
				System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\", or \"6\"");
			} else {
			printInstructions();
			}
			functionSelection = getFunctionality();
		}
	}
	
	public static void functionality1 (ArrayList<Automobile> Automobiles) {
		String currMake;	//Current vehicle Make
		String currModel;	//Current vehicle Model
		String currColor;	//Current vehicle Color
		int currYear;		//Current vehicle Year
		int currMileage;	//Current vehicle Mileage
		String currVIN;		//Current vehicle VIN
		Scanner scnr = new Scanner(System.in);	//Scanner object
		
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
		
		printInstructions();
	}
	
	public static void functionality2 (ArrayList<Automobile> Automobiles) {
		int vehicleNumber;	//used to get the vehicle listing number within the Automobiles ArrayList
		
		System.out.println("You entered 2");
		//List vehicle information of a selected vehicle
		System.out.print("Enter the # of the vehicle you want information about.\n"
				+ "#");
		vehicleNumber = getVehicleNumber();
		System.out.print("#" + (vehicleNumber) + ": ");
		try {
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getMake() + " ");
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getModel() + " ");
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getColor() + " ");
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getYear() + " ");
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getMileage() + " ");
			System.out.print(((Automobile) Automobiles.get(vehicleNumber-1)).getVIN() + " ");
			System.out.print("\n");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Error2: Vehicle selection does not exist in current inventory.");
		}
		
		printInstructions();
	}
	
	public static void functionality3 (ArrayList<Automobile> Automobiles) {
		int vehicleNumber;	//used to get the vehicle listing number within the Automobiles ArrayList
		String deleteYesOrNo;	//Used to ask if user would like to delete the selected vehicle
		Scanner scnr = new Scanner(System.in);	//Scanner object
		
		System.out.println("You entered 3");
		//Delete a vehicle from the ArrayList Automobiles
		System.out.println("Enter the #Number associated with the vehicle to be deleted: ");
		vehicleNumber = getVehicleNumber();
		System.out.println("Current vehicle information");
		System.out.println("Vehicle Make: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getMake() + " ");
		System.out.println("Vehicle Model: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getModel() + " ");
		System.out.println("Vehicle Color: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getColor() + " ");
		System.out.println("Vehicle Year: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getYear() + " ");
		System.out.println("Vehicle Mileage: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getMileage() + " ");
		System.out.println("Vehicle VIN: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getVIN() + " ");
		System.out.println("Confirm if you want to delete this vehicle. Enter \"Remove\" to remove vehicle from inventory.");
		deleteYesOrNo = scnr.next();
		if (deleteYesOrNo.equals("Remove")) {
			Automobiles.remove(vehicleNumber-1);
		}
		
		printInstructions();
	}
	
	public static void functionality4 (ArrayList<Automobile> Automobiles) {
		int vehicleNumber;	//used to get the vehicle listing number within the Automobiles ArrayList
		String vehicleAttribute;	//used to get the attribute to change about a specific vehicle
		String currMake;	//Current vehicle Make
		String currModel;	//Current vehicle Model
		String currColor;	//Current vehicle Color
		int currYear;		//Current vehicle Year
		int currMileage;	//Current vehicle Mileage
		String currVIN;		//Current vehicle VIN
		Scanner scnr = new Scanner(System.in);	//Scanner object
		
		System.out.println("You entered 4");
		//Update a vehicle attributes
		System.out.println("Enter the #Number associated with the vehicle to be modified: ");
		vehicleNumber = getVehicleNumber();
		System.out.println("Current vehicle information");
		System.out.println("Vehicle Make: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getMake() + " ");
		System.out.println("Vehicle Model: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getModel() + " ");
		System.out.println("Vehicle Color: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getColor() + " ");
		System.out.println("Vehicle Year: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getYear() + " ");
		System.out.println("Vehicle Mileage: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getMileage() + " ");
		System.out.println("Vehicle VIN: " + ((Automobile) Automobiles.get(vehicleNumber-1)).getVIN() + " ");
		System.out.println("Enter the attribute to change (\"Make\", \"Model\", \"Color\", \"Year\", \"Mileage\", or \"VIN\": ");
		vehicleAttribute = scnr.next();
		if (vehicleAttribute.equals("Make")) {
			System.out.print("Enter the updated vehicle Make: ");
			currMake = scnr.next();
			((Automobile) Automobiles.get(vehicleNumber-1)).setMake(currMake);
		} else if (vehicleAttribute.equals("Model")) {
			System.out.print("Enter the updated vehicle Model: ");
			currModel = scnr.next();
			((Automobile) Automobiles.get(vehicleNumber-1)).setModel(currModel);
		} else if (vehicleAttribute.equals("Color")) {
			System.out.print("Enter the updated vehicle Color: ");
			currColor = scnr.next();
			((Automobile) Automobiles.get(vehicleNumber-1)).setColor(currColor);
		} else if (vehicleAttribute.equals("Year")) {
			System.out.print("Enter the updated vehicle Year: ");
			currYear = scnr.nextInt();
			((Automobile) Automobiles.get(vehicleNumber-1)).setYear(currYear);
		} else if (vehicleAttribute.equals("Mileage")) {
			System.out.print("Enter the updated vehicle Mileage: ");
			currMileage = scnr.nextInt();
			((Automobile) Automobiles.get(vehicleNumber-1)).setMileage(currMileage);
		} else if (vehicleAttribute.equals("VIN")) {
			System.out.print("Enter the updated vehicle VIN: ");
			currVIN = scnr.next();
			((Automobile) Automobiles.get(vehicleNumber-1)).setVIN(currVIN);
		}
		
		printInstructions();
	}
	
	public static void functionality5 (ArrayList<Automobile> Automobiles) {
		int i;	//integer for use in for loops
		
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
		
		printInstructions();
	}
}