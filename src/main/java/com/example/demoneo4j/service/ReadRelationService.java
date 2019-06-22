package com.example.demoneo4j.service;

public interface ReadRelationService {

    /**
     * Method create relation between book and user
     *
     * @param readerId reade id
     * @param bookId book id
     */
    void createReadRelation(final String readerId, final long bookId);

}
