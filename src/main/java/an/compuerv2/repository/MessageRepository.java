// Importing packages
package an.compuerv2.repository;

// Importing required classes
import an.compuerv2.model.Client;
import an.compuerv2.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Class
public interface MessageRepository extends CrudRepository<Message,Integer> {
}
