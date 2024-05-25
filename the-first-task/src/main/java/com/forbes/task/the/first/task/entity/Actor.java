package com.forbes.task.the.first.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Data // Lombok annotation to generate getters, setters, equals, hash, and toString methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all properties
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Document(collection = "actors") // Specifies the MongoDB collection name for this entity
public class Actor {

    @Id // Marks this field as the primary key
    private String actorId; // Unique identifier for the actor
    private String name; // Actor's name
    private int age; // Actor's age
    private String nickName; // Actor's nickname
    private String nationality; // Actor's nationality
    private LocalDateTime birthDate; // Actor's birth date
    private String photoUrl; // URL to the actor's photo
    @DBRef // Specifies a reference to another document
    Set<Film> films; // Set of films the actor has acted in
}
