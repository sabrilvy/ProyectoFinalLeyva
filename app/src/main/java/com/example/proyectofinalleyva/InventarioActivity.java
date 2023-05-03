package com.example.proyectofinalleyva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InventarioActivity extends AppCompatActivity {

    public TextView tvPrecio, tvId, tvNombre;
    public ListView lvProductos;

    private  String [] productos= {"Rollito de Canela","Rollito de Oreo","Rollito de Cacao","Rollito de Coco","Rollito de Chocolate", "Rollito de Almendra", "Rollito de Nuez"};
    private  String [] precios= {"$65","$60","$60","$70","$65","$75","$65"};
    private  String [] ids= {"1","2","3","4","5","6","7"};
    private  String [] nombres= {"Canela","Oreo","Cacaco","Coco","Chocolate", "Almendra", "Nuez"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventario);

        //integracion de XML a Java

        tvId=findViewById(R.id.tvId);
        tvNombre=findViewById(R.id.tvNombre);
        tvPrecio=findViewById(R.id.tvPrecio);
        lvProductos=findViewById(R.id.lvProductos);

        //adaptacion de arreglo de precios y arreglo de productos mediante un ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productos);
        lvProductos.setAdapter(adapter); //integra los datos de productos en la lista
        //programacion de evento click se determina el precio del producto
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                tvId.setText("Id: "+ids[position]);
                tvNombre.setText("Nombre: "+nombres[position]);
                tvPrecio.setText("Precio: "+precios[position]);
            }
        });

    }
}