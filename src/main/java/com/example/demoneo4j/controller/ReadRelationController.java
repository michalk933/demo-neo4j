package com.example.demoneo4j.controller;

import com.example.demoneo4j.service.ReadRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/relation")
@RequiredArgsConstructor
class ReadRelationController {

    private final ReadRelationService service;

    @PostMapping("/{readerId}/{bookId}")
    public void createRelation(
            @PathVariable("readerId") @Valid @NotBlank final String readerId,
            @PathVariable("bookId") @Valid @NotNull final Long bookId
    ) {
        service.createReadRelation(readerId, bookId);
    }

}
