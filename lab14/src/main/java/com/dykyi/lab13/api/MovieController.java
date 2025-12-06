package com.dykyi.lab13.api;

import com.dykyi.lab13.dto.MovieDto;
import com.dykyi.lab13.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        try {
            return new ResponseEntity<>(movieService.getAllMovies(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by_year")
    public ResponseEntity<List<MovieDto>> getMoviesByYear(@RequestParam int year) {
        try {
            return new ResponseEntity<>(movieService.getMoviesByYear(year),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto) {
        try {
            MovieDto savedMovie = movieService.addMovie(movieDto);
            return new ResponseEntity<>("Movie added successfully with ID: " + savedMovie.id(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}