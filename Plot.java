
public class Plot {
	// Create the instance field for this class 
	private int x, y, width, depth;
	
	// Create a no-arg constructor that creates a default plot with args 0 and 1
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	// Create a copy constructor that creates a new object using the information of the object passed to it 
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	// Create a parameterized constructor with the name of p
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	// Create a overlaps method that will return a boolean, and it will determine if the plot overlaps the parameter
	public boolean overlaps(Plot p) {
		boolean oneOverlapsXYone, oneOverlapsXYtwo, twoOverlapsXYone, twoOverlapsXYtwo, threeOverlapsXYone, threeOverlapsXYtwo, fourOverlapsXYone,
		fourOverlapsXYtwo;
		
		oneOverlapsXYone = (p.x >= x && p.x < (x + width)) && (p.y >= y && p.y < (y + depth));
		oneOverlapsXYtwo = (x >= p.x && x < (p.x + width)) && (y >= p.y && y < (p.depth + p.y));
		
		twoOverlapsXYone = (p.x + p.width) > x && (p.x + p.width) < (x + width) && p.y >= y && p.y <= (y + depth);
		twoOverlapsXYtwo = (x + width) > p.x && (x + width) < (p.x + p.width) && y >= p.y && y <= (p.y + p.depth);
		
		threeOverlapsXYone = p.x >= x && p.x < (x + width) && (p.y + p.depth) > y && (p.y + p.depth) <= (y + depth);
		threeOverlapsXYtwo = x >= p.x && x < (p.x + p.width) && (y + depth) > p.y && (y + depth) <= (p.y + p.depth);
		
		fourOverlapsXYone = (p.x + p.width) > x && (p.x + p.width) <= (x + width) && (p.y + p.depth) > y && (p.y + p.depth) <= (y + depth);
		fourOverlapsXYtwo = (x + width) > p.x && (x + width) <= (p.x + p.width) && (y + depth) > p.y &&  (y + depth) <= (p.y + p.depth);
		
		return oneOverlapsXYone || oneOverlapsXYtwo || twoOverlapsXYone || twoOverlapsXYtwo || threeOverlapsXYone || threeOverlapsXYtwo ||
				fourOverlapsXYone || fourOverlapsXYtwo;
	}
	
	// Create a method that will determine if this plot encompasses the parameter
	public boolean encompasses(Plot p) {
		boolean inX, inY, inWidth, inDepth;
		inX = p.x >= x;
		inY = p.y >= y;
		inWidth = (p.x + p.width) <= (x + width);
		inDepth = (p.y + p.depth) <= (y + depth);
		return inX && inY && inWidth && inDepth;
	}
	
	// setter method for X
	public void setX(int x) {
		this.x = x;
	}
	
	// getter method for X
	public int getX() {
		return x;
	}
	
	// setter method of Y
	public void setY(int y) {
		this.y = y;
	}
	
	// getter method of Y
	public int getY() {
		return y;
	}
	
	// setter method for width
	public void setWidth(int width) {
		this.width = width;
	}
	
	// getter method for width
	public int getWidth() {
		return width;
	}
	
	// setter method for depth
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// getter method for depth
	public int getDepth() {
		return depth;
	}
	
	// Create a toString method that will display the results to the console
	public String toString() {
		String toReturn = "Upper left: (" + x + "," + y + ");" + " Width: " + width + " Depth: " + depth;
		return toReturn;
	}
}
