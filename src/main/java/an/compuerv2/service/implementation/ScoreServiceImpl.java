// Importing packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Score;
import an.compuerv2.repository.ScoreRepository;
import an.compuerv2.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Annotation
@Service
//Implementing MessageService
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }


    @Override
    public List<Score> finAllScore() {
        return (List<Score>) scoreRepository.findAll();
    }

    @Override
    public Optional<Score> findIdScore(Integer idScore) {
        return scoreRepository.findById(idScore);
    }

    @Override
    public Score saveScore(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreFound = scoreRepository.findById(score.getIdScore());
            if (scoreFound.isPresent()) {
                return score;
            } else {
                return scoreRepository.save(score);
            }
        }
    }

    @Override
    public Score updateScore(Score score) {
        if(score.getIdScore()!= null) {
            Optional<Score> scoreFound = scoreRepository.findById(score.getIdScore());
            if (!scoreFound.isEmpty()) {
                if (score.getMessageText() != null) {
                    scoreFound.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    scoreFound.get().setStars(score.getStars());
                }
                return scoreRepository.save(scoreFound.get());
            }
        }
        return score;
    }

    @Override
    public void deleteScore(Integer idScore) {
        scoreRepository.deleteById(idScore);
    }
}
