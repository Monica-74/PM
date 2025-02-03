package InterfazGrafica1;

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
    public AgregarAlumnoVentana(){
        initGUI();
    }

    private void initGUI() {
        gLayout = new GridLayout(3,2);

        panel = this.getContentPane();
        panel.setLayout(gLayout);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(btnAceptar);
        panel.add(btnCancelar);
    }

    public static void  main(String [] args) {
        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setTitle("Agregar Alumno");
        ventana.setSize(400, 300);
        ventana.setVisible(true);
    }


}

