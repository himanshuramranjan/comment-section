package service;

import enums.ReactionType;
import factory.ReactionFactory;
import models.Comment;
import models.User;

public class ReactionServiceImpl implements ReactionService {
    public void addReaction(Comment comment, User user, ReactionType type) {
        boolean alreadyReacted = comment.getReactions().stream()
                .anyMatch(r -> r.getUser().equals(user) && r.getType() == type);
        if (!alreadyReacted) {
            comment.addReaction(ReactionFactory.createReaction(user, type));
        }
    }
}
