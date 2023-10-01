package com.example.exercicioaula04pdm;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class CityStateActivity extends Activity {
    String [] rs_cities = {"Porto Alegre", "Santa Cruz do Sul", "Santa Maria"};
    String [] pr_cities = {"Cascavel","Curitiba", "Maringá"};
    String [] sc_cities = {"Balneário Camboriú", "Blumenau", "Florianópolis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_state);
        Intent intent = getIntent();
        String nameParam = intent.getStringExtra("name");
        TextView name = findViewById(R.id.namePerson);
        name.setText(nameParam);

        Spinner ufs = (Spinner) findViewById(R.id.ufSpinner);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.ufs, android.R.layout.simple_spinner_item);

        ufs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listagem = (ListView) findViewById(R.id.cityList);
                String [] cidades = {};

                if (i == 1) {
                    cidades = pr_cities;
                } else if (i == 2) {
                    cidades = rs_cities;
                } else if (i == 3) {
                    cidades = sc_cities;
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(cidades));
                listagem.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ufs.setAdapter(adapterSpinner);


    }
}