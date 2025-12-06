package com.dykyi.lab13.service;

import com.dykyi.lab13.dto.MovieWithRolesDto;
import com.dykyi.lab13.dto.PersonDto;
import com.dykyi.lab13.model.Person;
import com.dykyi.lab13.model.Movie;
import com.dykyi.lab13.model.ActedIn;
import com.dykyi.lab13.repository.PersonRepository;
import com.dykyi.lab13.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;

    public List<MovieWithRolesDto> getMoviesByPerson(String personName) {
        Optional<Person> personOptional =
                personRepository.findByName(personName);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            return person.getActedInMovies()
                    .stream()
                    .map(item -> new
                            MovieWithRolesDto(item.getMovie().getTitle(), item.getRoles()))
                    .toList();
        } else {
            return new ArrayList<>();
        }
    }

    public Person addActor(PersonDto person) {
        return personRepository.save(new Person(person.born(), person.name()));
    }

    public Person addActedInToActor(Long personId, Long movieId, List<String> roles) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        ActedIn actedIn = new ActedIn();
        actedIn.setMovie(movie);
        actedIn.setRoles(roles);
        person.getActedInMovies().add(actedIn);
        return personRepository.save(person);
    }

    public List<Person> getAllActors() {
        return personRepository.findAll();
    }


    public List<Person> getActorsByMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        List<Person> actors = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            for (ActedIn actedIn : person.getActedInMovies()) {
                if (actedIn.getMovie().getId().equals(movieId)) {
                    actors.add(person);
                    break;
                }
            }
        }
        return actors;
    }
}
