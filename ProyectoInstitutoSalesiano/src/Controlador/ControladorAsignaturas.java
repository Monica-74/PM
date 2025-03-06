package Controlador;

import ModeloBBDD.Asignatura;
import ModeloBBDD.DAOInstituto;
import java.util.ArrayList;

public class ControladorAsignaturas {

    private DAOInstituto daoInstituto = new DAOInstituto();
    private ArrayList<Asignatura> listaAsignaturas;

    public ControladorAsignaturas() {
        listaAsignaturas = new ArrayList<>();
        actualizarAsignaturas();
    }

    // Método para obtener las asignaturas desde la base de datos
    public ArrayList<Asignatura> obtenerAsignaturas() {
        return listaAsignaturas;
    }

    private void actualizarAsignaturas() {
        listaAsignaturas = new ArrayList<>(daoInstituto.obtenerAsignaturas());
    }

    public int insertarAsignatura(String nombre, String curso) {
        Asignatura asignatura = new Asignatura(nombre, curso);
        int resultado = daoInstituto.insertarAsignatura(asignatura);
        if (resultado > 0) {
            actualizarAsignaturas(); // Recargar datos después de la inserción
        }
        return resultado;
    }
}
