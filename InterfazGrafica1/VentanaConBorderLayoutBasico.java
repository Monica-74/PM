package InterfazGrafica1;

import javax.swing.*;
import java.awt.*;

public class VentanaConBorderLayoutBasico extends JFrame {

    //el JFrame no se meten las cosas sino en el contenedor
    //defino las fuentes
    BorderLayout layout = new BorderLayout();
    Font fuente = new Font("Courier", Font.BOLD, 36);


    //Elementos del formulario que son las etiquetas
    JLabel lblNorte = new JLabel("Etiqueta NORTE");
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

    public VentanaConBorderLayoutBasico() {
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

        lblNorte.setFont(fuente);
        lblEste.setFont(fuente);
        lblOeste.setFont(fuente);
        lblSur.setFont(fuente);

        //vamos a añadir a cada panel su etiqueta correspondiente
        pnNorte.add(lblNorte);
        //botones

        pnEste.add(lblOeste);
        pnOeste.add(lblEste);
        pnSur.add(lblSur);

        //Panel del centro que esta definido como un split pane vertical
        //eso significa que añado 2 cosas y una se pone encima  de la otra
        //el boton el priemro,va arriba
        splitCentral.add(btnCentro);
        //btnCentro.setVerticalAlignment(SwingConstants.TOP);
        splitCentral.add(textAreaCentro);
        //propiedades del panel divisor,central
        // es lo que esta entre el boton centro y el area de texto centro abajo
        splitCentral.setDividerLocation(400);
        splitCentral.setOneTouchExpandable(true);
        lblNorte.setFont(fuente);

        //agrero los componenetes al panel contendor del JFrma
        //en las posiciones del border layout
        panelContenedor.add(pnNorte, BorderLayout.NORTH);
        panelContenedor.add(splitCentral, BorderLayout.CENTER);
        panelContenedor.add(pnOeste, BorderLayout.WEST);
        panelContenedor.add(pnEste, BorderLayout.EAST);
        panelContenedor.add(pnSur, BorderLayout.SOUTH);


    }


    public static void main(String[] args) {
       VentanaConBorderLayoutBasico ventana = new VentanaConBorderLayoutBasico();
        ventana.setTitle("Ejercicio basico border layout 2 dam");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}

