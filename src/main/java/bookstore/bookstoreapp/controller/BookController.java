package bookstore.bookstoreapp.controller;

import bookstore.bookstoreapp.model.Book;
import bookstore.bookstoreapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public Iterable<Book> getAllBooks(){
        return bookService.findBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping("/books/{categoryId}/books")
    public Optional<Book> createBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Book book) {
        return bookService.CreateBook(categoryId, book);
    }

    @PutMapping("/books/{categoryId}/books")
    public Optional<Book> updateBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Book book) {
        return bookService.UpdateBook(categoryId, book);
    }

    @DeleteMapping("book/{id}")
    public void DeleteBook(@PathVariable Long id){
         bookService.deleteBook(id);
    }

    @GetMapping("/searchbooks")
    public Iterable<Book> searchBooks(@RequestParam("query") String query){
        return bookService.searchBooks(query);
    }

    @GetMapping("/categories/{id}")
    public Iterable<Book> findByCategoryId(@PathVariable Long id){
        return bookService.findByCategoryId(id);
    }

}
