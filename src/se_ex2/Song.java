package se_ex2;

public class Song implements Media {

    private String name;
    private double length;

    // CTORS and copy CTOR
    public Song(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public Song() { // Default CTOR
        this("Stairway to heaven", 8.02);
    }

    public Song(Song other) {
        this.name = other.name;
        this.length = other.length;
    }

    // getters.
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(this.name + " is now playing for " + this.length);
    }

    // play method for a Song.
    @Override
    public void play() {
        System.out.println("The song " + this.toString());
    }
}
