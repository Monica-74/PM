package com.example.tab_layout2.DB;



import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tab_layout2.Contacto;

import java.util.ArrayList;

import kotlin.Suppress;

public class DBConexion extends SQLiteOpenHelper {


    private static final String DB_NAME = "aplicacionDB";
    private static final int DB_VERSION = 3;  // par cambiar las versiones se cambia por el numero ss
    public static final String SENTENCIA_SELECCION_CONTACTOS = "select _id, nombre, telefono, email " +
            "from contactos";
    public static final String TABLA_CONTACTOS = "contactos";
    public static final String SENTENCIA_CREACION_TABLA_CONTACTOS = "create table contactos " +
            "(_id int not null, nombre text not null, telefono text not null, email text not null)";

    // public static final String SENTENCIA_ACTUALIZACION_TABLA_CONTACTOS = "UPDATE contactos add column" + ("foto integer");
    public DBConexion(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);  //factory, tambien se le llama cursor .Cuando queremos usar una api de persistencia.
        // no se actualizan los objetos mientras no haya una consulta nueva.
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //cod sql
        //instanciamos y creamos la BBDD
        //este código se ejecuta cuando se crea la BBDD
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONTACTOS);
        db.execSQL(SENTENCIA_CREACION_TABLA_CONTACTOS);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //codigo sql para acualizacion de la base de datos
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONTACTOS);
        onCreate(db);


    }

    public ArrayList selectContactos(SQLiteDatabase db) {
        ArrayList contactos = new ArrayList<Contacto>();

        //coonsultamos los datos
        Cursor c = db.rawQuery(SENTENCIA_SELECCION_CONTACTOS, null);
        if(c.moveToFirst()){ //Es un fetch Array lo utilizamos
            do{
                //@SuppressLint("Range")
                //int id= c.getInt(c.getColumnIndex("_id"));
                //Asignamos el valor en nuestras variables para usarlos en los que necesitemos.
                @SuppressLint("Range")String nombre = c.getString(c.getColumnIndex("nombre")); //@SuppressLint para que no de errores
                @SuppressLint("Range")String telefono = c.getString(c.getColumnIndex("telefono"));
                @SuppressLint("Range")String email = c.getString(c.getColumnIndex("email"));
                Contacto contactoExtraidoDB = new Contacto(nombre,email,telefono,1);
                contactos.add((contactoExtraidoDB));
            }while (c.moveToNext());
        }
        c.close();
        return contactos;
    }
    public void insertContacto(SQLiteDatabase db, Contacto contact){

        ContentValues valores = new ContentValues();
        valores.put("_id",1);  //valores.put---guardar el valor
        valores.put("nombre",contact.getNombre());
        valores.put("telefono",contact.getTfno());
        valores.put("email",contact.getEmail());
        db.insert("contactos", null,valores);
    }
    /*public void actualizarContacto (SQLiteDatabase db, Contacto actualizado) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", actualizado.getNombre());
        valores.put("telefono", actualizado.getTfno());
        valores.put("email", actualizado.getEmail());
        String[] args = new String []{String.valueOf(actualizado.getId())};
        db.update("contactos", valores, "id=?", args);
    }*/

    /*public void eliminarContacto (SQLiteDatabase db, Contacto eliminar) {
        String sentenciaEliminar = "DELETE FROM contactos WHERE _id=" + eliminar.getId();
        db.execSQL(sentenciaEliminar);
    }*/

}



//en el caso que quiera borrar o actualizar el contacto lo haria aquí delete o update.