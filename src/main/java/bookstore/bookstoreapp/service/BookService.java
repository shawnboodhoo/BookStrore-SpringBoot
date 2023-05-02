package bookstore.bookstoreapp.service;

import bookstore.bookstoreapp.model.Book;
import bookstore.bookstoreapp.model.Category;
import bookstore.bookstoreapp.repository.BookRepository;
import bookstore.bookstoreapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Book> CreateBook(Long category_id, Book book) {
        return categoryRepository.findById(category_id).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });

    }

    public Optional<Book> UpdateBook(Long category_id, Book book) {
        return categoryRepository.findById(category_id).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });

    }

    public Optional<Book> findBookById(Long book_id) {
        return bookRepository.findById(book_id);
    }

    public Iterable<Book> findBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
         bookRepository.deleteById(id);
    }

    public Iterable<Book> searchBooks(String query){
        return bookRepository.searchBooks(query);
    }

    public Iterable<Book> findByCategoryId(Long id){
        return bookRepository.findByCategoryId(id);
    }

}