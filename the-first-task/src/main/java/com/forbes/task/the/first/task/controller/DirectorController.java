package com.forbes.task.the.first.task.controller;

import com.forbes.task.the.first.task.entity.Director;
import com.forbes.task.the.first.task.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/director") // Base URL for all endpoints in this controller
public class DirectorController {

    @Autowired // Automatically injects an instance of DirectorService
    private DirectorService directorService;

    @GetMapping // Maps HTTP GET requests to this method
    public Page<Director> getAllDirectors(Pageable pageable) {
        return directorService.getAllDirectors(pageable); // Returns a list of all directors
    }

    @GetMapping("/{directorId}") // Maps HTTP GET requests with a directorId path variable to this method
    public Optional<Director> getDirectorById(@PathVariable String directorId) {
        return directorService.getDirectorById(directorId); // Returns a director by their ID
    }

    @PostMapping // Maps HTTP POST requests to this method
    public Director createDirector(@RequestBody Director director) {
        return directorService.createDirector(director); // Creates a new director
    }

    @PutMapping("/{directorId}") // Maps HTTP PUT requests with a directorId path variable to this method
    public void updateDirector(@PathVariable String directorId, @RequestBody Director newDirector) {
        directorService.updateDirector(directorId, newDirector); // Updates an existing director
    }

    @DeleteMapping("/{directorId}") // Maps HTTP DELETE requests with a directorId path variable to this method
    public void deleteDirectorById(@PathVariable String directorId) {
        directorService.deleteDirectorById(directorId); // Deletes a director by their ID
    }
}
