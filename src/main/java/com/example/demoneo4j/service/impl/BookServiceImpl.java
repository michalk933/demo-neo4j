package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.exception.Neo4jException;
import com.example.demoneo4j.model.Book;
import com.example.demoneo4j.repository.BookRepository;
import com.example.demoneo4j.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public List<Book> getBooks() {
        return repository.getAllBooks();
    }

    @Override
    public Book getBook(final long bookId) {
        return repository.getBook(bookId)
                .orElse(new Book());
    }

    @Override
    public void delete(final long bookId) {
        repository.deleteBook(bookId);
    }

    @Override
    public Book updateBook(final long bookId, final Book book) {
        return repository.updateBook(bookId, book.getTitle(), book.getIsbn(), book.getAuthor())
                .orElseThrow(() -> new Neo4jException("Something wrong during update book, for book: " + bookId));
    }

    @Override
    public Book createBook(final Book book) {
        return repository.createBook(book.getTitle(), book.getIsbn(), book.getAuthor())
                .orElseThrow(() -> new Neo4jException("Something wrong during create new book, for book: " + book));
    }

    @Override
    public List<Book> getBooksByTitle(final String title) {
        return repository.findByTitle(title)
                .orElse(Collections.singletonList(new Book()));
    }

}
