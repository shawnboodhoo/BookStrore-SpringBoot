package bookstore.bookstoreapp.controller;

import bookstore.bookstoreapp.model.Category;
import bookstore.bookstoreapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Iterable<Category> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id)  {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public Category createCategory( @RequestBody Category category) {
        return categoryService.CreateCategory(category);
    }

    @PutMapping("/category/{categoryId}")
    public void updateBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category category) {
         categoryService.UpdateCategory(category, categoryId);
    }


    @DeleteMapping("/category/{categoryId}")
    public void DeleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }


}

