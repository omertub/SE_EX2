package se_ex2;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Calendar extends ContactApplication{
	private LinkedList<Event> calen;
	private Date initialDate;
	
    public Calendar(MobilePhone phone) {

        super(phone);
        this.calen=new LinkedList<Event>();
    }
    //1.adding Event
    public void addEvent(Event newEvent) {
    	this.calen.add(newEvent);
    	
    }
    //2.removing Event
    public void removeEvent(Event newEvent) {
    	Iterator<Event> iter=this.calen.iterator();
    	while(iter.hasNext()) {
    		Event temp=iter.next();
    		if(temp.equals(newEvent)) {
    			iter.remove();
    		}
    	}	
    }
    //3.print all Events of a specific day
    public void printDay(Date day) {
    	if(this.calen==null) {
    		return;
    	}
    	
    	Collections.sort(this.calen);
    	Iterator<Event> iter=this.calen.iterator();
    	Event temp;
    	
    	while(iter.hasNext()) {
    		temp=iter.next();
    		if(sameDay(day,temp)) {
    			System.out.println(temp);
    		}
    	}
    	
    
//    	while(iter.hasNext()) {
//    		temp=iter.next();
//    		if(sameDay(day,temp)){
//    			//reached our day (the calendar is sorted
//    			while(sameDay(day,temp)) {
//    				System.out.println(temp);
//    				if(!(iter.hasNext())) {
//    					return;
//    				}
//    				temp=iter.next();
//    			}
//    			return;
//    		}
//    	}
    }
    //4.print all events of a specific contact.
    public void printConEvents(Contact c) {
    	if(this.calen==null) {
    		return;
    	}
   
    	System.out.println("Printing "+c+"'s Events...");
    	Collections.sort(this.calen);
    	Iterator<Event> iter=this.calen.iterator();
    	Event temp;
    	while(iter.hasNext()) {
    		temp=iter.next();
    		if(temp instanceof EventCon) 
    			if(((EventCon) temp).belongsToContact(c))
    				System.out.println(((EventCon)temp));	
    	}
    }
    
    public void sortCalendar() {
    	Collections.sort(this.calen);
    }

    //6.print all events
    @Override
    public void printAll() {
    	this.sortCalendar();
        Iterator<Event> iter = this.calen.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next()); 
        }
        
    }
    //check if event occurs in a specific day
    public static boolean sameDay(Date day,Event e1) {
    	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
    	return f.format(e1.getDate()).equals(f.format(day));
    }
    
    
 
    
    	
    
    public void removeEntry(Contact c) {

        // TODO Auto-generated method stub
        
    }

    @Override
    public void menu(Scanner s) {
        // TODO Auto-generated method stub
        
    }
   

    //5.prevent collisions
    //7.exit

}
