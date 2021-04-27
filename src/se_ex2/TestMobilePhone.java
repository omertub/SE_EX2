package se_ex2;

import java.util.Random;

public class TestMobilePhone {
	static Contact[] Contacts = new Contact[4];

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        //phone.menu();
        
        testSms(phone);
    }


	private static void testCreateContacts(MobilePhone phone) {
		String[] Names = {"Almog","Omer","Eilon", "Yair"};
		for (int i=0; i<4; i++) {
			Contact c = new Contact(Names[i],Integer.toString((i+100)*500));
			phone.getPb().addContact(c);
			Contacts[i] = c;
		}	
	}


	private static void testSms(MobilePhone phone) {
		System.out.println("\n********************* SMS TEST *********************");
        testCreateContacts(phone);
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
}
