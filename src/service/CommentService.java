package service;

import models.Comment;
import models.User;
import models.Video;

import java.util.List;

interface CommentService {
    Comment addComment(String content, User author, Video video, Comment parent);
    void deleteComment(Comment comment);
    void editComment(Comment comment, String newContent);
    List<Comment> getReplies(Comment comment);
}
