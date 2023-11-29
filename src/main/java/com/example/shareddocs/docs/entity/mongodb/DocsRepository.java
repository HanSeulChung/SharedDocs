package com.example.shareddocs.docs.entity.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocsRepository extends MongoRepository<Docs, String> {

}
