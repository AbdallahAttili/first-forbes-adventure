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
@Document(collection = "films") // Specifies the MongoDB collection name for this entity
public class Film {

    @Id // Marks this field as the primary key
    private String filmId; // Unique identifier for the film
    private String name; // Name of the film
    private String description; // Description of the film
    private String size; // Size of the film (e.g., file size)
    private LocalDateTime uploadDate; // Date and time when the film was uploaded
    private LocalDateTime lastModifiedDate; // Date and time when the film was last modified
    @DBRef // Specifies a reference to another document
    Set<Actor> actors; // Set of actors who acted in the film
    @DBRef // Specifies a reference to another document
    Set<Director> directors; // Set of directors who directed the film
}
