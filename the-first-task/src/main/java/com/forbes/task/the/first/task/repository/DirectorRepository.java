package com.forbes.task.the.first.task.repository;

import com.forbes.task.the.first.task.entity.Director;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a repository component in Spring
public interface DirectorRepository extends MongoRepository<Director, String> {
    // This interface provides CRUD operations for the Director entity
}
