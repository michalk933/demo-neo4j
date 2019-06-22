package com.example.demoneo4j.service;

import com.example.demoneo4j.model.Book;

import java.util.List;

public interface BookService {

    /**
     * Method return all book
     *
     * @return Books
     */
    List<Book> getBooks();

    /**
     * Method return book by id
     *
     * @param bookId book id
     * @return book
     */
    Book getBook(final long bookId);

    /**
     * Method delete book by id
     *
     * @param bookId book id
     */
    void delete(final long bookId);

    /**
     * Method return update book or throw exception Neo4jException
     *
     * @param bookId book id
     * @param book   book data
     * @return book after update
     */
    Book updateBook(final long bookId, final Book book);

    /**
     * Method create new Book or throw exception Neo4jException
     *
     * @param book book data
     * @return book
     */
    Book createBook(final Book book);

    /**
     * Method return books by title or parts title
     *
     * @param title title or parts title
     * @return books
     */
    List<Book> getBooksByTitle(final String title);

}
