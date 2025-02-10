package ProyectoInstitutoSalesianos;

import javax.swing.*;
import java.awt.*;

public class AgregarAlumnoVentana extends JFrame {
   Container panel;
   GridLayout gLayout;
   JButton btnAceptar = new JButton("Aceptar");
   JButton btnCancelar = new JButton("Cancelar");
   JLabel lblNombre = new JLabel("Nombre");
    JLabel lblApellido = new JLabel("Apellido");
    JTextField txtNombre = new JTextField(30);
    JTextField txtApellido = new JTextField(30);
    JLabel lblDireccion = new JLabel("Dirección");
    JTextField txtDireccion = new JTextField(30);
    JLabel lblEstado = new JLabel("Estado");
    JTextField txtEstado = new JTextField(30);


    public AgregarAlumnoVentana(){

        initGUI();
    }

    private void initGUI() {
        panel = this.getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuración básica de los constraints
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1 - Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtNombre, gbc);

        // Fila 2 - Dirección
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblDireccion, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtDireccion, gbc);

        // Fila 3 - Estado
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblEstado, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtEstado, gbc);

        // Fila 4 - Botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonesPanel.add(btnAceptar);
        botonesPanel.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(botonesPanel, gbc);
//        gLayout = new GridLayout(3,2);
//
//        panel = this.getContentPane();
//        panel.setLayout(gLayout);
//        panel.add(lblNombre);
//        panel.add(txtNombre);
//        panel.add(lblApellido);
//        panel.add(txtApellido);
//        panel.add(btnAceptar);
//        panel.add(btnCancelar);
    }

    public static void  main(String [] args) {
        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setTitle("Agregar Alumno");
        ventana.setSize(400, 300);
        ventana.setVisible(true);
    }


}

