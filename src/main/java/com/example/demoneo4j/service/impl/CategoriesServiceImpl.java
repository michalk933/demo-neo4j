package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.aop.LogExecutionAop;
import com.example.demoneo4j.exception.Neo4jException;
import com.example.demoneo4j.model.Categories;
import com.example.demoneo4j.repository.CategoriesRepository;
import com.example.demoneo4j.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository repository;

    @LogExecutionAop
    @Override
    public List<Categories> getCategoriesWithBooks() {
        return repository.getCategoriesWithBooks();
    }

    @LogExecutionAop
    @Override
    public Categories getCategories(final long categoriesId) {
        return repository.getCategories(categoriesId)
                .orElseThrow(() -> new Neo4jException("Something wrong during get categories by id: " + categoriesId));
    }

    @LogExecutionAop
    @Override
    public List<Categories> getAllCategories() {
        return repository.getAllCategories();
    }
}
