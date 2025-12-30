package org.solid.principle.structural.facadedesign.withfacade;

import org.solid.principle.structural.facadedesign.DVDPlayer;
import org.solid.principle.structural.facadedesign.Projector;
import org.solid.principle.structural.facadedesign.SurroundSound;

public class FacadeDemo {

    public static void main(String[] args) {
        DVDPlayer dvdPlayer=new DVDPlayer();
        Projector projector=new Projector();
        SurroundSound sound=new SurroundSound();
        HomeTheaterFacade homeTheaterFacade=new HomeTheaterFacade(dvdPlayer,projector,sound);

        homeTheaterFacade.watchMovie("Inception");
        homeTheaterFacade.endMovie();
    }
}
