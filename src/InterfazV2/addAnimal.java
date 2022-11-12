package InterfazV2;

import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.sql.Connection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import zoo.Animal;
import util.Conexion;
import util.TextPrompt;
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
    Connection miConexion;
    DefaultTableModel modelo;
    ArrayList especies;
    /**
     * Creates new form addAnimañ
     */
    
    
    public addAnimal(boolean admin) {
        //Comprobamos si el usuario es admin o no, si es admin tiene acceso a toda la funcionalidad, pero si no lo es, no va a poder eliminar o editar animales
        try{
            initComponents(); 
            JButtonAddAnimal.setCursor(new Cursor(HAND_CURSOR));
            JButtonEditAnimal.setCursor(new Cursor(HAND_CURSOR));
            JButtonErase.setCursor(new Cursor(HAND_CURSOR));
            JButtonRemoveAnimal.setCursor(new Cursor(HAND_CURSOR));
            if(admin==false){
                JButtonRemoveAnimal.setEnabled(false);
                JButtonEditAnimal.setEnabled(false);
                jLabelAviso.setText("Aviso: los cuidadores no pueden eliminar ni editar animales");
            }
            //TextPrompt sirve para poner un placeholder en un textfield
            TextPrompt placeholder = new TextPrompt("Toby", jTNombreAnimal);
            especies = new ArrayList();
            animales = new ArrayList<Animal>();
            miConexion = new Conexion("localhost","3306","zoo","zoologico","pepe").makeConnect();            
            //Rellenamos la tabla de animales con los animales de la base de datos
            modelo = (DefaultTableModel) jTablaAnimales.getModel();
            String consulta = "SELECT animal.NOMBRE,animal.PESO,especie.NOMBRE_ESPECIE,ESPECIE.id_especie,ID_ANIMAL,animal.LAST_MOD FROM animal, especie WHERE animal.ESPECIE=especie.ID_ESPECIE ORDER BY id_animal";
            //System.out.println(consulta);
            ResultSet rsTabla = util.Conexion.getSelect(consulta,miConexion);
            while(rsTabla.next()){
                Especie esp = new Especie(rsTabla.getInt(4),rsTabla.getString(3));
                modelo.addRow(new Object[] {rsTabla.getInt(5),rsTabla.getString(1),esp,rsTabla.getFloat(2),rsTabla.getTimestamp(6)});
            }
            //Rellenamos la caja de especies
            try{
                String consultaEspecie = "SELECT * FROM especie";
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                ResultSet rsEspecie = util.Conexion.getSelect(consultaEspecie,miConexion);
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
                JOptionPane.showMessageDialog(null, "Error al cargar los datos");
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
        jTNombreAnimal = new javax.swing.JTextField();
        jSPesoAnimal = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEspecie = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        JButtonAddAnimal = new javax.swing.JToggleButton();
        JButtonEditAnimal = new javax.swing.JToggleButton();
        JButtonRemoveAnimal = new javax.swing.JToggleButton();
        JButtonErase = new javax.swing.JToggleButton();
        jLabelAviso = new javax.swing.JLabel();

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 400));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 15, 0};
        jPanel2Layout.rowHeights = new int[] {0, 25, 0, 25, 0, 25, 0, 25, 0};
        jPanel2.setLayout(jPanel2Layout);

        LnombreAnimal.setFont(new java.awt.Font("Freshman", 0, 18)); // NOI18N
        LnombreAnimal.setForeground(new java.awt.Color(0, 86, 44));
        LnombreAnimal.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(LnombreAnimal, gridBagConstraints);

        LespecieAnimal.setFont(new java.awt.Font("Freshman", 0, 18)); // NOI18N
        LespecieAnimal.setForeground(new java.awt.Color(0, 86, 44));
        LespecieAnimal.setText("Especie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(LespecieAnimal, gridBagConstraints);

        LpesoAnimal.setFont(new java.awt.Font("Freshman", 0, 18)); // NOI18N
        LpesoAnimal.setForeground(new java.awt.Color(0, 86, 44));
        LpesoAnimal.setText("Peso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(LpesoAnimal, gridBagConstraints);

        jTNombreAnimal.setBackground(new java.awt.Color(255, 255, 255));
        jTNombreAnimal.setFont(new java.awt.Font("Freshman", 0, 18)); // NOI18N
        jTNombreAnimal.setForeground(new java.awt.Color(0, 0, 0));
        jTNombreAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 51))); // NOI18N
        jTNombreAnimal.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jTNombreAnimal, gridBagConstraints);

        jSPesoAnimal.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        jSPesoAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 51))); // NOI18N
        jSPesoAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSPesoAnimal.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jSPesoAnimal, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Freshman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Animales");
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

        jLabelAviso.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelAviso)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAviso)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddAnimalActionPerformed
        String nombre = jTNombreAnimal.getText();
        Especie esp = new Especie((Especie)jComboBoxEspecie.getSelectedItem());
        int especie = esp.getId();
        String nombreEsp = esp.getName();
        float peso = (float) jSPesoAnimal.getValue();
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
                ResultSet rs1 =util.Conexion.comprobarDatos(consulta,miConexion);
                LocalDateTime dateTime = LocalDateTime.now();
                String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                //System.out.println(rs1);
                if(rs1==null){
                    ResultSet rs = util.Conexion.getSelect("Select * from animal",miConexion);
                    //Irse a la ultima linea de la tabla
                    rs.moveToInsertRow();
                    //
                    rs.updateString("nombre",nombre);
                    rs.updateInt("especie",especie);
                    rs.updateFloat("peso",peso);
                    rs.insertRow();
                    ResultSet getId=util.Conexion.comprobarDatos("SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='ZOO' AND TABLE_NAME='ANIMAL'",miConexion);
                    //System.out.println(getId);
                    JOptionPane.showMessageDialog(null, "Animal añadido correctamente");
                    jTNombreAnimal.setText("");
                    jSPesoAnimal.setValue(0);
                    modelo.addRow(new Object[] {getId.getInt("AUTO_INCREMENT")-1,nombre,esp,peso,currentTimeStamp});
                }
                else{
                    JOptionPane.showMessageDialog(null, "El animal ya existe");
                }
            
        }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al añadir el animal");
            }
        }
    }//GEN-LAST:event_JButtonAddAnimalActionPerformed

    private void JButtonEditAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEditAnimalActionPerformed
        try{
            int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro? No podrás recuperar los datos anteriores","Editar animal",JOptionPane.YES_OPTION);
            if(resp==0){
                String nombre = jTNombreAnimal.getText();
                float peso = (float) jSPesoAnimal.getValue();
                int fila = jTablaAnimales.getSelectedRow();
                int id=(int)jTablaAnimales.getValueAt(fila, 0);

                String sentencia = "UPDATE ANIMAL SET NOMBRE='"+nombre+"', PESO="+peso+" WHERE ID_ANIMAL="+id;
                System.out.println(sentencia);
                if(util.Conexion.editTable(sentencia,miConexion)==1){
                    LocalDateTime dateTime = LocalDateTime.now();
                    String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                    modelo.setValueAt(jTNombreAnimal.getText(), fila, 1);
                    modelo.setValueAt(jSPesoAnimal.getValue(), fila, 3);
                    modelo.setValueAt(currentTimeStamp, fila, 4);
                    JOptionPane.showMessageDialog(null, "Animal editado correctamente");
                    jTNombreAnimal.setText("");
                    jSPesoAnimal.setValue(0);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al editar el animal");
                }
            }
        }
        catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla");
        }
    }//GEN-LAST:event_JButtonEditAnimalActionPerformed

    private void JButtonRemoveAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRemoveAnimalActionPerformed
        try{
            int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro? No vas a poder recuperar los datos eliminados","Eliminar animal",JOptionPane.YES_OPTION);
            if(resp==0){
                int id=(int)jTablaAnimales.getValueAt(jTablaAnimales.getSelectedRow(), 0);
                int fila = jTablaAnimales.getSelectedRow();
                try {
                    miConexion.setAutoCommit(false);
                    String comprobarTarea = "Select * from realizada where id_animal="+id;
                    ResultSet rs1 = util.Conexion.comprobarDatos(comprobarTarea, miConexion);
                    if(rs1!=null){
                        String sentencia = "DELETE FROM REALIZADA WHERE ID_ANIMAL="+id;
                        if(util.Conexion.editTable(sentencia,miConexion)!=1){
                            miConexion.rollback();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Tareas relacionadas con el animal elimada correctamente");
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el animal");
                }
                String sentencia = "DELETE FROM ANIMAL WHERE ID_ANIMAL="+id;
                if(util.Conexion.editTable(sentencia,miConexion)==1){
                    try {
                        modelo.removeRow(fila);
                        JOptionPane.showMessageDialog(null, "Animal elimado correctamente");
                        jTNombreAnimal.setText("");
                        jSPesoAnimal.setValue(0);
                        miConexion.commit();
                    } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "Error al eliminar el animal");
                    }
                }
                else{
                    try {
                        miConexion.rollback();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el animal");
                    }
                }
            }
            
        }
        catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla");
        }
    }//GEN-LAST:event_JButtonRemoveAnimalActionPerformed

    private void selectRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRow
        int fila = jTablaAnimales.getSelectedRow();
        jTNombreAnimal.setText((String)jTablaAnimales.getValueAt(fila,1));
        Especie esp = new Especie ((Especie)jTablaAnimales.getValueAt(fila, 2));
        //System.out.println(esp.getId());
        jComboBoxEspecie.getModel().setSelectedItem(esp);
        jSPesoAnimal.setValue((Float)jTablaAnimales.getValueAt(fila,3));
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

    private void JButtonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEraseActionPerformed
        jTNombreAnimal.setText("");
        jSPesoAnimal.setValue(0);
    }//GEN-LAST:event_JButtonEraseActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JButtonAddAnimal;
    private javax.swing.JToggleButton JButtonEditAnimal;
    private javax.swing.JToggleButton JButtonErase;
    private javax.swing.JToggleButton JButtonRemoveAnimal;
    private javax.swing.JLabel LespecieAnimal;
    private javax.swing.JLabel LnombreAnimal;
    private javax.swing.JLabel LpesoAnimal;
    private javax.swing.JComboBox<String> jComboBoxEspecie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSPesoAnimal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTNombreAnimal;
    private javax.swing.JTable jTablaAnimales;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
