package edu.upc.eetac.dsa.themovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buscar;
    TextView parametres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscar = findViewById(R.id.button_buscar);
        parametres = findViewById(R.id.parametres);

        
    }
}
