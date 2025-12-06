package com.dykyi.toad.repository;

import com.dykyi.toad.entity.Curator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuratorRepository extends MongoRepository<Curator, String> {
}
