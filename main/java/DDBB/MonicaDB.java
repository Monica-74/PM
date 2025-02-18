package DDBB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.hobies_viajes.R;
import com.example.hobies_viajes.Viaje;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MonicaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "MonicaDB";
    private static final int DB_VERSION = 21;

    public static final String SENTENCIA_SELECCION_VIAJES = "select id, nombre, descripcion, viaje, pais,foto " +
            "from viajes";

    private static final String SENTENCIA_CREACION_TABLA_VIAJES =  "create table viajes " +
            "(id integer primary key, nombre text not null, descripcion text not null, pais text not null,foto BLOB NOT NULL); ";


    public static final String TABLA_VIAJES = "viajes";

    public MonicaDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MonicaDB", "Creando la base de datos...");
        db.execSQL(SENTENCIA_CREACION_TABLA_VIAJES);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLA_VIAJES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
           db.execSQL("DROP TABLE IF EXISTS " + TABLA_VIAJES);
            onCreate(db);
        }
    }



    // Método para seleccionar viajes y convertir la imagen de byte[] a Bitmap
    public ArrayList<Viaje> insertarViaje(SQLiteDatabase db) { //listaViajes
        ArrayList<Viaje> listaViajes = new ArrayList<>();
        //Cursor c = db.rawQuery("SELECT id, nombre, descripcion, pais, foto FROM viajes", null);
        Cursor c = db.rawQuery(SENTENCIA_SELECCION_VIAJES, null);


        if (c.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
                @SuppressLint("Range") String nombre = c.getString(c.getColumnIndex("nombre"));
                @SuppressLint("Range") String descripcion = c.getString(c.getColumnIndex("descripcion"));
                @SuppressLint("Range") String pais = c.getString(c.getColumnIndex("pais"));
                @SuppressLint("Range") byte[] fotoBytes = c.getBlob(c.getColumnIndex("foto"));

                // Convertimos byte[] a Bitmap
                Bitmap fotoBitmap = BitmapFactory.decodeByteArray(fotoBytes, 0, fotoBytes.length);

                Viaje viaje = new Viaje(id, nombre, descripcion, pais, fotoBitmap);
                listaViajes.add(viaje);
                // En MonicaDB.java
//                Log.d("MonicaDB", "Número de viajes recuperados: " + listaViajes.size());
//                Log.d("MonicaDB", "Viaje: "+ fotoBitmap + " " + nombre + ", " + descripcion + ", " + pais);
            } while (c.moveToNext());
        }

        c.close();
        return insertarViaje(db);
    }


    // Método para convertir Bitmap a byte[]
    public byte[] convertirImagenABytes(Bitmap imagen) {
        if (imagen == null) {
            throw new IllegalArgumentException("La imagen no puede ser nula");
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        boolean success = imagen.compress(Bitmap.CompressFormat.PNG, 100, stream);

        if (!success) {
            throw new RuntimeException("Error al comprimir la imagen");
        }

        return stream.toByteArray();
    }


    // Método para insertar un viaje en la base de datos con imagen en BLOB

    public void guardarViajes(SQLiteDatabase db, Viaje viaje)  { //, Context context
        ContentValues valores = new ContentValues();
        //valores.put("_id", 1);
        valores.put("nombre", viaje.getNombre());
        valores.put("descripcion", viaje.getDescripcion());
        valores.put("pais", viaje.getPais());

        // Cargar la imagen desde res/drawable
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.fotoviaje);

        if (bitmap == null) {
            throw new IllegalArgumentException("No se pudo cargar la imagen desde el recurso");
        }
        // Convertimos Bitmap a byte[]
        byte[] fotoBytes = convertirImagenABytes(bitmap);
        valores.put("foto", fotoBytes);

        //db.insert(TABLA_VIAJES, null, valores);
        db.insert(TABLA_VIAJES,null,valores);
    }
    public void actualizarViaje (SQLiteDatabase db, Viaje actualizado) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", actualizado.getNombre());
        valores.put("descripcion", actualizado.getDescripcion());
        valores.put("pais", actualizado.getPais());

        // Cargar la imagen desde res/drawable
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.fotoviaje);

        if (bitmap == null) {
            throw new IllegalArgumentException("No se pudo cargar la imagen desde el recurso");
        }
        // Convertimos Bitmap a byte[]
        byte[] fotoBytes = convertirImagenABytes(bitmap);
        valores.put("foto", fotoBytes);
        db.update(TABLA_VIAJES, valores, "id=?", new String[]{String.valueOf(actualizado.getId())});
    }

    // Método para eliminar un viaje por ID
    public void eliminarViaje(SQLiteDatabase db, int id) {
        db.delete(TABLA_VIAJES, "id=?", new String[]{String.valueOf(id)});
    }
}





























