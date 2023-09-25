package com.edydev.movies.controller;




import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edydev.movies.model.Review;
import com.edydev.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody String body, ObjectId id) {
        return new ResponseEntity<Review>(reviewService.createReview(body, id), HttpStatus.CREATED);
    }
}
