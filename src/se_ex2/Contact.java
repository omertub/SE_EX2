package se_ex2;

import java.util.Comparator;

public class Contact {
	
	private String name;
	private String phoneNumber;
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public Contact(Contact other) {
		this.name = other.name;
		this.phoneNumber = other.phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phoneNumber;
	}
	
	//Comparator for sorting the phone book by Contact name
	public static Comparator<Contact> NameComp = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			String name1 = c1.getName().toUpperCase();
			String name2 = c2.getName().toUpperCase();
			return name1.compareTo(name2); //ascending order
		}
	};

	//Comparator for sorting the phone book by Contact phone number
	public static Comparator<Contact> PhoneComp = new Comparator<Contact>() {
		public int compare(Contact c1, Contact c2) {
			String phone1 = c1.getPhone();
			String phone2 = c2.getPhone();
			return phone2.compareTo(phone1); //descending order
		}
	};
  
	@Override
	public String toString() { 
		return String.format(this.name + ": " + this.phoneNumber);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Contact))
			return false;
		Contact other = (Contact) obj;
		return this.name.equalsIgnoreCase(other.name);
	}
}
