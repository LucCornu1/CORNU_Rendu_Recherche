package com.example.cornuluc_patisserie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_patisserieList);
        monRecyclerView.setHasFixedSize(true); //Taille fixe des éléments de la liste = optimisation du recyclerView

        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);

        ArrayList<Patisserie> patisserieList = new ArrayList<Patisserie>();
        initList(patisserieList);

        monAdapter = new rec_adapter(patisserieList); //cf. rec_adapter.java, classe de l’adaptateur
        monRecyclerView.setAdapter(monAdapter);
    }

    private void initList(ArrayList<Patisserie> patisserieList) {
        Patisserie patisserie = new Patisserie();
        patisserie.setPatisserieName("Macaron");
        patisserie.setPatisserieDescription("4.99€");
        patisserie.setPatisserieId(getResources().getIdentifier("macaron" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Eclair");
        patisserie.setPatisserieDescription("2.99€");
        patisserie.setPatisserieId(getResources().getIdentifier("eclair" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Pain au chocolat");
        patisserie.setPatisserieDescription("1.99");
        patisserie.setPatisserieId(getResources().getIdentifier("petit_pain" , "drawable", getPackageName()));
        patisserieList.add(patisserie);

        patisserie = new Patisserie();
        patisserie.setPatisserieName("Croissant");
        patisserie.setPatisserieDescription("1.59€");
        patisserie.setPatisserieId(getResources().getIdentifier("croissant" , "drawable", getPackageName()));
        patisserieList.add(patisserie);
    }
}