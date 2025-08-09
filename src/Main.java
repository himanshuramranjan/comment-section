import enums.ReactionType;
import models.Comment;
import models.User;
import models.Video;
import service.CommentServiceWithStrategy;
import service.ReactionService;
import service.ReactionServiceImpl;
import strategy.TopCommentsStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User("Alice", "alice@example.com");
        Video video = new Video("Intro to Java");

        CommentServiceWithStrategy commentService = new CommentServiceWithStrategy(new TopCommentsStrategy());

        ReactionService reactionService = new ReactionServiceImpl();

        Comment parent = commentService.addComment("Great video!", user, video, null);
        Comment reply1 = commentService.addComment("Thanks!", user, video, parent);
        Comment reply2 = commentService.addComment("Very helpful.", user, video, null);

        reactionService.addReaction(reply2, user, ReactionType.LIKE);
        reactionService.addReaction(reply2, user, ReactionType.LIKE);
        reactionService.addReaction(reply1, user, ReactionType.LIKE);

        List<Comment> replies = commentService.getReplies(parent);
        replies.forEach(r -> System.out.println(r.getContent()));
        replies.forEach(r -> System.out.println(video.getComments()));

    }
}