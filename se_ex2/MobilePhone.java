package se_ex2;

import java.util.Scanner;

public class MobilePhone {
	
	private PhoneBook pb;
	private SmsManager sms;
	private MediaPlayer media;
	private Calendar calendar;
	
	public MobilePhone() {
		this.pb = new PhoneBook(this);
		this.sms = new SmsManager(this);
		this.media = new MediaPlayer();
		this.calendar = new Calendar(this);
	}
	
	public void menu() {
		Scanner s = new Scanner(System.in);
		int exit = 0;
		while (exit == 0) {
			System.out.println("********************Menu********************");
			System.out.println("1. Open Phone Book");
			System.out.println("2. Open SMS");
			System.out.println("3. Open Media Player");
			System.out.println("4. Open Calander");
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
			case 4: this.calendar.menu(); break;
			case 5:
				this.pb.printAll();
				this.sms.printAll();
				this.media.printAll();
				this.calendar.printAll(); break;
			case 6: exit++; break;
			default: System.out.println("Not valid!"); break;
			}
		}
		s.close();
	}
	


    public PhoneBook getPb() {
        return pb;
    }

    public SmsManager getSms() {
        return sms;
    }

    public MediaPlayer getMedia() {
        return media;
    }

    public Calendar getCalendar() {
        return calendar;
    }
	
}
