package se_ex2;

import java.util.ArrayList;

public class SmsConversation {
    private Contact contact;
    private ArrayList<String> content;
    
    public void SmsConveration(Contact contact, String str) {
        this.contact = contact;
        content = new ArrayList<String>();
        addMessage(str);
    }
    
    public Contact getContact() {
        return contact;
    }
    
    public ArrayList<String> getContent() {
        return content;
    }
    
    public void setContact (Contact c) {
        contact = c;
    }
    
    public void addMessage (String s) {
        content.add(s);
    }
}
