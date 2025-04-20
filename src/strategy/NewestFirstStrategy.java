package strategy;

import models.Comment;

import java.util.Comparator;
import java.util.List;

public class NewestFirstStrategy implements CommentSortingStrategy {
    public List<Comment> sort(List<Comment> comments) {
        comments.sort(Comparator.comparing(Comment::getTimestamp).reversed());
        return comments;
    }
}
