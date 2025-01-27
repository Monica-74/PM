

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProyectoInstitutoJava extends JFrame {

    //el JFrame no se meten las cosas sino en el contenedor
    //defino las fuentes
    //este es el de los botones de arriba del todo
    //faltaria meter el icono para que este bien?????
    BorderLayout layout = new BorderLayout();
    Font fuente = new Font("Courier", Font.BOLD, 36);
    FlowLayout fl = new FlowLayout(FlowLayout.LEFT,10,5);

    JButton btnAccion1= new JButton("Accion 1");
    JButton btnAccion2= new JButton("Accion 2");
    JButton btnAccion3= new JButton("Accion 3");
    private final AgregarAlumnoVentana ventanaAgregarAlumno = new AgregarAlumnoVentana();




    //Elementos del formulario

    JLabel lblOeste = new JLabel("Etiqueta OESTE");
    JLabel lblEste = new JLabel("Etiqueta ESTE");
    JLabel lblSur = new JLabel("Etiqueta SUR");
    JSplitPane splitCentral = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //seria lo que va en medio y no los laterales.
    //me va a poner los elementos al contrario, es decir en horizontal.
    Container panelContenedor;
    JPanel pnOeste = new JPanel();
    JPanel pnEste = new JPanel();
    JPanel pnNorte = new JPanel();
    JPanel pnSur = new JPanel();


    //elementos visuales:

    JButton btnCentro = new JButton("Boton centro");
    JTextArea textAreaCentro;



    public ProyectoInstitutoJava() {
        //se pueden hacer otras cosas,
        //se inicia la interfaz de usuatio
        initGUI();
    }

    private void initGUI() {
        //hago el panel contendor de  un
        panelContenedor = this.getContentPane();
        //le aplico al panel contenedor un Border LAyout
        panelContenedor.setLayout(layout);

        //empiezo a definir elementos
        textAreaCentro = new JTextArea(10, 50);
        textAreaCentro.setFont(fuente);
        textAreaCentro.setText("Area de texto centro abajo");

        //a las etiquetas les asigno a todas las fuentes creadas anteriormente
//        no es necesario ni imprescindible, pero ayuda a mejorar la vista

        lblEste.setFont(fuente);
        lblOeste.setFont(fuente);
        lblSur.setFont(fuente);

    //ventanitas de arriba del todo
        lblEste.setFont(fuente);
        lblOeste.setFont(fuente);
        lblSur.setFont(fuente);



        //vamos a añadir a cada panel su etiqueta correspondiente y le añado el panel
        pnNorte.setLayout(fl);
        //botones
        btnAccion1.setFont(fuente);
        btnAccion1.setToolTipText("este boton es el primero");
       // btnAccion1.setIcon(new ImageIcon("lib/imagenes/entrenamiento.png"));

        btnAccion1.setIcon((new ImageIcon("lib/imagenes/entrenamiento.png")));
        btnAccion1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaAgregarAlumno();

                    }
                });








        pnNorte.add(btnAccion1);
        pnNorte.add(btnAccion2);
        pnNorte.add(btnAccion3);

        //Panel del centro que esta definido como un split pane vertical
        //eso significa que añado 2 cosas y una se pone encima  de la otra
        //el boton el priemro,va arriba
        splitCentral.add(btnCentro);
        //btnCentro.setVerticalAlignment(SwingConstants.TOP);
        splitCentral.add(textAreaCentro);
        //propiedades del panel divisor,central
        splitCentral.setDividerLocation(400);
        splitCentral.setOneTouchExpandable(true);

        //agrero los componenetes al panel contendor del JFrma
        //en las posiciones del border layout
        panelContenedor.add(pnNorte, BorderLayout.NORTH);
        panelContenedor.add(splitCentral, BorderLayout.CENTER);
        panelContenedor.add(pnOeste, BorderLayout.WEST);
        panelContenedor.add(pnEste, BorderLayout.EAST);
        panelContenedor.add(pnSur, BorderLayout.SOUTH);
    }






    public static void main(String[] args) {
        ProyectoInstitutoJava ventana = new ProyectoInstitutoJava();
        ventana.setTitle("Ejercicio basico border layout 2 dam");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    private void abrirVentanaAgregarAlumno() {
        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setTitle("Agregar Alumno");
        ventana.setSize(400,300);
        ventana.setVisible(true);
    }
}


