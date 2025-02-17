package ProyectoInstitutoSalesianos.ModeloBBDD;

import java.sql.*;
import java.util.ArrayList;

public class DAOInstituto extends ArrayList<Object> {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /* Inserción de alumno */
    public static void insertarAlumno(String nombre, String direccion, String estadoMatricula) throws SQLException {
        int resultado = 0;

        try (Connection conn = connect()){
            String query = "INSERT INTO alumnos (nombre, direccion, estadoMatricula)" + "VALUES (?, ?, ?)";
             PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, estadoMatricula);
            resultado = stmt.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Inserción de asignatura */
    public static void insertarAsignatura(String nombre, String codigo, int creditos) {
        String query = "INSERT INTO asignaturas (nombre, codigo, creditos) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, codigo);
            stmt.setInt(3, creditos);
            stmt.executeUpdate();
            System.out.println("Asignatura insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Inserción de matrícula */
    public static void insertarMatricula(int idAlumno, int idAsignatura, double nota) {
        String query = "INSERT INTO matriculas (id_alumno, id_asignatura, nota) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idAsignatura);
            stmt.setDouble(3, nota);
            stmt.executeUpdate();
            System.out.println("Matrícula insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Seleccionar todos los alumnos */
    public static ArrayList<Alumno> selectAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumnos ORDER BY nombre ASC";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estadoMatricula = rs.getString("estadoMatricula");
                alumnos.add(new Alumno(id, nombre, direccion, estadoMatricula));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

//    /* Seleccionar todas las asignaturas */
//    public static ArrayList<Asignatura> selectAsignaturas() {
//        ArrayList<Asignatura> asignaturas = new ArrayList<>();
//        String query = "SELECT * FROM asignaturas";
//
//        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nombre = rs.getString("nombre");
//                int curso = rs.getInt("Curso");
//                asignaturas.add(new Asignatura(id, nombre, curso));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return asignaturas;
//    }

    /* Seleccionar todas las matrículas */
//    public static ArrayList<Matricula> selectMatriculas() {
//        ArrayList<Matricula> matriculas = new ArrayList<>();
//        String query = "SELECT * FROM matriculas";
//
//        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                int idAlumno = rs.getInt("id_alumno");
//                int idAsignatura = rs.getInt("id_asignatura");
//                String fechaMatricula = rs.getString("fechaMatricula");
//                String estadoMatricula = rs.getString("estadoMatricula");
//
//                // Se deben implementar estos métodos o cambiar la lógica
//                Alumno alumno = selectAlumno(idAlumno);
//                Asignatura asignatura = selectAsignatura(idAsignatura);
//
//            ;
//                matriculas.add(new Matricula(id_alumno, id_asignatura, fechaMatricula, estadoMatricula));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return matriculas;
//    }

    /* Metodo para seleccionar un alumno por ID */
    public static Alumno selectAlumno(int id) {
        String query = "SELECT * FROM alumnos WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Alumno(id, rs.getString("nombre"), rs.getString("direccion"), rs.getString("estadoMatricula"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Metodo para seleccionar una asignatura por ID */
    public static Asignatura selectAsignatura(int id) {
        String query = "SELECT * FROM asignaturas WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Asignatura(id, rs.getString("nombre"), rs.getString("codigo"), rs.getInt("creditos"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
