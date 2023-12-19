package com.example.shareddocs.docs.entity.mongodb;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DocsRepository extends MongoRepository<Docs, String> {
    @Transactional
    void deleteById(String documentId);
}
