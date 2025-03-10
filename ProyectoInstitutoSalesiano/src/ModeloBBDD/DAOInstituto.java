package ModeloBBDD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOInstituto extends ArrayList<Object> {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "Root1234";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (Connection conn = connect()) {
            String query = "SELECT id, nombre, direccion, estado_matricula FROM alumno ORDER BY nombre ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion= rs.getString("direccion");
                String estado_matricula = rs.getString("estado_matricula");
                Alumno alumno = new Alumno(id, nombre, direccion, estado_matricula);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public int insertarAsignatura(Asignatura asignatura) {
        int resultado = 0;
        try (Connection conn = connect()) {
            String query = "INSERT INTO asignaturas (nombre, curso) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, asignatura.getNombre());
            stmt.setString(2, asignatura.getCurso());
            resultado =stmt.executeUpdate();
           // stmt.executeUpdate();
            System.out.println("Asignatura insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    private static void insertarMatricula(int idAlumno, int idAsignatura, double nota) {

        try (Connection conn = connect()) {
            String query = "INSERT INTO matriculas (id_alumno, id_asignatura, nota, nombreAsignatura) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idAsignatura);
            stmt.setDouble(3, nota);
            stmt.executeUpdate();
            System.out.println("Matrícula insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insertarAlumno(Alumno alumno){
        int resultado = 0;
        try (Connection conn = connect()) {
            String query = "INSERT INTO alumno (nombre, direccion, estado_matricula) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getDireccion());
            stmt.setString(3, alumno.getEstadoMatricula());
            resultado = stmt.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    public ArrayList<Asignatura> obtenerAsignaturas() {
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
        String sql = "SELECT * FROM asignaturas"; // Ajusta el nombre de la tabla si es diferente

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");

                Asignatura asignatura = new Asignatura(id, nombre, curso);
                listaAsignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAsignaturas;
    }




    private static ArrayList<Matricula> selectMatriculas(int idAlumno) {
        ArrayList<Matricula> matriculas = new ArrayList<>();
        try (Connection conn = connect()) {
            String query = "SELECT mat.id, asig.nombre AS nombreAsignatura, mat.nota, mat.id_asignatura FROM matriculas mat JOIN asignaturas asig ON mat.id_asignatura = asig.id WHERE mat.id_alumno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombreAsignatura");
                double nota = rs.getDouble("nota");
                int idAsignatura = rs.getInt("id_asignatura");
                Matricula mat = new Matricula(id, idAlumno, idAsignatura, nombre, nota);
                matriculas.add(mat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matriculas;
    }



    private static double[] obtenerMejorPeorNota(int idAlumno) {
        double[] notas = new double[2];
        try (Connection conn = connect()) {
            String query = "SELECT MAX(nota) AS mejorNota, MIN(nota) AS peorNota FROM matriculas WHERE id_alumno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notas[0] = rs.getDouble("mejorNota");
                notas[1] = rs.getDouble("peorNota");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }

    private static double obtenerNotaMedia(int idAlumno) {
        double notaMedia = 0.0;

        try (Connection conn = connect()) {
            String query = "SELECT AVG(nota) AS notaMedia FROM matriculas WHERE id_alumno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notaMedia = rs.getDouble("notaMedia");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notaMedia;
    }



}