/*
 * Class: CMSC203 
 * Instructor: Alexander Robert
 * Description: This java file contains instance variables for property name,
 * city, rental amount, owner, and plot. A toString method to represent a Property
 * object, and constructors and getter and setter methods that for passing 
 * the values.
 * Due: 10/29/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: ____Jie Pan______
*/
public class Plot {

	private int x, y, width, depth;
	
	//Create a constructor that passes default values
	Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	//Copy Constructor
	Plot(Plot p){
		this.x = p.x; 
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	//Parameterized Constructor
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Determines if this plot overlaps
	public boolean overlaps(Plot plot) {
	    return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth
	    		   && y + depth > plot.y;
	}
	
	//Determine if this plot encompasses
	public boolean encompasses(Plot plot) {
	    boolean encompass = false;
	    double rightX = x + width;
	    double bottomY = y + depth;
	    double newRightX = plot.getX() + plot.getWidth();
	    double newBottomY = plot.getY() + plot.getDepth();
	    if (this.x <= plot.getX() && plot.getX() <= rightX && this.y <= plot.getY() && 
	    plot.getY() <= bottomY && this.x <= rightX && newRightX <= rightX && 
	        this.y <= newBottomY && newBottomY <= bottomY) {
	        encompass = true;
	    }
	    return encompass;
	}
	
	//Set value to x
	public void setX(int x) {
		this.x = x;
	}
	
	//Get value of x
	public int getX() {
		return x;
	}
	
	//Set value to y
	public void setY(int y) {
		this.y = y;
	}
	
	//Get value of y
	public int getY() {
		return y;
	}
	
	//Set value to width
	public void setWidth(int width) {
		this.width = width;
	}
	
	//Get value of width
	public int getWidth() {
		return width;
	}
	
	//Set value to depth
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//Get value of depth
	public int getDepth() {
		return depth;
	}
	
	//Print out the name, city, owner and rent amount for property
	public String toString() { 
		return "Upper left: (" + x + ", " + y + "); Width: " + width + " Depth: " + depth;  
	}
}
