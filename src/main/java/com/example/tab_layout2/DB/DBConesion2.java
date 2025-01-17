//package com.example.tab_layout2.DB;
//
//Ir al contenido principal
//        Google Classroom
//        Classroom
//        Programación multimedia y móviles 2º DAM 24/25
//        Tablón
//        Trabajo de clase
//        Personas
//        Se ha actualizado el tablón de anuncios
//        Programación multimedia y móviles 2º DAM 24/25
//
//        Meet
//        Próximas entregas
//        ¡Yuju! ¡No tienes que entregar nada pronto!
//
//        Anuncia algo a tu clase
//
//        Anuncio: "Queridos alumnos, os subo DBConexion y…"
//        Antonia María Herruzo Herruzo
//        Fecha de creación: 10 ene10 ene
//        Queridos alumnos, os subo DBConexion y el borde xml para los campos de texto del agregar contacto si queréis utilizarlo.
//
//        DBConexion.java
//        Java
//
//        edit_text_border.xml
//        XML
//
//        Añade un comentario de clase…
//
//        Material: "Unidad 6 - Conexión con Base de datos"
//        Antonia María Herruzo Herruzo ha publicado nuevo material: Unidad 6 - Conexión con Base de datos
//        Fecha de creación: 16 dic 202416 dic 2024 (Última modificación: 10 ene)
//
//        Anuncio: "Queridos alumnos, como ya hemos…"
//        Antonia María Herruzo Herruzo
//        Fecha de creación: 12 dic 202412 dic 2024
//        Queridos alumnos, como ya hemos comentado en clase, sería bastante recomendable que me adjuntaseis a la práctica de este módulo, la de la app, un vídeo de unos 30 segundos como mucho, en la que se vea que accedéis a la aplicación, mostrar las pestañas y mostrar las diferentes actividades que contiene.
//
//        El vídeo lo podéis realizar por ejemplo con la GameBar de Windows, o VideoMaker o algún programa sencillito. Sin sonido si queréis o con vuestra voz explicando.
//        Pongo de fecha límite domingo por la noche o lunes por la mañana a más tardar, tened en cuenta que vuestra evaluación es el miércoles, Por tiempo, vamos justos.
//
//        Antonia María Herruzo Herruzo16 dic 2024
//        En la misma tarea Raul, lo dije en clase. Un saludo
//
//        Añade un comentario de clase…
//
//
//        Anuncio: "Queridos alumnos, como ya dije, esta…"
//        Antonia María Herruzo Herruzo
//        Fecha de creación: 9 dic 20249 dic 2024
//        Queridos alumnos, como ya dije, esta semana vamos a cambiar el horario de forma que podamos hacer el viernes 2 horas seguidas de procesos para el examen, y perjudicar lo menos posible a la asignatura de multimedia  y móviles. Así, mañana martes 10 a primera hora tendremos multimedia y móviles, y a última hora procesos.
//        El jueves tendremos horario normal tanto en SGE como en el procesos. Y el viernes tendremos a cuarta hora, la hora de multimedia y móviles (empezaremos algo nuevo o repasaremos lo llevado), y las 2 últimas horas haremos el examen de procesos tal y como aprobásteis por mayoría en clase.
//
//        Añade un comentario de clase…
//
//        Material: "Unidad 5: Recycler View o listas dinámicas"
//        Antonia María Herruzo Herruzo ha publicado nuevo material: Unidad 5: Recycler View o listas dinámicas
//        Fecha de creación: 2 dic 20242 dic 2024 (Última modificación: 13 dic 2024)
//        Tarea: "Práctica evaluable App: Kotlin, Android Layout, Activity e Intent "
//        Antonia María Herruzo Herruzo ha publicado una nueva tarea: Práctica evaluable App: Kotlin, Android Layout, Activity e Intent
//        Fecha de creación: 22 nov 202422 nov 2024 (Última modificación: 12 dic 2024)
//        Material: "TabLayout"
//        Antonia María Herruzo Herruzo ha publicado nuevo material: TabLayout
//        Fecha de creación: 20 nov 202420 nov 2024
//        Material: "4.2 Barra de acciones y comunicación entre actividades"
//        Antonia María Herruzo Herruzo ha publicado nuevo material: 4.2 Barra de acciones y comunicación entre actividades
//        Fecha de creación: 15 nov 202415 nov 2024
//
//        Publicado por David Castro Pérez
//        David Castro Pérez
//        Fecha de creación: 4 nov 20244 nov 2024
//        Codigo borde.xml en la carpeta drawable
//
//        <?xml version="1.0" encoding="utf-8"?>
//        <layer-list xmlns:android="http://schemas.android.com/apk/res/android"&gt;
//        <item>
//        <shape android:shape="rectangle">
//        <solid android:color="#CE070000" />
//        </shape>
//        </item>
//        <item android:left="2dp" android:right="2dp" android:top="2dp" android:bottom="2dp">
//        <shape android:shape="rectangle">
//        <solid android:color="#ffffff" />
//        </shape>
//        </item>
//        </layer-list>
//
//        Añade un comentario de clase…
//
//
//        Anuncio: "Buenos días Mañana haremos un cambio de…"
//        Antonia María Herruzo Herruzo
//        Fecha de creación: 2 nov 20242 nov 2024
//        Buenos días
//        Mañana haremos un cambio de horario de forma puntual, por el acto que tendremos en el santuario a partir de las 18 horas
//        Durante
//        la media hora de 17:30 a 18:00 daremos Sistemas de gestión empresarial,
//        por si tenéis que preguntar algo de la práctica, que ya cerraré el
//        plazo de entrega ese día.
//        Después del recreo, daremos 2 horas de
//        programación multimedia y móviles, que llevamos ya algunos días y horas
//        perdidas. Y a última hora daremos Procesos.
//        Todo esto es por intentar
//        repartir cargas lectivas de forma proporcional en las asignaturas que
//        hemos perdido en algunos días por circunstancias varias
//
//        Añade un comentario de clase…
//
//        Tablón
//        package com.example.tablayout.DB;
//
//import android.annotation.SuppressLint;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import com.example.tablayout.Contacto;
//
//import java.util.ArrayList;
//
//public class DBConexion extends SQLiteOpenHelper {
//
//    private static final String DB_NAME = "aplicacionDB";
//    private static final int DB_VERSION = 1;
//    public static final String SENTENCIA_SELECCION_CONTACTOS = "select _id, nombre, telefono, email " +
//            "from contactos";
//    public static final String SENTENCIA_CREACION_TABLA_CONTACTOS = "create table contactos " +
//            "(nombre text not null, telefono text not null, email text not null); ";
//    public static final String TABLA_CONTACTOS = "contactos";
//
//    public DBConexion(@Nullable Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //código sql
//        //instanciamos y creamos la base de datos
//        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONTACTOS);
//        db.execSQL(SENTENCIA_CREACION_TABLA_CONTACTOS);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        //código sql para actualización de la base de datos
//        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONTACTOS);
//        onCreate(db);
//    }
//
//    public ArrayList selectContactos (SQLiteDatabase db) {
//        ArrayList contactos = new ArrayList<Contacto>();
//        //Consultamos los datos
//        Cursor c = db.rawQuery(SENTENCIA_SELECCION_CONTACTOS, null);
//        if (c.moveToFirst()) {
//            //Es un fetch Array, ya utilizado en SQL Statement
//            do {
//                //@SuppressLint("Range")
//                //int id = c.getInt(c.getColumnIndex("_id"));
//
//                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
//                @SuppressLint("Range") String nombre = c.getString(c.getColumnIndex("nombre"));
//                @SuppressLint("Range") String telefono = c.getString(c.getColumnIndex("telefono"));
//                @SuppressLint("Range") String email = c.getString(c.getColumnIndex("email"));
//                Contacto contactoExtraidoBD = new Contacto (nombre,email, telefono,1);
//                contactos.add(contactoExtraidoBD);
//            } while (c.moveToNext());
//        }
//        c.close();
//        return  contactos;
//    }
//
//    public void insertContacto(SQLiteDatabase db, Contacto contact) {
//
//        ContentValues valores = new ContentValues();
//        valores.put("_id", 1);
//        valores.put("nombre", contact.getNombre());
//        valores.put("telefono", contact.getTfno());
//        valores.put("email", contact.getEmail());
//        db.insert("contactos", null, valores);
//    }
//
//
//    /*public void actualizarContacto (SQLiteDatabase db, Contacto actualizado) {
//        ContentValues valores = new ContentValues();
//        valores.put("nombre", actualizado.getNombre());
//        valores.put("telefono", actualizado.getTfno());
//        valores.put("email", actualizado.getEmail());
//        String[] args = new String []{String.valueOf(actualizado.getId())};
//        db.update("contactos", valores, "id=?", args);
//    }*/
//
//    /*public void eliminarContacto (SQLiteDatabase db, Contacto eliminar) {
//        String sentenciaEliminar = "DELETE FROM contactos WHERE _id=" + eliminar.getId();
//        db.execSQL(sentenciaEliminar);
//    }*/
//
//}
//DBConexion.java
//Mostrando DBConexion.java.