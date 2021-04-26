package se_ex2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class SmsManager extends ContactApplication{
    private HashMap<Contact, LinkedList<String>> conversations;

    // Constructor
    public SmsManager(MobilePhone phone) {
        super(phone);
        conversations = new HashMap<Contact, LinkedList<String>>();
    }

    // (1) Add conversation
    public void addEntry(Contact c, String s, Boolean incoming) {
        LinkedList<String> conversation = conversations.get(c);
        s = (incoming? c.getName() + ": " : "Me: ") +  s;
        if (conversation == null) {
            conversation = new LinkedList<String>();
            conversations.put(c, conversation);
        }
        conversation.add(s);
    }

    // (2) Delete conversation
    @Override
    public void removeEntry(Contact c) {
        conversations.remove(c);
    }

    // (3) Print conversation
    public void printConversation (Contact c) {
        System.out.println(c + ":");
        System.out.println(conversations.get(c));
    }

    // (4) Search sentence in any of the conversations
    public void searchSentence(String s) {
        ListIterator<String> iter;
        LinkedList<String> conversation;
        for (HashMap.Entry<Contact, LinkedList<String>> entry : conversations.entrySet()) {
            conversation = entry.getValue();
            iter = conversation.listIterator();
            while (iter.hasNext()) {
                String str = iter.next();
                if (str.contains(s)) {
                    System.out.println(entry.getKey());
                    break;
                }
            }
        }
    }

    // (5) Print all conversations
    public void printAll() {
        for (HashMap.Entry<Contact, LinkedList<String>> entry : conversations.entrySet())
            printConversation(entry.getKey());
    }

    @Override
    public void menu() {
        Scanner s = new Scanner(System.in);
        int exit = 0;
        while (exit == 0) {
            System.out.println("******************SMS Menu******************");
            System.out.println("1. Add conversation");
            System.out.println("2. Delete Conversation");
            System.out.println("3. Print conversation");
            System.out.println("4. Search");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.println("********************************************");
            int func = s.nextInt();
            s.nextLine();
            
            String msg;
            Contact c;
            switch (func) {
            case 1:
                c = askForContactName();
                System.out.println("Message:");
                msg = s.nextLine();
                System.out.println("Incoming message? [y/n]");
                String incoming = s.nextLine();
                addEntry(c, msg, (incoming == "y"));
                break;
            case 2:
                c = askForContactName();
                removeEntry(c);
                break;
            case 3:
                c = askForContactName();
                printConversation(c);
                break;
            case 4: 
                System.out.println("Search message:");
                msg = s.nextLine();
                searchSentence(msg);
                break;
            case 5:
                printAll();
                break;
            case 6:
                exit++;
                break;
            default: System.out.println("Not valid!"); break;
            }
        }
        s.close();
    }
    
    public Contact askForContactName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Contact Name:");
        String name = s.nextLine();
        s.close();
        return super.getPhone().getPb().getContactByName(name);
    }
}
