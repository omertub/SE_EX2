package se_ex2;

import java.util.Scanner;

public class MobilePhone {
	
	private PhoneBook pb;
	private SmsManager sms;
	private Media media;
	private Diary diary;
	
	public MobilePhone() {
		this.pb = new PhoneBook();
		this.sms = new SmsManager();
		this.media = new Media();
		this.cal = new Calander();
	}
	
	public void menu() {
		Scanner s = new Scanner(System.in);
		int exit = 0;
		while (exit == 0) {
			System.out.println("********************Menu********************");
			System.out.println("1. Open phone book");
			System.out.println("2. Open messages");
			System.out.println("3. Open media player");
			System.out.println("4. Open diary");
			System.out.println("5. Print all");
			System.out.println("6. Exit");
			System.out.println("********************************************");
			System.out.println("Enter function number:");
			int func = s.nextInt();
			s.nextLine();
			
			switch (func) {
			case 1: this.pb.menu(); break;
			case 2: this.sms.menu(); break;
			case 3: this.media.menu(); break;
			case 4: this.cal.menu(); break;
			case 5:
				this.pb.print();
				this.sms.print();
				this.media.print();
				this.diary.print(); break;
			case 6: exit++; break;
			default: System.out.println("Not valid!"); break;
			}
		}
		s.close();
	}
	
}
