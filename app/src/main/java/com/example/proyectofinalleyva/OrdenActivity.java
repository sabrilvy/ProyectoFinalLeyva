package com.example.proyectofinalleyva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OrdenActivity extends AppCompatActivity {

    public EditText etId,etPrecio,etCantidad,etNombre;
    public TextView tvNombre,tvPrecio,tvCantidad,tvDescuento,tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orden);

        etId=findViewById(R.id.etIdProd);
        etNombre=findViewById(R.id.etNombreProd);
        etPrecio=findViewById(R.id.etPrecioProd);
        etCantidad=findViewById(R.id.etCantidadProd);

        tvNombre=findViewById(R.id.tvNombreProd);
        tvPrecio=findViewById(R.id.tvPrecioProd);
        tvCantidad=findViewById(R.id.tvCantidadProd);
        tvDescuento=findViewById(R.id.tvDescuentoProd);
        tvTotal=findViewById(R.id.tvTotal);
    }
    //Total
    public void total(View view){

        int valorPrecio = Integer.parseInt(etPrecio.getText().toString());
        int valorCantidad = Integer.parseInt(etCantidad.getText().toString());
        String valorNombre = etNombre.getText().toString();



        double valorTotal = valorPrecio * valorCantidad;
        double valorDescuento = 0;
        double valorTodo = 0;

        if( valorTotal > 100){
            valorDescuento = valorTotal * 0.10;
            valorTodo = valorTotal - valorDescuento;

            tvDescuento.setText("El descuento es de: " + valorDescuento);
            tvTotal.setText("Total: "+valorTodo);
        }
        else{
            tvDescuento.setText(("No hay descuento"));
            tvTotal.setText("Total: " +valorTotal);
        }


        tvNombre.setText("Nombre del producto: "+ valorNombre);
        tvCantidad.setText("Cantidad: "+valorCantidad);
        tvPrecio.setText("Precio: "+valorPrecio);


    }
}