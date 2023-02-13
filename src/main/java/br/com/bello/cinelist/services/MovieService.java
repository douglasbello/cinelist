package br.com.bello.cinelist.services;

import br.com.bello.cinelist.entities.Movie;
import br.com.bello.cinelist.entities.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class MovieService {

    RestTemplate restTemplate = new RestTemplate();

    String apiKey = "47d272a74c9aad3916ae7e998615a9f1";

//    public Movie searchMovieByName() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://api.themoviedb.org/3/movie/240?api_key=47d272a74c9aad3916ae7e998615a9f1";
//
//
//        ResponseEntity<Map> response = restTemplate.getForEntity(url,Map.class);
//        Map<String,Object> resultado = response.getBody();
//
//        String nome = (String) resultado.get("title");
//        String sinopse = (String) resultado.get("overview");
//
//        Movie movie = new Movie();
//
//        movie.setTitle(nome);
//        movie.setDescription(sinopse);
//
//        return movie;
//    }

    public List<Movie> SearchByMovieName() {
        String url = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&language=en-US&page=1&include_adult=true&query=tropa-de-elite";
        Response movieResponse = restTemplate.getForObject(url, Response.class);

        return movieResponse.getResults();
    }
}
