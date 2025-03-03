package Controlador;


import ModeloBBDD.Alumno;
import ModeloBBDD.DAOInstituto;

import java.util.ArrayList;
import java.util.List;

//Hace de conexión entre la capa de modelo y las clases de vista
//Para ello va a definir métodos que van a ser invocados desde las vistas
//para insertar en la base de datos
//Y también va a definir métodos que van a devolver datos hacia las vistas
//desde las capas inferiores o base de datos

public class ControladorAlumnos {

    private DAOInstituto daoInstituto = new DAOInstituto();

    public ControladorAlumnos() {

    }

    //Primer metodo: hallar alumnos de la base de datos
    //tengo que llamar al metodo selectAlumnos del DAO
    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = null;
        try {
            // Llamar al método del DAO para obtener los alumnos
            alumnos = daoInstituto.obtenerAlumnos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }
////    // Método para obtener los alumnos desde la base de datos
//    public ArrayList<Alumno> obtenerAlumnos() {
//        return (ArrayList<Alumno>) DAOInstituto.obtenerAlumnos();
//    }



    public int insertarAlumno(String nombre, String direccion, String estadoMatricula) {
        // Validar que el estado de la matrícula no sea nulo
        if (estadoMatricula == null || estadoMatricula.trim().isEmpty()) {
            estadoMatricula = "Provisional"; // Asignar un valor por defecto
        }

        // Aquí construyo el objeto Alumno que voy a insertar en la base de datos
        Alumno alumno = new Alumno(nombre, direccion, estadoMatricula);

        // Llamar al método del DAO para insertar el alumno
        int resultado = DAOInstituto.insertarAlumno(alumno);
        return resultado;
    }
}