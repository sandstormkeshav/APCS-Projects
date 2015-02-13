import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;


public class JwlWorld extends World {
	ArrayList<Location> neighbors;
	ArrayList<Location> toDelete = new ArrayList<Location>();
	ArrayList<Location> yesDelete = new ArrayList<Location>();
	private Location firstLoc = null;
	private Location secondLoc = null;
	Location temp;
	int points = 0;
	Random die = new Random();
	
	
	public JwlWorld() {
		super(new BoundedGrid(12,8));
		resetJwls();
	}

	private void resetJwls() {
		Grid g = this.getGrid();
		fillRandom();


			
		
	
		
	}

	private void fillRandom() {
		//add randomly to the world
		Grid g = this.getGrid();
		for(int r=0; r<g.getNumRows(); r++) {
			for(int c = 0; c< g.getNumCols();c++) {
				Location loc = new Location(r,c);
				add(loc, randomJwl(loc));//Add a Sapphire into loc
			}
		}

	}
	


	

	private Object randomJwl(Location loc) {
		// TODO Auto-generated method stub
		int s = die.nextInt(7);
		if(s == 1) {
			return new Sapphire(loc, this.getGrid());
		}
		
		if(s == 2){
			return new Ruby(loc, this.getGrid());
		}
		
		if(s == 3){
			return new Gold(loc,this.getGrid());
		}
		if(s == 4){
			return new Cyan(loc,this.getGrid());
		}
		if(s == 5){
			return new Orange(loc,this.getGrid());
		}
		if(s == 6){
			return new Morganite(loc,this.getGrid());
		}
		
		else {

			return new Emerald(loc, this.getGrid());
		}
	
	}
	
	
	public void dumbclearmethod(){
		Grid g = this.getGrid();
		for(int x = 0;x<12;x++){
		for(int y = 0;y<8;y++){
			
			Location loca = new Location(y,x);
			threeHor(g,loca);
			threeVer(g,loca);			
		
				for(Location lo: toDelete){
					g.remove(lo);
					points += 100;
					dropJwl();
					fillNull();
					System.out.println("cleared");
				}
				toDelete.clear();
			}
		}
	}


    public boolean locationClicked(Location loc) {
		Grid g = this.getGrid();
		int count = 0;
		

//		
		
		if(firstLoc == null) {
			System.out.println("\nFirst clicked on " + loc + ": ");
			firstLoc = loc;
			neighbors = g.getValidAdjacentLocations(loc);

			
	}else if(secondLoc == null){
		System.out.println("Second click on " + loc + ": ");
		secondLoc = loc;
		
		if(true){
			swapJewels(firstLoc, secondLoc);
			}
		firstLoc = null;
		secondLoc = null;
	}
		
		
	return true;
	}
 
	private void swapJewels(Location first, Location second) {
		Grid g = this.getGrid();

		for(int x = 0;x<neighbors.size();x++){
				temp = neighbors.get(x);
				int mainCol = second.getCol();
				int mainRow = second.getRow();
				int sideCol = temp.getCol();
				int sideRow = temp.getRow();
//				return (this.loc.getCol() == other.loc.getCol() && this.loc.getRow() == other.loc.getRow());
//				if(second.equals(temp)){ //neighbors.get(x);
				if(mainCol == sideCol && mainRow == sideRow){
				Object tmp = g.get(first);
				g.remove(first);
				this.add(first, g.get(second));
				g.remove(second);
				this.add(second, tmp);
				System.out.println("swapped");
//				if((threeHor(g,second)||threeVer(g,second))== false){
//					Object tmpx = g.get(second);
//					g.remove(second);
//					this.add(second, g.get(first));
//					g.remove(first);
//					this.add(first, tmpx);
//					System.out.println("unswapped");
//		}
//				
//			}


				
		} 
		dumbclearmethod();
//		threeHor(g, second);
//		threeVer(g,second);
//		clearInRow();
		}
		

}// swapJewels()


	private boolean threeHor(Grid g, Location loc){
		Location holder = loc;
		Location holder2 = loc;
		int count = 0;
		Location testHolder = holder.getAdjacentLocation(holder.WEST);
		Location testHolderX =holder2.getAdjacentLocation(holder2.EAST);

		while(g.isValid(holder) && g.isValid(holder.getAdjacentLocation(holder.WEST))&& g.get(holder.getAdjacentLocation(holder.WEST)).equals(g.get(holder))){
			yesDelete.add(holder);
		    count++;
		    if(g.isValid(holder.getAdjacentLocation(holder.WEST))){
			holder = holder.getAdjacentLocation(holder.WEST);
		    }
//			if(holder.equals(holder.getAdjacentLocation(holder.EAST))){
				count++;
				yesDelete.add(holder);
//			}
		}
			
		while(g.isValid(holder2) && g.isValid(holder2.getAdjacentLocation(holder2.EAST))&& g.get(holder2.getAdjacentLocation(holder2.EAST)).equals(g.get(holder2))){
			yesDelete.add(holder2);
			count++;	
			
			
		    if(g.isValid(holder2.getAdjacentLocation(holder2.EAST))){
			holder2 = holder2.getAdjacentLocation(holder2.EAST);
		    }
		    
		    	count++;
				yesDelete.add(holder2);
		}	
			
		if(count>=3){
			for(int x = 0;x<yesDelete.size();x++){
				toDelete.add(yesDelete.get(x));
			}
			
			
			
		}
		
		yesDelete.clear();
		return count>=3;
		
	}
	
	
	
	
	
	
	
	
	private boolean threeVer(Grid g,Location loc){
		Location holder = loc;
		Location holder2 = loc;
		int count = 0;

		
		
		while(g.isValid(holder)&& g.isValid(holder.getAdjacentLocation(holder.NORTH)) && g.get(holder.getAdjacentLocation(holder.NORTH)).equals(g.get(holder))){
			yesDelete.add(holder);
			count++;
			
		if(g.isValid(holder.getAdjacentLocation(holder.NORTH))){
			holder = holder.getAdjacentLocation(holder.NORTH);
		}
			count++;
			yesDelete.add(holder); 
			
		}
		
		while(holder2.getRow() <= 11 && g.isValid(holder2)&& g.isValid(holder.getAdjacentLocation(holder2.SOUTH))&& g.get(holder2.getAdjacentLocation(holder2.SOUTH)).equals(g.get(holder2))){
			yesDelete.add(holder2);
			count++;
				
		if(g.isValid(holder2.getAdjacentLocation(holder2.SOUTH))){
			holder2 = holder2.getAdjacentLocation(holder2.SOUTH);
		}
		
			count++;
			yesDelete.add(holder2);
		}	
		
//		while(g.isValid(holder2)&& g.isValid(holder2.getAdjacentLocation(holder2.SOUTH)) && g.get(holder2.getAdjacentLocation(holder2.SOUTH)).equals(g.get(holder2))){
//			yesDelete.add(holder);
//			count++;
//			holder = holder.getAdjacentLocation(holder.SOUTH);
//
//			count++;
//			yesDelete.add(holder);
//		}

		
		if(count>=3){
			for(int x = 0;x<yesDelete.size();x++){
				toDelete.add(yesDelete.get(x));
//				System.out.println(yesDelete.get(x));
			}
		}
		
		yesDelete.clear();
		return count>=3;
	}
		
	private void clearInRow(){
		Grid g = this.getGrid();
		if(toDelete.size() == 0){
			
//			Object tmp = g.get(secondLoc);
//			g.remove(secondLoc);	
//			this.add(secondLoc, g.get(firstLoc));
//			g.remove(firstLoc);
//			this.add(firstLoc, tmp);
		}
		points = (toDelete.size()-1/3)*100;
		
		for(Location lo: toDelete){
			g.remove(lo);
		}
		toDelete.clear();

//		if(count == 0){

		
		
//		count++;
		
		
	dropJwl();
	fillNull();
	
	

	}
	
	
	private void fillNull(){
		Grid g = this.getGrid();
		for(int x = 0;x<g.getNumRows();x++){
			for(int y = 0;y<g.getNumCols();y++){
				Location location = new Location(x,y);	
				if(g.get(location) == null){
					Jwl random = (Jwl) randomJwl(location);
					g.put(location,random);
					
				}
			}
		}
	}
	


	private void dropJwl() {
		Location loc = null;
		Location foundLoc = null;
		Grid g = this.getGrid();
		for (int y = 0; y<g.getNumCols(); y++){
			for (int x = g.getNumRows()-1; x>=0; x--){
				loc = new Location (x, y);
				int add = 1;
				if (g.get(loc)==null){
					foundLoc = loc;
					while (g.get(foundLoc) == null && add <= x){
						foundLoc = new Location (x-add, y);
						add++;
					}
					if (g.get(foundLoc)!=null) {
						g.put(loc, this.getGrid().get(foundLoc));
						g.remove(foundLoc);
						
					}
					foundLoc=null;
//					System.out.println(points);
				} 
			}
		}
	}

	

	
	
	
	
	
	
	
	
	
	
}