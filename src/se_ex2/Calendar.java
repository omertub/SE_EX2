package se_ex2;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;



public class Calendar extends ContactApplication{
	private LinkedList<Event> calen;
	final private Date init=new Date(0);//initial date is set to 00:00 UTC, 1.1.1970 
	
    public Calendar(MobilePhone phone) {
        super(phone);
        this.calen=new LinkedList<Event>();
    }
    //1.add Event
    public void addEvent(Event newEvent) throws OutOfBoundryException {
    	Date limit=new Date(init.getTime());
    	limit.setMonth(init.getMonth()+1);
    	if(newEvent.getDate().before(init)||newEvent.getDate().after(limit)) {
    		throw new OutOfBoundryException();
    	}
    	this.calen.add(newEvent);	
    }
    
    //2.remove Event
    public void removeEvent(Event newEvent)throws NoSuchElementException {
    	boolean flag=false;
    	Iterator<Event> iter=this.calen.iterator();
    	while(iter.hasNext()) {
    		Event temp=iter.next();
    		if(temp.equals(newEvent)) {
    			iter.remove();
    			flag=true;
    		}
    	}	
    	if(!flag) {
    		throw new NoSuchElementException();
    	}
    }
   
    //3.print all Events of a specific day
    public void printInDay(int day)throws OutOfBoundryException {
    	if(this.calen==null) {
    		return;
    	}
  		if((day<1||day>30)){
  			throw new OutOfBoundryException();
  		}
  		System.out.println("Printing all events in:"+day+"."+(init.getMonth()+1));
    	Date d=new Date(1000*60*60*24*(day-1));
  		SimpleDateFormat f=new SimpleDateFormat("dd.MM.yyyy");
    	System.out.println("Printing "+f.format(day)+"'s Events...");
    	Collections.sort(this.calen);
    	Iterator<Event> iter=this.calen.iterator();
    	Event temp;
    	int count=0;
    	while(iter.hasNext()) {
    		temp=iter.next();
    		if(sameDay(d,temp)) {
    			System.out.println(temp);
    			count++;
    		}
    	}
    	if(count==0) {
    		System.out.println("No events on:"+f.format(day));
    	}
    	else System.out.println(count+" events were printed");
    	System.out.println();
    }
    
    //4.print all events of a specific contact.
    public void printConEvents(Contact c) throws NullPointerException {
    	if(c==null) {
    		throw new NullPointerException();
    	}
    	System.out.println("Printing "+c.getName()+"'s Events:");
    	Collections.sort(this.calen);
    	Iterator<Event> iter=this.calen.iterator();
    	Event temp;
    	int count=0;
    	while(iter.hasNext()) {
    		temp=iter.next();
    		if(temp instanceof EventCon) {
    			if(((EventCon) temp).belongsToContact(c)) {
    				System.out.println(((EventCon)temp));
    				count++;
    			}
    		}
    	}
    	if(count==0) {
    		System.out.println("No events for "+c);
    	}
    	else System.out.println(count+" events were printed");
    	System.out.println();
    }
    
    //5.prevent collisions
    public void cleanColl() {
    	Collections.sort(this.calen);
    	Iterator<Event> iter=this.calen.iterator();
    	
    	Event before,after;
    	if(!(iter.hasNext())) {
    		return;
    	}
    	before=iter.next();
    	long befEnd,afStart;
    	while(iter.hasNext()) {
    		after=iter.next();
    		befEnd=before.getDate().getTime()+before.getMin()*60*1000;
    		afStart=after.getDate().getTime();
    		if((afStart-befEnd)<0) {
    			iter.remove();
    		}
    		else {
    			before=after;
    		}
    		
    	}
    }
   
    //6.print all events
    @Override
    public void printAll() {
    	if(this.calen==null) {
    		System.out.println("No Events in Calendar");
    		return;
    	}
    	System.out.println("Printing all Events in Calendar...");
    	int count=0;
    	this.sortCalendar();
        Iterator<Event> iter = this.calen.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next()); 
            count++;
        }   
        System.out.println(count+" Events printed");
        System.out.println();
    }
    
    
    public void sortCalendar() {
    	Collections.sort(this.calen);
    }

    //check if Event occurs in a specific day
    public static boolean sameDay(Date day,Event e1) {
    	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
    	return f.format(e1.getDate()).equals(f.format(day));
    }
    
    
    public void cleanCalen() {
    	Iterator<Event> iter=this.calen.iterator();
    	while(iter.hasNext()) {
    		iter.next();
    		iter.remove();
    	}
    }
    	 
    public void removeEntry(Contact c) {
        Iterator<Event> iter=this.calen.iterator();
        Event temp;
        System.out.println("Removing entry "+c+"...");
        while(iter.hasNext()) {
        	temp=iter.next();
        	if(temp instanceof EventCon) {
        		if(((EventCon)temp).getContact().equals(c)) {
        			iter.remove();
        		}
        	}
        }
        System.out.println("Entry "+c+" removed!");
        System.out.println();   
    }
 
    @Override
    public void menu(Scanner s) {
    	int exit = 0;
        while (exit == 0) {
            System.out.println("******************Calendar Menu******************");
            System.out.println("1. Add an Event");
            System.out.println("2. Remove an Event");
            System.out.println("3. Clean Event collisions");
            System.out.println("4. Print Events in a specific day");
            System.out.println("5. Print a contact's Events");
            System.out.println("6. Print all events");
            System.out.println("7. Exit");
            System.out.println("********************************************");
            int func = s.nextInt();
            s.nextLine();
            //variables for switch case
            long millisec; 	int min;		 	String option;
        	Contact con; 	Event newEvent; 	Date d;
            switch(func) {
            case 1:            	
            	System.out.println("Adding an Event...");
            	System.out.println("Enter time in millisec after 1st,Jan: ");
            	millisec=s.nextLong();
            	s.nextLine();
            	d=new Date(millisec);
            	System.out.println("How long is the Event? (0-60 min)");
            	min=s.nextInt();
            	s.nextLine();
            	System.out.println("Include a contact?(y/n)");
            	option=s.nextLine();
            	if(option.equals("y")) {
            		System.out.println("Enter contact's name:");
            		String name=s.nextLine();
            		con = this.getPhone().getPb().getContactByName(name);
            		try {
            		newEvent=new EventCon(d,min,con);
            		}
            		catch(NullPointerException e) {
            			System.out.println("(Exception) Contact doesn't exist!");
            			break;
            		}
            		catch(OutOfBoundryException e) {
            			System.out.println(e.getMessage());
            			break;
            		}
            	}
            	else {
            		System.out.println("Add a comment?");
            		String comm=s.nextLine();
            		try {
            		newEvent=new EventNoCon(d,min,comm);
            		}
            		catch(OutOfBoundryException e) {
            			System.out.println(e.getMessage());
            			break;
            		}
            	}
            	
            	try {
            		this.addEvent(newEvent);
            	}
            	catch(OutOfBoundryException e) {
            		System.err.println(e.getMessage());
            		break;
            	}

            	System.out.println("Event added!");
            	break;   	
            	
            case 2:
            	System.out.println("Removing an Event...");
            	System.out.println("Enter time in millisec after 1st,Jan: ");
            	millisec=s.nextLong();
            	s.nextLine();
            	d=new Date(millisec);
            	System.out.println("How long is the Event? (0-60 min)");
            	min=s.nextInt();
            	s.nextLine();
            	System.out.println("Event with a contact?(y/n)");
            	option=s.nextLine();
            	if(option.equals("y")) {
            		System.out.println("Enter contact's name:");
            		String name=s.nextLine();
            		con = this.getPhone().getPb().getContactByName(name);
            		try {
            		newEvent=new EventCon(d,min,con);
            		}
            		catch (NullPointerException e) {
            			System.out.println("NullPointerException");
            			break;
            		}
            		catch(OutOfBoundryException e) {
            			System.out.println(e.getMessage());
            			break;
            		}
            	}
            	else {
            		System.out.println("Enter the comment:");
            		String comm=s.nextLine();
            		try {
            		newEvent=new EventNoCon(d,min,comm);
            		}
            		catch(OutOfBoundryException e) {
            			System.out.println(e.getMessage());
            			break;
            		}
            	}
            	try{
            		this.removeEvent(newEvent);
            	}
            	catch(NoSuchElementException e) {
            		System.out.println("(Exception) Event already doesn't exist!");
            		break;
            	}
            	System.out.println("Event Removed!");
            	break; 
            	
            case 3:
            	System.out.println("Cleaning collisions...");
            	this.cleanColl();
            	System.out.println("Cleaned!");
            	break;
            	
            case 4:
            	System.out.println("Enter which day to print:(1-30)");
            	int day=s.nextInt();            	
            	try {
            	this.printInDay(day);
            	}
            	catch(OutOfBoundryException e) {
            		System.out.println(e.getMessage());
            		break;
            	}
            	System.out.println("Events printed!");
            	break;
            	
            case 5:
            	System.out.println("Enter contact's name:");
            	String name=s.nextLine();
            	con = this.getPhone().getPb().getContactByName(name);
            	try {
            	this.printConEvents(con);
            	System.out.println("Events printed!");
            	}
            	catch(NullPointerException e) {
            		System.out.println("(Exception) Contact doesn't exist!");
            	}
            	break;
            case 6:
            	this.printAll();
            	break;
            	
            case 7:
            	System.out.println("exiting Calendar...");
            	exit++;
            	break;
            default:
            	System.out.println("Invalid input!");
            	break;         
            }      
            
        }
    }
}
