package xhemil.learn.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xhemil.learn.App.model.Book;
import xhemil.learn.App.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int Id){
        return ResponseEntity.ok(bookService.get(Id));
    }

    @PostMapping("/api/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        long id = bookService.save(book);
        return ResponseEntity.ok().body("Book created with ID: " + id);
    }

    @PutMapping("api/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id,@RequestBody Book book){
        bookService.update(id, book);
        return ResponseEntity.ok("Book with id " + id + " has been updated successfully");
    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
        bookService.delete(id);
        return ResponseEntity.ok("Book with ID: " + id + " has been deleted");
    }
}
