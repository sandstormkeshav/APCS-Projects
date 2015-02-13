
public class RecursionEx1 {

	
	public static void main(String[] args){
//		catastrophe(1);
		drawLine(3);
	}

	private static void catastrophe(int i) {

		System.out.println(i);
		catastrophe(1);
	}

	public static void drawLine(int n){
		if(n == 0){
			System.out.println("END");
		}
		else {
			for(int x = 1;x<=n;x++){
				System.out.print("*");
			System.out.println();
			drawLine(n-1);
			}
		}
	}
}
