package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Video {
    private final String videoId;
    private final String title;
    private final List<Comment> comments;

    public Video(String title) {
        this.videoId = UUID.randomUUID().toString();
        this.title = title;
        this.comments = new ArrayList<>();
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}
