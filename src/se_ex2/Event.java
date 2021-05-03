package se_ex2;
import java.util.Date;

public abstract class Event implements Comparable<Event> {
	private Date date;
	private int min;
	
	//c'tors
	public Event(Date otherDate,int otherMin) {
		this.min=otherMin;
		Date dateCopy=new Date(otherDate.getTime());
		this.date=dateCopy;
	}
	//default
	public Event() {
		this(new Date(),60);
	}
	//copy c'tor
	//i don't think we need this since we wont be making Event duplicates on purpose.
//	public Event(Event other) {
//		this.min=other.getMin();
//		Date dateCopy= new Date(other.getDate().getTime());
//		this.date=dateCopy;
//	}
	//getters
	public Date getDate() {return this.date;}
	public int getMin() {return this.min;}
	//setters
	public void setDate(Date other) {
		Date dateCopy=new Date(other.getTime());
		this.date=dateCopy;
	}
	public void setMin(int other) {
		this.min=other;
	}
		
	@Override
	public String toString() {
		return "printing event...\r\n**********\r\n"+date.toString()+"\r\nlength: " + min + " minutes";
	}
	
	@Override
	public abstract boolean equals(Object obj);
	
	
	
	@Override
	public int compareTo(Event other) {
		return this.getDate().compareTo(other.getDate());
	}
	
	public boolean isBefore(Event other) {
		return this.getDate().before(other.getDate());
	}
	public boolean isAfter(Event other) {
		return this.getDate().after(other.getDate());
	}
	//functions summary:
	//toString,getters, (abstract) equals,compareTo(by date), isBefore,isAfter
}
