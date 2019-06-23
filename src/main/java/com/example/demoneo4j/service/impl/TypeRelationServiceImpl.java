package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.aop.LogExecutionAop;
import com.example.demoneo4j.model.TypeCategories;
import com.example.demoneo4j.repository.TypeRelationshipRepository;
import com.example.demoneo4j.service.TypeRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TypeRelationServiceImpl implements TypeRelationService {

    private final TypeRelationshipRepository repository;

    @LogExecutionAop
    @Override
    public void createTypeRelation(final String ISBN, final TypeCategories typeCategories, final int rate) {
        repository.addTypeRelation(ISBN, typeCategories.name(), rate);
    }

    @LogExecutionAop
    @Override
    public int updateRateByTypeId(final int typeId, final int rate) {
        return repository.updateRateByTypeId(typeId, rate);
    }
}
