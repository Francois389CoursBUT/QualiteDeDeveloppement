/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseur;

import javax.swing.JOptionPane;

/**
 *
 * @author francois.desaintpala
 */
public class Convertisseur extends javax.swing.JFrame {

    private static final float EUROS_TO_DOLLARD = 1.1703f;
    
    /**
     * Creates new form Convertisseur
     */
    public Convertisseur() {
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

        selectionDevise = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        montantAConvertir = new javax.swing.JTextField();
        montantConverti = new javax.swing.JTextField();
        dollar = new javax.swing.JRadioButton();
        euro = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        indicateur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        setResizable(false);

        jLabel1.setText("Montant à convertir");

        jLabel2.setText("Montant converti");

        montantConverti.setEditable(false);

        selectionDevise.add(dollar);
        dollar.setText("$");
        dollar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dollarMouseClicked(evt);
            }
        });

        selectionDevise.add(euro);
        euro.setText("€");
        euro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                euroMouseClicked(evt);
            }
        });

        jButton1.setText("Convertir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConvertirAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(montantAConvertir, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(montantConverti))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(euro)
                        .addGap(52, 52, 52)
                        .addComponent(dollar))
                    .addComponent(indicateur))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(montantAConvertir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dollar)
                    .addComponent(euro))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(montantConverti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(indicateur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConvertirAction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConvertirAction
        // TODO add your handling code here:
        if (   montantAConvertir.getText().isEmpty()
            || !montantAConvertir.getText().matches("^[1-9]+$")) {
            JOptionPane.showMessageDialog(this, 
                    "Erreur : Veillez entrer un nombre", "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int aConvertir = Integer.parseInt(montantAConvertir.getText());
                if (euro.isSelected()) {
                    montantConverti.setText(aConvertir * EUROS_TO_DOLLARD + "");
                } else if (dollar.isSelected())  {
                    montantConverti.setText(aConvertir / EUROS_TO_DOLLARD + "");
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Veillez selectionnez une devise", "", 
                        JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException e) {
                System.err.println("Veillez saisir un nombre");
            }   
        }
        
        System.out.println("Salut");
    }//GEN-LAST:event_btnConvertirAction

    private void euroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_euroMouseClicked
        indicateur.setText("$");
        montantConverti.setText("");
    }//GEN-LAST:event_euroMouseClicked

    private void dollarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dollarMouseClicked
        indicateur.setText("€");
        montantConverti.setText("");
    }//GEN-LAST:event_dollarMouseClicked

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
            java.util.logging.Logger.getLogger(Convertisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Convertisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Convertisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Convertisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Convertisseur().setVisible(true);
            }
        });
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dollar;
    private javax.swing.JRadioButton euro;
    private javax.swing.JLabel indicateur;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField montantAConvertir;
    private javax.swing.JTextField montantConverti;
    private javax.swing.ButtonGroup selectionDevise;
    // End of variables declaration//GEN-END:variables
}
