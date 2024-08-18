package hello.world;

public class Pyramid {
	
	public void printPyramid(String pyramidCharacter, int length) {
		for(int j=0; j < length; j++) {
			for(int i=0; i <= j; i++) {
				System.out.print(pyramidCharacter + " ");
			}
			System.out.println("");
		}

	}
	
	public static void main(String[] args) {
		Pyramid p1 = new Pyramid();
		p1.printPyramid("#", 5);
	}
}
