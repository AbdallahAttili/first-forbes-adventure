package com.forbes.task.the.first.task.controller;

import com.forbes.task.the.first.task.entity.Actor;
import com.forbes.task.the.first.task.entity.Film;
import com.forbes.task.the.first.task.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/actor") // Base URL for all endpoints in this controller
public class ActorController {

    @Autowired // Automatically injects an instance of ActorService
    private ActorService actorService;

    @PostMapping // Maps HTTP POST requests to this method
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.createActor(actor); // Creates a new actor
    }

    @GetMapping // Maps HTTP GET requests to this method
    public Page<Actor> getAllActors(Pageable pageable) {
        return actorService.getAllActors(pageable); // Returns a list of all actors
    }

    @GetMapping("/{id}") // Maps HTTP GET requests with an ID path variable to this method
    public Optional<Actor> getActorById(@PathVariable String id) {
        return actorService.getActorById(id); // Returns an actor by their ID
    }

    @PutMapping("/{actorId}") // Maps HTTP PUT requests with an actorId path variable to this method
    public void updateActor(@PathVariable String actorId, @RequestBody Actor actor) {
        actorService.updateActor(actorId, actor); // Updates an existing actor
    }

    @DeleteMapping("/{actorId}") // Maps HTTP DELETE requests with an actorId path variable to this method
    public void deleteActorById(@PathVariable String actorId) {
        actorService.deleteActorById(actorId); // Deletes an actor by their ID
    }

    @GetMapping("/actors/{name}/films")
    public Set<Film> getFilmsByActorName(@PathVariable String name) {
        return actorService.getFilmsByActorName(name);
    }
}
