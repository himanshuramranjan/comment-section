package factory;

import enums.ReactionType;
import models.Reaction;
import models.User;

public class ReactionFactory {
    public static Reaction createReaction(User user, ReactionType type) {
        return new Reaction(user, type);
    }
}
