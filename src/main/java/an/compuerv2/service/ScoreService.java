// Importing packages
package an.compuerv2.service;

// Importing required classes


import an.compuerv2.model.Message;
import an.compuerv2.model.Score;

import java.util.List;
import java.util.Optional;

// Class
public interface ScoreService {

    // Save operation
    List<Score> finAllScore();

    // Read operations
    Optional<Score> findIdScore(Integer idScore);

    Score saveScore(Score score);

    // Update operation
    Score updateScore(Score score);

    // Delete operation
    void deleteScore(Integer idScore);
}
