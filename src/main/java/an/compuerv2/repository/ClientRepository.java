// Importing packages
package an.compuerv2.repository;

// Importing required classes
import an.compuerv2.model.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Class
public interface ClientRepository extends CrudRepository<Client,Integer> {
}
