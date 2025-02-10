package ProyectoInstitutoSalesianos.ModeloBBDD;

public class Matricula {
    private int id_matricula;
    private int id;
    private int id_asignatura;
    private String nombreAsignatura;
    private int nota;

    public Matricula(int id_asignatura, int id_matricula,int id_alumno,String nombreAsignatura, int nota){
        this.id = id_alumno;
        this.id_matricula= id_matricula;
        this.nombreAsignatura = nombreAsignatura;
        this.nota = nota;
        this.id_asignatura= id_asignatura;

    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public int getNota() {
        return nota;
    }
}
