package models;

import java.util.UUID;

public class Video {
    private final String videoId;
    private final String title;

    // other fields


    public Video(String title) {
        this.videoId = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }
}
