package ProyectoInstitutoSalesianos.ModeloBBDD;

public class Alumno {
  private int id;
    private String nombre;
  private String direccion;
  private String estadoMatricula;


  public Alumno(int id,String nombre,String direccion, String estadoMatricula){
      this.direccion= direccion;
      this.estadoMatricula=estadoMatricula;
      this.id = id;
      this.nombre= nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }


}
