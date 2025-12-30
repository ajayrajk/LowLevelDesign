package org.solid.principle.structural.proxy;

public class YoutubeDemo {

    public static void main(String[] args) {
        VideoDownloader downloader=new YoutubeDownloader();
        downloader.downLoading("www.");

        downloader.downLoading("https://youtube.com/watch?v=abc123");
        downloader.downLoading("https://youtube.com/watch?v=abc123"); // same video again
    }
}
