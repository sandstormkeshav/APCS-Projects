	import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class JavaGame extends JFrame{
	int x;
	int y;
	
	public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e){
			//whenever pressed then the method for this is automatically called
			int keycode = e.getKeyCode();
			
			if(keycode == e.VK_LEFT){
				x--;
			}
			if(keycode == e.VK_RIGHT){
				x++;
			}
			if(keycode == e.VK_UP){
				y--;
			}
			if(keycode == e.VK_DOWN){
				y++;
			}
			
		}
	}
	
	public JavaGame(){
		addKeyListener(new AL());
		setTitle("Java");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		x = 150;
		y= 150;
	}
	
	public void paint(Graphics g){
		g.drawOval(x, y, 15, 15);
		repaint();
	}
	
	
	public static void main(String[] args){
		new JavaGame();
	}
}
