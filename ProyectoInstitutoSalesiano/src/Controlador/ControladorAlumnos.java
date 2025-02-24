package Controlador;




import ModeloBBDD.Alumno;
import ModeloBBDD.DAOInstituto;

import java.util.List;

//Hace de conexión entre la capa de modelo y las clases de vista
//Para ello va a definir métodos que van a ser invocados desde las vistas
//para insertar en la base de datos
//Y también va a definir métodos que van a devolver datos hacia las vistas
//desde las capas inferiores o base de datos
public class ControladorAlumnos {

    DAOInstituto daoInstituto = new DAOInstituto();
    public ControladorAlumnos() {

    }

    //Primer metodo: hallar alumnos de la base de datos
    //tengo que llamar al metodo selectAlumnos del DAO
    public List<Alumno> obtenerAlumnos() {
        List<Alumno>lista=DAOInstituto.selectAlumnos();
        return lista;
    }

    public int insertarAlumno(String nombre, String direccion, String estadoMatricula) {
        //Aquí construyo el objeto Alumno que voy a insertar en la base de datos
        Alumno alum = new Alumno(nombre, direccion, estadoMatricula);
        int resultado = DAOInstituto.insertarAlumno(alum);
        return resultado;
    }
}
