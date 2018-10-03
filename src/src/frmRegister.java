package src;

/**
 *
 * @author 
 */

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class frmRegister extends javax.swing.JFrame {
Statement st=null;
ResultSet rs=null;
frmConnection frm=new frmConnection();
    public frmRegister() {
        initComponents();
       
        lbldisplay.setVisible(false);
        labdigit.setVisible(false);
        lblname.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbldisplay = new javax.swing.JLabel();
        labdigit = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Module");

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registration Panel"));
        jPanel1.setLayout(null);
        jPanel1.add(txtPassword);
        txtPassword.setBounds(200, 160, 210, 30);

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 170, 80, 19);

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        jPanel1.add(txtUserName);
        txtUserName.setBounds(200, 120, 210, 30);

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel3.setText("User Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 130, 90, 19);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-delete.gif"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 370, 130, 40);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel1.setText("Registration Panel");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 30, 185, 24);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_icon.jpg"))); // NOI18N
        jButton3.setText("Register");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(90, 370, 143, 39);

        jLabel7.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 250, 80, 19);

        jLabel8.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel8.setText("mobile");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 320, 80, 19);

        jLabel6.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel6.setText("Address");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 210, 80, 19);

        txtMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMobileKeyPressed(evt);
            }
        });
        jPanel1.add(txtMobile);
        txtMobile.setBounds(200, 320, 210, 30);
        jPanel1.add(txtAddress);
        txtAddress.setBounds(200, 200, 210, 30);

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(200, 240, 210, 30);
        jPanel1.add(lbldisplay);
        lbldisplay.setBounds(420, 250, 80, 10);

        labdigit.setText("jLabel9");
        jPanel1.add(labdigit);
        labdigit.setBounds(420, 330, 140, 14);

        lblname.setText("jLabel9");
        jPanel1.add(lblname);
        lblname.setBounds(420, 130, 140, 14);

        jLabel9.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel9.setText("Name ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(90, 290, 60, 19);
        jPanel1.add(txtName);
        txtName.setBounds(200, 280, 210, 30);

        jLabel4.setBackground(new java.awt.Color(255, 153, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_1.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel5.setText("Eliptical curve cryptography");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go-back-icon.png"))); // NOI18N
        jButton1.setText("Back To Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new frmLogin().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String utype="";
        
            utype="users";
        
         try
        {
            st=frm.getCon().createStatement();
            rs=st.executeQuery("select * from users where uname='"+txtUserName.getText()+"' and utype in ('users')");
            if(rs.next())
            {
                JOptionPane.showMessageDialog(rootPane,"User Name is Already Registered ... Try Again");
                txtUserName.setText("");
            }
            else
            {
                if(txtEmail.getText().length()==0 || txtAddress.getText().length()==0||txtMobile.getText().length()==0||txtUserName.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "All Feilds Must be filled");
                }
 else{
                    if(txtPassword.getText().length()>=5 && txtPassword.getText().length()<=10 && txtMobile.getText().length()==10)
                    {
                st.execute("insert into users(uname,passw,addr,email,mobile,utype,name) values('"+txtUserName.getText()+"','"
                    +txtPassword.getText()+"','"+txtAddress.getText()+"','"+txtEmail.getText()+"','"+txtMobile.getText()+"','"+utype+"','"+txtName.getText()+"')");
            
            JOptionPane.showMessageDialog(rootPane,"You are Registered Successfully");
            this.dispose();
            new frmLogin().setVisible(true);
                    }
 else{
             JOptionPane.showMessageDialog(null, "Password Must be between 5 to 10 and check your mobile No");
             

 }
                }
            
            }
            frm.closeCon();
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception : "+ex.getMessage());
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new frmLogin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
         String email = txtEmail.getText();
                String exp = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
                CharSequence seq = email;
                Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
                Matcher m = pattern.matcher(seq);
                if (m.matches()) {
                    lbldisplay.setVisible(false);
                } else {
                    lbldisplay.setText("* Invalid Email ID");
                    lbldisplay.setVisible(true);
                    lbldisplay.setForeground(Color.red);
                }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtMobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMobileKeyPressed
        // TODO add your handling code here:
         String input = txtMobile.getText();
                Pattern p = Pattern.compile("[A-Z,a-z,&%$@!()*^]");
                Matcher m = p.matcher(input);
                if (m.find()) {
                    labdigit.setText("* only Numeric Value");
                    txtMobile.setText("");
                    labdigit.setVisible(true);
                    labdigit.setForeground(Color.red);
                } else {
                    labdigit.setVisible(false);
                }
    }//GEN-LAST:event_txtMobileKeyPressed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        // TODO add your handling code here:
         String input = txtUserName.getText();
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(input);
                if (m.find()) {
                    lblname.setText("* only Text Value");
                    lblname.setVisible(true);
                    lblname.setForeground(Color.red);
                } else {
                    lblname.setVisible(false);
                }
    }//GEN-LAST:event_txtUserNameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labdigit;
    private javax.swing.JLabel lbldisplay;
    private javax.swing.JLabel lblname;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
