package com.example.shareddocs.docs.entity.mongodb;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocsRepository extends MongoRepository<Docs, String> {

    Optional<Docs> findByRoomIdx(String roomIdx);
}
