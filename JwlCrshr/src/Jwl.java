import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;


public abstract class Jwl {
	private static Grid g;// belongs to the class
	public static final int JWL_TYPES = 5;
	
	private Shape s;
	private Location loc;
	private Color c;
	private Image i;
//	private BufferedImage img;
	
	public Color getColor() {
		return this.c;
	}
	public void setColor(Color c) {
		this.c = c;
	}
	
	public Jwl(Shape s, Color c, Location loc, Grid gr) {
		g = gr;
		this.s = s;
		this.c = c;
		this.loc = loc;
//		this.img = img;`
	}
	

	
	
	@Override
	public boolean equals(Object o) {
		
		try {
			
			Jwl other = (Jwl) o;
			
			
			return s.getSides()==other.s.getSides() && c.equals(other.c);
			
		
		}
		catch(Exception e) {
			
		}		
		return false;
	}
	
	
	public abstract void spin();
	
	
	
	
	
	
	public void drop() {
		loc = loc.getAdjacentLocation(loc.SOUTH);
	}
	public  boolean canDrop() {
		Location locBelow = loc.getAdjacentLocation(loc.SOUTH);
		return (g.isValid(locBelow)&& g.get(locBelow)== null);
			
	}
	public Object getShape() {
		return s;
	}
	public Image getImage() {
		
		return i;
	}
}
