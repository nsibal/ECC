/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.math.BigInteger;


import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*import sun.misc.*;*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;



/**
 *
 * @author 
 */
public class testEnc_Ecc extends javax.swing.JFrame {

    private static String algo = "ECC";
   // private static String Key_algo = "Blowfish";
    String addressFile = "";

    /**
     * Creates new form testEnc
     */
    byte[] baSignature;

    public testEnc_Ecc() {
        initComponents();
        setTitle("Encryption Using ECC");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        txtPass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtInput.setColumns(20);
        txtInput.setRows(5);
        jScrollPane1.setViewportView(txtInput);

        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Decrypt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Enter Text to Encrypt :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Key:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("First Point :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Second Point :");

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Encrypted Text :");

        jButton3.setText("Write To File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Read File");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Provider p[] = Security.getProviders();
            Provider p1 = Security.getProvider("SunEC");
            System.out.println(p1.getName());

            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "SunEC");
            ECGenParameterSpec ecsp = new ECGenParameterSpec("sect163r2");   //sect163r2
            kpg.initialize(256);   //ecsp
            KeyPair kyp = kpg.genKeyPair();
            System.out.println("Key Pair=" + kyp);

            kpg = KeyPairGenerator.getInstance("EC", "SunEC");

            ecsp = new ECGenParameterSpec("sect163k1");
            kpg.initialize(ecsp);
            KeyPair kp = kpg.genKeyPair();
            PrivateKey privKey = kp.getPrivate();
            PublicKey pubKey = kp.getPublic();
            System.out.println("Private Key =" + privKey.toString());
            System.out.println("Public Key =" + pubKey.toString());
            Signature ecdsa;
            ecdsa = Signature.getInstance("SHA1withECDSA", "SunEC");
            ecdsa.initSign(privKey);
            String text = txtInput.getText();
            System.out.println("Text: " + text);
            byte[] baText = text.getBytes("UTF-8");
            ecdsa.update(baText);
            baSignature = ecdsa.sign();
            System.out.println("Signature: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

            Signature signature;
            signature = Signature.getInstance("SHA1withECDSA", "SunEC");
            signature.initVerify(pubKey);
            signature.update(baText);
            boolean result = signature.verify(baSignature);
            System.out.println("Valid: " + result);
            System.out.println("Algorithms Details =" + kpg.getAlgorithm());
            String data1 = txtInput.getText();
            String st = txtPass.getText() + txt4.getText() + txt5.getText();
            Key key = new SecretKeySpec(
                    //new String(txtPass.getText()).getBytes()+txt4.getText().getBytes()+txt5.getText().getBytes(), algorithm);

                    new String(st).getBytes(), ECC.algorithm);
            Cipher chiper = Cipher.getInstance(ECC.algorithm);
            chiper.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = chiper.doFinal(data1.getBytes());
            String encryptedValue = new BASE64Encoder().encode(encVal);
            System.out.println(encryptedValue);
            txtOutput.setText(encryptedValue);
            //Key Encryption Using Blowfish
            String enc_key=txtPass.getText();
            Key key1 = new SecretKeySpec(
                   
            new String(txtPass.getText()).getBytes(), ECC.algorithm);
            Cipher chiper1 = Cipher.getInstance(ECC.algorithm);
            chiper.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal1 = chiper.doFinal(enc_key.getBytes());
            String encryptedValue1 = new BASE64Encoder().encode(encVal);
            System.out.println("Encrypted Key ="+encryptedValue1);
            System.out.println("Key"+txtPass.getText());
            System.out.println("Private Key="+kyp.getPrivate());
            System.out.println("Private Key="+kyp.getPublic());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String st = txtPass.getText() + txt4.getText() + txt5.getText();
            Key key = new SecretKeySpec(
                    new String(st).getBytes(), ECC.algorithm);
            Cipher chiper = Cipher.getInstance(ECC.algorithm);
            chiper.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(txtInput.getText());
            byte[] decValue = chiper.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            System.out.println("Data" + decryptedValue);
            txtOutput.setText(decryptedValue);
                //JOptionPane.showMessageDialog(null, decryptedValue);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addressFile = openSaveChooser();
        writeFile(addressFile);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        addressFile = openChooser();
        readFile(addressFile);
    }//GEN-LAST:event_jButton4ActionPerformed
    private String openChooser() {
        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("*.txt", "Text Files Only");
            chooser.addChoosableFileFilter(txtFilter);
            int ret = chooser.showOpenDialog(this);
            File file = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private void readFile(String addressFile) {
        String line = null;
        txtInput.setText("");
        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(addressFile)));

            do {
                line = reader.readLine();
                txtInput.setVisible(true);

                txtInput.append(line);
                txtInput.append("\n");
            } while (line != null);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void writeFile(String addressFile) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(addressFile)));
            writer.write(txtOutput.getText());
            writer.close();
            JOptionPane.showMessageDialog(rootPane, "Your File is Saved To " + addressFile);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private String openSaveChooser() {
        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(".txt", "Text Files");
            chooser.addChoosableFileFilter(txtFilter);
            int ret = chooser.showSaveDialog(this);
            File file = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            return file.getAbsolutePath() + ".txt";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

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
            java.util.logging.Logger.getLogger(testEnc_Ecc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testEnc_Ecc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testEnc_Ecc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testEnc_Ecc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testEnc_Ecc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
