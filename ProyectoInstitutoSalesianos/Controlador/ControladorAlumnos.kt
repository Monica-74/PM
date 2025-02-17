package ProyectoInstitutoSalesianos.Controlador

import ProyectoInstitutoSalesianos.ModeloBBDD.Alumno
import ProyectoInstitutoSalesianos.ModeloBBDD.DAOInstituto

    //para ellos va a definir metoos que van a ser invocados desde las vistas
    //para insertar en la BBDD
    //y tambien va a definir metodos que van a devolver datos hacia las vistas
    //desde las capas inferiores o BBDD

    class ControladorAlumnos {
        //primer metodo:hallar alumnos de la BBDD
        //llamo a metodo obtenerAlumnos de DAOInstituto
        fun obtenerAlumnos(): List<Alumno> {
            val lista: List<Alumno> = DAOInstituto.selectAlumnos()
            return resultado;
        }

        companion object {
            fun obtenerAlumnos(nombre: String?, direccion: String?, estadoMatricula: String?): List<Alumno> {
                val lista: List<Alumno> = DAOInstituto.selectAlumnos()
                return lista
            }

            fun insertarAlumno(nombre: String?, direccion: String?, estadoMatriucla: String?): Int {
                val alumno = Alumno(nombre, direccion, estadoMatriucla)
                val resultado: Int = DAOInstituto.insertarAlumno(alumno)
                return resultado
            }
        }
    }
}