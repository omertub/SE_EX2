package se_ex2;

public abstract class  Media {
	protected String name;
	protected double length;
	
    public Media(String name, double length) {
        this.name = name;
        this.length = length;
    }
    
	public abstract void play();
	
    @Override
    public String toString() {
        return String.format("'"+this.name + "' is now playing for " + this.length);
    }
	
    // getters
    public double getLength() {
		return length;
	}
    public String getName() {
		return name;
	}
    // setters
	public void setLength(double length) {
		this.length = length;
	}
	public void setName(String name) {
		this.name = name;
	}
}
