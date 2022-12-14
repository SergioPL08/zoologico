package InterfazV2;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Conexion;
import util.TextPrompt;
import zoo.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author sergio
 */
public class addEspecialidad extends javax.swing.JFrame {
    ArrayList<Especialidad> especialidades;
    Conexion miConexion;
    DefaultTableModel modelo;
    /**
     * Creates new form addEspecialidad
     */
    public addEspecialidad() {
        try {
            initComponents();
            //TextPrompt sirve para poner un placeholder en un textfield
            TextPrompt name = new TextPrompt("Perros", jTFNombreEsp);
            TextPrompt descripcion = new TextPrompt("Especialista en cuidado y tratado de perros", jTADesc);
            
            especialidades = new ArrayList<Especialidad>();
            miConexion = new Conexion("localhost","3306","zoologico","zoo","pepe");
            //Rellenamos la tabla de especialidades con los datos de la base de datos
            modelo = (DefaultTableModel) jTablaEspecialidades.getModel();
            
            String consulta = "SELECT * FROM especialidad";
            ResultSet rsTabla = miConexion.getSelect(consulta);
            while(rsTabla.next()){
                modelo.addRow(new Object[] {rsTabla.getInt(1),rsTabla.getString(2),rsTabla.getString(3),rsTabla.getTimestamp(4)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(addEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        addEspecialidad = new javax.swing.JLabel();
        JLDescrip = new javax.swing.JLabel();
        JLNombreEsp = new javax.swing.JLabel();
        jTFNombreEsp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADesc = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEspecialidades = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAdd = new javax.swing.JButton();
        JButtonEditAnimal = new javax.swing.JToggleButton();
        JButtonRemoveAnimal = new javax.swing.JToggleButton();
        JButtonErase = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 35, 0, 35, 0};
        jPanel1Layout.rowHeights = new int[] {0, 32, 0, 32, 0, 32, 0, 32, 0};
        jPanel1.setLayout(jPanel1Layout);

        addEspecialidad.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        addEspecialidad.setForeground(new java.awt.Color(51, 51, 51));
        addEspecialidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addEspecialidad.setText("A??adir Especialidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(addEspecialidad, gridBagConstraints);

        JLDescrip.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        JLDescrip.setForeground(new java.awt.Color(0, 153, 51));
        JLDescrip.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLDescrip.setText("Descripcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(JLDescrip, gridBagConstraints);

        JLNombreEsp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        JLNombreEsp.setForeground(new java.awt.Color(0, 153, 51));
        JLNombreEsp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLNombreEsp.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(JLNombreEsp, gridBagConstraints);

        jTFNombreEsp.setBackground(new java.awt.Color(255, 255, 255));
        jTFNombreEsp.setForeground(new java.awt.Color(0, 0, 0));
        jTFNombreEsp.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jTFNombreEsp, gridBagConstraints);

        jTADesc.setBackground(new java.awt.Color(255, 255, 255));
        jTADesc.setColumns(20);
        jTADesc.setForeground(new java.awt.Color(51, 51, 51));
        jTADesc.setRows(5);
        jScrollPane2.setViewportView(jTADesc);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jTablaEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "??ltima Modificaci??n"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaEspecialidades);
        if (jTablaEspecialidades.getColumnModel().getColumnCount() > 0) {
            jTablaEspecialidades.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTablaEspecialidades.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTablaEspecialidades.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTablaEspecialidades.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAdd.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButtonAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAdd);

        JButtonEditAnimal.setBackground(new java.awt.Color(51, 51, 51));
        JButtonEditAnimal.setForeground(new java.awt.Color(0, 0, 0));
        JButtonEditAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        JButtonEditAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JButtonEditAnimal.setPreferredSize(new java.awt.Dimension(70, 22));
        JButtonEditAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonEditAnimalActionPerformed(evt);
            }
        });
        jToolBar1.add(JButtonEditAnimal);

        JButtonRemoveAnimal.setBackground(new java.awt.Color(51, 51, 51));
        JButtonRemoveAnimal.setForeground(new java.awt.Color(0, 0, 0));
        JButtonRemoveAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        JButtonRemoveAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JButtonRemoveAnimal.setPreferredSize(new java.awt.Dimension(70, 22));
        JButtonRemoveAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRemoveAnimalActionPerformed(evt);
            }
        });
        jToolBar1.add(JButtonRemoveAnimal);

        JButtonErase.setBackground(new java.awt.Color(51, 51, 51));
        JButtonErase.setForeground(new java.awt.Color(0, 0, 0));
        JButtonErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        JButtonErase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JButtonErase.setFocusable(false);
        JButtonErase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JButtonErase.setPreferredSize(new java.awt.Dimension(70, 22));
        JButtonErase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JButtonErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonEraseActionPerformed(evt);
            }
        });
        jToolBar1.add(JButtonErase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        String nombre = jTFNombreEsp.getText();
        String desc = jTADesc.getText();
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Introduce el nombre");
        }
        else{
            Especialidad esp = new Especialidad (nombre,desc);
            especialidades.add(esp);
            try{
                String consulta = "SELECT * FROM especialidad WHERE nombre='"+nombre+"' AND descripcion='"+desc+"'";
                ResultSet rs1 = miConexion.comprobarDatos(consulta);
                LocalDateTime dateTime = LocalDateTime.now();
                String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                if(rs1==null){
                    ResultSet rs = miConexion.getSelect("Select * from especialidad");
                    //Irse a la ultima linea de la tabla
                    rs.moveToInsertRow();
                    //
                    rs.updateString("nombre",nombre);
                    rs.updateString("descripcion",desc);
                    rs.insertRow();
                    //users.add(user);
                    JOptionPane.showMessageDialog(null, "Especialidad a??adida correctamente");
                    ResultSet getId=miConexion.comprobarDatos("SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='ZOO' AND TABLE_NAME='especialidad'");
                    modelo.addRow(new Object[] {getId.getInt("AUTO_INCREMENT")-1,nombre,desc,currentTimeStamp});
                    jTFNombreEsp.setText("");
                    jTADesc.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "La especialidad ya existe");
                }   
            } catch (SQLException ex) {
                Logger.getLogger(addEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void JButtonEditAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEditAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "??Est??s seguro? No podr??s recuperar los datos anteriores","Editar especie",JOptionPane.YES_OPTION);
        if(resp==0){
            String nombre = jTFNombreEsp.getText();
            String desc = jTADesc.getText();
            int fila = jTablaEspecialidades.getSelectedRow();
            int id=(int)jTablaEspecialidades.getValueAt(fila, 0);
            String sentencia = "UPDATE ESPECIALIDAD SET NOMBRE='"+nombre+"',DESCRIPCION='"+desc+"' WHERE ID="+id;
            System.out.println(sentencia);
            if(miConexion.editTable(sentencia)==1){
                modelo.setValueAt(jTFNombreEsp.getText(), fila, 1);
                modelo.setValueAt(jTADesc.getText(), fila, 2);
                JOptionPane.showMessageDialog(null, "Especialidad editada correctamente");
                jTFNombreEsp.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al editar la especialidad");
            }
        }
    }//GEN-LAST:event_JButtonEditAnimalActionPerformed

    private void JButtonRemoveAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRemoveAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "??Est??s seguro, man??n? No vas a poder recuperar los datos eliminados","Eliminar especie",JOptionPane.YES_OPTION);
        if(resp==0){
            int id=(int)jTablaEspecialidades.getValueAt(jTablaEspecialidades.getSelectedRow(), 0);
            int fila = jTablaEspecialidades.getSelectedRow();
            String sentencia = "DELETE FROM ESPECIALIDAD WHERE ID="+id;
            if(miConexion.editTable(sentencia)==1){
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Especialidad elimado correctamente");
                jTFNombreEsp.setText("");
                jTADesc.setText("");
            }
        }
        
    }//GEN-LAST:event_JButtonRemoveAnimalActionPerformed

    private void click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click
        int fila = jTablaEspecialidades.getSelectedRow();
        jTFNombreEsp.setText((String)jTablaEspecialidades.getValueAt(fila,1));
        jTADesc.setText((String)jTablaEspecialidades.getValueAt(fila,2));
    }//GEN-LAST:event_click

    private void JButtonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEraseActionPerformed
        jTFNombreEsp.setText("");
        jTADesc.setText("");
    }//GEN-LAST:event_JButtonEraseActionPerformed

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
            java.util.logging.Logger.getLogger(addEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addEspecialidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addEspecialidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JButtonEditAnimal;
    private javax.swing.JToggleButton JButtonErase;
    private javax.swing.JToggleButton JButtonRemoveAnimal;
    private javax.swing.JLabel JLDescrip;
    private javax.swing.JLabel JLNombreEsp;
    private javax.swing.JLabel addEspecialidad;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTADesc;
    private javax.swing.JTextField jTFNombreEsp;
    private javax.swing.JTable jTablaEspecialidades;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
