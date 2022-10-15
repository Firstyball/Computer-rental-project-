// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Category;
import java.util.List;
import java.util.Optional;

// Class
public interface CategoryService {

    // Save operation
    List<Category> finAllCategory();

    // Read operations
    Optional<Category> findIdCategory (Integer id);

    Category saveCategory(Category category);

    // Update operation
    Category updateCategory(Category category);

    // Delete operation
    void deleteCategory(Integer id);

}
