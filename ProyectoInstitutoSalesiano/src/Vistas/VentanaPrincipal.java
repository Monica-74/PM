package Vistas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import Controlador.ControladorAlumnos;
import ModeloBBDD.Alumno;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static ModeloBBDD.DAOInstituto.connect;


public class VentanaPrincipal extends JFrame{

    final static int NUMERO_OPCIONES = 2;
    //Elementos del formulario
    Container panelContenedor;
    JButton btnCentro = new JButton("Boton centro");
    BorderLayout layout = new BorderLayout();
    Font fuenteMenu = new Font("Courier", Font.BOLD, 14);
    JPanel pnEste = new JPanel();

    //
    //Para el norte y el sur
    JPanel pnNorte = new JPanel();
    JButton boton2 = new JButton("Boton 2");
    JButton boton3 = new JButton("Boton 3");
    JTextArea txtSur;

    //El panel de pestannas del centro
    JTabbedPane pnPestannas = new JTabbedPane();
    //Un panel divisor
    JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    //Arbol2 arbolContactos = new Arbol2();
    JScrollPane scroll;

    // MENU
    JMenuBar barra = new JMenuBar();
    JMenu menuAlumnos = new JMenu("Alumnos");
    JMenu menuAsignaturas = new JMenu("Asignaturas");
    JMenu menuMatriculas = new JMenu("Matriculas");
    JMenuItem menuAgregarAlumno = new JMenuItem("Agregar Alumno");

    //Barra de herramientas
    JToolBar barraTool = new JToolBar();
    JButton botonAbrir = new JButton();
    //Defino el panel donde va a ir la tabla de alumnos
    JPanel panelAlumnos = new JPanel(new BorderLayout());
    static JTable tablaAlumnos;


    public VentanaPrincipal() {

        initGUI();
        initMenu();
        initEventos();
        initToolBar();
    }

    public void initGUI() {
        //Hallo el panel contenedor de la ventana
        panelContenedor = this.getContentPane();
        //Le aplico al panel contenedor un Border Layout
        panelContenedor.setLayout(layout);
        btnCentro.setVerticalAlignment(SwingConstants.TOP);
        txtSur = new JTextArea(10, 50);
        setBotonesBar();
        establecerPestanas();

        split2.add(split1);
        split2.add(txtSur);
        split2.setDividerLocation(800);
        split1.setOneTouchExpandable(true);
        //Agrego los componentes
        panelContenedor.add(pnNorte, BorderLayout.NORTH);
        panelContenedor.add(split2, BorderLayout.CENTER);
        //panelContenedor.add(pnOeste, BorderLayout.WEST);
        panelContenedor.add(pnEste, BorderLayout.EAST);  //al este
        JTabbedPane panelPestana = new JTabbedPane();

        int iconWidth = 24, iconHeight = 24;
        ImageIcon iconAlumnos = createResizedIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png", 24, 24);
        ImageIcon iconAsignaturas = createResizedIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png", iconWidth, iconHeight);
        ImageIcon iconMatriculas = createResizedIcon("C:\\Users\\Dell\\IdeaProjects\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png", iconWidth, iconHeight);

        panelPestana.addTab("Alumnos", iconAlumnos, panelAlumnos);
        JPanel panelAsignaturas = new JPanel();
        panelAsignaturas.add(new JLabel("asignaturas"));
        panelPestana.addTab("Asignaturas", iconAsignaturas, panelAsignaturas);
        panelPestana.addTab("Matriculas", iconMatriculas, new JPanel());

        panelContenedor.add(panelPestana, BorderLayout.CENTER);
    }
    private ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }


    public void initMenu() {
        menuAlumnos.setFont(fuenteMenu);
        barra.add(menuAlumnos);
        menuAsignaturas.setFont(fuenteMenu);
        barra.add(menuAsignaturas);
        menuMatriculas.setFont(fuenteMenu);
        barra.add(menuMatriculas);
        //
        menuAlumnos.add(menuAgregarAlumno);
        menuAgregarAlumno.setFont(fuenteMenu);
        menuAsignaturas.add(new JSeparator());

        // Aquí irían más opciones de menú
        //
        //Por ultimo la barra de menu se la pongo a la ventana
        this.setJMenuBar(barra);

    }

    //Barra de herramientas
    public void initToolBar() {
        botonAbrir.setIcon(new ImageIcon("lib/imagenes/abrir.png"));
        barraTool.add(botonAbrir);
        this.add(barraTool, BorderLayout.NORTH);
    }

    public void initEventos() {
        menuAgregarAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaNuevoAlumno();
            }
        });
        botonAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirExploradorArchivos();
            }
        });

    }
    public void abrirVentanaNuevoAlumno() {
        AgregarAlumnoVentana agregarAlumnoVentana = new AgregarAlumnoVentana();
        agregarAlumnoVentana.setVisible(true);

        agregarAlumnoVentana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTablaAlumnos(); // Actualizar la tabla
            }
        });
    }


    public void abrirExploradorArchivos() {
        JFileChooser chooser = new JFileChooser("C:/Program Files/");
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Ejecutables", "exe");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            try {
                Runtime.getRuntime().exec(archivo.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*public void crearArbolContactos() {
        scroll = new JScrollPane(arbolContactos);
        split1.add(scroll);
    }*/

    public void setBotonesBar(){
        //Defino un layout flow especial
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 15, 15);
        //Se lo aplico al panel del norte
        pnNorte.setLayout(fl);
        //Al panel del norte le meto los diferentes botones
        pnNorte.add(boton2);
        pnNorte.add(boton3);

    }
    public void establecerPestanas() {
        iniciarTablaAlumnos();

        // Redimensionar los iconos antes de asignarlos a las pestañas
        ImageIcon iconoAlumno = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png", 24, 24);
        ImageIcon iconoAsignaturas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png", 24, 24);
        ImageIcon iconoMatriculas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png", 24, 24);

        // Asignar los iconos redimensionados a las pestañas
        pnPestannas.addTab("Alumnos", iconoAlumno, panelAlumnos);

        JPanel panelAsignaturas = new JPanel();
        panelAsignaturas.add(new JLabel("Aquí irá la tabla de asignaturas"));
        pnPestannas.addTab("Asignaturas", iconoAsignaturas, panelAsignaturas);

        JPanel panelMatriculas = new JPanel();
        panelMatriculas.add(new JLabel("Aquí irá la tabla de matriculas"));
        pnPestannas.addTab("Matriculas", iconoMatriculas, panelMatriculas);

        split1.add(pnPestannas);
    }


    private void iniciarTablaAlumnos() {
        //Se crea una Jtable a partir del modelo definido AbstractTableModel

        //JTable tablaAlumnos = new JTable();
        tablaAlumnos = new JTable(new TablaAlumnosModel());
        JScrollPane pnScroll = new JScrollPane(tablaAlumnos);
        panelAlumnos.add(pnScroll, BorderLayout.CENTER);

        //Le asigna un modo de redimensionamiento de columnas especial a la tabla
        tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        //A la tabla le voy a poner color de fuente y fondo diferente al blanco
        //tabla.setForeground(Color.white);
        //tabla.setBackground(Color.blue);

        /** Instalacion de renderers o maquillaje de celdas*/
        //Primero, hallo el modelo de columnas de la tabla
        TableColumnModel tcm = tablaAlumnos.getColumnModel();

        //TableColumn tc2 = tcm.getColumn(TablaAlumnosModel.ESTADOMATRICULA);
        //tc2.setHeaderRenderer(new MultilineaCabecera());

        //Selecciones de celdas, filas, y columnas varias
        tablaAlumnos.setRowSelectionAllowed(true);
        tablaAlumnos.setColumnSelectionAllowed(true);
        tablaAlumnos.setCellSelectionEnabled(true);

    }
    public static ArrayList<Alumno> obtenerAlumnosDesdeBD() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = connect()) {
            // Consulta SQL para obtener los alumnos
            String query = "SELECT id, nombre, direccion, estado_matricula FROM alumno ORDER BY nombre ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Recorrer el resultado y crear objetos Alumno
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estadoMatricula = rs.getString("estado_matricula");
                Alumno alumno = new Alumno(id, nombre, direccion, estadoMatricula);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
    public void actualizarTablaAlumnos() {
        ArrayList<Alumno> alumnos = obtenerAlumnosDesdeBD();

        if (tablaAlumnos == null) {
            System.err.println("Error: tablaAlumnos no ha sido inicializada.");
            return;
        }
        tablaAlumnos.validate();
        //TablaAlumnosModel modeloAlumnos = (TablaAlumnosModel) tablaAlumnos.getModel();

        // Actualizar los datos del modelo
        //modeloAlumnos.actualizarDatos();

        // Notificar a la tabla que los datos han cambiado
       // modeloAlumnos.fireTableDataChanged();
       // ((TablaAlumnosModel) tablaAlumnos.getModel()).cargarDatos();
        // Refrescar la tabla
        tablaAlumnos.repaint();
        tablaAlumnos.revalidate();



    }


    public static void main (String[] args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}