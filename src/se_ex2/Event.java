package se_ex2;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Event implements Comparable<Event> {
	private Date date;
	private int min;
	
	//c'tors
	public Event(Date otherDate,int otherMin)throws OutOfBoundryException {
		if(otherMin<0||60<otherMin) {
			throw new OutOfBoundryException();
		}
		this.min=otherMin;
		Date dateCopy=new Date(otherDate.getTime());
		this.date=dateCopy;
	}
	//default
	public Event()throws OutOfBoundryException {
		this(new Date(),60);
	}
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
		return "**********\r\n"+date.toString()+"\r\nlength: " + min + " minutes";
	}
	
	@Override
	public abstract boolean equals(Object obj);
	
	
	
	@Override
	public int compareTo(Event other) {
		return this.getDate().compareTo(other.getDate());
	}
	public boolean sameDay(Event other) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
    	return f.format(this.getDate()).equals(f.format(other.getDate()));
	}
	
	public boolean isBefore(Event other) {
		return this.getDate().before(other.getDate());
	}
	public boolean isAfter(Event other) {
		return this.getDate().after(other.getDate());
	}
}
