package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String s= movieService.addMovie(movie);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String s= movieService.addDirector(director);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")

    public ResponseEntity addMovieDirectorPair(@RequestParam("movie name")String moviename,@RequestParam("directorname")String directorname){
        String s=movieService.addMovieDirectorPair(moviename,directorname);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathParam("name")String name){
    Movie movie=movieService.getMovieByName(name);
    return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity  getDirectorByName(@PathParam("name")String name){

        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity  getMoviesByDirectorName(@PathParam("director")String name){
        List<String>list=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String>list=movieService.findAllMovies();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director’s name")String name){
        String s= movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String s= movieService.deleteAllDirectors();
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }
}
