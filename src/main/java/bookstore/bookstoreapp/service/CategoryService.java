package bookstore.bookstoreapp.service;

import bookstore.bookstoreapp.model.Category;
import bookstore.bookstoreapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long customerID) {
        return categoryRepository.findById(customerID);
    }



    public Category CreateCategory(Category category){
        return categoryRepository.save(category);
    }

    public void UpdateCategory(Category category, Long id){
         categoryRepository.save(category);
    }

    public void deleteCategory(Long category_id) {
        categoryRepository.deleteById(category_id);
    }
}
