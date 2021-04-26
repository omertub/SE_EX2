package se_ex2;

import java.util.ArrayList;
import java.util.Scanner;

// MediaPlayer application.
public class MediaPlayer implements Application {
    // We choose to implement the Media list using an ArrayList data structure.
    private ArrayList<Media> mediaList;

    // play application, thanks to the Interface inheritance easy to implement.
    public void play(Media media_file) {
        media_file.play();
    }

    // getter.
    public Media getMedia(String name) {
        for (Media m : this.mediaList) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null; // if we reach this point, the media is not exist.
    }

    // using getMedia, we will get the right media object
    public void playMediaByName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your media name:");
        String m = s.nextLine();
        s.nextLine();
        Media find_m = getMedia(m);
        if (find_m == null)
            System.out.println(m + " not exists!");
        else
            find_m.play();
        s.close();
    }

    // Play all media objects in our Media list
    public void playAll() {
        if (this.mediaList.isEmpty()) {
            System.out.println("Media list is EMPTY!!");
            return;
        } else {
            for (Media m : this.mediaList)
                m.play();
        }
    }

    // this method will use the "select" received from the user to add a new media
    // (Song/Video) to the list.
    public void newMedia(int select) {
        Media new_media;
        Scanner s = new Scanner(System.in);

        System.out.println("please enter a Name:");
        String name = s.nextLine();
        System.out.println("please enter length");
        int length = s.nextInt();
        s.nextLine();
        if (select == 1) { // a song
            new_media = new Song(name, length);
        } else { // a video
            new_media = new Video(name, length);
        }
        this.mediaList.add(new_media);
        s.close();
    }

    // In this method we will receive a request to add media object to list.
    public void addMedia() {
        Scanner s = new Scanner(System.in);
        int exit = 0;

        System.out.println(
                "Hello there! what kind of new media would you like to add?\n enter '1' for a song.\n'2' for a video.\n'3' to return to menu.");
        int select = s.nextInt();
        s.nextLine();
        while (exit == 0) {
            if (select == 1 || select == 2)
                newMedia(select); // the select will act as a term for newMedia method.
            else if (select == 3)
                exit++;
            else
                System.out.println("Input is Not valid!\n please try again.");
        }
        s.close();
    }
    
    public void printAll() {
        
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
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
                this.playMediaByName();
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
}
