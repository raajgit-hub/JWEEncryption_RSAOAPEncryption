package com.c1b.negativefile.model;

import java.util.Date;

public class NegativeFileVO {

	String firstName;
	String lastName;
	Date dob;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String zip;
	String email;
	String phone;
	String source;
	String ssn;
	
	  public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setState(String state) {
			this.state = state;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}	
}