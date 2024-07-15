package reels.service.like;

import reels.entities.Like;

import java.util.List;

public interface LikeService {
    Like saveLike(Like like);
    List<Like> getLikesByReelId(Long reelId);
    void deleteLike(Long likeId);
}
