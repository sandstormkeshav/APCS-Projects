import javax.swing.JOptionPane;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;


public class TicTacToeWorld extends World{

	// Up here, you put the info that you need to keep track of 
	// all you need to keep track of in a tic-tac-toe game...
	boolean xTurn = true;
	Location firstLocation;
	Location secondLocation;
	int clicks;
	
	
	
	
	public TicTacToeWorld(){
		// what does the default tic tac toe game look like?
		super(new BoundedGrid(3,3));
		
	}
	
	public void clearBoard(){
		Grid g = this.getGrid();
		for(int x = 0;x<g.getNumRows();x++){
			for(int y = 0;y<g.getNumCols();y++){
				Location tempLoc = new Location(x,y);
				remove(tempLoc);
			}
		}
		
	}
	
	
	@Override
	public boolean locationClicked(Location loc){
		// what should happen when someone clicks a square?
		
		
		Grid g = this.getGrid();

		
//		
//		if(g.get(loc) != null){
//		return false;
//		}
		
		clicks++;
		int count = 0;
		
		
		if(firstLocation == null){
//			System.out.println("\nFirst clicked on " + loc + ": ");
			System.out.println(loc + " was clicked! What should we do there?");
			add(loc,"X");
			firstLocation = loc;
			
		}else if(secondLocation == null){
			System.out.println(loc + " was clicked! What should we do there?");
			secondLocation = loc;
			add(loc,"O");
			firstLocation = null;
			secondLocation = null;
		}	
		gameOver(loc);
		checkBug();
		return true;
	}
	
	
	private void checkBug(){
		if(clicks == 9){
			JOptionPane.showMessageDialog(null, "Oops, No One Wins");
			clicks = 0;
			playAgain();

			
		}
	}
	
	
	
	private void playAgain() {		

		
		 int dialogButton = JOptionPane.YES_NO_OPTION;
         JOptionPane.showConfirmDialog (null, "Would You Like to Play Again?","Continue?",dialogButton);

         if(dialogButton == JOptionPane.YES_OPTION){
        	 clearBoard();
         }else if(dialogButton == JOptionPane.NO_OPTION){
        	 exitCode();
         }
        	 
            
	}


	
	
	private void exitCode() {
		Grid g = this.getGrid();
		Location loc1= new Location(0,0);
		Location loc2 = new Location(0,1);
		Location loc3 = new Location (0,2);
		Location loc4 = new Location(1,0);
		Location loc5 = new Location(2,0);
		Location loc6 = new Location(1,1);
		Location loc7 = new Location(1,2);
		Location loc8 = new Location (2,1);
		Location loc9 = new Location(2,2);
		
		add(loc1, "Thank You For Playing");
		add(loc2, "Hope You Enjoyed Playing");
		add(loc3, "XD");
		
		
		
	
	}

	public boolean gameOver(Location loc){
		// this method checks to see if the game is over.  Location loc
		// is the location of the last marker placed into the board
		Grid g = this.getGrid();
		int winO = 0;
		
		Location loc1 = loc;
		Location loc2 = loc;
		Location loc3 = loc;
		Location loc4 = loc;

		
	while(g.isValid(loc1) && g.isValid(loc1.getAdjacentLocation(loc1.EAST)) && g.get(loc1).equals(g.get(loc1.getAdjacentLocation(loc1.EAST)))){
			winO++;
			loc1 = loc1.getAdjacentLocation(loc1.EAST);
			if(winO == 2){
				String s;
				if(g.get(loc1) == "X"){
					 s = "Player 1";
				}
				else{
					 s = "Player 2";
				}
//				System.out.println("GameOver" + s + " wins");
				JOptionPane.showMessageDialog(null, "GameOver" + s + " wins");
				clicks = 0;
//				JOptionPane.showInputDialog("GameOver" + s + " wins");
				playAgain();
				return true;
			}	
		}
	
	winO = 0;

	
	while(g.isValid(loc2) && g.isValid(loc2.getAdjacentLocation(loc2.WEST)) && g.get(loc2).equals(g.get(loc2.getAdjacentLocation(loc2.WEST)))){
		winO++;
		loc2 = loc2.getAdjacentLocation(loc2.WEST);
		if(winO == 2){
			String s;
			if(g.get(loc2) == "X"){
				 s = "Player 1";
			}
			else{
				 s = "Player 2";
			}
//			System.out.println("GameOver" + s + " wins");
			JOptionPane.showMessageDialog(null, "GameOver" + s + " wins");
			clicks = 0;

//			JOptionPane.showInputDialog("GameOver" + s + " wins");
			playAgain();

			return true;
		}
	}

	winO = 0;
	
	
	
	while(g.isValid(loc3) && g.isValid(loc3.getAdjacentLocation(loc3.SOUTH)) && g.get(loc3).equals(g.get(loc3.getAdjacentLocation(loc3.SOUTH)))){
		winO++;
		loc3 = loc3.getAdjacentLocation(loc3.SOUTH);
		if(winO == 2){
			String s;
			if(g.get(loc3) == "X"){
				 s = "Player 1";
			}
			else{
				 s = "Player 2";
			}
//			System.out.println("GameOver" + s + " wins");
			JOptionPane.showMessageDialog(null, "GameOver" + s + " wins");
			clicks = 0;

//			JOptionPane.showInputDialog("GameOver" + s + " wins");
			playAgain();

			return true;
		}
		

	}

	winO = 0;
	
	
	while(g.isValid(loc4) && g.isValid(loc4.getAdjacentLocation(loc4.NORTH)) && g.get(loc4).equals(g.get(loc4.getAdjacentLocation(loc4.NORTH)))){
		winO++;
		loc4 = loc4.getAdjacentLocation(loc4.NORTH);
		if(winO == 2){
			String s;
			if(g.get(loc3) == "X"){
				 s = "Player 1";
			}
			else{
				 s = "Player 2";
			}
			
			JOptionPane.showMessageDialog(null, "GameOver" + s + " wins");
			clicks = 0;

//			JOptionPane.showInputDialog("GameOver" + s + " wins");
			playAgain();

//			System.out.println("GameOver" + s + " wins");
			return true;
		}
		
		
	
	
	}
	winO = 0;
	
	
	Location locX1 = new Location(0,0);
		Location locX2 = new Location(1,1);
		Location locX3 = new Location(2,2);
	Location locX4 = new Location(0,2);			    
		Location locX5 = new Location(2,0);
	
	if(g.get(locX1).equals(g.get(locX2)) && g.get(locX1).equals(g.get(locX3))){
		winO = 2;

		if(winO == 2){
			String s;
			if(g.get(locX1) == "X"){
				 s = "Player 1";
			}
			else{
				 s = "Player 2";
			}
	}
		
		winO = 0;
		
	if(g.get(locX4).equals(g.get(locX2)) && g.get(locX4).equals(g.get(locX5))){
		winO = 2;

		if(winO == 2){
			String s;
			if(g.get(locX4) == "X"){
				 s = "Player 1";
			}
			else{
				 s = "Player 2";
			}
	}
	
	
	

}
}
	
	Location check = new Location(0,0);
	System.out.println(g.get(check));
	
	
	return false;
	}
}