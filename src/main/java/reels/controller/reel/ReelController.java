package reels.controller.reel;

import reels.entities.Reel;
import reels.service.reel.ReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reels")
public class ReelController {
    @Autowired
    private ReelService reelService;

    @PostMapping("/upload")
    public ResponseEntity<Reel> uploadReel(@RequestBody Reel reel) {
        Reel savedReel = reelService.saveReel(reel);
        return ResponseEntity.ok(savedReel);
    }

    @GetMapping("/{reelId}")
    public ResponseEntity<Reel> getReel(@PathVariable Long reelId) {
        Optional<Reel> reel = reelService.getReelById(reelId);
        return reel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // get reels by category
    //get reels by userId
    // Get reels from the favourite content creator

    // Other reel-related endpoints
}