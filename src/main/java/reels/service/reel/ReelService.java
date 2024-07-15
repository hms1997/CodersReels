package reels.service.reel;

import reels.entities.Reel;

import java.util.List;
import java.util.Optional;

public interface ReelService {
    Reel saveReel(Reel reel);
    Optional<Reel> getReelById(Long reelId);
    List<Reel> getReelsByUserId(Long userId);
    List<Reel> getAllReels();
    void deleteReel(Long reelId);
}