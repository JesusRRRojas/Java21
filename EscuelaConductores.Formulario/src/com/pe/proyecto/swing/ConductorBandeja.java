/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pe.proyecto.swing;

import com.pe.proyecto.bean.EscuelaConductor;
import com.pe.proyecto.interfaces.EscuelaConductorDAO;
import com.pe.proyecto.persistencia.ConductorDAOImpl;
import com.pe.proyecto.util.JPanelMensaje;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miche
 */
public class ConductorBandeja extends javax.swing.JFrame {

    /**
     * Creates new form ConductorBandeja
     */
    JPanelMensaje JPanel = new JPanelMensaje();
    ArrayList<Object[]> ListaConductores = new ArrayList<>();
    
    public ConductorBandeja() {
        initComponents();
        setLocationRelativeTo(null);
        ListarConductores();
        setResizable(false);
        //setUndecorated(true);
        txtNombreBusqueda.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            buscarConductores(); // Llama al método separado
        }
    });
    }
    
    private void buscarConductores() {
        String nombre = txtNombreBusqueda.getText().trim();
        if (!nombre.isEmpty()) {
            ListarConductoresPorNombre(nombre);
        } else {
            ListarConductores();
        }
    }
    
    public void ListarConductores() {
        try {
            EscuelaConductorDAO conductorDAO = new ConductorDAOImpl();

            List<EscuelaConductor> conductores = conductorDAO.listarTodos();

            // Definir las columnas
            String columnas[] = {"Seleccionar", "ID_CONDUCTOR", "DEPARTAMENTO", "PROVINCIA", "DISTRITO", "NRO_RUC", "NOMBRE ESCUELA", "DIRECCION", "CORREO", "TELEFONO", "ESTADO"};

            // Crear un nuevo modelo con las columnas
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) return Boolean.class; // Primera columna será un checkbox
                    return super.getColumnClass(columnIndex);
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 0; // Solo la primera columna es editable (checkbox)
                }
            };

            // Llenar el modelo con los datos obtenidos
            for (EscuelaConductor c : conductores) {
                Object[] fila = {
                    false, c.getId(),
                    c.getNomDep(), c.getNomPro(), c.getNomDis(),
                    c.getNroRuc(), c.getNombreEstablecimiento(), c.getDireccion(),
                    c.getCorreo(), c.getTelefono(), c.getEstado()
                };
                modelo.addRow(fila);
            }

            tablaConductor.setModel(modelo);
            tablaConductor.repaint(); // Refrescar la tabla

            // Agregar un TableModelListener para manejar la selección única
            modelo.addTableModelListener(e -> {
                if (e.getColumn() == 0 && e.getType() == TableModelEvent.UPDATE) {
                    int selectedRow = e.getFirstRow();
                    boolean isChecked = (Boolean) modelo.getValueAt(selectedRow, 0);

                    if (isChecked) {
                        // Desmarcar todas las demás filas
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            if (i != selectedRow) {
                                modelo.setValueAt(false, i, 0);
                            }
                        }
                    }
                }
            });

        } catch (Exception e) {
            JPanel.Error(e.getMessage());
        }
    }

    public void ListarConductoresPorNombre(String Nombre) {
        try {
            EscuelaConductorDAO conductorDAO = new ConductorDAOImpl();

            List<EscuelaConductor> conductores = conductorDAO.listarPorNombre(Nombre);

            // Definir las columnas
            String columnas[] = {"Seleccionar", "ID_CONDUCTOR", "DEPARTAMENTO", "PROVINCIA", "DISTRITO", "NRO_RUC", "NOMBRE ESCUELA", "DIRECCION", "CORREO", "TELEFONO", "ESTADO"};

            // Crear un nuevo modelo con las columnas
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) return Boolean.class; // Primera columna será un checkbox
                    return super.getColumnClass(columnIndex);
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 0; // Solo la primera columna es editable (checkbox)
                }
            };

            // Llenar el modelo con los datos obtenidos
            for (EscuelaConductor c : conductores) {
                Object[] fila = {
                    false, c.getId(),
                    c.getNomDep(), c.getNomPro(), c.getNomDis(),
                    c.getNroRuc(), c.getNombreEstablecimiento(), c.getDireccion(),
                    c.getCorreo(), c.getTelefono(), c.getEstado()
                };
                modelo.addRow(fila);
            }

            tablaConductor.setModel(modelo);
            tablaConductor.repaint(); // Refrescar la tabla

            // Agregar un TableModelListener para manejar la selección única
            modelo.addTableModelListener(e -> {
                if (e.getColumn() == 0 && e.getType() == TableModelEvent.UPDATE) {
                    int selectedRow = e.getFirstRow();
                    boolean isChecked = (Boolean) modelo.getValueAt(selectedRow, 0);

                    if (isChecked) {
                        // Desmarcar todas las demás filas
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            if (i != selectedRow) {
                                modelo.setValueAt(false, i, 0);
                            }
                        }
                    }
                }
            });

        } catch (Exception e) {
            JPanel.Error(e.getMessage());
        }
    }
    
    private EscuelaConductor obtenerConductorSeleccionado() {
        
        for (int i = 0; i < tablaConductor.getRowCount(); i++) {
            Boolean seleccionado = (Boolean) tablaConductor.getValueAt(i, 0); // Columna del checkbox

            if (Boolean.TRUE.equals(seleccionado)) { // Si está seleccionado
                EscuelaConductor obj = new EscuelaConductor();
                obj.setId((int) tablaConductor.getValueAt(i, 1));
                obj.setNroRuc((String) tablaConductor.getValueAt(i, 5));
                obj.setNombreEstablecimiento((String) tablaConductor.getValueAt(i, 6));
                obj.setDireccion((String) tablaConductor.getValueAt(i, 7));
                obj.setCorreo((String) tablaConductor.getValueAt(i, 8));
                obj.setTelefono((String) tablaConductor.getValueAt(i, 9));
                obj.setEstado((String) tablaConductor.getValueAt(i, 10));
                return obj; // Devuelve el primer conductor encontrado
            }
        }
        return null; // Si no hay selección
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConductor = new javax.swing.JTable();
        txtNombreBusqueda = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaConductor.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablaConductor);
        if (tablaConductor.getColumnModel().getColumnCount() > 0) {
            tablaConductor.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tablaConductor.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tablaConductor.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tablaConductor.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        txtNombreBusqueda.setToolTipText("Buscar por nombre");
        txtNombreBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda por nombre"));
        txtNombreBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBusquedaActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Agregar nueva Escuela");
        btnRegistrar.setMaximumSize(new java.awt.Dimension(80, 25));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(80, 25));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(80, 25));
        btnEditar.setMinimumSize(new java.awt.Dimension(80, 25));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Escuela de Conductores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombreBusqueda)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtNombreBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBusquedaActionPerformed
          
    }//GEN-LAST:event_txtNombreBusquedaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        ConductorFormulario formulario = new ConductorFormulario();
        formulario.setTipoFormulario(1); // Registrar
        formulario.setConductorBandeja(this);
        formulario.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
                     
        EscuelaConductor obj = obtenerConductorSeleccionado();
        if(obj != null)
        {
            ConductorFormulario formulario = new ConductorFormulario();
            formulario.setTipoFormulario(2); // Actualizar
            formulario.setConductorBandeja(this);
            formulario.cargarEditar(obj);

            formulario.setVisible(true);
            
         
        }else{
            JPanel.Alert("Debe seleccionar algun registro de la bandeja");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        EscuelaConductor obj = obtenerConductorSeleccionado();
        if(obj != null)
        {
            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "Esta sgeuro de eliminar el registro",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            
            if(confirmacion == JOptionPane.YES_OPTION)
            {
                try {
                    EscuelaConductorDAO conductorDAO = new ConductorDAOImpl();
                    conductorDAO.eliminar(obj.getId());
                    ListarConductores();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }else{
            JPanel.Alert("Debe seleccionar algun registro de la bandeja");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConductorBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConductorBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConductorBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConductorBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConductorBandeja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConductor;
    private javax.swing.JTextField txtNombreBusqueda;
    // End of variables declaration//GEN-END:variables
}
