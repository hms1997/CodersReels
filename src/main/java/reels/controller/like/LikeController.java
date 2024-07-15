package reels.controller.like;

import reels.entities.Like;
import reels.service.like.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/add")
    public ResponseEntity<Like> addLike(@RequestBody Like like) {
        Like savedLike = likeService.saveLike(like);
        return ResponseEntity.ok(savedLike);
    }

    @GetMapping("/reel/{reelId}")
    public ResponseEntity<List<Like>> getLikesByReelId(@PathVariable Long reelId) {
        List<Like> likes = likeService.getLikesByReelId(reelId);
        return ResponseEntity.ok(likes);
    }

    @DeleteMapping("/delete/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.noContent().build();
    }
}

