package se_ex2;

import java.util.ArrayList;
import java.util.Scanner;

// MediaPlayer application.
public class MediaPlayer implements Application {
	
	
	///////////////////// Container //////////////////////////////////////////
	
    // We choose to implement the Media list using an ArrayList data structure.
    private ArrayList<Media> mediaList = new ArrayList<Media>();
    //////////////////////////////////////////////////////////////////////////
    private static Scanner s;
    ///////////////////// Scanner ////////////////////////////////////////////
    
    //////////////////////////////////////////////////////////////////////////
    
    //////////////////////////// play song by name methods //////////////////
    public void getName() { //input from client
    	
        System.out.println("Please enter your media name:");
        String m = s.nextLine();
        playMediaByName(m);
    }
     
    public void playMediaByName(String m) { // using getMedia, we will get the right media object
        Media find_m = getMedia(m);
        if (find_m == null)
            System.out.println(m + " not exists!");
        else
            find_m.play();
    }   
        
    public Media getMedia(String name) { // media getter.
        for (Media m : this.mediaList) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null; // if we reach this point, the media is not exist.
    }
    //////////////////////////////////////////////////////////////////////////
    
    //////////// Play all media objects in our Media list ////////////////////
    public void playAll() {
        if (this.mediaList.isEmpty()) {
            System.out.println("Media list is EMPTY!!");
            return;
        } else {
            for (Media m : this.mediaList)
                m.play();
        }
    }
    //////////////////////////////////////////////////////////////////////////

    //////////////////// add new media ///////////////////////////////////////
    // this method will use the "select" received from the user to add a new media
    // (Song/Video) to the list.
    public void newMedia(int select) {
    	boolean valid_input = false;
        Media new_media;
        double length = 0;
        String name = "";
        
        System.out.println("please enter a Name:");
        name = s.nextLine();
        System.out.println("please enter length");
	    while (!valid_input) {
            try {
	        	length = s.nextDouble();
	        	s.nextLine();	
	        	valid_input = true;
	        }
	        catch (Exception ex) {
		        s.nextLine();
		        System.out.println("this is not a number! try again.");
	        }  
	    }
        if (select == 1) { // a song
            new_media = new Song(name, length);
        } else { // a video
            new_media = new Video(name, length);
        }
        this.mediaList.add(new_media);
      
    }

    // In this method we will receive a request to add media object to list.
    public void addMedia() {
        int get_name = 1;
        int select = 0;
        while (get_name == 1) {
        	System.out.println("Hello there! what kind of new media would you like to add?\nEnter:\n[1] for a song.\n[2] for a video.\n[3] to return to menu.");
	        try {
	            select = s.nextInt();
		        s.nextLine();
	        }
	        catch (Exception ex) {
	            System.out.println("this is not a number! goodbye!");
	            s.nextLine();
	            return;
	        }        
            if ((select == 1) || (select == 2)) {
                newMedia(select); // the select will act as a term for newMedia method.
                return;
            }
            else if (select == 3) {
            	System.out.println("see you next time!"); 
                return;
            }
            else
                System.out.println("Input is Not valid!\n please try again.");
        }
        
     }
    
    //////////////////////////////////////////////////////////////////////////
    
    
    @Override
    public void printAll() {
    	this.playAll();
    }

    //////////////////////////////// MENU ////////////////////////////////////
    public void menu() {
    	s = new Scanner(System.in);
        int exit = 0;
        while (exit == 0) {
            System.out.println("******************MediaPlayer Menu******************");
            System.out.println("1. Add new Media");
            System.out.println("2. Play Media by name");
            System.out.println("3. play all Media");
            System.out.println("4. Exit");
            System.out.println("****************************************************");
           
            int func = s.nextInt();
            s.nextLine();

            switch (func) {
            case 1:
                // add new media
            	this.addMedia();
                break;
            case 2:
                // play media
                this.getName();
                break;
            case 3:
                // play all
                this.playAll();
                break;
            case 4:
                // exit
                exit++;
                break;
            default:
                System.out.println("Not valid!");
                break;
            }
            
        }
    s.close();
  }
    //////////////////////////////////////////////////////////////////////////
      
}
