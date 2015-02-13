import javax.swing.JFrame;


public class JwlFrame extends JFrame {

	public JwlFrame(JwlWorld jwlWorld) {
		super("Jwl Crusher 1.0");
		makeToolbar();// so you can make a toolbar, like "real" apps
		
		// the JwlPanel is where the Jwls and other stuff will
		// be displayed.  The code to display stuff is triggered in 
		// the     paintComponent(Graphics g) method we are overriding
		this.add(new JwlPanel(jwlWorld));
		setVisible(true);
		this.pack();
		this.validate();
		this.setResizable(true);
	}

	private void makeToolbar() {
		// TODO Auto-generated method stub
		
	}

	
}
