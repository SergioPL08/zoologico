/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazV2;

import com.toedter.calendar.JDateChooser;
import java.security.Timestamp;
import javax.swing.table.DefaultTableModel;
import util.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import util.TextPrompt;
import zoo.Animal;
import zoo.Cuidador;
import zoo.Cuidados;
/**
 *
 * @author Sergio
 */

public class Actividades extends javax.swing.JFrame {
    public boolean ValitateHour(String hora){
       char[] a = hora.toString().toCharArray();
       String[] c = hora.split(":");
       if((a[0]==' ') || (a[1]==' ') || (a[2]==' ') || (a[3]==' ') || (getInteger(c[0])>24) || (getInteger(c[1])>59) ){
           return false;
       }
       else
           return true;
   }
   
   public int getInteger(String valor){
       return Integer.parseInt(valor);
   }
    Conexion miConexion;
    DefaultTableModel modelo;
    ArrayList animales,cuidadores,cuidados;
    /**
     * Creates new form Actividades
     */
    public Actividades() {
        initComponents();
        animales = new ArrayList();
        cuidadores = new ArrayList();
        cuidados = new ArrayList();
        miConexion = new Conexion("localhost","3306","zoologico","zoo","pepe");
        //Rellenamos la tabla de animales con los animales de la base de datos
        modelo = (DefaultTableModel) jTablaTareas.getModel();
        String consulta = "SELECT realizada.id_tarea,realizada.ID_ANIMAL, animal.NOMBRE as NOMBRE_ANIMAL,realizada.ID_CUIDADOR,persona.NOMBRE as NOMBRE_CUIDADOR,realizada.ID_CUIDADO,cuidado.NOMBRE_CUIDADO,realizada.FECHA FROM realizada,persona,cuidado,animal WHERE realizada.ID_ANIMAL=animal.ID_ANIMAL AND realizada.ID_CUIDADOR=persona.ID_PERSONA AND realizada.ID_CUIDADO=cuidado.ID_CUIDADO";
        System.out.println(consulta);
        ResultSet rsTabla = miConexion.getSelect(consulta);
        try {
            while(rsTabla.next()){
                Animal ani = new Animal(rsTabla.getInt(2),rsTabla.getString(3));
                Cuidador cuidador = new Cuidador(rsTabla.getInt(4),rsTabla.getString(5));
                Cuidados cuidado = new Cuidados(rsTabla.getInt(6),rsTabla.getString(7));
                modelo.addRow(new Object[] {rsTabla.getInt(1),ani,cuidador,cuidado,rsTabla.getTimestamp(8)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Rellenamos la caja de animales
        String selectAnimal = "SELECT * FROM ANIMAL";
        ResultSet rsTablaAnimales = miConexion.getSelect(selectAnimal);
        DefaultComboBoxModel modelAnimales = new DefaultComboBoxModel();
        try{
            while (rsTablaAnimales.next()){
                Animal ani = new Animal(rsTablaAnimales.getInt(1),rsTablaAnimales.getString(2));
                modelAnimales.addElement(ani);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxAnimal.setModel(modelAnimales);
         
        //Rellenamos la caja de cuidadores
        String selectCuidador = "SELECT * FROM PERSONA";
        ResultSet rsTablaCuidador = miConexion.getSelect(selectCuidador);
        DefaultComboBoxModel modelCuidador = new DefaultComboBoxModel();
        try{
            while (rsTablaCuidador.next()){
                Cuidador cuidad = new Cuidador(rsTablaCuidador.getInt(1),rsTablaCuidador.getString(2));
                modelCuidador.addElement(cuidad);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxCuidador.setModel(modelCuidador);
        //Rellenamos la caja de cuidados
        String selectCuidado = "SELECT * FROM CUIDADO";
        ResultSet rsTablaCuidados = miConexion.getSelect(selectCuidado);
        DefaultComboBoxModel modelCuidado = new DefaultComboBoxModel();
        try{
            while (rsTablaCuidados.next()){
                Cuidados cuidado = new Cuidados(rsTablaCuidados.getInt(1),rsTablaCuidados.getString(2));
                modelCuidado.addElement(cuidado);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxCuidado.setModel(modelCuidado);
        
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
        jTablaTareas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLHora = new javax.swing.JLabel();
        LCuidador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCuidador = new javax.swing.JComboBox<>();
        LAnimal = new javax.swing.JLabel();
        jComboBoxAnimal = new javax.swing.JComboBox<>();
        LCuidado = new javax.swing.JLabel();
        jComboBoxCuidado = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLFecha = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jToolBar1 = new javax.swing.JToolBar();
        JButtonAddAnimal = new javax.swing.JToggleButton();
        JButtonEditAnimal = new javax.swing.JToggleButton();
        JButtonRemoveAnimal = new javax.swing.JToggleButton();
        JButtonErase = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Animal", "Cuidador", "Cuidado", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        jTablaTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaTareasselectRow(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaTareas);

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
        jPanel2Layout.columnWidths = new int[] {0, 15, 0, 15, 0};
        jPanel2Layout.rowHeights = new int[] {0, 25, 0, 25, 0, 25, 0, 25, 0, 25, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLHora.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLHora.setForeground(new java.awt.Color(0, 153, 51));
        jLHora.setText("Hora");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLHora, gridBagConstraints);

        LCuidador.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LCuidador.setForeground(new java.awt.Color(0, 153, 51));
        LCuidador.setText("Cuidador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel2.add(LCuidador, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir tarea");
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        jPanel2.add(jComboBoxCuidador, gridBagConstraints);

        LAnimal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LAnimal.setForeground(new java.awt.Color(0, 153, 51));
        LAnimal.setText("Animal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(LAnimal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jComboBoxAnimal, gridBagConstraints);

        LCuidado.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        LCuidado.setForeground(new java.awt.Color(0, 153, 51));
        LCuidado.setText("Cuidado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        jPanel2.add(LCuidado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        jPanel2.add(jComboBoxCuidado, gridBagConstraints);

        jDateChooser1.setDateFormatString("y-MM-d");
        jDateChooser1.setMaxSelectableDate(new java.util.Date(253370764915000L));
        jDateChooser1.setOpaque(false);
        jDateChooser1.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jDateChooser1, gridBagConstraints);

        jLFecha.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLFecha.setForeground(new java.awt.Color(0, 153, 51));
        jLFecha.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLFecha, gridBagConstraints);

        jFormattedTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField1.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("07:27");
        jFormattedTextField1.setPreferredSize(new java.awt.Dimension(50, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jFormattedTextField1, gridBagConstraints);

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
                JButtonAddAnimaltextButtonAdd(evt);
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
                JButtonEditAnimaltextButtonEdit(evt);
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
                JButtonRemoveAnimaltextButtonDelete(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaTareasselectRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaTareasselectRow
        int fila = jTablaTareas.getSelectedRow();
        
        Animal ani = new Animal ((Animal)jTablaTareas.getValueAt(fila, 1));
        jComboBoxAnimal.getModel().setSelectedItem(ani);
        //System.out.println(ani.getId());
        Cuidador cuidador = new Cuidador ((Cuidador)jTablaTareas.getValueAt(fila, 2));
        jComboBoxCuidador.getModel().setSelectedItem(cuidador);
        
        Cuidados cuidado = new Cuidados ((Cuidados)jTablaTareas.getValueAt(fila, 3));
        jComboBoxCuidado.getModel().setSelectedItem(cuidado);
        
        Date date = (Date)jTablaTareas.getValueAt(fila, 4);
        jDateChooser1.setDate(date);
        
        
        jFormattedTextField1.setText(date.toString());
    }//GEN-LAST:event_jTablaTareasselectRow

    private void JButtonAddAnimaltextButtonAdd(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAddAnimaltextButtonAdd
        JButtonAddAnimal.setToolTipText("Añadir");
    }//GEN-LAST:event_JButtonAddAnimaltextButtonAdd

    private void JButtonAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddAnimalActionPerformed
        Date date = jDateChooser1.getDate();
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        String hora = jFormattedTextField1.getText();
        //Timestamp ts = new Timestamp(date,hora);
        Animal ani = new Animal((Animal)jComboBoxAnimal.getSelectedItem());
        Cuidador cuidador = new Cuidador((Cuidador)jComboBoxCuidador.getSelectedItem());
        Cuidados cuidado = new Cuidados((Cuidados)jComboBoxCuidado.getSelectedItem());
        
        //(String name, String especie, String subespecie, float peso)
        if(ValitateHour(jFormattedTextField1.getText())==false){
            JOptionPane.showMessageDialog(null, "Formato de hora incorrecto");
        }
        else{
            //            Animal animal = new Animal(nombre,especie,peso);
            //            animales.add(animal);
            //            //System.out.println(animales);
            try {
                String consulta = "SELECT * FROM realizada WHERE ID_ANIMAL='"+ani.getId()+"' AND ID_CUIDADOR="+cuidador.getId()+" AND ID_CUIDADO="+cuidado.getId();
                ResultSet rs1 =miConexion.comprobarDatos(consulta);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(fecha+" "+hora, formato);
                String dateTimeFormateado = dateTime.format(formato);
                //System.out.println(rs1);
                if(rs1==null){
                    ResultSet rs = miConexion.getSelect("Select * from realizada");
                    //Irse a la ultima linea de la tabla
                    rs.moveToInsertRow();
                    rs.updateInt("ID_ANIMAL",ani.getId());
                    rs.updateInt("ID_CUIDADOR",cuidador.getId());
                    rs.updateInt("ID_CUIDADO",cuidado.getId());
                    rs.updateString("FECHA", dateTimeFormateado);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(null, "Tarea añadida correctamente");
                    jFormattedTextField1.setText("");
                    //jDateChooser1.setDate();
                    ResultSet getId=miConexion.comprobarDatos("SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='ZOO' AND TABLE_NAME='REALIZADA'");
                    modelo.addRow(new Object[] {getId.getInt("AUTO_INCREMENT")-1,ani,cuidador,cuidado,dateTimeFormateado+"00"});
                    jDateChooser1.setDate(null);
                    jFormattedTextField1.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "La tarea ya existe");
                }

            }   catch (SQLException ex) {
                Logger.getLogger(addAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_JButtonAddAnimalActionPerformed

    private void JButtonEditAnimaltextButtonEdit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonEditAnimaltextButtonEdit
        JButtonAddAnimal.setToolTipText("Editar");
    }//GEN-LAST:event_JButtonEditAnimaltextButtonEdit

    private void JButtonEditAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEditAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro? No podrás recuperar los datos anteriores","Editar tarea",JOptionPane.YES_OPTION);
        if(resp==0){
            int fila = jTablaTareas.getSelectedRow();
            Date date = jDateChooser1.getDate();
            java.sql.Date fecha = new java.sql.Date(date.getTime());
            String hora = jFormattedTextField1.getText();
            int id = (int)jTablaTareas.getValueAt(fila, 0);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(fecha+" "+hora, formato);
            String dateTimeFormateado = dateTime.format(formato);
            //Timestamp ts = new Timestamp(date,hora);
            Animal ani = new Animal((Animal)jComboBoxAnimal.getSelectedItem());
            Cuidador cuidador = new Cuidador((Cuidador)jComboBoxCuidador.getSelectedItem());
            Cuidados cuidado = new Cuidados((Cuidados)jComboBoxCuidado.getSelectedItem());
        
            String sentencia = "UPDATE REALIZADA SET ID_ANIMAL="+ani.getId()+", ID_CUIDADOR="+cuidador.getId()+" AND ID_CUIDADO="+cuidado.getId()+" WHERE ID_TAREA="+id;
            System.out.println(sentencia);
            if(miConexion.editTable(sentencia)==1){
                String currentTimeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0").format(dateTime);
                modelo.setValueAt(ani.getName(), fila, 1);
                modelo.setValueAt(cuidador.getNombre(), fila, 2);
                modelo.setValueAt(cuidado.getNombre(), fila, 3);
                modelo.setValueAt(dateTimeFormateado, fila, 3);
                JOptionPane.showMessageDialog(null, "Animal editado correctamente");
                jDateChooser1.setDate(null);
                jFormattedTextField1.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al editar el animal");
            }
        }
        
    }//GEN-LAST:event_JButtonEditAnimalActionPerformed

    private void JButtonRemoveAnimaltextButtonDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoveAnimaltextButtonDelete
        JButtonAddAnimal.setToolTipText("Eliminar");
    }//GEN-LAST:event_JButtonRemoveAnimaltextButtonDelete

    private void JButtonRemoveAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRemoveAnimalActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro, manín? No vas a poder recuperar los datos eliminados","Eliminar tarea",JOptionPane.YES_OPTION);
        if(resp==0){
            int id=(int)jTablaTareas.getValueAt(jTablaTareas.getSelectedRow(), 0);
            int fila = jTablaTareas.getSelectedRow();
            String sentencia = "DELETE FROM REALIZADA WHERE ID_TAREA="+id;
            if(miConexion.editTable(sentencia)==1){
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Tarea elimada correctamente");
                jDateChooser1.setDate(null);
                jFormattedTextField1.setText("");
            }
        }
    }//GEN-LAST:event_JButtonRemoveAnimalActionPerformed

    private void JButtonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonEraseActionPerformed
        jDateChooser1.setDate(null);
        jFormattedTextField1.setText("");
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
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JButtonAddAnimal;
    private javax.swing.JToggleButton JButtonEditAnimal;
    private javax.swing.JToggleButton JButtonErase;
    private javax.swing.JToggleButton JButtonRemoveAnimal;
    private javax.swing.JLabel LAnimal;
    private javax.swing.JLabel LCuidado;
    private javax.swing.JLabel LCuidador;
    private javax.swing.JComboBox<String> jComboBoxAnimal;
    private javax.swing.JComboBox<String> jComboBoxCuidado;
    private javax.swing.JComboBox<String> jComboBoxCuidador;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaTareas;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
