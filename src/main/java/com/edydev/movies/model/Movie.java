package com.edydev.movies.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String title;
    private String releaseDate;
    private String poster;
    private List<String> genres;

    @DocumentReference
    private List<Review> reviewIds;

    @JsonCreator
    public Movie(
        @JsonProperty("title") String title, 
        @JsonProperty("releaseDate") String releaseDate, 
        @JsonProperty("poster") String poster, 
        @JsonProperty("genres") List<String> genres
    ){
        this.title = title;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.genres = genres;
    }
}
