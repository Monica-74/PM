package ModeloBBDD;

public class Asignatura {

    private int id;
    private String nombre;
    private int curso;



    public Asignatura(int id, String nombre, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    public Asignatura(String nombre, int curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCurso() {
        return curso;
    }
    @Override
    public String toString() {
        return "Asignatura: " + id + ", Nombre: " + nombre + ", Curso: " + curso;
    }
}