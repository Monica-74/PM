package ProyectoInstitutoSalesianos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    BorderLayout layout = new BorderLayout();
    Font fuente = new Font("Courier", Font.BOLD, 36);


    //Elementos del formulario que son las etiquetas
//    JLabel lblNorte = new JLabel("Etiqueta NORTE");

    //JSplitPane splitCentral = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //sería lo que va en medio y no los laterales.
    //me va a poner los elementos al contrario, es decir en horizontal.
    Container panelContenedor;

//    JPanel pnNorte = new JPanel();

    JFileChooser btnCentro = new JFileChooser("Boton Centro");


//    JButton btnCentro = new JButton("Boton centro");
//    JTextArea textAreaCentro;

    JTabbedPane pnPestannas = new JTabbedPane();
    JPanel panelTablaAlumnos = new JPanel();

    JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane getSplit2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//    Arbol2 arbolContactos = new Arbol2();
    JScrollBar scroll;




    //elementos de menu
    JMenuBar barra = new  JMenuBar();
    JMenu menuAlumnos = new JMenu("Alumnos");
    JMenu menuAsignatura = new JMenu("Asignaturas");
    JMenu menuMatricula = new JMenu("Matriculas");
    JMenuItem agregarAlumno = new JMenuItem("Agregar Alumnos");
    JMenuItem agregarAsignatura = new JMenuItem("Agregar Asignaturas");
    JMenuItem agregarMatricula = new JMenuItem("Agregar Matriculas");
    //    private final AgregarAsignaturaVentana ventanaAgregarAsignatura = new AgregarAsignaturaVentana();
    private final AgregarAlumnoVentana ventanaAgregarAlumno = new AgregarAlumnoVentana();
//    private final AgregarMatriculaVentana ventanaAgregarMatricula = new AgregarMatriculaVentana();

    JToolBar barraTool = new JToolBar();
    JButton botonAbrir = new JButton();
    JPanel panelAlumnos = new JPanel(new BorderLayout());
    JTable tablaAlumnos;

    public VentanaPrincipal() {
        //se pueden hacer otras cosas,
        //se inicia la interfaz de usuatio
        initGUI();
        initMenu();
    }

    public static VentanaPrincipal getVentanaPrincipal() {
        return null;
    }

    private void initGUI() {
        //hago el panel contendor de  un
        panelContenedor = this.getContentPane();
        //le aplico al panel contenedor un Border LAyout
        panelContenedor.setLayout(layout);
        //btnCentro.setVerticalAlim




        JTabbedPane panelPestana = new JTabbedPane();

        int iconWidth = 24, iconHeight = 24;
        // Agregar pestañas con iconos

        ImageIcon iconAlumnos = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\alumno.png", 24 , 24);
        ImageIcon iconAsignaturas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\asignaturas.png", iconWidth, iconHeight);
        ImageIcon iconMatriculas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\tesis.png", iconWidth, iconHeight);


        //crear texto para Alumno
//        JPanel panelAlumnos = new JPanel(new BorderLayout());
//        JTable tablaAlumnos = new JTable(new TablaAlumnosModel());

        //JScrollPane scrollTabla = new JScrollPane(tablaAlumnos);
        //panelAlumnos.add(panelAlumnos, BorderLayout.CENTER);

        panelPestana.addTab("Alumnos", iconAlumnos, panelAlumnos);

        iniciarTablaAlumno();

        JPanel panelAsignaturas = new JPanel();
        panelAsignaturas.add(new JLabel("asignaturas"));
        panelPestana.addTab("Asignaturas", iconAsignaturas, panelAsignaturas);
        panelPestana.addTab("Matriculas", iconMatriculas, new JPanel());

        panelContenedor.add(panelPestana, BorderLayout.CENTER);
    }

    private void iniciarTablaAlumno(){
        JTable tablaAlumnos = new JTable(new TablaAlumnosModel());

        JScrollPane scrollPaneAlumnos = new JScrollPane(tablaAlumnos);
        tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelAlumnos.add(scrollPaneAlumnos, BorderLayout.CENTER);

    }


    //initMenu();

    private ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }




    public void initMenu () {

        this.setJMenuBar(barra);
        barra.add(menuAlumnos);
        barra.add(menuAsignatura);
        barra.add(menuMatricula);
        menuAlumnos.add(agregarAlumno);
        agregarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarAlumno();
            }
        });

    }

    private void abrirVentanaAgregarAlumno() {
        ventanaAgregarAlumno.setTitle("Agregar alumno");
        ventanaAgregarAlumno.setSize(400, 300);
        ventanaAgregarAlumno.setVisible(true);
    }


    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setTitle("Ejercicio");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}


