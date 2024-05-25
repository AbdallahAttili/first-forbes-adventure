package com.forbes.task.the.first.task.service;

import com.forbes.task.the.first.task.entity.Actor;
import com.forbes.task.the.first.task.entity.Film;
import com.forbes.task.the.first.task.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service // Marks this class as a service component in Spring
public class ActorService {

    @Autowired // Automatically injects an instance of ActorRepository
    private ActorRepository actorRepository;

    // Creates a new actor and saves it to the database
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // Retrieves a paginated list of all actors from the database
    public Page<Actor> getAllActors(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    // Retrieves an actor by their ID
    public Optional<Actor> getActorById(String actorId) {
        return actorRepository.findById(actorId);
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void updateActor(String actorId, Actor newActor) {
        if (actorRepository.existsById(actorId)) {
            actorRepository.deleteById(actorId); // Deletes the existing actor
            actorRepository.save(newActor); // Saves the new actor
        } else {
            throw new IllegalArgumentException("Actor with id " + actorId + " not found!");
        }
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void deleteActorById(String actorId) {
        actorRepository.deleteById(actorId); // Deletes an actor by their ID
    }

    public Set<Film> getFilmsByActorName(String actorName) {
        Actor actor = actorRepository.findByName(actorName);
        return actor != null ? actor.getFilms() : null;
    }
}
