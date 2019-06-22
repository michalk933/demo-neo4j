package com.example.demoneo4j.repository;

import com.example.demoneo4j.model.Book;
import com.example.demoneo4j.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends Neo4jRepository<Book, Long> {

    @Query("MATCH (b:Book) RETURN b")
    List<Book> getAllBooks();

    @Query("MATCH (b) WHERE ID(b)={bookId} RETURN b")
    Optional<Book> getBook(@Param("bookId") final long bookId);

    @Query("CREATE (b :Book {title: {title}, ISBN: {isbn}, author: {author}}) RETURN b")
    Optional<Book> createBook(
            @Param("title") final String title,
            @Param("isbn") final String isbn,
            @Param("author") final String author
            );

    @Query("MATCH (b) WHERE ID(b)={bookId} DETACH DELETE b")
    void deleteBook(@Param("bookId") final long bookId);

    @Query("MATCH (b) WHERE ID(b)={bookId} SET b = {title: {title}, ISBN: {isbn}, author: {author}} RETURN b")
    Optional<Book> updateBook(
            @Param("bookId") final long bookId,
            @Param("title") final String title,
            @Param("isbn") final String isbn,
            @Param("author") final String author
    );

    @Query("MATCH (b:Book) WHERE (b.title=~'(?i).*{title}.*') RETURN b ")
    Optional<List<Book>> findByTitle(@Param("title") final String title);

}
