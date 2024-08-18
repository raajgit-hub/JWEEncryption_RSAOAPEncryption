package example.collectns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SampleCollection {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("abc"); list.add("def"); list.add("ghi");
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext() ) {
			System.out.println(iter.next());
		}
	}
}
