package reels.service.reel;

import reels.entities.Reel;
import reels.repository.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReelServiceImpl implements ReelService {
    @Autowired
    private ReelRepository reelRepository;

    @Override
    public Reel saveReel(Reel reel) {
        return reelRepository.save(reel);
    }

    @Override
    public Optional<Reel> getReelById(Long reelId) {
        return reelRepository.findById(reelId);
    }

    @Override
    public List<Reel> getReelsByUserId(Long userId) {
        return reelRepository.findAll().stream()
                .filter(reel -> reel.getUserId()
                        .equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reel> getAllReels() {
        return reelRepository.findAll();
    }

    @Override
    public void deleteReel(Long reelId) {
        reelRepository.deleteById(reelId);
    }
}
