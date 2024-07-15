package reels.service.like;

import reels.entities.Like;
import reels.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public List<Like> getLikesByReelId(Long reelId) {
        return likeRepository.findAll().stream()
                .filter(like -> like.getReelId().equals(reelId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
