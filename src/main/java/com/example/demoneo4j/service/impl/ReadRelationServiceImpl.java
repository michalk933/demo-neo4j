package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.aop.LogExecutionAop;
import com.example.demoneo4j.repository.ReadRelationshipRepository;
import com.example.demoneo4j.service.ReadRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
class ReadRelationServiceImpl implements ReadRelationService {

    private final ReadRelationshipRepository repository;

    @LogExecutionAop
    @Override
    public void createReadRelation(final String readerId, final long bookId){
        repository.addReadRelation(readerId, bookId, LocalDate.now());
    }

}
