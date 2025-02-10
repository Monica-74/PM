package ProyectoInstitutoSalesianos.ModeloBBDD;

public class Asignatura {
    private int id_asignatura;
    private String nombre;
    private int curso;

    public Asignatura(int id_asignatura, String nombre,int curso){
        this.id_asignatura=id_asignatura;
        this.nombre= nombre;
        this.curso = curso;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
