package com.example.filmingapp.ui.Series;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmingapp.R;

import java.util.ArrayList;

public class SeriesFragment extends Fragment {
    private SeriesInterface seriesInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private java.util.List<Series> datos;
    View rootView;

    private SeriesViewModel seriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_series, container, false);
        datos = new ArrayList<>();
        //agregar series
        //  datos.add(new Series(R.drawable., "","", "",".","", R.drawable. ));
        datos.add(new Series(R.drawable.db, "Dragon Ball", "Minoru Okazaki, Daisuke Nishio", "Masako Nozawa como Goku, Hiromi Tsuru como Bulma, Kōhei Miyauchi como Kame Sennin, Mayumi Tanaka como Krilin, Tohru Furuya como Yamcha, Hirotaka Suzuoki como Ten Shin Han y Toshio Furukawa como Piccolo.", "Dragon Ball es un Manga de Akira Toriyama, inspirado en la novela china Viaje al Oeste, Dragon Ball sigue las aventuras de Son Gokū desde su infancia hasta su edad adulta, período en el que se somete básicamente a un entrenamiento de artes marciales, y explora el mundo en búsqueda de siete objetos legendarios conocidos ...", "5", R.drawable.cincoestrellas));
        datos.add(new Series(R.drawable.pokemon, "Pokemon", "Masamitsu Hidaka", "Rika Matsumoto,Ikue Ohtani,Mayumi Iizuka,Yuji Ueda,Tomokazu Seki,Midori Kawana,Fushigi Yamada,Megumi Toyoguchi,Aoi Yuki,Mamoru Miyano ,Mayuki Makiguchi,Yuki Kaji,Mariya Ise,Megumi Hayashibara,Shinichiro Miki,Inuko Inuyama", "Ash Ketchum es uno de ellos, un niño de 10 años que sueña con llegar a ser el mejor entrenador Pokémon del mundo, por lo que visita al profesor Oak, una autoridad en la materia. El profesor le informa que lo primero que debe hacer es escoger un Pokémon (hay más de seiscientos). Ash escoge a Pikachu.", "7", R.drawable.cuatroestrellas));
        datos.add(new Series(R.drawable.digimon, "Digimon Adventure", "Akiyoshi Hongo", "Toshiko Fujita ,Chika Sakamoto,Yuuto Kazama,Mayumi Yamaguchi,Yuko Mizutani,Atori Shigematsu,Umi Tenjin,Takahiro Sakurai,Shihomi Mizowaki,Ai Maeda ,Masami Kikuchi,Junko Takeuchi,Miwa Matsumoto,Hiroko Konishi,Kae Araki,Yuka Tokumitsu", "Es la primera película de Digimon, se centra en el primer encuentro de Taichi y Hikari Yagami con los Digimon cuatro años antes de lo ocurrido en la serie de televisión. Se narra cómo encuentran un digihuevo del que sale un Botamon y cómo este evoluciona para enfrentarse a un Parrotmon..", "1", R.drawable.cuatroestrellas));
        datos.add(new Series(R.drawable.breaking, "Breaking Bad", "Vince Gilligan", "Bryan Cranston, Aaron Paul, Anna Gunn", "Hundido por una monótona e insulsa relación con su mujer e incapaz de poner a prueba su brillantez trabajando como profesor de instituto, Walter da un giro radical a su forma de vida cuando descubre que tiene un cáncer terminal.", "5", R.drawable.cuatroestrellas));
        datos.add(new Series(R.drawable.juegotronos, "Juego de Tronos", "D.B. Weiss, David Benioff", "Peter Dinklage, Kit Harington, Emilia Clarke", "La serie nos sitúa en Invernalia, uno de los siete reinos del continente de Poniente. Tras un largo verano, Lord Eddard 'Ned' Stark (Sean Ben, 'El señor de los anillo', 'Troya', 'Equilibrium'), señor de Invernalia, es llamado a ocupar el cargo de Mano del Rey", "8", R.drawable.cincoestrellas));

        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewSeries);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new SeriesAdapter(datos, seriesInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewSeries);
        recyclerView.setAdapter(new SeriesAdapter(datos, new SeriesInterface() {
            @Override
            public void onClick(View v, int position) {
                if (v.getId() == (R.id.img_serie)) {
                    Intent seriesImagenDetalles = new Intent(rootView.getContext(), SeriesImagenDetalles.class);
                    seriesImagenDetalles.putExtra("serieImagenDetalle", datos.get(position).getImagen());
                    startActivity(seriesImagenDetalles);
                } else {
                    Intent seriesDetalles = new Intent(rootView.getContext(), SeriesDetalles.class);
                    seriesDetalles.putExtra("imgSerieDetalle", datos.get(position).getImagen());
                    seriesDetalles.putExtra("txtTituloSerieDetalle", datos.get(position).getTitulo());
                    seriesDetalles.putExtra("director_detalle_serie", datos.get(position).getDirector());
                    seriesDetalles.putExtra("reparto_detalle_serie", datos.get(position).getReparto());

                    seriesDetalles.putExtra("sinopsi_detalle_serie", datos.get(position).getSinopsi());
                    seriesDetalles.putExtra("temporadas_detalle_serie", datos.get(position).getTemporadas());
                    seriesDetalles.putExtra("imgSerieClasificacion", datos.get(position).getClasificacion());

                    startActivity(seriesDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}