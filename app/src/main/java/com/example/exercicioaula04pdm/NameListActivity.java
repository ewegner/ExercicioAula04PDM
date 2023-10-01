package com.example.exercicioaula04pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class NameListActivity extends Activity {
    String [] pessoas = {"Eduardo", "Marco", "Maurício", "Manoel", "Jorge"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);

        ListView listagem = (ListView) findViewById(R.id.listViewNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(pessoas));

        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = pessoas[position];
                Intent intent = new Intent(NameListActivity.this, CityStateActivity.class);
                intent.putExtra("name", item);
                startActivity(intent);
            }
        });

        listagem.setAdapter(adapter);


    }
}