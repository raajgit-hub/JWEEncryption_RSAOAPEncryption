package inheritance.example;

public class InterfaceImpl implements IInterface {
	public static void main(String[] args) {
		InterfaceImpl impl = new InterfaceImpl();
		System.out.println(" impl.abc = " + impl.abc);
	}
}
