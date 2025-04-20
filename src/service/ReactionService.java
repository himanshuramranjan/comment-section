package service;

import enums.ReactionType;
import models.Comment;
import models.User;

public interface ReactionService {
    void addReaction(Comment comment, User user, ReactionType type);
}
