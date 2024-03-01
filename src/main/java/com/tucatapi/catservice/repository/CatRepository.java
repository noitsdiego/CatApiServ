package com.tucatapi.catservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tucatapi.catservice.model.CatModel;

@Repository
public interface CatRepository extends MongoRepository<CatModel, String> {
}
