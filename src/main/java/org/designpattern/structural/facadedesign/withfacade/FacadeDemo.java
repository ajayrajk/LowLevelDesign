package org.designpattern.structural.facadedesign.withfacade;

import org.designpattern.structural.facadedesign.DVDPlayer;
import org.designpattern.structural.facadedesign.Projector;
import org.designpattern.structural.facadedesign.SurroundSound;

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
