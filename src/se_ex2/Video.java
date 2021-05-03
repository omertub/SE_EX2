package se_ex2;

public class Video extends Media {

    // CTORS and copy CTOR
    public Video(String name, double length) {
        super(name,length);
    }

    public Video() {
        this("The Lord of the Rings: The Fellowship of the Ring", 3.42);
    }

    public Video(Video other) {
        this(other.getName(), other.getLength());
    }

    // play method for a Video.
    @Override
    public void play() {
        System.out.println("The video " + this.toString());
    }
}
