package com.dykyi.lab13.api;

import com.dykyi.lab13.dto.MovieWithRolesDto;
import com.dykyi.lab13.dto.PersonDto;
import com.dykyi.lab13.model.Person;
import com.dykyi.lab13.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping("/movie/roles/{actorName}")
    public ResponseEntity<List<MovieWithRolesDto>>
    getMoviesWithRolesByActor(@PathVariable String actorName) {
        try {
            return new
                    ResponseEntity<>(actorService.getMoviesByPerson(actorName),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> addActor(@RequestBody PersonDto person) {
        try {
            Person savedPerson = actorService.addActor(person);
            return new ResponseEntity<>("Actor added successfully with ID: " + savedPerson.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/set_acted_in")
    public ResponseEntity<String> setActorInMovie(@RequestParam Long actorId,
                                                  @RequestParam Long movieId,
                                                  @RequestParam List<String> roles) {
        try {
            actorService.addActedInToActor(actorId, movieId, roles);
            return new ResponseEntity<>("Actor roles set successfully in movie: " + movieId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllActors() {
        try {
            return new ResponseEntity<>(actorService.getAllActors(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by_movie")
    public ResponseEntity<List<Person>> getActorsByMovie(@RequestParam Long movieId) {
        try {
            return new ResponseEntity<>(actorService.getActorsByMovie(movieId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

