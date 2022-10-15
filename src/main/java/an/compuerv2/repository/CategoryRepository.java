// Importing packages
package an.compuerv2.repository;

// Importing required classes
import an.compuerv2.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



// Annotation
@Repository
// Class
public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
