
public abstract class Shape {
	private int sides;
	
	
	public Shape(int sides) {
		this.sides = sides;
	}
	public int getSides(){
		return sides;
		
	}
	public boolean equals(Object o){
		Shape s=null;
		try{
			 s= (Shape) o;
			 return(this.sides == s.sides);
		}catch(Exception e){
			
		}
		return false;
	}
}
