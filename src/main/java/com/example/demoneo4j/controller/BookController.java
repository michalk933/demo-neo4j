package com.example.demoneo4j.controller;


import com.example.demoneo4j.model.Book;
import com.example.demoneo4j.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
class BookController {

    private final BookService service;

    @GetMapping("")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable(value = "bookId", required = true) @Valid @NotNull final Long bookId) {
        return service.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId", required = true) @Valid @NotNull final Long bookId) {
        service.delete(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(
            @PathVariable(value = "bookId", required = true) @Valid @NotNull final Long bookId,
            @RequestBody @Valid @NotNull Book book
    ) {
        return service.updateBook(bookId, book);
    }

    @PostMapping
    public Book createBook(@RequestBody @Valid @NotNull Book book) {
        return service.createBook(book);
    }

    @GetMapping("/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable(value = "title", required = true) @Valid @NotNull final String title) {
        return service.getBooksByTitle(title);
    }

}
