package org.solid.principle.structural.facadedesign.withfacade;

import org.solid.principle.structural.facadedesign.DVDPlayer;
import org.solid.principle.structural.facadedesign.Projector;
import org.solid.principle.structural.facadedesign.SurroundSound;

public class HomeTheaterFacade {
     private DVDPlayer dvdPlayer;
     private Projector projector;
     private SurroundSound surroundSound;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SurroundSound surroundSound) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.surroundSound = surroundSound;
    }

    void watchMovie(String movie){
        System.out.println("Get ready to watch a movie");
        dvdPlayer.on();
        projector.on();
        projector.setInput("DVD input");
        surroundSound.on();;
        surroundSound.setVolume(8);
        dvdPlayer.play(movie);
        System.out.println("Enjoy the movie");
    }

    void endMovie(){
        System.out.println("Shutting down the home theater");
        dvdPlayer.off();
        projector.off();
        surroundSound.off();
    }


}
