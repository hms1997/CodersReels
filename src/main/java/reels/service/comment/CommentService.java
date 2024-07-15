package reels.service.comment;

import reels.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> getCommentsByReelId(Long reelId);
    void deleteComment(Long commentId);
}
