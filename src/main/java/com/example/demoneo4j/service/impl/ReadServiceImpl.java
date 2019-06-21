package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.repository.ReadRelationshipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadServiceImpl {

    private final ReadRelationshipRepository repository;

    void createRelation(final String readerId, final long bookId){
        repository.addRelation(readerId, bookId);
    }

}
