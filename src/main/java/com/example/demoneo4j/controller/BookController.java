package com.example.demoneo4j.controller;


import com.example.demoneo4j.model.Book;
import com.example.demoneo4j.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {


    private final BookService service;

    @GetMapping("")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") final long bookId) {
        return service.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") final long bookId) {
        service.delete(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(
            @PathVariable("bookId") final long bookId,
            @RequestBody Book book
    ) {
        return service.updateBook(bookId, book);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable("title") final String title) {
        return service.getBooksByTitle(title);
    }

}
