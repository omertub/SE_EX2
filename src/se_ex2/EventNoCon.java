package se_ex2;

import java.util.Date;

public class EventNoCon extends Event{
	private String comment;
	
	public EventNoCon(Date otherDate,int otherMin,String otherComment)throws OutOfBoundryException{
		super(otherDate, otherMin);
		this.comment=otherComment; //String is immutable
	}
	//default c'tor
	public EventNoCon()throws OutOfBoundryException {
		super();
		this.comment="no comment";
	}
	//get
	public String getComment() {return this.comment;}
	//set
	public void setComment(String s) {
		this.comment=s;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\r\ncomment: "+this.getComment()+"\r\n**********";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof EventNoCon)) {
			return false;
		}
		EventNoCon copy=(EventNoCon) obj;
		return this.getComment().equals(copy.getComment())
				&&this.getDate().equals(copy.getDate())
				&& this.getMin()==copy.getMin();
	}
	
}
