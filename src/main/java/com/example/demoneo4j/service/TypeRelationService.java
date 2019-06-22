package com.example.demoneo4j.service;

import com.example.demoneo4j.model.TypeCategories;

public interface TypeRelationService {

    /**
     * Method create new relation TYPE for Categories and Book
     *
     * @param ISBN isbn
     * @param typeCategories type categories
     * @param rate rate book
     */
    void createTypeRelation(final String ISBN, final TypeCategories typeCategories, final int rate);

    /**
     * Method update rate for book
     *
     * @param typeId type id
     * @param rate rate
     * @return new rate
     */
    int updateRateByTypeId(final int typeId, final int rate);

}
