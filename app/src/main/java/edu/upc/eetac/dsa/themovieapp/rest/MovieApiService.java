package edu.upc.eetac.dsa.themovieapp.rest;

import edu.upc.eetac.dsa.themovieapp.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by annag on 10/12/2017.
 */

public interface MovieApiService {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
