package com.forbes.task.the.first.task.service;

import com.forbes.task.the.first.task.entity.Film;
import com.forbes.task.the.first.task.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service // Marks this class as a service component in Spring Boot
public class FilmService {

    @Autowired // Automatically injects an instance of FilmRepository
    FilmRepository filmRepository;

    // Creates a new film and saves it to the database
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    // Retrieves a paginated list of all films from the database
    public Page<Film> getAllFilms(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    // Retrieves a film by its ID
    public Optional<Film> getFilmById(String filmId) {
        return filmRepository.findById(filmId);
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void updateFilm(String filmId, Film newFilm) {
        if (filmRepository.existsById(filmId)) {
            filmRepository.deleteById(filmId); // Deletes the existing film
            filmRepository.save(newFilm); // Saves the new film
        } else {
            throw new IllegalArgumentException("This id " + filmId + " can't be found!");
        }
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void deleteFilmById(String filmId) {
        filmRepository.deleteById(filmId); // Deletes a film by its ID
    }
}
