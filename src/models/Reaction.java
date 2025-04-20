package models;

import enums.ReactionType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reaction {
    private final String reactionId;
    private final User user;
    private final ReactionType type;
    private final LocalDateTime timestamp;

    public Reaction(User user, ReactionType type) {
        this.reactionId = UUID.randomUUID().toString();
        this.user = user;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getReactionId() {
        return reactionId;
    }

    public User getUser() {
        return user;
    }

    public ReactionType getType() {
        return type;
    }
}
