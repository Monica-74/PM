package ModeloBBDD;

public class Matricula {
    private int id;
    private int idAlumno;
    private int idAsignatura;
    private String nombreAsignatura;
    private double nota;

    public Matricula(int id, int idAlumno, int idAsignatura, String nombreAsignatura, double nota) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public double getNota() {
        return nota;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", ID Alumno: " + idAlumno + ", ID Asignatura: " + idAsignatura + ", Nota: " + nota;
    }
}