package edu.upc.eetac.dsa.themovieapp.rest;

import edu.upc.eetac.dsa.themovieapp.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by annag on 12/12/2017.
 */

public interface MovieApiService {
    @GET("/search/movie")
    Call<MovieResponse> getSearch(@Query("api_key") String apiKey, @Query("query") String queryString);
}
