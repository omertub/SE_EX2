package se_ex2;

public class Video implements Media {

    private String name;
    private double length;

    // CTORS and copy CTOR
    public Video(String name, double length) {
        this.name = name;
        this.length = length;
    }

    public Video() {
        this("The Lord of the Rings: The Fellowship of the Ring", 3.42);
    }

    public Video(Video other) {
        this.name = other.name;
        this.length = other.length;
    }

    // getters.
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("'"+this.name + "' is now playing for " + this.length);
    }

    // play method for a Video.
    @Override
    public void play() {
        System.out.println("The video " + this.toString());
    }
}
