package se_ex2;

import java.awt.geom.Arc2D.Double;
import java.util.Scanner;


// we created a Father Interface class of "Media" TO INHERATE From. this way we can implement all methods in a more Effective way.
public interface Media { 
	
	public void play();
	public String toStrings();
	public String getName();
	public double getLength();
	
}

// the first class is "Song".
class Song implements Media{ 
	
	private String name;
	private double length;	
	
	// CTORS and copy CTOR
	public Song(String name, double length) { 
		this.name = name;
		this.length = length;
	}
	public Song() { // Default CTOR
		this.name = "Stairway to heaven";
		this.length = 8.02;
	}
	public Song(Song other) { 
		this.name = other.name;
		this.length = other.length;
	}
	//getters.
	public String getName(){
		return name;
	}
	public double getLength(){
		return length;
	}
	
	@Override
	public String toStrings(){
		
		return String.format(this.name + "is now playing for" + this.length);
	}
	//play method for a Song.	
	@Override
	public void play() {
		// TODO Auto-generated method stub
			System.out.println("The song "+this.toStrings());
	}	
}
//the second class is "Video".
class Video implements Media{
	
	private String name;
	private double length;	
	
	// CTORS and copy CTOR
	public Video(String name, double length) { 
		this.name = name;
		this.length = length;
	}
	public Video() { 
		this.name = "The Lord of the Rings: The Fellowship of the Ring";
		this.length = 3.42;
	}
	public Video(Video other) { 
		this.name = other.name;
		this.length = other.length;
	} 
	//getters.	
	public String getName(){
		return name;
	}
	public double getLength(){

		return length;
	}
	
	@Override
	public String toStrings(){

		return String.format(this.name + "is now playing for" + this.length);
	}
	//play method for a Video.
	@Override
	public void play() {
		System.out.println("The video "+this.toStrings());
		Scanner s = new Scanner(System.in);
		
	}
}


