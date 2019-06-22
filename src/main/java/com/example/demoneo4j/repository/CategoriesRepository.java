package com.example.demoneo4j.repository;

import com.example.demoneo4j.model.Categories;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends Neo4jRepository<Categories, Long> {

    @Query("MATCH (c:Categories)<-[t:TYPE]-(b:Book) RETURN c,t,b")
    List<Categories> getCategoriesWithBooks();

    @Query("MATCH (c:Categories) WHERE ID(c)={categoriesId} RETURN c")
    Optional<Categories> getCategories(@Param("categoriesId") final long categoriesId);

    @Query("MATCH (c:Categories) RETURN c")
    List<Categories> getAllCategories();

}
