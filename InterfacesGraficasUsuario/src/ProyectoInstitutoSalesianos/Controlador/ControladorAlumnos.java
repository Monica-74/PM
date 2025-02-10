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


//primer metodo:hallar alumnos de la BBDD
    //llamo a metodo obtenerAlumnos de DAOInstituto
    public List<Alumno>obtenerAlumnos(){
        return DAOInstituto.selectAlumnos();
    }

}
