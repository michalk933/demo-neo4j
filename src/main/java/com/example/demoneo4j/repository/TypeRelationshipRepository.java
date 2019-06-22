package com.example.demoneo4j.repository;

import com.example.demoneo4j.model.Type;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface TypeRelationshipRepository extends Neo4jRepository<Type, Long> {

    @Query("MATCH (b:Book {ISBN: {ISBN}}) MATCH (c:Categories {name: {categoriesName}}) CREATE (c)-[:TYPE {rate: {rate}}]->(b)")
    void addTypeRelation(
            @Param("ISBN") final String ISBN,
            @Param("categoriesName") final String categoriesName,
            @Param("rate") final int rate
    );

    @Query("MATCH ()-[r:TYPE]->() WHERE ID(r)={typeId} SET r.rate={rate} RETURN r")
    int updateRateByTypeId(
            @Param("typeId") final int typeId,
            @Param("rate") final int rate
    );

}
