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
    ResultSet rs;
    PreparedStatement pst;
    Connection con = null;
    public Sell() {
        initComponents();
        createConnection();
    }
    
     public void autorefNo(){
         try {
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery("Select Max(S_RefNo) from solditem ");
             rs.next();
             
             rs.getString("Max(S_RefNo)");
             
             if(rs.getString("Max(S_RefNo)")==null){
                 S_refnot.setText("B0001");
             }
             else{
                 Long B_RefNo = Long.parseLong(rs.getString("Max(S_RefNo)").substring(2,rs.getString("Max(S_RefNo)").length()));
                 B_RefNo++;
                 S_refnot.setText("B0" + String.format("%03d", B_RefNo));
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
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","9823Nan@831");
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
            String regno1 = regnot.getText();
            String s_refno1 = S_refnot.getText();
            
            //For Sold items
            String s_refno = S_refnot.getText();
            String regno = regnot.getText();
            String price = pricet.getText();
            String date = datet.getText();
            String spnote = spnotet.getText();
            
            //From vechicle table
            
            
            //Insert Items
            Statement stm = con.createStatement();
            String sql ="INSERT INTO newowner VALUES('"+s_refno1+"','"+nic+"','"+name+"','"+address+"','"+tp+"','"+regno1+"')";
            String sql1 ="INSERT INTO solditem VALUES('"+s_refno+"','"+regno+"','"+price+"','"+date+"','"+spnote+"')";
            stm.executeUpdate(sql);
            stm.executeUpdate(sql1);
            
            //Delete Items
            Statement stm1 = (Statement) con.createStatement();
            String query1 = "delete from  vehicle where Regno='"+regno+"'";
            stm1.executeUpdate(query1);
            
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
        jScrollPane2 = new javax.swing.JScrollPane();
        addresst = new javax.swing.JTextArea();
        tpt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        spnotet = new javax.swing.JTextArea();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(189, 76, 84));
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telephone");

        nict.setBackground(new java.awt.Color(189, 76, 84));
        nict.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nict.setForeground(new java.awt.Color(255, 255, 255));
        nict.setToolTipText("");
        nict.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        nict.setCaretColor(new java.awt.Color(255, 255, 255));
        nict.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nictKeyPressed(evt);
            }
        });

        namet.setBackground(new java.awt.Color(189, 76, 84));
        namet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namet.setForeground(new java.awt.Color(255, 255, 255));
        namet.setToolTipText("");
        namet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        namet.setCaretColor(new java.awt.Color(255, 255, 255));
        namet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nametKeyPressed(evt);
            }
        });

        addresst.setBackground(new java.awt.Color(189, 76, 84));
        addresst.setColumns(20);
        addresst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addresst.setForeground(new java.awt.Color(255, 255, 255));
        addresst.setRows(5);
        addresst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addresst.setCaretColor(new java.awt.Color(255, 255, 255));
        addresst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addresstKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(addresst);

        tpt.setBackground(new java.awt.Color(189, 76, 84));
        tpt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tpt.setForeground(new java.awt.Color(255, 255, 255));
        tpt.setToolTipText("");
        tpt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tpt.setCaretColor(new java.awt.Color(255, 255, 255));
        tpt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tptKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Save ");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Home ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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

        jLabel14.setBackground(new java.awt.Color(255, 204, 204));
        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 255));
        jLabel14.setText("Owner  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(tpt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nict, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(73, 31, 61));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 400));

        spnotet.setBackground(new java.awt.Color(73, 31, 61));
        spnotet.setColumns(20);
        spnotet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnotet.setForeground(new java.awt.Color(255, 255, 255));
        spnotet.setRows(5);
        spnotet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        spnotet.setCaretColor(new java.awt.Color(255, 255, 255));
        spnotet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spnotetKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(spnotet);

        datet.setBackground(new java.awt.Color(73, 31, 61));
        datet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datet.setForeground(new java.awt.Color(255, 255, 255));
        datet.setToolTipText("");
        datet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        datet.setCaretColor(new java.awt.Color(255, 255, 255));
        datet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datetKeyPressed(evt);
            }
        });

        pricet.setBackground(new java.awt.Color(73, 31, 61));
        pricet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pricet.setForeground(new java.awt.Color(255, 255, 255));
        pricet.setToolTipText("");
        pricet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pricet.setCaretColor(new java.awt.Color(255, 255, 255));
        pricet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pricetKeyPressed(evt);
            }
        });

        regnot.setBackground(new java.awt.Color(73, 31, 61));
        regnot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regnot.setForeground(new java.awt.Color(255, 255, 255));
        regnot.setToolTipText("");
        regnot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        regnot.setCaretColor(new java.awt.Color(255, 255, 255));
        regnot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                regnotKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reg. no");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Special Note");

        jLabel7.setFont(new java.awt.Font("Tekton Pro Ext", 0, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("ABC");

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Vehicle ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ref. no");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        S_refnot.setBackground(new java.awt.Color(73, 31, 61));
        S_refnot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        S_refnot.setForeground(new java.awt.Color(255, 255, 255));
        S_refnot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pricet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(regnot, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(S_refnot))))
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S_refnot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regnot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pricet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void addresstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addresstKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            tpt.requestFocus();
        }
    }//GEN-LAST:event_addresstKeyPressed

    private void tptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tptKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            sellcar();
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

    private void spnotetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnotetKeyPressed
         if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            nict.requestFocus();
        }   

        
    }//GEN-LAST:event_spnotetKeyPressed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
     
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel6KeyPressed
      
    }//GEN-LAST:event_jLabel6KeyPressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         try {
                // TODO add your handling code here:
                pst = con.prepareStatement("SELECT * from vehicle WHERE Regno=?");
                pst.setString(1,regnot.getText());
                rs = pst.executeQuery();
                if(rs.next()==false){
                    JOptionPane.showMessageDialog(this, "This car can't be sold");
                    regnot.setText("");
                }
                else{
                    sellcar();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
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
    private javax.swing.JTextArea addresst;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namet;
    private javax.swing.JTextField nict;
    private javax.swing.JTextField pricet;
    private javax.swing.JTextField regnot;
    private javax.swing.JTextArea spnotet;
    private javax.swing.JTextField tpt;
    // End of variables declaration//GEN-END:variables
}
