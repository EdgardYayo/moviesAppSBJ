package com.edydev.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edydev.movies.model.Movie;
import com.edydev.movies.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired  // Instead of create a constructor to initialize this class we can use the annotation @Autowired
    private MovieRepository movieRepository;


    public List<Movie> AllMovies() {
        return movieRepository.findAll();
    } 


    // The Optional class serves as a guidance for java or spring to tell it hey maybe this is null
    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public String createMovie(String title, String releaseDate, String poster, List<String> genres) {
        Movie movie = movieRepository.insert(new Movie(title, releaseDate, poster, genres));
        return "Created Successfully";
    }
    
}
