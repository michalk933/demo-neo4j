package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.repository.ReadRelationshipRepository;
import com.example.demoneo4j.service.ReadRelationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadRelationServiceImpl implements ReadRelationService {

    private final ReadRelationshipRepository repository;

    @Override
    public void createReadRelation(final String readerId, final long bookId){
        repository.addReadRelation(readerId, bookId, LocalDate.now());
    }

}
