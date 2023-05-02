package bookstore.bookstoreapp.repository;

import bookstore.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)

    Iterable<Book> searchBooks(String query);

    Iterable<Book> findByCategoryId(Long categoryId);

}
