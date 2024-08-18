package multi.threading;

class Method1 extends Thread {
	String name;
	
	Method1(String name) {
		this.name = name;
	}
	
	public void run() {
		// thread body of execution
		System.out.println("Running thread :: " + this.name);
	}

	public static void main(String[] args) {
		Method1 t1 = new Method1("t1");
		Method1 t2 = new Method1("t2");
		Method1 t3 = new Method1("t3");
		Method1 t4 = new Method1("t4");
		Method1 t5 = new Method1("t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}