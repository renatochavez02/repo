
public class Property {
	//declare the instance fields that will be used throughout the class
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;
	
	// Create a no-arg constructor that will create a new object with empty strings as values and 0 as value of rent amount
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	
	// Create a copy constructor that will create a new object using the information of the object passed to it
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	// Create a parameterized constructor with no information provided for plot 
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	// Create a parameterized constructor with the name of p
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.rentAmount = p.rentAmount;
		this.propertyName = p.propertyName;
		this.plot = new Plot(p.plot);
	}
	
	// Getter method for city
	public String getCity() {
		return city;
	}
	
	// Getter method for owner
	public String getOwner() {
		return owner;
	}
	
	// getter method of the name of property
	public String getPropertyName() {
		return propertyName;
	}
	
	// getter method of the rent amount 
	public double getRentAmount() {
		return rentAmount;
	}
	
	// getter method for the plot 
	public Plot getPlot() {
		return plot;
	}
	
	// setter method for plot 
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}
	
	// setter method for city
	public void setCity(String city) {
		this.city = city;
	}
	
	// setter method for owner 
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	// setter method for the name of property
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	// setter method of the rent amount
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	// toString method with the information that will be displayed  
	public String toString() {
		String toReturn = "Property Name: " + propertyName + "\nLocation: " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount;
		return toReturn;
	}
}
