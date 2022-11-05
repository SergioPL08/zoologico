package InterfazV2;


import java.io.Serializable;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import zoo.Animal;
import util.Conexion;
import zoo.Especie;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author sergio
 */
public class addAnimal extends javax.swing.JFrame implements Serializable{
    ArrayList<Animal> animales;
    Conexion miConexion;
    DefaultTableModel modelo;
    ArrayList especies;
    /**
     * Creates new form addAnimañ
     */
    
    
    public addAnimal() {
        try{
            initComponents();
            especies = new ArrayList();
            animales = new ArrayList<Animal>();
            miConexion = new Conexion("localhost","3306","zoologico","zoo","pepe");
            //Rellenamos la tabla de animales con los animales de la base de datos
            modelo = (DefaultTableModel) jTablaAnimales.getModel();
            String consulta = "SELECT animal.NOMBRE,animal.PESO,especie.NOMBRE_ESPECIE,ESPECIE.id_especie,ID_ANIMAL,animal.LAST_MOD FROM animal, especie WHERE animal.ESPECIE=especie.ID_ESPECIE ORDER BY id_animal";
            //System.out.println(consulta);
            ResultSet rsTabla = miConexion.getSelect(consulta);
            while(rsTabla.next()){
                Especie esp = new Especie(rsTabla.getInt(4),rsTabla.getString(3));
                modelo.addRow(new Object[] {rsTabla.getInt(5),rsTabla.getString(1),esp,rsTabla.getFloat(2),rsTabla.getTimestamp(6)});
            }
            //Rellenamos la caja de especies
            try{
                String consultaEspecie = "SELECT * FROM especie";
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                ResultSet rsEspecie = miConexion.getSelect(consultaEspecie);
                while (rsEspecie.next()){
                    Especie esp = new Especie(rsEspecie.getInt(1),rsEspecie.getString(2));
                    especies.add(esp);
                    model.addElement(esp);
                    //System.out.println(rsEspecie.getInt(1)+rsEspecie.getString(2));
                }
                jComboBoxEspecie.setModel(model);
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            catch(java.lang.NullPointerException ex){
                System.out.println("Abre el xamp xd");
            }
        }
        catch(SQLException ex){
                Logger.getLogger(addAnimal.class.getName()).log(Level.SEVERE,null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaAnimales = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        LnombreAnimal = new javax.swing.JLabel();
        LespecieAnimal = new javax.swing.JLabel();
        LpesoAnimal = new javax.swing.JLabel();
        TNombreAnimal = new javax.swing.JTextField();
        SPesoAnimal = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEspecie = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        JButtonAddAnimal = new javax.swing.JToggleButton();
        JButtonEditAnimal = new javax.swing.JToggleButton();
        JButtonRemoveAnimal = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTablaAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Especie", "Peso", "Última Modificación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaAnimales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectRow(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaAnimales);
        if (jTablaAnimales.getColumnModel().getColumnCount() > 0) {
            jTablaAnimales.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTablaAnimales.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTablaAnimales.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTablaAnimales.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 400));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 15, 0};
        jPanel2Layout.rowHeights = new int[] {0, 25, 0, 25, 0, 25, 0, 25, 0};
        jPanel2.setLayout(jPanel2Layout);

        LnombreAnimal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LnombreAnimal.setForeground(new java.awt.Color(0, 153, 51));
        LnombreAnimal.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(LnombreAnimal, gridBagConstraints);

        LespecieAnimal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LespecieAnimal.setForeground(new java.awt.Color(0, 153, 51));
        LespecieAnimal.setText("Especie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(LespecieAnimal, gridBagConstraints);

        LpesoAnimal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LpesoAnimal.setForeground(new java.awt.Color(0, 153, 51));
        LpesoAnimal.setText("Peso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(LpesoAnimal, gridBagConstraints);

        TNombreAnimal.setBackground(new java.awt.Color(255, 255, 255));
        TNombreAnimal.setForeground(new java.awt.Color(0, 0, 0));
        TNombreAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 51))); // NOI18N
        TNombreAnimal.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(TNombreAnimal, gridBagConstraints);

        SPesoAnimal.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        SPesoAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 51))); // NOI18N
        SPesoAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SPesoAnimal.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        jPanel2.add(SPesoAnimal, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir animal");
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jComboBoxEspecie, gridBagConstraints);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        JButtonAddAnimal.setBackground(new java.awt.Color(51, 51, 51));
        JButtonAddAnimal.setForeground(new java.awt.Color(0, 0, 0));
        JButtonAddAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        JButtonAddAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JButtonAddAnimal.setPreferredSize(new java.awt.Dimension(70, 22));
        JButtonAddAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textButtonAdd(evt);
            }
        });
        JButtonAddAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAddAnimalActionPerformed(evt);
            }
        });
        jToolBar1.add(JButtonAddAnimal);

        JButtonEditAnimal.setBackground(new java.awt.Color(51, 51, 51));
        JButtonEditAnimal.setForeground(new java.awt.Color(0, 0, 0));
        JButtonEditAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        JButtonEditAnimal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JButtonEditAnimal.setPreferredSize(new java.awt.Dimension(70, 22));
        JButtonEditAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textButtonEdit(evt);
            }
        });
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
        JButtonRemoveAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textButtonDelete(evt);
            }
        });
        JButtonRemoveAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRemoveAnimalActionPerformed(evt);
            }
        });
        jToolBar1.add(JButtonRemoveAnimal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddAnimalActionPerformed
        String nombre = TNombreAnimal.getText();
        Especie esp = new Especie((Especie)jComboBoxEspecie.getSelectedItem());
        int especie = esp.getId();
        String nombreEsp = esp.getName();
        float peso = (float) SPesoAnimal.getValue();
        //(String name, String especie, String subespecie, float peso)
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Introduce el nombre del animal");
        }
        else if(peso==0){
            JOptionPane.showMessageDialog(null, "El peso no puede ser 0");
        }
        else{
//            Animal animal = new Animal(nombre,especie,peso);
//            animales.add(animal);
//            //System.out.println(animales);
            try {
                String consulta = "SELECT * FROM animal WHERE nombre='"+nombre+"' AND especie="+especie;
                ResultSet rs1 =miConexion.comprobarDatos(consulta);
                LocalDateTime dateTime = LocalDateTime.now();
                String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                //System.out.println(rs1);
                if(rs1==null){
                    ResultSet rs = miConexion.getSelect("Select * from animal");
                    //Irse a la ultima linea de la tabla
                    rs.moveToInsertRow();
                    //
                    rs.updateString("nombre",nombre);
                    rs.updateInt("especie",especie);
                    rs.updateFloat("peso",peso);
                    rs.insertRow();
                    ResultSet getId=miConexion.comprobarDatos("SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='ZOO' AND TABLE_NAME='ANIMAL'");
                    //System.out.println(getId);
                    JOptionPane.showMessageDialog(null, "Animal añadido correctamente");
                    TNombreAnimal.setText("");
                    SPesoAnimal.setValue(0);
                    modelo.addRow(new Object[] {getId.getInt("AUTO_INCREMENT")-1,nombre,esp,peso,currentTimeStamp});
                }
                else{
                    JOptionPane.showMessageDialog(null, "El animal ya existe");
                }
            
        }   catch (SQLException ex) {
                Logger.getLogger(addAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JButtonAddAnimalActionPerformed

    private void JButtonEditAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEditAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro? No podrás recuperar los datos anteriores","Editar animal",JOptionPane.YES_OPTION);
        if(resp==0){
            String nombre = TNombreAnimal.getText();
            float peso = (float) SPesoAnimal.getValue();
            int fila = jTablaAnimales.getSelectedRow();
            int id=(int)jTablaAnimales.getValueAt(fila, 0);
            String sentencia = "UPDATE ANIMAL SET NOMBRE='"+nombre+"', PESO="+peso+" WHERE ID_ANIMAL="+id;
            System.out.println(sentencia);
            if(miConexion.editTable(sentencia)==1){
                LocalDateTime dateTime = LocalDateTime.now();
                String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                modelo.setValueAt(TNombreAnimal.getText(), fila, 1);
                modelo.setValueAt(SPesoAnimal.getValue(), fila, 3);
                modelo.setValueAt(currentTimeStamp, fila, 4);
                JOptionPane.showMessageDialog(null, "Animal editado correctamente");
                TNombreAnimal.setText("");
                SPesoAnimal.setValue(0);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al editar el animal");
            }
        }
    }//GEN-LAST:event_JButtonEditAnimalActionPerformed

    private void JButtonRemoveAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRemoveAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro, manín? No vas a poder recuperar los datos eliminados","Eliminar animal",JOptionPane.YES_OPTION);
        if(resp==0){
            int id=(int)jTablaAnimales.getValueAt(jTablaAnimales.getSelectedRow(), 0);
            int fila = jTablaAnimales.getSelectedRow();
            String sentencia = "DELETE FROM ANIMAL WHERE ID_ANIMAL="+id;
            if(miConexion.editTable(sentencia)==1){
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Animal elimado correctamente");
                TNombreAnimal.setText("");
                SPesoAnimal.setValue(0);
            }
        }
    }//GEN-LAST:event_JButtonRemoveAnimalActionPerformed

    private void selectRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRow
        int fila = jTablaAnimales.getSelectedRow();
        TNombreAnimal.setText((String)jTablaAnimales.getValueAt(fila,1));
        Especie esp = new Especie ((Especie)jTablaAnimales.getValueAt(fila, 2));
        //System.out.println(esp.getId());
        jComboBoxEspecie.getModel().setSelectedItem(esp);
        SPesoAnimal.setValue((Float)jTablaAnimales.getValueAt(fila,3));
    }//GEN-LAST:event_selectRow

    private void textButtonDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textButtonDelete
        JButtonAddAnimal.setToolTipText("Eliminar");
    }//GEN-LAST:event_textButtonDelete

    private void textButtonEdit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textButtonEdit
        JButtonAddAnimal.setToolTipText("Editar");
    }//GEN-LAST:event_textButtonEdit

    private void textButtonAdd(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textButtonAdd
        JButtonAddAnimal.setToolTipText("Añadir");
    }//GEN-LAST:event_textButtonAdd

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
            java.util.logging.Logger.getLogger(addAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JButtonAddAnimal;
    private javax.swing.JToggleButton JButtonEditAnimal;
    private javax.swing.JToggleButton JButtonRemoveAnimal;
    private javax.swing.JLabel LespecieAnimal;
    private javax.swing.JLabel LnombreAnimal;
    private javax.swing.JLabel LpesoAnimal;
    private javax.swing.JSpinner SPesoAnimal;
    private javax.swing.JTextField TNombreAnimal;
    private javax.swing.JComboBox<String> jComboBoxEspecie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaAnimales;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
