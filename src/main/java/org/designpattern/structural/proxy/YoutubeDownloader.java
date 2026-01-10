package org.designpattern.structural.proxy;

public class YoutubeDownloader implements VideoDownloader{

    @Override
    public void downLoading(String url) {
        System.out.println("connecting youtube");
        System.out.println("Downloading video from youtube "+url);
    }
}
