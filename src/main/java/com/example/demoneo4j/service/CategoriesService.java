package com.example.demoneo4j.service;

import com.example.demoneo4j.model.Categories;

import java.util.List;

public interface CategoriesService {

    /**
     * Method return list categories with books
     *
     * @return categories
     */
    List<Categories> getCategoriesWithBooks();

    /**
     * Method return categories by id
     *
     * @param categoriesId category id
     * @return categories
     */
    Categories getCategories(final long categoriesId);

    /**
     * Method return all categories
     *
     * @return categories
     */
    List<Categories> getAllCategories();

}
