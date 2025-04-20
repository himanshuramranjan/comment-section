package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comment {
    private final String commentId;
    private String content;
    private final User author;
    private final Video video;
    private LocalDateTime timestamp;
    private boolean isDeleted;
    private final Comment parent;
    private final List<Comment> replies;
    private final List<Reaction> reactions;

    public Comment(String content, User author, Video video, Comment parent) {
        this.commentId = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.video = video;
        this.parent = parent;
        this.replies = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.isDeleted = false;
    }

    public void edit(String newContent) {
        this.content = newContent;
        this.timestamp =  LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
    }

    public void addReply(Comment comment) {
        replies.add(comment);
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
    }

    public String getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }
}
