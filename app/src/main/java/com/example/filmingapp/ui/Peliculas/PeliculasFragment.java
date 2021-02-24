package com.example.filmingapp.ui.Peliculas;

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
public class PeliculasFragment extends Fragment
{
    private PeliculasInterface peliculasInterface;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private java.util.List<com.example.filmingapp.ui.Peliculas.Peliculas> datos;
    View rootView;

    private PeliculasViewModel peliculasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        rootView = inflater.inflate(R.layout.fragment_peliculas, container, false);
        datos = new ArrayList<>();
        //agregar pelis
        // datos.add(new Peliculas(R.drawable., "", "", "", "", R.drawable.));
        datos.add(new Peliculas(R.drawable.jp1, "jurassic park", "Colin Trevorrow", "Sam Neill, Laura Dern, Jeff Goldblum, Richard Attenborough, Bob Peck, Martin Ferrero, Joseph Mazzello, Ariana Richards, Samuel L. Jackson, B. D. Wong, Wayne Knight, Gerald R. Molen, Cameron Thor", "John Hammond, magnate propietario de la empresa multinacional en bioingeniería InGen, ha soñado toda su vida con construir el mayor parque de atracciones del mundo. Una isla en Costa Rica donde habiten las criaturas más espectaculares que han pisado la Tierra: los dinosaurios. Pese a la extinción de estos reptiles, InGen ha logrado clonar diversas especies mediante la manipulación de segmentos de ADN de la propia sangre de dinosaurio, encontrada en mosquitos fosilizados en ámbar..",R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.jp2, "El mundo perdido", "Steven Spielberg", "Jeff Goldblum, Julianne Moore,Vince Vaughn,Pete Postlethwaite,Vanessa Lee Chester,Arliss Howard,Richard Attenborough,Peter Stormare,Harvey Jason,Richard Schiff,Thomas F. Duffy,Camilla Belle ", "La trama está ambientada cuatro años después de los sucesos del filme original y se desarrolla en la ficticia isla Sorna, ubicada en el Pacífico frente a Costa Rica, donde los dinosaurios clonados creados por la empresa InGen de Hammond vagan en libertad en su propio ecosistema.", R.drawable.cuatroestrellas));
        datos.add(new Peliculas(R.drawable.jp3, "jurassic park 3", "Joe Johnston", "Sam Neill,William H. Macy,Téa Leoni,Alessandro Nivola,Trevor Morgan,John Diehl,Bruce A. Young,Laura Dern,Mark Harelik,Julio Oscar Mechoso,Blake Michael Bryan,Sarah Danielle Madison,Linda Park", "Sam Neill,William H. Macy,Téa Leoni,Alessandro Nivola,Trevor Morgan,John Diehl,Bruce A. Young,Laura Dern,Mark Harelik,Julio Oscar Mechoso,Blake Michael Bryan,Sarah Danielle Madison,Linda Park", R.drawable.cuatroestrellas));
        datos.add(new Peliculas(R.drawable.jw1, "jurasic world", "Colin Trevorrow", "Chris Pratt,Bryce Dallas Howard,Vincent D'Onofrio,Ty Simpkins,Nick Robinson,Irrfan Khan,Jake Johnson,Omar Sy,B. D. Wong,Judy Greer,Lauren Lapkus,Brian Tee,Katie McGrath,Andy Buckley", "Veintidós años después de los acontecimientos en Parque Jurasico, Steven Spielberg vuelve a producir la esperada entrega de la franquicia Jurassic Park, Después de diez años de funcionamiento el parque temático tiene un declive de visitantes y con el fin de cumplir con el la misión corporativa se crea una nueva atracción para así los visitantes tengan un nuevo interés hacia el parque lo que resulta contraproducente.", R.drawable.cincoestrellas));
        datos.add(new Peliculas(R.drawable.jw2, "jurassic world El reino caído", "J.A. Bayona", "Chris Pratt,Bryce Dallas Howard,Rafe Spall,Justice Smith,Daniella Pineda,James Cromwell,Toby Jones,Ted Levine,B. D. Wong,Isabella Sermon,Geraldine Chaplin,Jeff Goldblum", "Tras cuatro años de abandono del complejo turístico Jurassic World, Isla Nublar sólo está habitada por los dinosaurios supervivientes. Cuando el volcán de la isla entra en erupción, Owen (Chris Pratt) y Claire (Bryce Dallas Howard) vuelven allí para rescatar a los dinosaurios de la extinción.", R.drawable.cincoestrellas));


        // Obtenemos el Recycler
        recycler = (RecyclerView) rootView.findViewById(R.id.myRecyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        //Crear un nuevo adaptador
        adapter = new com.example.filmingapp.ui.Peliculas.PeliculasAdapter(datos, peliculasInterface);
        recycler.setAdapter(adapter);

        setupRecyclerView();
        return rootView;
    }
    private void setupRecyclerView(){
        RecyclerView recyclerView = recycler.findViewById(R.id.myRecyclerViewPeliculas);
        recyclerView.setAdapter(new com.example.filmingapp.ui.Peliculas.PeliculasAdapter(datos, new PeliculasInterface() {
            @Override
            public void onClick(View v, int position) {
                if(v.getId()==(R.id.imgPeli)){
                    Intent pelisImagenDetalles = new Intent(rootView.getContext(), PeliculasImagenDetalles.class);
                    pelisImagenDetalles.putExtra("peliculaImagenDetalle", datos.get(position).getImagen());
                    startActivity(pelisImagenDetalles);
                }
                else{
                    Intent pelisDetalles = new Intent(rootView.getContext(),com.example.filmingapp.ui.Peliculas.PeliculasDetalles.class);
                    pelisDetalles.putExtra("imgPeliculaDetalle", datos.get(position).getImagen());
                    pelisDetalles.putExtra("txtTituloPeliculaDetalle", datos.get(position).getTitulo());
                    pelisDetalles.putExtra("director_detalle_pelicula", datos.get(position).getDirector());
                    pelisDetalles.putExtra("reparto_detalle_pelicula", datos.get(position).getReparto());
                    pelisDetalles.putExtra("sinopsi_detalle_pelicula", datos.get(position).getSinopsi());
                    pelisDetalles.putExtra("imgPeliculaClasificacion", datos.get(position).getClasificacion());
                    startActivity(pelisDetalles);
                }
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}