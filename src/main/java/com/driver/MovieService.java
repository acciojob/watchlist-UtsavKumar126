package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        String s=movieRepository.addMovie(movie);
        return s;
    }

    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movie,String director){

        Director d2=null;
        Movie m2=null;

        for(Movie m: movieRepository.movieSet){
            if(m.getName().equals(movie)){
                m2=m;
                break;
            }
        }
        for(Director d: movieRepository.directorSet){
            if(d.getName().equals(director)){
                d2=d;
                break;
            }
        }
        String s=movieRepository.addMovieDirectorPair(d2,m2);
        return s;
    }

    public Movie getMovieByName(String name){
        Movie movie=movieRepository.getMovieByName(name);

        return movie;
    }

    public Director getDirectorByName(String name){
        Director director=movieRepository.getDirectorByName(name);
        return director;
    }
    public List<String>getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }
    public List<String>findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String name){
        Director director=null;
        for(Director x: movieRepository.movieMap.keySet()){
           if(x.getName().equals(name)){
               director=x;
               break;
           }
        }
        String s=movieRepository.deleteDirectorByName(director);

        return s;
    }
    public String deleteAllDirectors(){
        String s=movieRepository.deleteAllDirectors();
        return s;
    }
}
