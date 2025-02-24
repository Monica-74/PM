package Vistas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Tecnico
 */
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
        AgregarAlumnoVentana form = new AgregarAlumnoVentana();
        form.setVisible(true);
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

        pnPestannas.addTab("Alumnos ", new ImageIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\alumno.png"),
                panelAlumnos);
        //Añadir algo para los otros 2 pestañas
        JPanel panelAsignaturas = new JPanel();
        panelAsignaturas.add(new JLabel("Aquí irá la tabla de asignaturas"));
        pnPestannas.addTab("Asignaturas ", new ImageIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\asignaturas.png"),
                panelAsignaturas);
        JPanel panelMatriculas = new JPanel();
        panelMatriculas.add(new JLabel("Aquí irá la tabla de matriculas"));
        pnPestannas.addTab("Matriculas ", new ImageIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\ProyectoInstitutoSalesiano\\src\\Vistas\\tesis.png"),
                panelMatriculas);
        split1.add(pnPestannas);
    }

    private void iniciarTablaAlumnos() {
        //Se crea una Jtable a partir del modelo definido AbstractTableModel

        JTable tableAlumnos = new JTable(new TablaAlumnosModel());
        JScrollPane pnScroll = new JScrollPane(tableAlumnos);
        panelAlumnos.add(pnScroll, BorderLayout.CENTER);

        //Le asigna un modo de redimensionamiento de columnas especial a la tabla
        tableAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        //A la tabla le voy a poner color de fuente y fondo diferente al blanco
        //tabla.setForeground(Color.white);
        //tabla.setBackground(Color.blue);

        /** Instalacion de renderers o maquillaje de celdas*/
        //Primero, hallo el modelo de columnas de la tabla
        TableColumnModel tcm = tableAlumnos.getColumnModel();

        //TableColumn tc2 = tcm.getColumn(TablaAlumnosModel.ESTADOMATRICULA);
        //tc2.setHeaderRenderer(new MultilineaCabecera());

        //Selecciones de celdas, filas, y columnas varias
        tableAlumnos.setRowSelectionAllowed(true);
        tableAlumnos.setColumnSelectionAllowed(true);
        tableAlumnos.setCellSelectionEnabled(true);

        //
        //
        //


    }


    public static void main (String[] args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
