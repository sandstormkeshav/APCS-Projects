
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JwlPanel extends JPanel {
	JwlWorld jwlWorld;
	int row;
	int col;
	Grid grid;
	Image img;
	int elapsedTime = 0;
	ClockTicker b = new ClockTicker();
	Timer ticker = new Timer(10,b);
	Image Oct,Pent,Circle,Triangle,Rectangle,Heptagon,Hexagon;
	//need to add ticker.stop();
	
	class ClockTicker implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {

			// TODO Auto-generated method stub
			//advance the time by one time increment
			elapsedTime++;
//			setMessage("Elapsed time: "+ elapsedTime/100+"."+elapsedTime%100);
		}
		
	}
	
	public JwlPanel(final JwlWorld jwlWorld) {
		this.jwlWorld=jwlWorld;
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.BLACK);

        /////////////////////////////////////////////////////////////////////////////////
		///////////////////  this is where the mouse handling goes //////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ticker.start();
				System.out.println("you just clicked and here is the info\n"+e);
				row=e.getY()/50;
				col=e.getX()/50;
				Location loc = new Location(row,col);
//				if(grid.isValid(loc)){
				jwlWorld.locationClicked(new Location(row,col));
//				}
				
				// what should go here??  Need to turn that click into a row and col
				// then, tell the JwlWorld there was a click there
				
				repaint();// this will be the last thing we do after each click
				// we may want to repaint each time there is a JwlWorld activity
			}
		});
	}
	
	/*
	 * READ THIS!!!!!!
	 * The paintComponent method is already a double-buffered approach to graphical
	 * representation.  The best approach is to put all the code into this method that
	 * is needed to DRAW THE CURRENT VIEW FROM SCRATCH!!!
	 */
	


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Grid grid = this.jwlWorld.getGrid();
		drawExtraStuff(g);// maybe background other stuff...
		try {
			drawJewels(grid, g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void drawJewels(Grid grid, Graphics g) throws IOException {
		// This goes through the grid and draws images (or shapes or...)
		// at the corresponding locations on the Graphics.  As you traverse
		// the grid, you need to turn the Locations into x and y coords and
		// make sure you draw 
		Oct = ImageIO.read(new File("Cyan.png"));
		Pent = ImageIO.read(new File("Emerald.png"));
		Circle = ImageIO.read(new File("Gold.png"));
		Triangle = ImageIO.read(new File("Morganite.png"));
		Hexagon = ImageIO.read(new File("Orange.png"));//
		Heptagon = ImageIO.read(new File("Ruby.png"));//
		Rectangle = ImageIO.read(new File("Sapphire.png"));//
		for(int x=0;x<grid.getNumCols();x++){
			for(int y=0;y<grid.getNumRows();y++){
				if(grid.get(new Location(y,x))!=null){
					Jwl o = (Jwl) grid.get(new Location(y,x));
	
					g.setColor(o.getColor());
					//g.fillOval(5+50*x,5+50*y, 50, 50);
					if	(o.getShape().equals(new Octagon())){
//						img = ImageIO.read(new File("Orange"));
						g.drawImage(Oct,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
							
						
					}
					if(o.getShape().equals(new Circle())){
//						img = ImageIO.read(new File("Cyan"));
						g.drawImage(Circle,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
//						g.fillOval(5+50*x,5+50*y, 50, 50);
					}
					if(o.getShape().equals(new Triangle())){
//						img = ImageIO.read(new File("Triangle"));
						g.drawImage(Triangle,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
						
				
					}
					if(o.getShape().equals(new Hexagon())){
//						img = ImageIO.read(new File("Gold"));
						g.drawImage(Hexagon,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
					

					}
					if(o.getShape().equals(new Rectangle())){
//						img = ImageIO.read(new File("Morganite"));
						g.drawImage(Rectangle,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
//						g.drawRect(arg0, arg1, arg2, arg3);
				

					}
					if(o.getShape().equals(new Heptagon())){
//						img = ImageIO.read(new File("Ruby"));
						g.drawImage(Heptagon,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);
			

					}
					if(o.getShape().equals(new Pentagon())){
//						img = ImageIO.read(new File("Sapphire"));
						g.drawImage(Pent,10+50*x, 10+50*y,50,50,this);
//						g.drawOval(5+50*x,5+50*y, 50, 50);



					}
					
				
				}
			}
		}
	

				}
			
		
	

	private void drawExtraStuff(Graphics g) {
		// TODO Auto-generated method stub
//		g.drawOval(50, 50, 50, 50);
	}

}
