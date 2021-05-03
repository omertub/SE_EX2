package se_ex2;

import java.util.Date;

public class EventCon extends Event{
	private Contact con;
	
	//constructor
	public EventCon(Date otherDate,int otherMin,Contact otherCon) {
		super(otherDate, otherMin);
		Contact conCopy=new Contact(otherCon);
		this.con=conCopy;
	}
  //copy constructor, probably unnecessary
//	public EventCon(EventCon other) {
//		super(other.getDate(), other.getMin());
//		Contact conCopy=new Contact(other.getContact());
//		this.con=conCopy;
//	}
	
	//get
	public Contact getContact() {
		return this.con;
	}
	//set
	public void setContact(Contact c) {
		Contact copy=new Contact(c);
		this.con=copy;
	}
	@Override
	public String toString() {
		return super.toString()+"\r\ncontact: "+this.getContact().toString()+"\r\n**********";
	}

	@Override
	public boolean equals(Object obj) {
		//first we check if this and obj point to the same object
		if(this==obj) {
			return true;
		}
		//secondly we check if obj is even the correct object
		if(!(obj instanceof EventCon)) {
			return false;
		}
		//lastly we know that obj is an EventCon, so we cast it to EventCon and compare values
		EventCon c= (EventCon) obj;
		
		return this.getContact().equals(c.getContact())
				&& this.getDate().equals(c.getDate())  
				&& this.getMin()==c.getMin();
	}

	public boolean belongsToContact(Contact other) {
		return this.getContact().equals(other);
	}
}
