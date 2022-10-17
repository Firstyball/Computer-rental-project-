// Importing required packages
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Message;
import an.compuerv2.model.Score;
import an.compuerv2.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {


    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    // Read operation
    @GetMapping("/all")
    public List<Score> finAllScore() {
        return scoreService.finAllScore();
    }

    @GetMapping("/all/{idScore}")
    public Optional<Score> findIdScore(@PathVariable("idScore")Integer idScore) {
        return scoreService.findIdScore(idScore);
    }

    // Save operation
    @PostMapping("/save")
    public Score saveScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    // Update operation
    @PutMapping("/update")
    public Score updateScore(@RequestBody Score score)
    {
        return scoreService.updateScore(score);
    }
    // Delete operation
    @DeleteMapping("/{idScore}")
    public void deleteScore(@PathVariable("idScore")Integer idScore) {
        scoreService.deleteScore(idScore);
    }
}
