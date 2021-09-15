/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsalemanagement;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class registationform extends javax.swing.JFrame {

    Connection con = null;
    public registationform() {
        initComponents();
        createConnection();
        registerAsAdmin();
    }
    
    void createConnection(){
        String className = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(className);
            System.out.println("Driver loaded Successfully");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
            System.out.println("Connection Successfull");
      
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver loding Failed");
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
            System.out.println(ex.getMessage());
        }
    }
    
    public void submitData(){
        PreparedStatement pst;
        String url="INSERT INTO register VALUES(?,?,?)";
        try {
            pst = con.prepareStatement(url);
            pst.setString(1, namereg.getText());
            pst.setString(2, usernamereg.getText());
            pst.setString(3, passwordreg.getText());
            
            int i = pst.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(this,"Registation Successfull");
                loginform jf = new loginform();
                jf.show();
                dispose();
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(registationform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validatePassword(){
        String password1 = passwordreg.getText();
        String password2 = passwordreg1.getText();
        
        if(!password1.equals(password2)){
            JOptionPane.showMessageDialog(this,"Password does not match!");
        }else{
            submitData();
        }
    }
    
    public void usernameValidate(){
        ResultSet rs1;
        Statement st1;
        String admin= "admin";
        String username = usernamereg.getText();
        try {
            st1 = con.createStatement();
            rs1 = st1.executeQuery("SELECT * from register WHERE username='"+admin+"'");
            
            if(!rs1.next()){
                if(!username.equals("admin")){
                    JOptionPane.showMessageDialog(this,"Username must be 'admin'");
                }else{
                    validatePassword();
                }
            }else{
                validatePassword();
            }
        } catch (SQLException ex) {
            Logger.getLogger(registationform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registerAsAdmin(){
        ResultSet rs;
        Statement st;
        String admin= "admin";
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from register WHERE username='"+admin+"'");
            
            if(!rs.next()){
                usernamereg.setText(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(registationform.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namereg = new javax.swing.JTextField();
        usernamereg = new javax.swing.JTextField();
        passwordreg = new javax.swing.JPasswordField();
        passwordreg1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(510, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(73, 31, 61));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 0, 60)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("ABC");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("User name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Confirm password");

        namereg.setBackground(new java.awt.Color(73, 31, 61));
        namereg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namereg.setForeground(new java.awt.Color(255, 255, 255));
        namereg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        namereg.setCaretColor(new java.awt.Color(255, 255, 255));
        namereg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameregActionPerformed(evt);
            }
        });
        namereg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameregKeyPressed(evt);
            }
        });

        usernamereg.setBackground(new java.awt.Color(73, 31, 61));
        usernamereg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernamereg.setForeground(new java.awt.Color(255, 255, 255));
        usernamereg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        usernamereg.setCaretColor(new java.awt.Color(255, 255, 255));
        usernamereg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameregKeyPressed(evt);
            }
        });

        passwordreg.setBackground(new java.awt.Color(73, 31, 61));
        passwordreg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordreg.setForeground(new java.awt.Color(255, 255, 255));
        passwordreg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        passwordreg.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordregKeyPressed(evt);
            }
        });

        passwordreg1.setBackground(new java.awt.Color(73, 31, 61));
        passwordreg1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordreg1.setForeground(new java.awt.Color(255, 255, 255));
        passwordreg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        passwordreg1.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordreg1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordreg1FocusLost(evt);
            }
        });
        passwordreg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordreg1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(298, 298, 298))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernamereg, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namereg, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordreg1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordreg, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(namereg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usernamereg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(passwordreg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(189, 76, 84));
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Register ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("    Clear");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("    Back ");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameregActionPerformed

    private void passwordreg1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordreg1FocusLost
        //validatePassword();
    }//GEN-LAST:event_passwordreg1FocusLost

    private void nameregKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameregKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            usernamereg.requestFocus();
        }
    }//GEN-LAST:event_nameregKeyPressed

    private void usernameregKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameregKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            passwordreg.requestFocus();
        }
    }//GEN-LAST:event_usernameregKeyPressed

    private void passwordregKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordregKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            passwordreg1.requestFocus();
        }
    }//GEN-LAST:event_passwordregKeyPressed

    private void passwordreg1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordreg1KeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            usernameValidate();
        }
    }//GEN-LAST:event_passwordreg1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        usernameValidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        namereg.setText("");
        usernamereg.setText("");
        passwordreg.setText("");
        passwordreg1.setText("");
        namereg.requestFocus();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        loginform jf = new loginform();
        jf.show();
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(registationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registationform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField namereg;
    private javax.swing.JPasswordField passwordreg;
    private javax.swing.JPasswordField passwordreg1;
    private javax.swing.JTextField usernamereg;
    // End of variables declaration//GEN-END:variables
}
