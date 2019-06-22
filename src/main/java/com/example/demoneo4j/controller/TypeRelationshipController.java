package com.example.demoneo4j.controller;

import com.example.demoneo4j.model.TypeCategories;
import com.example.demoneo4j.service.TypeRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/type")
@RequiredArgsConstructor
public class TypeRelationshipController {

    private final TypeRelationService service;

    @PostMapping("/{ISBN}/{typeCategories}/{rate}")
    public void createTypeRelation(
            @PathVariable("ISBN") final String ISBN,
            @PathVariable("typeCategories") final TypeCategories typeCategories,
            @PathVariable("rate") final int rate
    ) {
        service.createTypeRelation(ISBN, typeCategories, rate);
    }

    @PutMapping("/{typeId}/{rate}")
    public int updateRate(
            @PathVariable("typeId") final int typeId,
            @PathVariable("rate") final int rate
    ) {
        return service.updateRateByTypeId(typeId, rate);
    }

}
