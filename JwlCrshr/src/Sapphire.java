import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sapphire extends Jwl {

	public Sapphire(Location loc, Grid gr) {
		super(new Pentagon(), new Color(20, 15, 250), loc, gr);
		// TODO Auto-generated constructor stub
	}	

//q23q
//	public static BufferedImage getImage(){
//	BufferedImage img = null;
//	try {
//	    img = ImageIO.read(new File("ok.jpg"));
//	    System.out.println("ok readed");
//	} catch (IOException e) {
//	}
//	return img;
//}


	@Override
	public void spin() {
		// TODO Auto-generated method stub

	}

}
