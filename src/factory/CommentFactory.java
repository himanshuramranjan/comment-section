package factory;

import models.Comment;
import models.User;
import models.Video;

public class CommentFactory {
    public static Comment createComment(String content, User author, Video video, Comment parent) {
        return new Comment(content, author, video, parent);
    }
}
