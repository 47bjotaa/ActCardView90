package com.example.actcardview;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListadoDeElementos> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cambiar el color de fondo programáticamente
        findViewById(R.id.main).setBackgroundColor(Color.parseColor("#a4fff4")); // Cambia el color según sea necesario

        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListadoDeElementos("#877657", "Ver Más", "Universidad de la Serena", "La Serena", R.drawable.logo_uls_8));
        elements.add(new ListadoDeElementos("#607D8B", "Ver Más", "Santo Tomás", "La Serena", R.drawable.santotomas));
        elements.add(new ListadoDeElementos("#03a9f4", "Ver Más", "Inacap", "La Serena", R.drawable.logo_inacap));
        elements.add(new ListadoDeElementos("#f44336", "Ver Más", "Ip Chile", "La Serena", R.drawable.logoipchile));
        elements.add(new ListadoDeElementos("#009688", "Ver Más", "Ucn", "Coquimbo", R.drawable.logoucn));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycledView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}