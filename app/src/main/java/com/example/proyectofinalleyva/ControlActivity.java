package com.example.proyectofinalleyva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {


    public EditText etCodigo,etDescripcion,etExistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);

        //Integrar XML-Java
        etCodigo=findViewById(R.id.etId);
        etDescripcion=findViewById(R.id.etNombre);
        etExistencia=findViewById(R.id.etExistencias);
    }

    //método altaProducto
    public void altaProducto (View view){
        //por medio de una instancia/objeto abre BDSQLite y genera la base de datos llamada administracion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//para que la BD sea reescribible (CRUD)

        //guardar los valores en las variables del formulario
        String Codigo=etCodigo.getText().toString();
        String Descripcion=etDescripcion.getText().toString();
        String Existencia=etExistencia.getText().toString();

        //Para guardar datos en la tabla artículo utilizando un contenedor de valores en variables
        ContentValues registro=new ContentValues();
        registro.put("cod", Codigo);
        registro.put("nombre", Descripcion);
        registro.put("existencia", Existencia);

        //inserta los registros en la tabla
        bd.insert("articulo", null, registro);

        //limpia los codigos

        etCodigo.setText(null);
        etDescripcion.setText(null);
        etExistencia.setText(null);

        //confirmar en ventana emergente TOAST

        Toast.makeText(this, "Éxito al ingresar producto", Toast.LENGTH_SHORT).show();

    }//termina método altaProducto

    //Metodo busqueda por campo distintivo CONSULTA
    public void consultaProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos se reescribible

        //se asigna una variable para busqueda y consulta por campo distintivo
        String codigoConsulta = etCodigo.getText().toString();
        //Cursor recorre los campos d euna tabla hasta encontralo por campo distintivo
        Cursor fila = bd.rawQuery("SELECT nombre,existencia from articulo where cod="+codigoConsulta,null);

        if(fila.moveToFirst()){//si condicion es verdadera, es decir, encontro un campo y sus datos
            etDescripcion.setText(fila.getString(0));
            etExistencia.setText(fila.getString(1));
            Toast.makeText(this,"Registro encontrado de forma EXITOSA",Toast.LENGTH_LONG).show();
        }else{//condicion falsa si no encontro un registro
            Toast.makeText(this,"No existe Articulo con ese Codigo\nVerifica",Toast.LENGTH_LONG).show();
            bd.close();
        }

    }//termina metodo consulta producto

    //Método para eliminar producto por campo distintivo
    public void eliminarProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se asigna variable para busqueda por campo distitivo caodigo producto
        String codigoBaja = etCodigo.getText().toString();
        //Se genera instrtuccion SQL para que se elimine el registro de producto
        int c = bd.delete("articulo","cod="+codigoBaja,null);
        if(c==1){
            Toast.makeText(this,"Registro eliminado de BD exitoso\nVerifica Consulta",Toast.LENGTH_LONG).show();
            //Limpia cajas de texto
            this.etCodigo.setText("");
            this.etDescripcion.setText("");
            this.etExistencia.setText("");
        }else{
            Toast.makeText(this,"Error\nNo existe Articulo con ese codigo",Toast.LENGTH_LONG).show();
        }

    }//termina metodo para eliminar producto

    //Método para modificar
    public void modificarProductos(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se declaran variables que vienen desde formulario sus datos
        String Codigo = etCodigo.getText().toString();
        String Descripcion = etDescripcion.getText().toString();
        String Existencia = etExistencia.getText().toString();

        //se genera un contenedor para almacenar los valores anteriores
        ContentValues registro = new ContentValues();
        registro.put("cod",Codigo);
        registro.put("nombre",Descripcion);
        registro.put("existencia",Existencia);

        //Se crea la variable que contine la instruccion SQL encargada de modificar y almacenar valor 1 si edito
        int cant = bd.update("articulo",registro,"cod="+Codigo,null);
        bd.close();
        if(cant==1) {//condicion si realizo modificacion
            Toast.makeText(this,"Registro actualizado de forma correcta",Toast.LENGTH_LONG).show();
            //Se limpian los campos de texto
            etCodigo.setText(null);
            etDescripcion.setText(null);
            etExistencia.setText(null);

        }else {//contrario a no modificacion
            Toast.makeText(this,"Error\nNo se modifico registro",Toast.LENGTH_LONG).show();
        }
    } //termina metodo

}