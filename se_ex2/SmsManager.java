package se_ex2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SmsManager implements AppManager{
    HashMap<Contact, LinkedList<String>> conversations;


    public SmsManager() {
        conversations = new HashMap<Contact, LinkedList<String>>();
    }

    public void addEntry(Contact c, String s) {
        LinkedList<String> conversation = conversations.get(c);
        if (conversation == null) {
            conversation = new LinkedList<String>();
            conversations.put(c, conversation);
        }
        conversation.add(s);
    }

    @Override
    public void removeEntry(Contact c) {
        conversations.remove(c);
    }
    
    public void printConversation (Contact c) {
        System.out.println(conversations.get(c));
    }
    
    public void findSentence(String s) {
        for (HashMap.Entry<Contact, LinkedList<String>> entry : conversations.entrySet()) {
            LinkedList<String> conversation = entry.getValue();
            Iterator<String> iter = conversation.iterator();
            while (iter.hasNext()) {
                String str = iter.next();
                if (str.contains(s))
                    System.out.println(entry.getKey());
            }
        }
    }
    
    public void printAll() {
        for (HashMap.Entry<Contact, LinkedList<String>> entry : conversations.entrySet())
            printConversation(entry.getKey());
    }
}
