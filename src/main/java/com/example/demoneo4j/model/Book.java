package com.example.demoneo4j.model;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity
public class Book {

    @Id
    private Long id;
    private String title;
    private String author;

    @Property("ISBN")
    private String isbn;

}
