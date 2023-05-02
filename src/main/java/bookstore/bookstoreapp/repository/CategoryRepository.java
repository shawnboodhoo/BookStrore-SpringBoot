package bookstore.bookstoreapp.repository;

import bookstore.bookstoreapp.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
