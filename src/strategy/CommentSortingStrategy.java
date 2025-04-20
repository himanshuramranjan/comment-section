package strategy;

import models.Comment;

import java.util.List;

public interface CommentSortingStrategy {
    List<Comment> sort(List<Comment> comments);
}
