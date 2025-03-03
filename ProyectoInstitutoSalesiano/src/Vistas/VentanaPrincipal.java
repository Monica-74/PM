//package Vistas;
//
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//
//import Controlador.ControladorAlumnos;
//import ModeloBBDD.Alumno;
//
//import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableColumnModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import static ModeloBBDD.DAOInstituto.connect;
//
//
//
//public class VentanaPrincipal extends JFrame {
//
//    private static VentanaPrincipal ventanaPrincipal;
//    private TablaAlumnosModel modeloAlumnos;
//    private JTable tablaAlumnos;
//    private JPanel panelAlumnos;
//
////    final static int NUMERO_OPCIONES = 2;
////    //Elementos del formulario
////    Container panelContenedor;
////    JButton btnCentro = new JButton("Boton centro");
////    BorderLayout layout = new BorderLayout();
////    Font fuenteCabeceras = new Font("Courier", Font.BOLD, 16);
////    Font fuenteMenu = new Font("Courier", Font.BOLD, 14);
////    Font fuenteCeldas = new Font("Courier", Font.PLAIN, 14);
////    JPanel pnEste = new JPanel();
////
////    //
////    //Para el norte y el sur
////    JPanel pnNorte = new JPanel();
////    JButton boton2 = new JButton("Boton 2");
////    JButton boton3 = new JButton("Boton 3");
////    JTextArea txtSur;
////
////    //El panel de pestannas del centro
////    JTabbedPane pnPestannas = new JTabbedPane();
////    JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
////    JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
////    //Arbol2 arbolContactos = new Arbol2();
////    JScrollPane scroll;
////
////    // MENU
////    JMenuBar barraMenu = new JMenuBar();
////    JMenu menuAlumnos = new JMenu("Alumnos");
////    JMenu menuAsignaturas = new JMenu("Asignaturas");
////    JMenu menuMatriculas = new JMenu("Matriculas");
////    JMenuItem menuAgregarAlumno = new JMenuItem("Agregar Alumno");
////
////    //Barra de herramientas
////    JToolBar barraTool = new JToolBar();
////    JButton botonAbrir = new JButton();
////    //JTable tablaAlumnos;
////    // Controlador para obtener los datos
////    private TablaAlumnosModel modeloAlumnos;
////    private ControladorAlumnos controlador = new ControladorAlumnos();
//
//
//
//    final static int NUMERO_OPCIONES = 2;
//    //Elementos del formulario
//    Container panelContenedor;
//    JButton btnCentro = new JButton("Boton centro");
//    BorderLayout layout = new BorderLayout();
//    Font fuenteCabeceras = new Font("Courier", Font.BOLD, 16);
//    Font fuenteMenu = new Font("Courier", Font.BOLD, 14);
//    JPanel pnEste = new JPanel();
//
//    //
//    //Para el norte y el sur
//    JPanel pnNorte = new JPanel();
//    JButton boton2 = new JButton("Boton 2");
//    JButton boton3 = new JButton("Boton 3");
//    JTextArea txtSur;
//
//    //El panel de pestannas del centro
//    JTabbedPane pnPestannas = new JTabbedPane();
//    //Un panel divisor
//    JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//    JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//    //Arbol2 arbolContactos = new Arbol2();
//    JScrollPane scroll;
//
//    // MENU
//    JMenuBar barraMenu = new JMenuBar();
//    JMenu menuAlumnos = new JMenu("Alumnos");
//    JMenu menuAsignaturas = new JMenu("Asignaturas");
//    JMenu menuMatriculas = new JMenu("Matriculas");
//    JMenuItem menuAgregarAlumno = new JMenuItem("Agregar Alumno");
//
//    //Barra de herramientas
//    JToolBar barraTool = new JToolBar();
//    JButton botonAbrir = new JButton();
//    //Defino el panel donde va a ir la tabla de alumnos
//    private final ControladorAlumnos controlador = new ControladorAlumnos();
//    //private JPanel panelAlumnos; // Panel para contener la tabla
//
//    public void VentanaPrincipal() {
//
//        initGUI();
//        initMenu();
//        initEventos();
//        initToolBar();
//        iniciarTablaAlumnos();
//    }
//
//     //Método para obtener la tabla de alumnos
//    public JTable getTablaAlumnos() {
//        return tablaAlumnos;
//    }
////    public void initGUI() {
////        //Hallo el panel contenedor de la ventana
////        panelContenedor = this.getContentPane();
////        //Le aplico al panel contenedor un Border Layout
////        //panelContenedor.setLayout(layout);
////        panelContenedor.setLayout(new BorderLayout());
////
////        btnCentro.setVerticalAlignment(SwingConstants.TOP);
////        txtSur = new JTextArea(10, 50);
////        setBotonesBar();
////        establecerPestanas();
////
////        split2.add(split1);
////        split2.add(txtSur);
////        split2.setDividerLocation(800);
////        split1.setOneTouchExpandable(true);
////        //Agrego los componentes
////        panelContenedor.add(pnNorte, BorderLayout.NORTH);
////        panelContenedor.add(split2, BorderLayout.CENTER);
////        //panelContenedor.add(pnOeste, BorderLayout.WEST);
////        panelContenedor.add(pnEste, BorderLayout.EAST);  //al este
////
////
////        // Inicializar el panel de alumnos
////        panelAlumnos = new JPanel(new BorderLayout());
////        iniciarTablaAlumnos(); // Inicializar la tabla de alumnos
////        JTabbedPane panelPestana = new JTabbedPane();
////
////        tablaAlumnos = new JTable(modeloAlumnos); // Asegurar que está inicializado antes de usarlo
////        iniciarTablaAlumnos();
////
////         //Configurar el layout del panel contenedor
////        panelContenedor.setLayout(new BorderLayout());
////
////        // Agregar el panel de alumnos al centro de la ventana
////        panelContenedor.add(panelAlumnos, BorderLayout.CENTER);
////
////        // Asignar la imagen a la pestaña de Alumnos
////        ImageIcon iconoAlumno = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png");
////        pnPestannas.addTab("Alumnos", iconoAlumno, panelAlumnos);
////
////        // Asignar la imagen a la pestaña de Asignaturas
////        ImageIcon iconoAsignatura = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png");
////        JPanel panelAsignaturas = new JPanel();
////        panelAsignaturas.add(new JLabel("Aquí irá la tabla de asignaturas"));
////        pnPestannas.addTab("Asignaturas", iconoAsignatura, panelAsignaturas);
////
////        // Asignar la imagen a la pestaña de Matriculas
////        ImageIcon iconoMatricula = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png");
////        JPanel panelMatriculas = new JPanel();
////        panelMatriculas.add(new JLabel("Aquí irá la tabla de matriculas"));
////        pnPestannas.addTab("Matriculas", iconoMatricula, panelMatriculas);
////
////        split1.add(pnPestannas);
////
////
////        tablaAlumnos = new JTable(modeloAlumnos);
////        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
////        add(scrollPane, BorderLayout.CENTER);
////        setSize(800, 600);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setVisible(true);
////
////    }
//    public void initGUI() {
//        //Hallo el panel contenedor de la ventana
//        panelContenedor = this.getContentPane();
//        //Le aplico al panel contenedor un Border Layout
//        //panelContenedor.setLayout(layout); //este lo cambio por el de abajo
//        panelContenedor.setLayout(new BorderLayout());
//        btnCentro.setVerticalAlignment(SwingConstants.TOP);
//        txtSur = new JTextArea(10, 50);
//        setBotonesBar();
//        establecerPestanas();
//
//        split2.add(split1);
//        split2.add(txtSur);
//        split2.setDividerLocation(800);
//        split1.setOneTouchExpandable(true);
//        //Agrego los componentes
//        panelContenedor.add(pnNorte, BorderLayout.NORTH);
//        panelContenedor.add(split2, BorderLayout.CENTER);
//        //panelContenedor.add(pnOeste, BorderLayout.WEST);
//        panelContenedor.add(pnEste, BorderLayout.EAST);  //al este
//
//        // Inicializar el panel de alumnos
//        panelAlumnos = new JPanel(new BorderLayout());
//        iniciarTablaAlumnos(); // Inicializar la tabla de alumnos
//
//        // Configurar el panel de pestañas
//        JTabbedPane panelPestana = new JTabbedPane();
//
//
//        // Configurar el layout del panel contenedor
//        panelContenedor.setLayout(new BorderLayout());
//
//        // Agregar el panel de alumnos al centro de la ventana
//        panelContenedor.add(panelAlumnos, BorderLayout.CENTER);
//
//        int iconWidth = 24, iconHeight = 24;
//
//        // Asignar la imagen a la pestaña de Alumnos
//        ImageIcon iconoAlumno = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png");
//        pnPestannas.addTab("Alumnos", iconoAlumno, panelAlumnos);
//
//        // Asignar la imagen a la pestaña de Asignaturas
//        ImageIcon iconoAsignatura = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png");
//        JPanel panelAsignaturas = new JPanel();
//        panelAsignaturas.add(new JLabel("Aquí irá la tabla de asignaturas"));
//        pnPestannas.addTab("Asignaturas", iconoAsignatura, panelAsignaturas);
//
//        // Asignar la imagen a la pestaña de Matriculas
//        ImageIcon iconoMatricula = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png");
//        JPanel panelMatriculas = new JPanel();
//        panelMatriculas.add(new JLabel("Aquí irá la tabla de matriculas"));
//        pnPestannas.addTab("Matriculas", iconoMatricula, panelMatriculas);
//
//        split1.add(pnPestannas);
//
//
//        tablaAlumnos = new JTable(modeloAlumnos);
//        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
//        add(scrollPane, BorderLayout.CENTER);
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//    private ImageIcon createResizedIcon(String path, int width, int height) {
//        ImageIcon originalIcon = new ImageIcon(path);
//        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        return new ImageIcon(resizedImage);
//    }
//    //Barra de herramientas
//    public void initToolBar() {
//        botonAbrir.setIcon(new ImageIcon("lib/imagenes/abrir.png"));
//        barraTool.add(botonAbrir);
//        this.add(barraTool, BorderLayout.NORTH);
//    }
//
//    public void initMenu() {
//        menuAlumnos.setFont(fuenteMenu);
//        barraMenu.add(menuAlumnos);
//        menuAsignaturas.setFont(fuenteMenu);
//        barraMenu.add(menuAsignaturas);
//        menuMatriculas.setFont(fuenteMenu);
//        barraMenu.add(menuMatriculas);
//        //
//        menuAlumnos.add(menuAgregarAlumno);
//        menuAgregarAlumno.setFont(fuenteMenu);
//        menuAsignaturas.add(new JSeparator());
//
//        //Por ultimo la barra de menu se la pongo a la ventana
//        this.setJMenuBar(barraMenu);
//
//    }
//
////    public void initMenu() {
////        menuAlumnos.setFont(fuenteMenu);
////        barraTool.add(menuAlumnos);
////        menuAsignaturas.setFont(fuenteMenu);
////        barraTool.add(menuAsignaturas);
////        menuMatriculas.setFont(fuenteMenu);
////        barraTool.add(menuMatriculas);
////        //
////        menuAlumnos.add(menuAgregarAlumno);
////        menuAgregarAlumno.setFont(fuenteMenu);
////        menuAsignaturas.add(new JSeparator());
////
////        // Aquí irían más opciones de menú
////        //
////        //Por ultimo la barra de menu se la pongo a la ventana
////        this.setJMenuBar(barra);
////
////    }
//
//    //Barra de herramientas
//
//
//    public void initEventos() {
//        menuAgregarAlumno.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaNuevoAlumno();
//            }
//        });
//        botonAbrir.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                abrirExploradorArchivos();
//            }
//        });
//
//    }
//
//    public void abrirVentanaNuevoAlumno() {
//        AgregarAlumnoVentana form = new AgregarAlumnoVentana();
//        form.setVisible(true);
//    }
//
//
//    public void abrirExploradorArchivos() {
//        JFileChooser chooser = new JFileChooser("C:/Program Files/");
//        FileNameExtensionFilter filter =
//                new FileNameExtensionFilter("Ejecutables", "exe");
//        chooser.setFileFilter(filter);
//        int returnVal = chooser.showOpenDialog(this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File archivo = chooser.getSelectedFile();
//            try {
//                Runtime.getRuntime().exec(archivo.getAbsolutePath());
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    /*public void crearArbolContactos() {
//        scroll = new JScrollPane(arbolContactos);
//        split1.add(scroll);
//    }*/
//
//    public void setBotonesBar() {
//        //Defino un layout flow especial
//        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 15, 15);
//        //Se lo aplico al panel del norte
//        pnNorte.setLayout(fl);
//        //Al panel del norte le meto los diferentes botones
//        pnNorte.add(boton2);
//        pnNorte.add(boton3);
//
//    }
//
//    public void establecerPestanas() {
//
//        iniciarTablaAlumnos();
//
//        pnPestannas.addTab("Alumnos ", new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png"),
//                panelAlumnos);
//        //Añadir algo para los otros 2 pestañas
//        JPanel panelAsignaturas = new JPanel();
//        panelAsignaturas.add(new JLabel("Aquí irá la tabla de asignaturas"));
//        pnPestannas.addTab("Asignaturas ", new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png"),
//                panelAsignaturas);
//        JPanel panelMatriculas = new JPanel();
//        panelMatriculas.add(new JLabel("Aquí irá la tabla de matriculas"));
//        pnPestannas.addTab("Matriculas ", new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png"),
//                panelMatriculas);
//        split1.add(pnPestannas);
//    }
//
//    public void iniciarTablaAlumnos() {
//        // Obtener los datos de los alumnos desde la BD
//        ArrayList<Alumno> alumnos = obtenerAlumnosDesdeBD(); // Implementa este método
//        // Crea el modelo de la tabla
//        TablaAlumnosModel modeloAlumnos = new TablaAlumnosModel(alumnos); // Error: Falta pasar la lista de alumnos
//
//
//        // Crea la tabla a partir del modelo
//        tablaAlumnos = new JTable(modeloAlumnos);
//
////        // Configura la tabla
//        tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//
//
//        // Fuentes de celdas y cabeceras
//        Font fuenteCeldas = new Font("Courier", Font.PLAIN, 14);
//        Font fuenteCabeceras = new Font("Courier", Font.BOLD, 16);
//        tablaAlumnos.setFont(fuenteCeldas);
//        tablaAlumnos.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        // Primero, hallo el modelo de columnas de la tabla
//        TableColumnModel tcm = tablaAlumnos.getColumnModel();
//        JTableHeader cabecera = new JTableHeader(tcm);
//        cabecera.setFont(fuenteCabeceras);
//        tablaAlumnos.setTableHeader(cabecera);
//
//        // Selecciones de celdas, filas, y columnas varias
//        tablaAlumnos.setRowSelectionAllowed(true);
//        tablaAlumnos.setColumnSelectionAllowed(true);
//        tablaAlumnos.setCellSelectionEnabled(true);
//
//        // Limpiar el panel antes de agregar la tabla
//        panelAlumnos.removeAll(); // Limpiar el panel
//        panelAlumnos.setLayout(new BorderLayout()); // Establecer el layout
//
//        // Agregar la tabla a un JScrollPane y luego al panel
//        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
//        panelAlumnos.add(scrollPane, BorderLayout.CENTER);
//
//        // Actualizar el panel
//        panelAlumnos.revalidate();
//        panelAlumnos.repaint();
//
//    }
//
//    public ArrayList<Alumno> obtenerAlumnosDesdeBD() {
//        ArrayList<Alumno> alumnos = new ArrayList<>();
//        try (Connection conn = connect()) {
//            // Consulta SQL para obtener los alumnos
//            String query = "SELECT id, nombre, direccion, estado_matricula FROM alumno ORDER BY nombre ASC";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            // Recorrer el resultado y crear objetos Alumno
//            // Recorrer el resultado y crear objetos Alumno
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nombre = rs.getString("nombre");
//                String direccion = rs.getString("direccion");
//                String estadoMatricula = rs.getString("estado_matricula");
//                Alumno alumno = new Alumno(id, nombre, direccion, estadoMatricula);
//                alumnos.add(alumno);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return alumnos;
//    }
//
//
//    public void actualizarTablaAlumnos() {
//        ArrayList<Alumno> alumnos = obtenerAlumnosDesdeBD();
//
//        TablaAlumnosModel modeloAlumnos = new TablaAlumnosModel(alumnos);
//
//        // Verificar que modeloAlumnos y tablaAlumnos estén inicializados
//        if (modeloAlumnos == null || tablaAlumnos == null) {
//        }
//
//        // Actualizar los datos del modelo
//        modeloAlumnos.actualizarDatos();
//
//        // Notificar a la tabla que los datos han cambiado
//        modeloAlumnos.fireTableDataChanged();
//
//        // Refrescar la tabla
//        tablaAlumnos.repaint();
//        tablaAlumnos.revalidate();
//    }
//
////    public static VentanaPrincipal getVentanaPrincipal() {
////        if (instancia == null) {
////            instancia = new VentanaPrincipal();
////            instancia.setVisible(true); // Asegurar que la ventana se muestra
////            instancia.initGUI();
////        }
////        return instancia;
////    }
//
//
//    public static VentanaPrincipal getVentanaPrincipal() {
//        if (ventanaPrincipal == null) {
//            ventanaPrincipal = new VentanaPrincipal();
//        }
//        return ventanaPrincipal;
//    }
//
//
//    public static void main(String[] args) {
//        VentanaPrincipal ventana = VentanaPrincipal.getVentanaPrincipal();
//        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        ventana.setVisible(true);
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }
//}
