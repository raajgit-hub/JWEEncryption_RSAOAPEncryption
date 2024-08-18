package com.exception.handling;

public class ExceptionHandling {
	public static void main(String[] args) {
		
		try {
			int a=5;
			int b=0;
			
			System.out.println(" a/b = " + a/b);
		} catch(Exception e) {
			//e.printStackTrace();
			//System.out.println(" Exception while performing Divison :: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
