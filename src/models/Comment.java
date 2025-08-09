package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Comment {
    private final String commentId;
    private String content;
    private final User author;
    private LocalDateTime timestamp;
    private boolean isPrivate;
    private final Comment parent;
    private final List<Comment> replies;
    private final List<Reaction> reactions;

    public Comment(String content, User author,  Comment parent) {
        this.commentId = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.parent = parent;
        this.replies = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.isPrivate = false;
        this.timestamp = LocalDateTime.now();
    }

    public void edit(String newContent) {
        this.content = newContent;
        this.timestamp =  LocalDateTime.now();
    }

    public void makePrivate() {
        this.isPrivate = true;
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

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", author=" + author +
                ", timestamp=" + timestamp +
                '}';
    }
}
