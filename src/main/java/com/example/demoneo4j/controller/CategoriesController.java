package com.example.demoneo4j.controller;

import com.example.demoneo4j.model.Categories;
import com.example.demoneo4j.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesService service;

    @GetMapping("/books")
    public List<Categories> getCategoriesWithBook() {
        return service.getCategoriesWithBooks();
    }

    @GetMapping("/{categoriesId}")
    public Categories getCategoriesById(@PathVariable("categoriesId") final long categoriesId) {
        return service.getCategories(categoriesId);
    }

    @GetMapping("/")
    public List<Categories> getCategories() {
        return service.getAllCategories();
    }

}
