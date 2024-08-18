package inheritance.example;

public class Actor extends Artist {
	
	String[] moviesActed;
	String[] awardsEarned;
	
	public Actor() {
		System.out.println(" I am in Actor() ");
	}
	
	public static void main(String[] args) {
		Person person = new Actor();
		//Artist artist = new Artist();
		Actor actor = new Actor();
		
	}

}
