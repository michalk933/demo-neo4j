package com.example.demoneo4j.controller;

import com.example.demoneo4j.model.TypeCategories;
import com.example.demoneo4j.service.TypeRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/type")
@RequiredArgsConstructor
class TypeRelationshipController {

    private final TypeRelationService service;

    @PostMapping("/{ISBN}/{typeCategories}/{rate}")
    public void createTypeRelation(
            @PathVariable("ISBN") @Valid @NotNull final String ISBN,
            @PathVariable("typeCategories") @Valid @NotNull final TypeCategories typeCategories,
            @PathVariable("rate") @Valid @NotNull final Integer rate
    ) {
        service.createTypeRelation(ISBN, typeCategories, rate);
    }

    @PutMapping("/{typeId}/{rate}")
    public int updateRate(
            @PathVariable("typeId") @Valid @NotNull final Integer typeId,
            @PathVariable("rate") @Valid @NotNull final Integer rate
    ) {
        return service.updateRateByTypeId(typeId, rate);
    }

}
