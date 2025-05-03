package com.pe.proyecto.app;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.pe.proyecto.bean.EscuelaConductor;
import com.pe.proyecto.interfaces.EscuelaConductorDAO;
import com.pe.proyecto.persistencia.ConductorDAOImpl;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

public class ConductorApi extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField txtNombre, txtDireccion, txtCorreo, txtTelefono;
    private JButton btnAgregar, btnActualizar, btnEliminar;
    private EscuelaConductorDAO conductorDAO;
    private int selectedId = -1;
    private JPanel panel;

    public ConductorApi() throws Exception {
        setTitle("Gestión de Conductores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        conductorDAO = new ConductorDAOImpl();

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.addListSelectionListener(e -> cargarDatosSeleccionados());
        add(new JScrollPane(list), BorderLayout.WEST);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formPanel.add(txtNombre);

        formPanel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        formPanel.add(txtDireccion);

        formPanel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        formPanel.add(txtCorreo);

        formPanel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        formPanel.add(txtTelefono);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        btnAgregar.addActionListener(e -> agregarConductor());
        btnActualizar.addActionListener(e -> actualizarConductor());
        btnEliminar.addActionListener(e -> eliminarConductor());

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnActualizar);
        buttonPanel.add(btnEliminar);

        add(buttonPanel, BorderLayout.SOUTH);

        panel = new JPanel();
        panel.putClientProperty(FlatClientProperties.STYLE, "arc:25; background:#D3D3D3;");
        cargarListaConductores();
    }

    private void cargarListaConductores() {
        try {
            listModel.clear();
            List<EscuelaConductor> conductores = conductorDAO.listarTodos();
            for (EscuelaConductor c : conductores) {
                listModel.addElement(c.getId() + " - " + c.getNombreEstablecimiento());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar conductores", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosSeleccionados() {
        try {
            String selected = list.getSelectedValue();
            if (selected != null) {
                selectedId = Integer.parseInt(selected.split(" - ")[0]);
                EscuelaConductor conductor = conductorDAO.BuscarPorId(selectedId);
                if (conductor != null) {
                    txtNombre.setText(conductor.getNombreEstablecimiento());
                    txtDireccion.setText(conductor.getDireccion());
                    txtCorreo.setText(conductor.getCorreo());
                    txtTelefono.setText(conductor.getTelefono());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos del conductor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarConductor() {
        try {
            EscuelaConductor obj = new EscuelaConductor();
            obj.setNombreEstablecimiento(txtNombre.getText());
            obj.setDireccion(txtDireccion.getText());
            obj.setCorreo(txtCorreo.getText());
            obj.setTelefono(txtTelefono.getText());
            conductorDAO.insertar(obj);
            cargarListaConductores();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar conductor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarConductor() {
        try {
            if (selectedId != -1) {
                EscuelaConductor obj = new EscuelaConductor();
                obj.setId(selectedId);
                obj.setNombreEstablecimiento(txtNombre.getText());
                obj.setDireccion(txtDireccion.getText());
                obj.setCorreo(txtCorreo.getText());
                obj.setTelefono(txtTelefono.getText());
                conductorDAO.actualizar(obj);
                cargarListaConductores();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar conductor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarConductor() {
        try {
            if (selectedId != -1) {
                conductorDAO.eliminar(selectedId);
                cargarListaConductores();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar conductor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            try {
                new ConductorApi().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
