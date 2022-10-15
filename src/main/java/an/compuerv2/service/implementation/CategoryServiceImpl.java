// Importing required packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Category;
import an.compuerv2.repository.CategoryRepository;
import an.compuerv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

//Annotation
@Service
//Implementing ComputerService
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Read operations
    @Override
    public List<Category> finAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findIdCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    // Save operation
    /*
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
        public Category saveCategory(Category category){
        if(category.getIdClient() != null){
            Optional<Category> temp = categoryRepository.findById(category.getIdClient());
            if( temp.isEmpty() )
                if(category.getName() != null && category.getDescription() != null )
                    return categoryRepository.save(category);
                else
                    return category;
            else
                return category;
        }
        else
            return category;
    }
     @Override
    public Category saveCategory(@NotNull @NotBlank Category category){

        if(category.getName() != null && category.getDescription() != null){
                    return categoryRepository.save(category);}
                else
                    return category;
        }
    */
    @Override
    public Category saveCategory(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> categoryFound = categoryRepository.findById(category.getId());
            if (categoryFound.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }



    // Update operation
    /*
    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
     public Category updateCategory(Category category){
        if(category.getIdClient() != null){
            Optional<Category> temp = categoryRepository.findById( category.getIdClient() );
            if( !temp.isEmpty() ){
                if(category.getName() != null)
                    temp.get().setName( category.getName() );
                if(category.getDescription() != null)
                    temp.get().setDescription( category.getDescription() );
                return categoryRepository.save( temp.get() );
            }
            else
                return category;
        }
        else
            return category;
    }
    */
    @Override
    public Category updateCategory(Category category) {
        if (category.getId() != null) {
            Optional<Category> categoryFound = categoryRepository.findById(category.getId());
            if (!categoryFound.isEmpty()) {
                if (category.getDescription() != null) {
                    categoryFound.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    categoryFound.get().setName(category.getName());
                }
                return categoryRepository.save(categoryFound.get());
            }
        }
        return category;
    }

    // Delete operation
    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }


}
