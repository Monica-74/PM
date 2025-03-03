package ModeloBBDD;

public class Alumno {
    private int id;
    private String nombre;
    private String direccion;
    private String estadoMatricula;

    public Alumno(int id, String nombre, String direccion, String estadoMatricula  ) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoMatricula = estadoMatricula;
    }
    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor sin id (para cuando se inserta un nuevo alumno)
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
//        return "Alumno{ " + id + ", Nombre: " + nombre + ", EstadoMatricula" + estadoMatricula + '\'' +
//                '}';
        return "ID: " + id + ", Nombre: " + nombre + ",EstadoMatricula" + estadoMatricula;
    }

}