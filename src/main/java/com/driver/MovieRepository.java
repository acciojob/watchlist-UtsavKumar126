package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@Repository
public class MovieRepository {
    Map<Director,HashSet<Movie>> movieMap=new HashMap<>();

    Set<Movie>movieSet=new HashSet<>();
    Set<Director>directorSet=new HashSet<>();

    public String addMovie(Movie movie){
        movieSet.add(movie);
        return "Added Sucessfully";
    }

    public String addDirector(Director director){
        directorSet.add(director);

        return "Director added successfully";
    }

    public String addMovieDirectorPair(Director director,Movie movie){

        if(movieMap.containsKey(director)){
            movieMap.get(director).add(movie);
        }
        else{
            movieMap.put(director,new HashSet<>());
            movieMap.get(director).add(movie);
        }
        return "Movie Pair added successfully";
    }


    public Movie getMovieByName(String name){
        for(Movie x:movieSet){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name){
        for(Director x:directorSet){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String name){
        Director d=null;
        for(Director x:movieMap.keySet()){
            if(x.getName().equals(name)){
                d=x;
                break;
            }
        }
        Set<Movie>movies=movieMap.get(d);
        List<String>ans=new ArrayList<>();
        for(Movie m:movies){
            ans.add(m.getName());
        }
        return ans;
    }
    public List<String> findAllMovies(){
        List<String>ans=new ArrayList<>();
        for(Movie x:movieSet){
            ans.add(x.getName());
        }

        return ans;
    }

    public String deleteDirectorByName(Director director){
        Set<Movie>delete=movieMap.get(director);
        for(Movie x:delete){
            if(movieSet.contains(x)){
                movieSet.remove(x);
            }
        }
        directorSet.remove(director);
        movieMap.remove(director);

        return "Successfully deleted ";
    }

    public String deleteAllDirectors(){
        for(Director x:movieMap.keySet()){
            Set<Movie>delete=movieMap.get(x);
            for(Movie y:delete){
                if(movieSet.contains(y)){
                    movieSet.remove(y);
                }
            }
        }

        movieMap.clear();
        directorSet.clear();

        return "All deleted Successfully";
    }
}
