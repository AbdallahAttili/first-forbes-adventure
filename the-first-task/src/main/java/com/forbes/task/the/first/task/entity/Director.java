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
@Document(collection = "directors") // Specifies the MongoDB collection name for this entity
public class Director {

    @Id // Marks this field as the primary key
    private String directorId; // Unique identifier for the director
    private String name; // Director's name
    private int age; // Director's age
    private String nickName; // Director's nickname
    private LocalDateTime birthDate; // Director's birth date
    private String nationality; // Director's nationality
    private String photoUrl; // URL to the director's photo
    @DBRef // Specifies a reference to another document
    private Set<Film> films; // Set of films the director has directed
}
