package service;

import models.Comment;
import models.User;
import models.Video;
import strategy.CommentSortingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceWithStrategy implements CommentService {
    private final Map<String, Comment> commentStore;
    private CommentSortingStrategy sortingStrategy;

    public CommentServiceWithStrategy(CommentSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
        this.commentStore = new HashMap<>();
    }

    public void setSortingStrategy(CommentSortingStrategy strategy) {
        this.sortingStrategy = strategy;
    }

    public Comment addComment(String content, User author, Video video, Comment parent) {
        Comment comment = new Comment(content, author, parent);
        commentStore.put(comment.getCommentId(), comment);
        if (parent != null) {
            parent.addReply(comment);
        } else {
            video.addComment(comment);
        }
        return comment;
    }

    public void privatiseComment(Comment comment) {
        comment.makePrivate();
    }

    public void editComment(Comment comment, String newContent) {
        comment.edit(newContent);
    }

    public List<Comment> getReplies(Comment comment) {
        List<Comment> replies = new ArrayList<>(comment.getReplies());
        return sortingStrategy != null ? sortingStrategy.sort(replies) : replies;
    }

    public Map<String, Comment> getCommentStore() {
        return commentStore;
    }

    public CommentSortingStrategy getSortingStrategy() {
        return sortingStrategy;
    }
}
