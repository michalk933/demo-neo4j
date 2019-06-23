package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.aop.LogExecutionAop;
import com.example.demoneo4j.exception.Neo4jException;
import com.example.demoneo4j.model.Book;
import com.example.demoneo4j.repository.BookRepository;
import com.example.demoneo4j.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @LogExecutionAop
    @Override
    public List<Book> getBooks() {
        return repository.getAllBooks();
    }

    @LogExecutionAop
    @Override
    public Book getBook(final long bookId) {
        return repository.getBook(bookId)
                .orElse(new Book());
    }

    @LogExecutionAop
    @Override
    public void delete(final long bookId) {
        repository.deleteBook(bookId);
    }

    @LogExecutionAop
    @Override
    public Book updateBook(final long bookId, final Book book) {
        return repository.updateBook(bookId, book.getTitle(), book.getIsbn(), book.getAuthor())
                .orElseThrow(() -> new Neo4jException("Something wrong during update book, for book: " + bookId));
    }

    @LogExecutionAop
    @Override
    public Book createBook(final Book book) {
        return repository.createBook(book.getTitle(), book.getIsbn(), book.getAuthor())
                .orElseThrow(() -> new Neo4jException("Something wrong during create new book, for book: " + book));
    }

    @LogExecutionAop
    @Override
    public List<Book> getBooksByTitle(final String title) {
        return repository.findByTitle(this.queryFormatTitle(title))
                .orElse(Collections.singletonList(new Book()));
    }

    private String queryFormatTitle(final String title) {
        return String.format("(?i).*%1$s.*", title);
    }

}
