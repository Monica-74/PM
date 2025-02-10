package InterfazGrafica1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EjemploAbstractButton extends JFrame {

    //declaramos los componentes que vamos a tener
    protected JButton boton = new JButton("Boton");
    protected JCheckBox casilla= new JCheckBox("MArcada");
    protected JRadioButton radio1 = new JRadioButton("Radio1");
    protected JRadioButton radio2 = new JRadioButton("Radio2");
    protected JToggleButton botonToogle = new JToggleButton("Boton no apretado");
    protected JComboBox combo= new JComboBox<>();
    protected Container panelContenedor;
    protected JList lista = new JList<>();



    public EjemploAbstractButton(){
        initGUI();
        initEventos();
    }

    public void initGUI(){
//averiguar el panel contenedor de la ventana
        panelContenedor = getContentPane();
        panelContenedor.setLayout(new FlowLayout());
//formo grupo de radios
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);

        //inicializo combo
        combo.addItem("Item 1");
        combo.addItem("Item 2");
        combo.addItem("Item 3");


        //agrego los componentes al panel contenedor
        panelContenedor.add(boton);
        panelContenedor.add(casilla);
        panelContenedor.add(botonToogle);
        panelContenedor.add(radio1);
        panelContenedor.add(radio2);
        panelContenedor.add(combo);



    }

    private void initEventos() {
        //eventos
        radiosListener(radio1, "Radio1");
        radiosListener(radio2, "Radio2");


        //implementacion boton de mensajito diciendo has pulsado el botón quieres aceptar???
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelContenedor, "HAs pulsado el botón");
            }


        });
        casilla.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int estado = e.getStateChange();

                SwingUtilities.invokeLater(() -> {

                    if (estado == ItemEvent.SELECTED) { //casilla ha sido seleccionada o no en el ejemplo de la interfaz
                        JOptionPane.showMessageDialog(panelContenedor, "La casilla ha sido seleccionada");

                    } else if (estado == ItemEvent.DESELECTED) {
                        JOptionPane.showMessageDialog(panelContenedor, "La casilla ha sido desmarcada");
                    }
                });
            }
        });

        botonToogle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonToogle.isSelected()) {

                    botonToogle.setText("Boton apretado");
                } else {
                    botonToogle.setText("Boton no apretado");
                }
            }
        });

        combo.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                String itemSeleccionado = cb.getSelectedItem().toString();
                JOptionPane.showMessageDialog(panelContenedor, "El item seleccionado es:" + itemSeleccionado);
            }
        });
    }

    protected void radiosListener(JRadioButton radio, final String nombre) {
        radio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    JOptionPane.showMessageDialog(panelContenedor, "El " + nombre + "ha sido seleccionado");

                }
            }
        });










    }







    public static void main(String[]args){
        EjemploAbstractButton marco = new EjemploAbstractButton();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400,300);
        marco.setVisible(true);
    }


//    public void initEventos() {
//
//        radiosListener
//
//
//    }










}
