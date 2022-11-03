/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazV2;

/**
 *
 * @author Sergio
 */
public class menuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipalñ
     */
    public menuPrincipal() {
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAnimales = new javax.swing.JButton();
        jButtoCuidados = new javax.swing.JButton();
        jButtonCuidados = new javax.swing.JButton();
        jButtonEspecialidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 50, 0, 50, 0, 50, 0, 50, 0};
        jPanel2Layout.rowHeights = new int[] {0, 25, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Main Menu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        jPanel2.add(jLabel1, gridBagConstraints);

        jButtonAnimales.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAnimales.setText("Animales");
        jButtonAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnimalesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jButtonAnimales, gridBagConstraints);

        jButtoCuidados.setForeground(new java.awt.Color(0, 0, 0));
        jButtoCuidados.setText("Cuidadores");
        jButtoCuidados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoCuidadosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        jPanel2.add(jButtoCuidados, gridBagConstraints);

        jButtonCuidados.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCuidados.setText("Cuidados");
        jButtonCuidados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCuidadosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jButtonCuidados, gridBagConstraints);

        jButtonEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEspecialidad.setText("Especialidad");
        jButtonEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecialidadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jButtonEspecialidad, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnimalesActionPerformed
        addAnimal OpenAnimal = new addAnimal();
        OpenAnimal.setVisible(true);
    }//GEN-LAST:event_jButtonAnimalesActionPerformed

    private void jButtoCuidadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoCuidadosActionPerformed
        addCuidadores OpenCuidadores = new addCuidadores();
        OpenCuidadores.setVisible(true);
    }//GEN-LAST:event_jButtoCuidadosActionPerformed

    private void jButtonCuidadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCuidadosActionPerformed
        addCuidados OpenCuidados = new addCuidados();
        OpenCuidados.setVisible(true);
    }//GEN-LAST:event_jButtonCuidadosActionPerformed

    private void jButtonEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecialidadActionPerformed
        addEspecialidad OpenEspecialidad = new addEspecialidad();
        OpenEspecialidad.setVisible(true);
    }//GEN-LAST:event_jButtonEspecialidadActionPerformed

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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoCuidados;
    private javax.swing.JButton jButtonAnimales;
    private javax.swing.JButton jButtonCuidados;
    private javax.swing.JButton jButtonEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
