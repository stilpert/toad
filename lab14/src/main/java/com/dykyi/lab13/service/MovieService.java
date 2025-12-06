package com.dykyi.lab13.service;

import com.dykyi.lab13.dto.MovieDto;
import com.dykyi.lab13.model.Movie;
import com.dykyi.lab13.model.Person;
import com.dykyi.lab13.repository.MovieRepository;
import com.dykyi.lab13.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(item -> new MovieDto(
                        item.getId(),
                        item.getTitle(),
                        item.getTagline(),
                        item.getReleased()))
                .toList();
    }

    public List<MovieDto> getMoviesByYear(int year) {
        return movieRepository.findByReleased(year)
                .stream()
                .map(item -> new MovieDto(
                        item.getId(),
                        item.getTitle(),
                        item.getTagline(),
                        item.getReleased()))
                .toList();
    }

    public MovieDto addMovie(MovieDto movieDto) {
        Movie save = movieRepository.save(
                new Movie(
                        movieDto.title(),
                        movieDto.tagline(),
                        movieDto.released()
                )
        );
        return new MovieDto(
                save.getId(),
                save.getTitle(),
                save.getTagline(),
                save.getReleased()
        );
    }
}
