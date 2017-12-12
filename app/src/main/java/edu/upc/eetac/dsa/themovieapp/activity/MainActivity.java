package edu.upc.eetac.dsa.themovieapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.upc.eetac.dsa.themovieapp.R;
import edu.upc.eetac.dsa.themovieapp.model.Movie;
import edu.upc.eetac.dsa.themovieapp.model.MovieResponse;
import edu.upc.eetac.dsa.themovieapp.rest.MovieApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    //private RecyclerView recyclerView = null;

    // insert your themoviedb.org API KEY here
    private final static String API_KEY = "e1685b58286df09a7f6c6a34a5819f26";

    private Button buscar_boto;
    private TextView parametres;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parametres = (TextView) findViewById(R.id.parametres);
        buscar_boto = (Button) findViewById(R.id.button_buscar);

        buscar_boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (parametres.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "No has buscat res", Toast.LENGTH_SHORT).show();
                else{
                    query = parametres.getText().toString(); //TODO: fer la query

                    connectAndGetApiData();
                }

            }
        });
    }

    public void connectAndGetApiData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        MovieApiService movieApiService = retrofit.create(MovieApiService.class);

        Call<MovieResponse> call = movieApiService.getSearch(API_KEY,query);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                // TODO: obrir la nova activity amb el layaut de recycler
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
