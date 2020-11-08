package com.example.BlogMe.repositories;

import com.example.BlogMe.entities.Content;

import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends CrudRepository<Content,Integer>{
    
}
