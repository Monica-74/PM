package Vistas;


import Controlador.ControladorAlumnos;
import ModeloBBDD.Alumno;

import javax.naming.ldap.Control;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaAlumnosModel extends AbstractTableModel{

    /* Indices de las columnas. Se refieren como constantes */
    public final static int NOMBRE = 0;
    public final static int DIRECCION = 1;
    public final static int ESTADOMATRICULA = 2;

    public final static String[] nombresColumnas =
            {"Nombre del alumno", "Dirección", "Estado de la \n matrícula"};

    public List<Alumno> alumnos;
    ControladorAlumnos controlador = new ControladorAlumnos();

    public TablaAlumnosModel() {
        alumnos = obtenerAlumnos();
    }

    //Este método devolvera los alumnos
    //Al principio los leemos estáticamente,
    //Luego los leeremos de la base de datos
    private List<Alumno> obtenerAlumnos() {
        return controlador.obtenerAlumnos();
    }

    /* Halla el numero de filas de la tabla */
    public int getRowCount() {
        return alumnos.size();
    }

    /* Halla el numero de columnas de la tabla */
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /*Me devuelve el objeto que se encuentra en la fila y columna especificada*/
    /* En la celda especificada */
    @Override
    public Object getValueAt(int fila, int columna) {
        //Primero hallo el objeto que se encuentra en la fila
        Alumno a = alumnos.get(fila);
        if (columna == NOMBRE) {
            return a.getNombre();
        }
        else if (columna == DIRECCION) {
            return a.getDireccion();
        }
        else if (columna == ESTADOMATRICULA) {
            return a.getEstadoMatricula();
        }

        return null;

    }

    @Override
    public String getColumnName (int columna){
        return nombresColumnas[columna];
    }


}
