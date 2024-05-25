package com.forbes.task.the.first.task.repository;

import com.forbes.task.the.first.task.entity.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a repository component in Spring Boot
public interface ActorRepository extends MongoRepository<Actor, String> {
    // This interface provides CRUD operations for the Actor entity

}
