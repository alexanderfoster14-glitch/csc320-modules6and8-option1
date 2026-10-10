
public class Automobile {
	private String make;
	private String model;
	private int year;
	private int mileage;
	private String color;
	private String vin;
	
	public Automobile () { //default constructor
		make = "Unknown";
		model = "Unknown";
		year = -1;
		mileage = -1;
		color = "Unknown";
		vin = "Unknown";
	}
	
	public Automobile (String make, String model, int year, int mileage, String color, String vin) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.color = color;
		this.vin = vin;
	}
	
}