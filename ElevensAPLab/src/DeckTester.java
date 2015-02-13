/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A","B","C"};
		String[] suits = {"Giraffe","Lions"};
		int[] pointValues = {2,1,6};
		
		Deck d = new Deck(ranks,suits,pointValues);
		System.out.println(d);
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	
}
		
	
}
