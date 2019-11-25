package com.openclassrooms.entrevoisins.ui.neighbour_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.openclassrooms.entrevoisins.R;




public class DetailNeighbourActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.content_detail_neighour);
        getSupportFragmentManager().beginTransaction().add(R.id.DetailNeighbour, new DetailNeighbourFragment()).commit();

    }

}






