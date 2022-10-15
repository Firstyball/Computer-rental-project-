// Importing packages modules
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Category;
import an.compuerv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@RestController
@RequestMapping("/api/Category")
// Class
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Read operations
    @GetMapping("/all")
    public List<Category> finAllCategory() {
        return categoryService.finAllCategory();
    }

    @GetMapping("/all/{id}")
    public Optional<Category> findIdCategory(@PathVariable("id")Integer id) {
        return categoryService.findIdCategory(id);
    }

    // Save operation
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Update operation
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id")Integer id) {
        categoryService.deleteCategory(id);
    }





}
