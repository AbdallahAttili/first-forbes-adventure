package com.forbes.task.the.first.task.controller;

import com.forbes.task.the.first.task.entity.Film;
import com.forbes.task.the.first.task.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/film") // Base URL for all endpoints in this controller
public class FilmController {

    @Autowired // Automatically injects an instance of FilmService
    private FilmService filmService;

    @GetMapping // Maps HTTP GET requests to this method
    public Page<Film> getAllFilms(Pageable pageable) {
        return filmService.getAllFilms(pageable); // Returns a list of all films
    }

    @GetMapping("/{filmId}") // Maps HTTP GET requests with a filmId path variable to this method
    public Optional<Film> getFilmById(@PathVariable String filmId) {
        return filmService.getFilmById(filmId); // Returns a film by its ID
    }

    @PostMapping // Maps HTTP POST requests to this method
    public Film createFilm(@RequestBody Film film) {
        return filmService.createFilm(film); // Creates a new film
    }

    @PutMapping("/{filmId}") // Maps HTTP PUT requests with a filmId path variable to this method
    public void updateFilm(@PathVariable String filmId, @RequestBody Film newFilm) {
        filmService.updateFilm(filmId, newFilm); // Updates an existing film
    }

    @DeleteMapping("/{filmId}") // Maps HTTP DELETE requests with a filmId path variable to this method
    public void deleteFilmById(@PathVariable String filmId) {
        filmService.deleteFilmById(filmId); // Deletes a film by its ID
    }

    /*
    @GetMapping
    public getAllFilmsForCertainDirector(@RequestBody Director director) {
    }

    @GetMapping
    public getAllFilmsForCertainActor(@RequestBody Actor actor) {
    }
    */
}
