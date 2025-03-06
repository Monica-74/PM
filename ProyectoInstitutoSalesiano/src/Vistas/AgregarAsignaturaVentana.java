package Vistas;

import Controlador.ControladorAsignaturas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarAsignaturaVentana extends JFrame {
    private JTextField txtNombre = new JTextField();
    JLabel lblNombre = new JLabel("Nombre de la Asignatura: ");
    private JTextField txtCurso = new JTextField();
    JLabel lblCurso = new JLabel("Nombre del Curso: ");

    private JButton aceptarButton = new JButton("Aceptar");
    private JButton cancelarButton = new JButton("Cancelar");
    private JPanel centroPanel = new JPanel();

    Font fuenteBotones = new Font("SansSerif", Font.BOLD, 12);

    private VentanaPrincipal ventanaPrincipal;
    private ControladorAsignaturas controladorAsignaturas = new ControladorAsignaturas();

    public AgregarAsignaturaVentana(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        initGUI();
        iniciarEventos();
        centrarVentana();
    }

    private void initGUI() {
        JPanel asignaturaPanel = new JPanel(new GridBagLayout());
        JPanel alumnoPanel = new JPanel(new GridBagLayout());
        alumnoPanel.add(lblNombre, new GridBagConstraints(0, 1, 1, 1, 0.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(12, 12, 0, 0), 0, 0));
        alumnoPanel.add(txtNombre, new GridBagConstraints(1, 1, 3, 1, 100.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(12, 12, 0, 12), 0, 0));
        alumnoPanel.add(lblCurso, new GridBagConstraints(0, 2, 1, 1, 0.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(12, 12, 0, 0), 0, 0));
        alumnoPanel.add(txtCurso, new GridBagConstraints(1, 2, 4, 4, 100.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(12, 12, 0, 12), 0, 0));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(alumnoPanel, BorderLayout.NORTH);
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(aceptarButton);
        botonesPanel.add(cancelarButton);
        getContentPane().add(botonesPanel, BorderLayout.SOUTH);

        this.setSize(500, 550);
        this.setResizable(false);
        iniciarEventos();
        cargarRecursos();
        centrarVentana();
        //setTitle("Nueva Asignatura");
    }

    private void iniciarEventos() {
        cancelarButton.addActionListener(e -> dispose());
        aceptarButton.addActionListener(this::agregarAsignatura);
    }

    private void agregarAsignatura(ActionEvent e) {
        String nombre = txtNombre.getText().trim();
        String curso = txtCurso.getText().trim();

        if (nombre.isEmpty() || curso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            //String curso = Integer.parseInt(cursoStr);
            int resultado = controladorAsignaturas.insertarAsignatura(nombre, curso);

            if (resultado > 0) {
                JOptionPane.showMessageDialog(this, "Asignatura agregada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                TablaAsignaturasModel modeloTabla =(TablaAsignaturasModel) ventanaPrincipal.tablaAsignaturas().getModel();
                modeloTabla.recargarDatos();
                this.ventanaPrincipal.tablaAsignaturas.setModel(new TablaAsignaturasModel());

//                ventanaPrincipal.actualizarTablaAsignaturas();
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(this, "Error al agregar asignatura", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "El curso debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    private void centrarVentana() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = kit.getScreenSize();
        setLocation(tamanoPantalla.width / 2 - getWidth() / 2, tamanoPantalla.height / 2 - getHeight() / 2);
    }
    private void cargarRecursos() {


        // Ajustar botones
        aceptarButton.setText("Aceptar");
        aceptarButton.setIcon(new ImageIcon("lib/imagenes/stock_apply_24.gif"));
        aceptarButton.setPreferredSize(new Dimension(100, 30)); // Tamaño preferido
        aceptarButton.setMargin(new Insets(5, 10, 5, 10));      // Margen interno
        aceptarButton.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar texto
        aceptarButton.setVerticalTextPosition(SwingConstants.CENTER);
        aceptarButton.setFont(fuenteBotones);

        cancelarButton.setText("Cancelar");
        cancelarButton.setIcon(new ImageIcon("lib/imagenes/stock_cancel_24.gif"));
        cancelarButton.setPreferredSize(new Dimension(100, 30)); // Tamaño preferido
        cancelarButton.setMargin(new Insets(5, 10, 5, 10));      // Margen interno
        cancelarButton.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar texto
        cancelarButton.setVerticalTextPosition(SwingConstants.CENTER);
        cancelarButton.setFont(fuenteBotones);

        // Tamaño del campo de texto
        txtNombre.setSize(25, 300);
        this.setTitle("Nueva Asignatura");
    }
}

