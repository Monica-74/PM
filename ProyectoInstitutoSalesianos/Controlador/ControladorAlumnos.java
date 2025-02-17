package ProyectoInstitutoSalesianos.Controlador;
//hace de conexion entre la capa de modelo y las clases de vista
//para ellos va a definir metoos que van a ser invocados desde las vistas
//para insertar en la BBDD
//y tambien va a definir metodos que van a devolver datos hacia las vistas
//desde las capas inferiores o BBDD

import ProyectoInstitutoSalesianos.ModeloBBDD.Alumno;
import ProyectoInstitutoSalesianos.ModeloBBDD.DAOInstituto;

import java.util.List;

public class ControladorAlumnos {

    public ControladorAlumnos(){


    }

    public static List<Alumno> obtenerAlumnos(String nombre, String direccion, String estadoMatricula) {
        List<Alumno>lista = DAOInstituto.selectAlumnos();
        return lista;

    }

    public static int insertarAlumno(String nombre, String direccion, String estadoMatriucla){

        Alumno alumno = new Alumno(nombre, direccion, estadoMatriucla);
        int resultado = DAOInstituto.insertarAlumno(alumno);
        return resultado;
    }


    //primer metodo:hallar alumnos de la BBDD
    //llamo a metodo obtenerAlumnos de DAOInstituto
    public List<Alumno>obtenerAlumnos(){
        List<Alumno>lista = DAOInstituto.selectAlumnos();
        return resultado;
    }

}
