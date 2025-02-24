package ModeloBBDD;


public class Alumno {
    private int id;
    private String nombre;
    private String direccion;
    private String estadoMatricula;

    public Alumno(int id, String nombre, String direc, String estadoMatricula  ) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direc;
        this.estadoMatricula = estadoMatricula;
    }
    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Alumno(String nombre, String direccion, String estadoMatricula) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoMatricula = estadoMatricula;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}

