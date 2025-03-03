package Vistas;


import Controlador.ControladorAlumnos;
import ModeloBBDD.Alumno;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import static Vistas.VentanaPrincipal.obtenerAlumnosDesdeBD;

public class TablaAlumnosModel extends AbstractTableModel{

    /* Indices de las columnas. Se refieren como constantes */
    public final static int NOMBRE = 0;
    public final static int DIRECCION = 1;
    public final static int ESTADOMATRICULA = 2;


    public String[] nombreColumnas =
            {"Nombre del alumno", "Dirección", "Estado de la \n matrícula"};

    public List<Alumno> alumnos;
    public ControladorAlumnos controlador = new ControladorAlumnos();

    public TablaAlumnosModel() {
        alumnos = obtenerAlumnosDesdeBD();
    }

    //Este método devolvera los alumnos
    //Al principio los leemos estáticamente,
    //Luego los leeremos de la base de datos
    private List<Alumno> obtenerAlumnos() {
        List<Alumno> lista = controlador.obtenerAlumnos();
        return lista;

    }

//    public TablaAlumnosModel() {
//        this.alumnos = alumnos;
//    }

    // Método para actualizar los datos de la tabla
    public void actualizarDatos() {
        alumnos = (ArrayList<Alumno>) controlador.obtenerAlumnos();
    }


    /* Halla el numero de filas de la tabla */
    public int getRowCount() {
        return alumnos.size();
    }

    /* Halla el numero de columnas de la tabla */
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    /*Me devuelve el objeto que se encuentra en la fila y columna especificada*/
    /* En la celda especificada */
    @Override
    public Object getValueAt(int Row, int Column) {
        //Primero hallo el objeto que se encuentra en la fila
        Alumno a = alumnos.get(Row);
        if (Column == NOMBRE) {
            return a.getNombre();
        }
        else if (Column == DIRECCION) {
            return a.getDireccion();
        }
        else if (Column == ESTADOMATRICULA) {
            return a.getEstadoMatricula();
        }

        return null;

    }

//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Alumno alumno = alumnos.get(rowIndex);
//        switch (columnIndex) {
//            case 0: return alumno.getNombre();
//            case 1: return alumno.getDireccion();
//            case 2: return alumno.getEstadoMatricula();
//            default: return null;
//        }
//    }

    @Override
    public String getColumnName (int columna){
        return nombreColumnas[columna];
    }
}
