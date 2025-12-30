package org.solid.principle.structural.proxy.withproxy;

public class YoutubeDownloader implements  VideoDownloader
{
    @Override
    public void downLoadVideo(String url) {
        System.out.println("connecting youtube");
        System.out.println("Downloading video from youtube "+url);
    }
}
