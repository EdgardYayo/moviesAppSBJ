package com.edydev.movies.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.edydev.movies.model.Movie;
import com.edydev.movies.model.Review;
import com.edydev.movies.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String body, ObjectId id) {
        Review review = reviewRepository.insert(new Review(body));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviewIds").value(review));

        return review;
    }
}
