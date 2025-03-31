package com.mitesh.libraryManageSys.controller;

import com.mitesh.libraryManageSys.entity.Book;
import com.mitesh.libraryManageSys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("getallbooks")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("getbook/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("addbook")
    public Book addBook(@RequestBody Book book)  {
        return bookService.save(book);
    }

    @PutMapping("updatebook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {

        return bookService.save(book);
    }

    @DeleteMapping("deletebook/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("returnbook/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
