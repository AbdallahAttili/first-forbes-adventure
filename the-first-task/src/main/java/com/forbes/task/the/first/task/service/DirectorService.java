package com.forbes.task.the.first.task.service;

import com.forbes.task.the.first.task.entity.Director;
import com.forbes.task.the.first.task.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service // Marks this class as a service component in Spring Boot
public class DirectorService {

    @Autowired // Automatically injects an instance of DirectorRepository
    private DirectorRepository directorRepository;

    // Creates a new director and saves it to the database
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    // Retrieves a paginated list of all directors from the database
    public Page<Director> getAllDirectors(Pageable pageable) {
        return directorRepository.findAll(pageable);
    }

    // Retrieves a director by their ID
    public Optional<Director> getDirectorById(String directorId) {
        return directorRepository.findById(directorId);
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void updateDirector(String directorId, Director newDirector) {
        if (directorRepository.existsById(directorId)) {
            directorRepository.deleteById(directorId); // Deletes the existing director
            directorRepository.save(newDirector); // Saves the new director
        } else {
            throw new IllegalArgumentException("This director id " + directorId + " Can't be found!");
        }
    }

    @Transactional // Ensures that the operation is atomic and consistent
    public void deleteDirectorById(String directorId) {
        directorRepository.deleteById(directorId); // Deletes a director by their ID
    }
}
