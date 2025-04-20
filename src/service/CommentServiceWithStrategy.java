package service;

import factory.CommentFactory;
import models.Comment;
import models.User;
import models.Video;
import strategy.CommentSortingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceWithStrategy implements CommentService {
    private final Map<String, Comment> commentStore = new HashMap<>();
    private CommentSortingStrategy sortingStrategy;

    public void setSortingStrategy(CommentSortingStrategy strategy) {
        this.sortingStrategy = strategy;
    }

    public Comment addComment(String content, User author, Video video, Comment parent) {
        Comment comment = CommentFactory.createComment(content, author, video, parent);
        commentStore.put(comment.getCommentId(), comment);
        if (parent != null) {
            parent.addReply(comment);
        }
        return comment;
    }

    public void deleteComment(Comment comment) {
        comment.delete();
    }

    public void editComment(Comment comment, String newContent) {
        comment.edit(newContent);
    }

    public List<Comment> getReplies(Comment comment) {
        List<Comment> replies = new ArrayList<>(comment.getReplies());
        return sortingStrategy != null ? sortingStrategy.sort(replies) : replies;
    }
}
