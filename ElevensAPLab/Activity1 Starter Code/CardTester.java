/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card cardone = new Card("4","Hearts",1);
		Card cardtwo = new Card("4","Hearts",1);
		System.out.println(cardone.matches(cardtwo));
		System.out.println(cardone.toString());
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
	}
}
