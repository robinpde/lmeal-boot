package com.hov.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hov.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
