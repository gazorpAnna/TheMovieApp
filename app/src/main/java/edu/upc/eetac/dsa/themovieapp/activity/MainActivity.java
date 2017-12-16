package edu.upc.eetac.dsa.themovieapp.activity;

import android.content.Intent;
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
                    query = parametres.getText().toString();

                    Intent inb1 = new Intent(MainActivity.this, Main2Activity.class);
                    inb1.putExtra("query", query);
                    startActivityForResult(inb1, 1);


                }

            }
        });
    }

}
