package org.solid.principle.structural.proxy.withproxy;

import org.solid.principle.structural.proxy.YoutubeDownloader;

import java.util.HashSet;
import java.util.Set;

public class YoutubeDownloaderProxy implements  VideoDownloader{
    private YoutubeDownloader realDownloader=new YoutubeDownloader();
    private Set<String> cachedVideos=new HashSet<>();
    @Override
    public void downLoadVideo(String url) {

          if (cachedVideos.contains(url)){
              System.out.println("Fetching video from cache");
          }else {
              realDownloader.downLoading(url);
              cachedVideos.add(url);
              System.out.println("cached video "+url);
          }

    }
}
