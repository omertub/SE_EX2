package se_ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {
	
	private ArrayList<Contact> contacts;
	private static Scanner s;
	
	public PhoneBook() {
		this.contacts = new ArrayList<Contact>();
	}
	
	public void menu() {
		s = new Scanner(System.in);
		int exit = 0;
		while (exit == 0) {
			System.out.println("********************Menu********************");
			System.out.println("1. Add contact");
			System.out.println("2. Remove contact");
			System.out.println("3. Print phone book");
			System.out.println("4. Find contact by name");
			System.out.println("5. Sort phone book by names");
			System.out.println("6. Sort phone book by phone number");
			System.out.println("7. Remove all duplicates from phone book");
			System.out.println("8. Reverse phone book");
			System.out.println("9. Save to file");
			System.out.println("10. Load from file");
			System.out.println("11. Exit");
			System.out.println("********************************************");
			System.out.println("Enter function number:");
			int func = s.nextInt();
			s.nextLine();
			
			switch (func) {
			case 1: this.userAddContact(); break;
			case 2: this.deleteContact(); break;
			case 3: this.print(); break;
			case 4: this.findByName(); break;
			case 5: this.sortByName(); break;
			case 6: this.sortByPhoneNumber(); break;
			case 7: this.removeDuplicates(); break;
			case 8: this.reverseList(); break;
			case 9: this.saveToFile(); break;
			case 10: this.loadFile(); break;
			case 11: exit++; break;
			default: System.out.println("Not valid!"); break;
			}
		}
		s.close();
	}
	
	public boolean userAddContact() {
		System.out.println("Name:");
		String name = s.nextLine();
		System.out.println("Phone Number:");
		String phoneNumber = s.nextLine();
		Contact c = new Contact(name, phoneNumber);
		if (addContact(new Contact(name, phoneNumber))) {
			System.out.println("Added successfully!");
			return true;
		}
		else {
			System.out.println("Contact name already exist!");
			return false;
		}
	}
	
	public boolean addContact(Contact c) {
		if (this.contacts.contains(c))
			return false;
		return this.contacts.add(c);
	}
	
	public boolean deleteContact() {
		System.out.println("Name:");
		String name = s.nextLine();
		for (Contact c : contacts){
			if (c.getName().equalsIgnoreCase(name) && contacts.remove(c)) {
				System.out.println("Deleted successfully!");
				//TODO: delete from other apps
				return true;
			}
		}
		System.out.println("Not Deleted!");
		return false;
	}

	public void print() {
		for (Contact c : contacts)
			System.out.println(c);
	}
	
	public boolean findByName() {
		System.out.println("Name:");
		String name = s.nextLine();
		for (Contact c : this.contacts){
			if (c.getName().equalsIgnoreCase(name)) {
				System.out.println(c);
				return true;
			}
		}		
		System.out.println("Not Found!");
		return false;
	}
	
	public boolean isExist(Contact c) {
		return this.contacts.contains(c);
	}
	
	public void sortByName() {
		Collections.sort(contacts, Contact.NameComp);
	}
	
	public void sortByPhoneNumber() {
		Collections.sort(contacts, Contact.PhoneComp);
	}
	
	public void removeDuplicates() {
        //create new array list and add each -new- Contact
		ArrayList<Contact> newList = new ArrayList<Contact>();
        for (Contact c : this.contacts)
            if (!newList.contains(c))
                newList.add(c);
        this.contacts = newList;
        System.out.println("Duplicates removed successfully!");
	}
	
	public void reverseList() {
		//Collections.reverse(contacts);
		ArrayList<Contact> newList = new ArrayList<Contact>();
        for (int i = contacts.size()-1; i >= 0; i--)
            newList.add(contacts.get(i));
        contacts = newList;
        System.out.println("Reversed successfully!");
	}
	
	public void saveToFile() {
		System.out.println("File name:");
		String fName = s.nextLine();
		
		File pbFile = null;
		try {
			pbFile = new File(fName + ".txt");
			if (!pbFile.createNewFile()) {
				System.out.println("File already exists!");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error opening file!");
			e.printStackTrace();
			return;
		}
		
		String text = "";
		for (Contact c : contacts)
			text = text + c.getName() + "," + c.getPhone() + "\n";
		try {
			FileWriter myWriter = new FileWriter(pbFile.getName());
			myWriter.write(text);
			myWriter.close();
			System.out.println("Successfully saved!");
		} catch (IOException e) {
			System.out.println("Error writing to file!");
			e.printStackTrace();
			return;
		}
	}
	
	public void loadFile() {
		System.out.println("File name:");
		String fName = s.nextLine();
		
		try {
			File pbFile = new File(fName + ".txt");
			Scanner myReader = new Scanner(pbFile);
			while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        if (line == "")
		        	break;
		        String[] data = line.split(",");
		        this.contacts.add(new Contact(data[0],data[1]));
			}
			myReader.close();
			System.out.println("Successfully load!");
			removeDuplicates();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}
}
