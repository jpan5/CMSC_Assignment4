/*
 * Class: CMSC203 
 * Instructor: Alexander Robert
 * Description: This java file contains instance variables of name, tax ID, management fee, MAX_PROPERTY, an array named
 * properties and two constants MGMT_WIDTH and MGMT_DEPTH. The addProperty method returns -1 if the array is full, -2 if 
 * the property is null, -3 if the plot for the property is not encompassed by the management plot, or -4 if the plot for 
 * the property overlaps any other property. The totalRent method is for returning the total rent of the property. The 
 * maxRentPropertyIndex method is for returning the index of the property within properties array that has the highest
 * rent amount. The maxRentProp method is for returning the highest rent amount.
 * Due: 10/29/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: ____Jie Pan______
*/
public class ManagementCompany {

	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private Plot plot;
	
	//Create a constructor that passes default values
	public ManagementCompany() {
		this.properties = new Property[MAX_PROPERTY];
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, 10, 10);
	}

	//Constructor that passes parameter values
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//Constructor that passes parameter values
	public ManagementCompany(String name, String taxID, double mgmFee, 
			int x, int y, int width, int depth) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}
	
	//Copy constructor that creates new object with passed object values
	public ManagementCompany(ManagementCompany otherCompany){
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
	}
	
	//Adds property to properties array 
	public int addProperty(Property property) {
		if(property == null) {
			return -2;
		}
		if(! plot.encompasses(property.getPlot())) {
			return -3;
		}
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				if(properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
		
		else {
			properties[i] = property;
			return i;
		    }
	    }
		return -1;
	}
	
	//Creates new object with default plot and adds to properties array
	public int addProperty(String name, String city, double rent, String owner) {
	    return addProperty(new Property(name, city, rent, owner));
	}
	
	//Creates object and adds it to properties array
	public int addProperty(String name, String city, double rent, String owner, 
			int x, int y, int width, int depth){
	    return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String displayPropertyAtIndex(int i) {
		String string = properties[i].toString();
		return string;
	}
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}
	
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	//Finds the maximum rent amount
	public double maxRentProp() {
		double rentAmount = 0;
		for(Property property: properties) {
			if(property == null) {
				break;
			}
			if(rentAmount < property.getRentAmount()) {
				rentAmount = property.getRentAmount();
			}
		}
		return rentAmount;
	}
	
	//Find the index of max rent amount
	public int maxRentPropertyIndex() {
		int index = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				break;
			}
			if(properties[i].getRentAmount() >= properties[index].getRentAmount()) {
				index = i;
			}
		}
		return index;
	}
	
	//List the information of a property
	public String toString() {
		String s = "";
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				break;
			}
			s += properties[i].toString() + "\n";
		}
		return "List of the properties for " + name + ", taxID: " + taxID + "\n___________"
				+ "___________________________\n" + s + "\n_______________________________"
						+ "_______\nTotal Management Fee: " + (totalRent() * mgmFeePer / 100); 
	}
	
	//Find the total amount of the rent
	public double totalRent() {
		double total = 0.0;
		for(Property property: properties) {
			if(property == null) {
				break;
			}
			total += property.getRentAmount();
		}
		return total;
	}
}
