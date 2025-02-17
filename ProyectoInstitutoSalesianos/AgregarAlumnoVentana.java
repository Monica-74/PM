package ProyectoInstitutoSalesianos;

import ProyectoInstitutoSalesianos.Controlador.ControladorAlumnos;

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
    JLabel lblEstadoMatricula = new JLabel("Estado");
    JTextField txtEstadoMatricula = new JTextField(30);
    JComboBox estadoMatriculaCombo= new JComboBox();

    public AgregarAlumnoVentana(){
        agregarAlumno();
        initGUI();
        iniciarEventos();
    }

    private void iniciarEventos() {
    }

    private void agregarAlumno() {
        String nombre =txtNombre.getText();
        String direccion = txtDireccion.getText();
        String estadoMatricula = estadoMatriculaCombo.getSelectedItem().toString();
        int resultado = ControladorAlumnos.insertarAlumno(nombre,direccion,estadoMatricula);

        if(resultado > 0){
            JOptionPane.showMessageDialog(this,"Alumno agregado exitosamente");
            VentanaPrincipal.getVentanaPrincipal().tablaAlumnos.repaint();
            VentanaPrincipal.getVentanaPrincipal().tablaAlumnos.revalidate();

        }else{
            JOptionPane.showMessageDialog(this,"Error al agregar el Alummo");
        }
        dispose();//para que se cierre la ventana
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
        panel.add(lblEstadoMatricula, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtEstadoMatricula, gbc);

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
        //panel = this.getContentPane();
//        panel.setLayout(gLayout);
//        panel.add(lblNombre);
//        panel.add(txtNombre);
//        panel.add(lblApellido);
//        panel.add(txtApellido);
//        panel.add(btnAceptar);
//        panel.add(btnCancelar);
    }

    public void cargar(){
        estadoMatriculaCombo.addItem("Provisional");
        estadoMatriculaCombo.addItem("Confirmada");
        estadoMatriculaCombo.addItem("Cancelada");


    }

    public static void  main(String [] args) {
        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setTitle("Agregar Alumno");
        ventana.setSize(400, 300);
        ventana.setVisible(true);
    }


}

