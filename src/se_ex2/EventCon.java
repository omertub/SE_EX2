package se_ex2;

import java.util.Date;

public class EventCon extends Event{
	private Contact con;
	
	//constructor
	public EventCon(Date otherDate,int otherMin,Contact otherCon)
			throws NullPointerException,OutOfBoundryException {
		super(otherDate, otherMin);
		if(otherCon==null) {
			throw new NullPointerException();
		}
		this.con=otherCon;
	}
	
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
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof EventCon)) {
			return false;
		}
		EventCon c= (EventCon) obj;
		
		return this.getContact().equals(c.getContact())
				&& this.getDate().equals(c.getDate())  
				&& this.getMin()==c.getMin();
	}

	public boolean belongsToContact(Contact other) {
		return this.getContact().equals(other);
	}
}
