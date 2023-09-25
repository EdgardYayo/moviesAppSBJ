package com.edydev.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edydev.movies.model.Movie;
import com.edydev.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.AllMovies(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")   
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

    // I couldn't get this method to work
    // @PostMapping("/new")
    // public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
    //     return new ResponseEntity<String>(
    //         movieService.createMovie(
    //             movie.getTitle(), 
    //             movie.getReleaseDate(),
    //             movie.getPoster(), 
    //             movie.getGenres()
    //             ), HttpStatus.OK);
    // }


}
