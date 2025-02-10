package ProyectoInstitutoSalesianos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConBorderLayout extends JFrame {

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


    public VentanaConBorderLayout() {
        //se pueden hacer otras cosas,
        //se inicia la interfaz de usuatio
        initGUI();
        initMenu();
    }

    private void initGUI() {
        //hago el panel contendor de  un
        panelContenedor = this.getContentPane();
        //le aplico al panel contenedor un Border LAyout
        panelContenedor.setLayout(layout);

        //empiezo a definir elementos
        /*textAreaCentro = new JTextArea(10, 50);
        textAreaCentro.setFont(fuente);
        textAreaCentro.setText("Area de texto centro abajo");*/

        //a las etiquetas les asigno a todas las fuentes creadas anteriormente
//        no es necesario ni imprescindible, pero ayuda a mejorar la vista
//        lblNorte.setFont(fuente);


        //vamos a añadir a cada panel su etiqueta correspondiente
//        pnNorte.add(lblNorte);
        //botones





        //splitCentral.add(btnCentro);
        //btnCentro.setVerticalAlignment(SwingConstants.TOP);
        //splitCentral.add(textAreaCentro);
        //propiedades del panel divisor,central
        // es lo que esta entre el boton centro y el area de texto centro abajo
        //splitCentral.setDividerLocation(400);
        //splitCentral.setOneTouchExpandable(true);
//        lblNorte.setFont(fuente);

        //agrero los componenetes al panel contendor del JFrma
        //en las posiciones del border layout
//        panelContenedor.add(pnNorte, BorderLayout.NORTH);

        JTabbedPane panelPestana = new JTabbedPane();

        int iconWidth = 24, iconHeight = 24;

        ImageIcon iconAlumnos = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\alumno.png", 24 , 24);
        ImageIcon iconAsignaturas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\asignaturas.png", iconWidth, iconHeight);
        ImageIcon iconMatriculas = createResizedIcon("C:\\Users\\blanco.mamoi\\Downloads\\PS\\InterfacesGraficasUsuario\\src\\InterfazGrafica2\\tesis.png", iconWidth, iconHeight);

        // Agregar pestañas con iconos
        panelPestana.addTab("Alumnos", iconAlumnos, new JPanel());
        panelPestana.addTab("Asignaturas", iconAsignaturas, new JPanel());
        panelPestana.addTab("Matriculas", iconMatriculas, new JPanel());

        panelContenedor.add(panelPestana, BorderLayout.CENTER);
    }


       //initMenu();

    private ImageIcon createResizedIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

//    private ImageIcon resizeIcon(String path, int width, int height) {
//        URL resource = getClass().getResource(path);
////        if (resource == null) {
////           // throw new IllegalArgumentException("El recurso no se encuentra: " + path);
////        }
//        ImageIcon originalIcon = new ImageIcon(resource);
//        Image img = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
//        return new ImageIcon(img);
//    }


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

//       menuAsignatura.add(agregarAsignatura);
//        agregarAsignatura.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaAgregarAsignatura();
//            }
//        });
//       menuMatricula.add(agregarMatricula);
//        agregarMatricula.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaAgregarMatricula();
//            }
//        });
//    }




    }

    private void abrirVentanaAgregarAlumno() {
        ventanaAgregarAlumno.setTitle("Agregar alumno");
        ventanaAgregarAlumno.setSize(400, 300);
        ventanaAgregarAlumno.setVisible(true);
    }
//    private void abrirVentanaAgregarAsignatura() {
//        ventanaAgregarAsignatura.setTitle("Agregar Asignatura");
//        ventanaAgregarAsignatura.setSize(400,300);
//        ventanaAgregarAsignatura.setVisible(true);
//
//
//    }
//    private void abrirVentanaAgregarMatricula() {
//        JFrame ventanaAgregarMatricula = new JFrame("Agregar Matricula");
//        ventanaAgregarMatricula.setSize(400,300);
//        ventanaAgregarMatricula.setVisible(true);
//
//
//    }


    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setTitle("Ejercicio");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}


