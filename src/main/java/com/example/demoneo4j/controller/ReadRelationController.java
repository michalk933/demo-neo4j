package com.example.demoneo4j.controller;

import com.example.demoneo4j.service.ReadRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/relation")
@RequiredArgsConstructor
public class ReadRelationController {

    private final ReadRelationService service;

    @PostMapping("/{readerId}/{bookId}")
    public void createRelation(
            @PathVariable("readerId") final String readerId,
            @PathVariable("bookId") final long bookId
            ){
        service.createReadRelation(readerId, bookId);
    }

}
