package hello.world;

public class HelloWorld {

	public HelloWorld(String str) {
		// TODO Auto-generated constructor stub
		System.out.println(" In helloworld constructor !");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorld hw = new HelloWorld("abc");
		
	}
	
	/*
	 * This method displays static text and returns nothing.
	 */
	public void display() {
		System.out.println(" Hello I am in display()");
		int i=0;
		
		while(i < 5) {
			System.out.println(" I = " + i);
			i++; // i = i +1 ;
		}
	}

}
