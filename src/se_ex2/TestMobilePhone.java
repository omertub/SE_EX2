package se_ex2;

import java.util.Random;
import java.util.Date;
public class TestMobilePhone {
	static Contact[] Contacts = new Contact[4];

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
       
        //testCreateContacts(phone);  // create 4 contacts for basic tests
        
       // testPhoneBook(phone);

        /* ********************** */
        /* INSERT YOUR TESTS HERE */
        //testSms(phone);
        testMediaPlayer(phone);
        testCalendar(phone);
        testSms(phone);
        // testMediaPlayer(phone);
        
        /* ********************** */
        
        // after all tests do phone book remove contact
        
        // Now run interactive mode
        //phone.menu();

    }

   public static void testMediaPlayer(MobilePhone phone) {
	   MediaPlayer tbMediaPlayer = phone.getMedia();
	   //movies
	   String[] videoNames = {"Harry Potter and the Philosopher's Stone","Harry Potter and the Chamber of Secrets","Harry Potter and the Prisoner of Azkaban", "Harry Potter and the Goblet of Fire", "Harry Potter and the Order of the Phoenix", "Harry Potter and the Half-Blood Prince", "Harry Potter and the Deathly Hallows � Part 1", "Harry Potter and the Deathly Hallows � Part 2"};
	   double[] videoLengths = {152,161,142,157,138,153,146,130};
	   
	   //songs
	   String[] songNames = {"Enter Sandman","Sad But True", "Holier Than Thou", "The Unforgiven", "Wherever I May Roam", "	Don't Tread on Me", "Through the Never", "Nothing Else Matters", "Of Wolf and Man", "The God That Failed", "My Friend of Misery", "	The Struggle Within"};
	  
	   double[] songLengths = {5.5,5.24,3.47,6.27,6.44,4,4.04,6.28,4.16,5.08,6.49,3.53 };
	   
	//1. add new media.   
		for (int i=0; i<videoNames.length-1; i++)
			tbMediaPlayer.newMedia(0,videoNames[i],videoLengths[i]);
			
		for (int i=0; i<videoNames.length-1; i++) 
			tbMediaPlayer.newMedia(1,songNames[i],songLengths[i]);	
	//2. play media by name
		tbMediaPlayer.playMediaByName("Harry Potter and the Philosopher's Stone");	// a video
		tbMediaPlayer.playMediaByName("Sad But True"); // a song about my life
		tbMediaPlayer.playMediaByName("bla bla"); // a media file, not exsist.	
	//3. play all Media.
		tbMediaPlayer.playAll(); // play all media		
					
	}
	   
   
	private static void testCreateContacts(MobilePhone phone) {
		String[] Names = {"Almog","Omer","Eilon", "Yair"};
		for (int i=0; i<4; i++) {
			Contact c = new Contact(Names[i],Integer.toString((i+100)*500));
			phone.getPb().addContact(c);
			Contacts[i] = c;
		}	
	}
	
	private static void testPhoneBook(MobilePhone phone) {
		String[] Names = {"Almog","Omer","Eilon", "Yair", "yair"};
		for (int i=0; i<5; i++) {
			Contact c = new Contact(Names[i],Integer.toString((i+100)*500));
			phone.getPb().addContact(c);
		}	
		phone.getPb().sortByName();
		phone.getPb().reverseList();
		phone.getPb().printAll();
		System.out.println("Search 'Almog': " + phone.getPb().getContactByName("almog"));
		System.out.println("Is Etni exist?: " + phone.getPb().isExist(new Contact("Etni", "12345")));
		phone.getPb().saveToFile("MyFile");
		System.out.println("Remove Almog...");
		phone.getPb().removeEntry(phone.getPb().getContactByName("Almog"));
		phone.getPb().loadFile("MyFile");
		phone.getPb().printAll();
		//after other tests, test removeEntry
	}
	

	private static void testSms(MobilePhone phone) {
		System.out.println("\n********************* SMS TEST *********************");
		SmsManager sms = phone.getSms();
		Random rand = new Random();
		Contact c;
		// Add Entries
		for (int i=0;i<100;i++) {
			c = Contacts[rand.nextInt(4)];
			sms.addEntry(c, getRandomWord(), (i%2 == 0));
		}
		sms.printAll();
		
		// Print Single Conversation
		c = Contacts[rand.nextInt(4)];
		System.out.println("\nprinting "+c);
		sms.printConversation(c);
		
		// Remove conversation
		c = Contacts[rand.nextInt(4)];
		System.out.println("\nremoving "+c);
		sms.removeEntry(c);
		sms.printAll();
		
		// Search sentence
		String s = getRandomWord();
		System.out.println("\nsearching "+s);
		sms.searchSentence(s);
	}
	
	public static String getRandomWord() {
		String words = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur dictum nisl sed mi euismod semper. Aliquam fermentum hendrerit ex, "
				+ "sed ultrices elit pellentesque eu. Pellentesque ac lectus in libero fermentum dapibus ac et magna. Quisque fringilla risus quis nunc egestas "
				+ "pellentesque. Sed viverra dapibus urna non varius. Aliquam tellus velit, imperdiet ac dignissim sed, fermentum convallis mauris. Vestibulum "
				+ "quis tortor quis diam vulputate sollicitudin non sed purus. Mauris maximus in augue sed posuere. Aenean at elit commodo, mollis sapien et, "
				+ "convallis nisl. Nullam id rhoncus purus, at condimentum urna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel diam elit. "
				+ "Proin consequat ultricies nulla quis tempor. Etiam tempor turpis eget risus pellentesque, vitae facilisis nisl pellentesque. Praesent quis "
				+ "leo orci. Aenean suscipit lorem diam, quis ullamcorper turpis volutpat cursus. Donec accumsan est et dolor iaculis finibus. Fusce turpis tortor, "
				+ "semper eu sagittis vitae, porta a leo. Pellentesque pharetra velit id dictum maximus. Curabitur a ligula nisi. Proin odio purus, tempus eu "
				+ "sapien ut, dapibus aliquet magna. Aenean lobortis nunc porta, bibendum libero vitae, eleifend ex. Fusce non mi eget urna blandit gravida in "
				+ "vitae quam. Donec eu quam blandit urna finibus sagittis vel eget magna. Mauris magna orci, sagittis.";
		String[] wordsAsArray = words.split(" ");
		int index = new Random().nextInt(wordsAsArray.length);
		return wordsAsArray[index];
	}

	private static void testCalendar(MobilePhone phone) {
		System.out.println("---------------Calendar test---------------\r\n");
        
        Calendar C=new Calendar(phone);
        try {
        EventNoCon z1=new EventNoCon(new Date(4000),20,"Comment z1");
        EventNoCon z2=new EventNoCon(new Date(88888888),20,"Comment z2");
        EventNoCon z3=new EventNoCon(new Date(5537),20,"Comment z3");
        EventCon y2= new EventCon(new Date(555555555),20,new Contact("other","9328473"));
        EventCon y3= new EventCon(new Date(10000),30,new Contact("yair","9328473"));
        EventCon y4= new EventCon(new Date(40000000),30,new Contact("other","444444"));  
       
        	
        C.addEvent(z1);
        C.addEvent(z2);
        C.addEvent(z3);
        C.addEvent(y2);
        C.addEvent(y3);
        C.addEvent(y4);
        }
        catch(OutOfBoundryException e){
        	System.out.println(e.getMessage());
        }
        System.out.println("Print all events");
        C.printAll();
        Date d=new Date(6000);
        try {
        	C.printInDay(d.getDay());
        }
        catch(OutOfBoundryException e) {
        	System.out.println(e.getMessage());
        }
        System.out.println("Print yair's Events:");
        C.printConEvents(new Contact("yair","9328473"));
        System.out.println("Clean event collisions, and print:");
        C.cleanColl();
        C.printAll();   
        System.out.println("---------------Calendar test done---------------");
	}
}
