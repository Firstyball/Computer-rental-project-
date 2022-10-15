package an.compuerv2.repository;

import an.compuerv2.model.Message;
import an.compuerv2.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Class
public interface ScoreRepository extends CrudRepository<Score,Integer> {
}
