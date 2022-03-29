/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: This program lets the user create a management company and add properties managed to its list with a maximum of five. 
 * It lets you input the name of the owner, city, amount for the rent, and percentage charged for management.
 * There are a few guidelines in order to do this, for example, the houses cannot overlap each other.
 * Due: 03/28/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Renato Chavez
*/
import java.util.Arrays;
public class ManagementCompany {
	// Declare the instance fields used throughout this class
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MAX_WIDTH = 10, count = 0;
	private int MAX_DEPTH = 10;
	private Plot plot;
	
	// create a no-arg constructor that will create an object for management company
	public ManagementCompany() {
		properties = new Property[MAX_PROPERTY];
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0 , MAX_WIDTH, MAX_DEPTH);
	}
	
	//A management company parameterized constructor together with a default company plot
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
	}
	
	// This constructor creates a management company object using another management company object
	public ManagementCompany(ManagementCompany otherCompany) {
		properties = new Property[MAX_PROPERTY];
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
	}
	
	// A management company parameterized constructor that will set the plot for the company 
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
	}
	
	// A get method which returns the size of property array
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	// Adds an already created property to the array
	public int addProperty(Property property) {
		int i;
		for(i = 0; i < count; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if(count == MAX_PROPERTY) {
			return -1;
		}
		if(property == null) {
			return -2;
		}
		if(this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		else {
			properties[count] = property;
			count++;
			return count;
		}
	}
	
	// This method adds the property with four arguments and a plot by default to the array
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
		properties[count] = property;
		count++;
		int i;
		for(i = 0; i < count ; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if(count == MAX_PROPERTY)
			return -1;
		if(this.plot.encompasses(property.getPlot()))
			return -3;
		else {
			properties[count] = property;
			count++;
			return count;
		}
	}
	
	// An add property that will have all parameters for the property and the plot 
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		properties[count] = property;
		for(int i = 0; i < count; i++) {
			if(properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}
		if(count == MAX_PROPERTY) {
			return -1;
		}
		else if(this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		else {
			properties[count] = property;
			count++;
			return count;
		}
	}
	
	// This method adds up all the amounts of the rent
	public double totalRent() {
		double totalRent = 0.0;
		for(int i = 0; i < count; i++) {
			if(properties[i] != null) {
				totalRent += properties[i].getRentAmount();
			}
		}
		return totalRent;
	}
	
	// This method sets the max rent amount to zero and returns the value
	public double maxPropertyRent() {
		double 	maxRentAmount = 0.0;
		maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();
		return maxRentAmount;
	}
	
	//This method returns the index of the maximum value of rent after setting it to 0
	public int maxPropertyRentIndex() {
		int indexOFMaxRent = 0;
		for(int i = 0; i < count; i++) {
			if(properties[i] != null) {
				if(properties[indexOFMaxRent].getRentAmount() < properties[i].getRentAmount()) {
					indexOFMaxRent = i;
				}
			}
		}
		return indexOFMaxRent;
	}
	
	// This method serves to displays and returns the owner, city, property name, and plot as a string with the respective results
	public String displayPropertyAtIndex(int i) {
		String str = "";
		if(properties[i] != null) {
			str = ("Owner: " + properties[i].getOwner() + " City: " + properties[i].getCity() + " Property Name: " + properties[i].getPropertyName()
					+ " Rent Amount: " + properties[i].getRentAmount() + " Plot: " + properties[i].getPlot());
		}
		return str;
	}
	
	// Finally, this method serves to display the last part of the program including the tax ID, property name, rent amount, who does it belong to
	// and the total management fee, it returns the whole final string 
	public String toString() {
		String printContent = "";
		System.out.println("List of the properties for Alliance, taxID: " + taxID);
		System.out.println("__________________");
		for(int i = 0; i < count; i++) {
			if(properties[i] != null)
				printContent = ("Property Name: " + properties[i].getPropertyName() + "\n" + "Located in: " + properties[i].getCity() + "\n" +
			 "Belonging to: " + properties[i].getOwner() + "\n" + "Rent Amount: " + properties[i].getRentAmount());
		}
		System.out.println("__________________");
		System.out.println("Total management Fee: " + mgmFeePer);
		return printContent;
	}
}
