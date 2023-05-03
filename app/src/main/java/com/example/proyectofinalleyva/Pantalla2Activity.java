package com.example.proyectofinalleyva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pantalla2Activity extends AppCompatActivity {

    public Button btnInventario, btnOrden, btnControl;
    public ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);

        btnInventario=findViewById(R.id.btnInventario);
        btnOrden=findViewById(R.id.btnOrden);
        btnControl=findViewById(R.id.btnControl);

        imagen = findViewById(R.id.ivLogo2);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirventana4 = new Intent(Pantalla2Activity.this, HistoriaActivity.class);
                startActivity(abrirventana4);
            }
        });

        btnInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirventana1 = new Intent(view.getContext(), InventarioActivity.class);
                startActivityForResult(abrirventana1, 0);
            }
        });

        btnOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirventana2 = new Intent(view.getContext(), OrdenActivity.class);
                startActivityForResult(abrirventana2, 0);
            }
        });

        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirventana3 = new Intent(view.getContext(), ControlActivity.class);
                startActivityForResult(abrirventana3, 0);
            }
        });

    }
}

