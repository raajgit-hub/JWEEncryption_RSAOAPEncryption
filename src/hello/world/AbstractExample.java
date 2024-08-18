package hello.world;

public class AbstractExample {
	static int count;
	static String name = "abc";
	
	public static void main(String[] args) {
		System.out.println(" The count = " + AbstractExample.name);
		
		AbstractExample abs = new AbstractExample();
		System.out.println(" The count = " + abs.name);
		
		AbstractExample abs1 = new AbstractExample();
		System.out.println(" The count = " + abs1.name);		
	}
}
