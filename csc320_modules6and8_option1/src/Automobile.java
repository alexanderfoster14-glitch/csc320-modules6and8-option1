public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	private String vin;
	
	public Automobile () { //default constructor
		make = "Unknown";
		model = "Unknown";
		color = "Unknown";		
		year = -1;
		mileage = -1;
		vin = "Unknown";
	}
	
	public Automobile (String make, String model, String color, int year, int mileage, String vin) {
		this.make = make;
		this.model = model;
		this.color = color;		
		this.year = year;
		this.mileage = mileage;
		this.vin = vin;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public String getVIN() {
		return vin;
	}
	
}