package com.example.filmingapp.ui.Series;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filmingapp.R;
public class SeriesImagenDetalles extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_imagen_detalles);

        ImageView imgSerie = (ImageView) findViewById(R.id.serieImagenDetalle);

        imgSerie.setOnClickListener(this);



        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if(bundle != null)
        {
            imgSerie.setImageResource(bundle.getInt("serieImagenDetalle"));

        }
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.serieImagenDetalle )
        {
            finish();
        }
        else if (v.getId() == R.id.imgSerieDetalle)
        {
            finish();
        }

    }
}
