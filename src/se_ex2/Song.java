package se_ex2;

public class Song extends Media {
	
    // CTORS and copy CTOR
    public Song(String name, double length) {
        super(name,length);
    }

    public Song() { // Default CTOR
        this("Stairway to heaven", 8.02);
    }

    public Song(Song other) {
        this(other.getName(), other.getLength());
    }

    // play method for a Song.
    @Override
    public void play() {
        System.out.println("The song " + this.toString());
    }
}
