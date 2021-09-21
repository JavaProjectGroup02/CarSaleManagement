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
 * @author Dell
 */
public class Sell extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
    ResultSet rs,rs_refno,rs_owner;
    PreparedStatement pst,pst_owner;
    Connection con = null;
    public Sell() {
        initComponents();
        createConnection();
    }
    
     public void autorefNo(){
         try {
             Statement s = con.createStatement();
             rs_refno = s.executeQuery("Select Max(RefNo) from sell ");
             rs_refno.next();
             
             rs_refno.getString("Max(RefNo)");
             
             if(rs_refno.getString("Max(RefNo)")==null){
                 S_refnot.setText("B0001");
             }
             else{
                 Long RefNo = Long.parseLong(rs_refno.getString("Max(RefNo)").substring(2,rs_refno.getString("Max(RefNo)").length()));
                 RefNo++;
                 S_refnot.setText("B0" + String.format("%03d", RefNo));
             }
         } catch (SQLException ex) {
             Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
         }
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
    
    public void sellcar(){
        try {
            // TODO add your handling code here:
           
            //For newowners
            String nic = nict.getText();
            String name = namet.getText();
            String address = addresst.getText();
            String tp = tpt.getText();
            
            //For Sold items
            String s_refno = S_refnot.getText();
            String regno = regnot.getText();
            String price = pricet.getText();
            String date = datet.getText();
            String spnote = spnotet.getText();
            String status = "Unavailable";
            
            
                pst_owner = con.prepareStatement("SELECT * from owner WHERE NIC=?");
                pst_owner.setString(1,nict.getText());
                rs_owner = pst_owner.executeQuery();
                Statement stm = con.createStatement();
                if(rs_owner.next()==false){
                    String sql_owner ="INSERT INTO owner VALUES('"+nic+"','"+name+"','"+address+"','"+tp+"')";
                    String sql_sell ="INSERT INTO sell VALUES('"+s_refno+"','"+nic+"','"+regno+"','"+date+"','"+price+"','"+spnote+"')";
                    stm.executeUpdate(sql_owner);
                    stm.executeUpdate(sql_sell);
                }
                else{
                    String sql_owner = "UPDATE owner SET Name = '"+name+"',Address = '"+address+"',Tele = '"+tp+"' WHERE NIC = '"+nic+"'";
                    String sql_sell ="INSERT INTO sell VALUES('"+s_refno+"','"+nic+"','"+regno+"','"+date+"','"+price+"','"+spnote+"')";
                    stm.executeUpdate(sql_owner);
                    stm.executeUpdate(sql_sell);
                }
                String sql_vehicle = "UPDATE vehicle SET Status = '"+status+"' WHERE RegNo = '"+regno+"'";
                stm.executeUpdate(sql_vehicle);
                   
                JOptionPane.showMessageDialog(this,"Vehicle sold successfully");

                nict.setText("");
                namet.setText("");
                addresst.setText("");
                tpt.setText("");
                regnot.setText("");
                pricet.setText("");
                datet.setText("");
                spnotet.setText("");
                S_refnot.setText("");
                S_refnot.requestFocus();  
                
        } catch (SQLException ex) {
            Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ensureVehicle(){
            try {
                pst = con.prepareStatement("SELECT * from vehicle WHERE RegNo=?");
                pst.setString(1,regnot.getText());
                rs = pst.executeQuery();
                if(rs.next()==false){
                    JOptionPane.showMessageDialog(this, "This car can't be sold");
                    regnot.setText("");
                    regnot.requestFocus();
                }
                else{
                    sellcar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nict = new javax.swing.JTextField();
        namet = new javax.swing.JTextField();
        tpt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        addresst = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        datet = new javax.swing.JTextField();
        pricet = new javax.swing.JTextField();
        regnot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        S_refnot = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        spnotet = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(189, 76, 84));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telephone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        nict.setBackground(new java.awt.Color(189, 76, 84));
        nict.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        nict.setForeground(new java.awt.Color(191, 191, 191));
        nict.setToolTipText("");
        nict.setBorder(null);
        nict.setCaretColor(new java.awt.Color(255, 255, 255));
        nict.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nictKeyPressed(evt);
            }
        });
        jPanel1.add(nict, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 20));

        namet.setBackground(new java.awt.Color(189, 76, 84));
        namet.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        namet.setForeground(new java.awt.Color(191, 191, 191));
        namet.setToolTipText("");
        namet.setBorder(null);
        namet.setCaretColor(new java.awt.Color(255, 255, 255));
        namet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nametKeyPressed(evt);
            }
        });
        jPanel1.add(namet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 20));

        tpt.setBackground(new java.awt.Color(189, 76, 84));
        tpt.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        tpt.setForeground(new java.awt.Color(191, 191, 191));
        tpt.setToolTipText("");
        tpt.setBorder(null);
        tpt.setCaretColor(new java.awt.Color(255, 255, 255));
        tpt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tptKeyPressed(evt);
            }
        });
        jPanel1.add(tpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 300, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 0, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 204, 204));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 255));
        jLabel14.setText("Owner  ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel3.setBackground(new java.awt.Color(189, 76, 84));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Home ");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 110, 40));

        jPanel5.setBackground(new java.awt.Color(189, 76, 84));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Save ");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jLabel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel6KeyPressed(evt);
            }
        });
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 110, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 300, 20));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 300, 20));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 300, 20));

        addresst.setBackground(new java.awt.Color(189, 76, 84));
        addresst.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        addresst.setForeground(new java.awt.Color(191, 191, 191));
        addresst.setToolTipText("");
        addresst.setBorder(null);
        addresst.setCaretColor(new java.awt.Color(255, 255, 255));
        addresst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addresstKeyPressed(evt);
            }
        });
        jPanel1.add(addresst, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 300, 20));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 300, 20));

        jPanel2.setBackground(new java.awt.Color(73, 31, 61));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datet.setBackground(new java.awt.Color(73, 31, 61));
        datet.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        datet.setForeground(new java.awt.Color(165, 165, 165));
        datet.setToolTipText("");
        datet.setBorder(null);
        datet.setCaretColor(new java.awt.Color(255, 255, 255));
        datet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datetKeyPressed(evt);
            }
        });
        jPanel2.add(datet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 300, 20));

        pricet.setBackground(new java.awt.Color(73, 31, 61));
        pricet.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        pricet.setForeground(new java.awt.Color(165, 165, 165));
        pricet.setToolTipText("");
        pricet.setBorder(null);
        pricet.setCaretColor(new java.awt.Color(255, 255, 255));
        pricet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pricetKeyPressed(evt);
            }
        });
        jPanel2.add(pricet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 300, 20));

        regnot.setBackground(new java.awt.Color(73, 31, 61));
        regnot.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        regnot.setForeground(new java.awt.Color(165, 165, 165));
        regnot.setToolTipText("");
        regnot.setBorder(null);
        regnot.setCaretColor(new java.awt.Color(255, 255, 255));
        regnot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                regnotKeyPressed(evt);
            }
        });
        jPanel2.add(regnot, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 20));

        jLabel8.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reg. No.");
        jLabel8.setToolTipText("");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Special Note");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tekton Pro Ext", 0, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("ABC");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 63));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Vehicle ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 11, -1, -1));

        jLabel13.setFont(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ref. No.");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 23));

        S_refnot.setBackground(new java.awt.Color(73, 31, 61));
        S_refnot.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        S_refnot.setForeground(new java.awt.Color(165, 165, 165));
        S_refnot.setBorder(null);
        S_refnot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S_refnotFocusGained(evt);
            }
        });
        S_refnot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                S_refnotKeyPressed(evt);
            }
        });
        jPanel2.add(S_refnot, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 20));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 300, 20));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 300, 20));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 300, 20));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 300, 20));

        spnotet.setBackground(new java.awt.Color(73, 31, 61));
        spnotet.setFont(new java.awt.Font("STXihei", 0, 15)); // NOI18N
        spnotet.setForeground(new java.awt.Color(165, 165, 165));
        spnotet.setToolTipText("");
        spnotet.setBorder(null);
        spnotet.setCaretColor(new java.awt.Color(255, 255, 255));
        spnotet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spnotetKeyPressed(evt);
            }
        });
        jPanel2.add(spnotet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 300, 20));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nictKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nictKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            namet.requestFocus();
        }
    }//GEN-LAST:event_nictKeyPressed

    private void nametKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            addresst.requestFocus();
        }
    }//GEN-LAST:event_nametKeyPressed

    private void tptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tptKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            ensureVehicle();
        }
    }//GEN-LAST:event_tptKeyPressed

    private void regnotKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regnotKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            pricet.requestFocus();
        }
    }//GEN-LAST:event_regnotKeyPressed

    private void pricetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricetKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            datet.requestFocus();
        }
    }//GEN-LAST:event_pricetKeyPressed

    private void datetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datetKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            spnotet.requestFocus();
        }
    }//GEN-LAST:event_datetKeyPressed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
     
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel6KeyPressed
      
    }//GEN-LAST:event_jLabel6KeyPressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ensureVehicle();  
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Welcome jf = new Welcome();
        jf.show();
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void S_refnotKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S_refnotKeyPressed
       if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            regnot.requestFocus();
        }   
    }//GEN-LAST:event_S_refnotKeyPressed

    private void S_refnotFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_refnotFocusGained
        autorefNo();
    }//GEN-LAST:event_S_refnotFocusGained

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        Welcome jf = new Welcome();
        jf.show();
        dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        ensureVehicle();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void addresstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addresstKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            tpt.requestFocus();
        }
    }//GEN-LAST:event_addresstKeyPressed

    private void spnotetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnotetKeyPressed
         if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            nict.requestFocus();
        }
    }//GEN-LAST:event_spnotetKeyPressed

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
                if ("metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField S_refnot;
    private javax.swing.JTextField addresst;
    private javax.swing.JTextField datet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField namet;
    private javax.swing.JTextField nict;
    private javax.swing.JTextField pricet;
    private javax.swing.JTextField regnot;
    private javax.swing.JTextField spnotet;
    private javax.swing.JTextField tpt;
    // End of variables declaration//GEN-END:variables
}
