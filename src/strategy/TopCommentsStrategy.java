package strategy;

import enums.ReactionType;
import models.Comment;

import java.util.List;

public class TopCommentsStrategy implements CommentSortingStrategy {
    public List<Comment> sort(List<Comment> comments) {
        comments.sort((c1, c2) -> Long.compare(
                c2.getReactions().stream().filter(r -> r.getType() == ReactionType.LIKE).count(),
                c1.getReactions().stream().filter(r -> r.getType() == ReactionType.LIKE).count()
        ));
        return comments;
    }
}
