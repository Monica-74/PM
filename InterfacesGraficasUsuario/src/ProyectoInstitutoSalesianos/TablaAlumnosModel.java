package ProyectoInstitutoSalesianos;

import ProyectoInstitutoSalesianos.Controlador.ControladorAlumnos;
import ProyectoInstitutoSalesianos.ModeloBBDD.Alumno;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaAlumnosModel extends AbstractTableModel {

    public final static int NOMBRE = 0;
    public final static int DIRECCION = 1;
    public final static int ESTADOMATRICULA = 2;
    //public final boolean String CARNET=3;
    public final static String[] nombresColumnas =
            {"Nombre del alumno", "Direccion", "Estado de la \n matricula"};
    public List<Alumno> alumnos;
    ControladorAlumnos controladorAlumnos= new ControladorAlumnos();

//en el constructor se inicializa la BBDD
    public TablaAlumnosModel() {

        alumnos = obtenerAlumnos();
    }

//Este metodo devuelve los alumnos, al principo lo leemos estaticamente,luego lo leemos de la BBDD
    private List<Alumno> obtenerAlumnos() {
        return  controladorAlumnos.obtenerAlumnos();//llamo al controlador
//        List<Alumno> alumnos = new ArrayList<Alumno>();
//        Alumno a1 = new Alumno("Pepe Garcia", "Calle 1", "confirmada");
//        alumnos.add(a1);
//        Alumno a2 = new Alumno("Manuel Garcia", "Calle 2", "confirmada");
//        alumnos.add(a2);
//        Alumno a3 = new Alumno("Rosa Garcia", "Calle 3", "confirmada");
//        alumnos.add(a3);
//        Alumno a4 = new Alumno("Clara Garcia", "Calle 4", "no confirmada");
//        alumnos.add(a4);
//        Alumno a5 = new Alumno("Rafael Garcia", "Calle 5", "no confirmada");
//        alumnos.add(a5);
       // return alumnos;
    }

    //Halla el numero de filas de la tabla
    public int getRowCount() {
        return alumnos.size();

    }
    //Halla el numero de columnas de la tabla
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    //me devuelve el objeto que se encuentra en la fila y columan especificada
    //en la celda especificada
    //metodo que pinta en cada celda de la tabla el valor correspondiente del alumno
    @Override
    public Object getValueAt(int fila, int columna) {
        //primero hallo el objeto que se encuentra en la fila
        Alumno a = alumnos.get(fila);
        if (columna == NOMBRE) {
            return a.getNombre();
        } else if (columna == DIRECCION) {
            return a.getDireccion();

        } else if (columna == ESTADOMATRICULA) {
            return a.getEstadoMatricula();

        }
        return null; //devuelve alumnos (fila)(columna)
    }

//    @Override
    public String getColumnName(int columna) {

        return nombresColumnas[columna];
    }


    }














//    }
//
//    @Override
//    public int getRowCount() {
//        return 0;
//    }
//
//    @Override
//    public int getColumnCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        return null;
//    }
//}
