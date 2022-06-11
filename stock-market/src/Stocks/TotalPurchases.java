        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Stocks;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class TotalPurchases extends javax.swing.JFrame {
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    DefaultTableModel dtm;
    Statement stmt;    
    /**
     * Creates new form CustomerDetails
     */
    public TotalPurchases() {
        initComponents();
        conn = Database.connect();
        clear();
        fetch();
        txtcustomerval.setText(null);
        txtstockval.setText(null);
        txtpurchaseval.setText(null);
    }
    public void clear(){
        dtm = (DefaultTableModel)tblpurchases.getModel();
        dtm.setRowCount(0);
        txtcustomer.setText(null);
        txtpurchase.setText(null);
        txtstock.setText(null);
        txtname.setText(null);
    }
    public void customerClear(){
        txtpurchaseval.setText(null);
        txtpurchase.setText(null);
        txtstock.setText(null);
        txtstockval.setText(null);
    }
    public void purchaseClear(){
        txtcustomerval.setText(null);
        txtcustomer.setText(null);
        txtstock.setText(null);
        txtstockval.setText(null);
    }
    public void stockClear(){
        txtpurchaseval.setText(null);
        txtpurchase.setText(null);
        txtcustomer.setText(null);
        txtcustomerval.setText(null);
    }
    public void allClear(){
        txtpurchaseval.setText(null);
        txtpurchase.setText(null);
        txtcustomer.setText(null);
        txtcustomerval.setText(null);
        txtstock.setText(null);
        txtstockval.setText(null);
        txtname.setText(null);
    }
    
    public void fetch(){
        try{
            txtname.setText(null);
             stmt = conn.createStatement();
             rs = stmt.executeQuery("select p.*,c.*,s.*,p.stockprice * p.shares as total from purchases p inner join customers c on p.customerid = c.customerid inner join stocks s on s.stockid = p.stockid");
             dtm = (DefaultTableModel)tblpurchases.getModel();
             dtm.setRowCount(0);
             while(rs.next()){
                 Vector v = new Vector();
                 v.add(rs.getString("p.purchaseid"));
                 v.add(rs.getString("c.username"));
                 v.add(rs.getString("s.name"));
                 v.add(rs.getString("date"));
                 v.add(rs.getString("time"));
                 v.add(rs.getString("p.stockprice"));
                 v.add(rs.getString("p.shares"));
                 v.add(rs.getString("total"));
                 dtm.addRow(v);
             }
        }
        catch(Exception e){
                     System.out.println("error" + e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcustomer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpurchases = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtpurchase = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        txtcustomerval = new javax.swing.JLabel();
        txtpurchaseval = new javax.swing.JLabel();
        txtstockval = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PURCHASE RECORDS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Enter Stock ID");

        txtcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomerActionPerformed(evt);
            }
        });
        txtcustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcustomerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcustomerKeyReleased(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtname.setText("0");

        tblpurchases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Customer", "Stock Name", "Date", "Time", "Bought Price", "Quantity", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblpurchases);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Enter Customer ID");

        txtpurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtpurchaseMouseEntered(evt);
            }
        });
        txtpurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpurchaseActionPerformed(evt);
            }
        });
        txtpurchase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpurchaseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpurchaseKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("HOME");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("STOCKS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("PURCHASES");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("CUSTOMERS");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("SALES");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("SALES RECORDS");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 0, 0));
        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("STOCK HOLDINGS");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Deposit");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Withdraw");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Enter Purchase ID");

        txtstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtstockMouseEntered(evt);
            }
        });
        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtstockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstockKeyReleased(evt);
            }
        });

        txtcustomerval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcustomerval.setForeground(new java.awt.Color(255, 0, 0));
        txtcustomerval.setText("jLabel4");

        txtpurchaseval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtpurchaseval.setForeground(new java.awt.Color(255, 0, 0));
        txtpurchaseval.setText("jLabel4");

        txtstockval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtstockval.setForeground(new java.awt.Color(255, 0, 0));
        txtstockval.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(191, 191, 191)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtpurchaseval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(204, 204, 204)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtstockval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtcustomerval, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcustomer)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(txtstock)
                    .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcustomerval)
                            .addComponent(txtpurchaseval)
                            .addComponent(txtstockval))
                        .addGap(25, 25, 25)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomerActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcustomerActionPerformed

    private void txtcustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcustomerKeyPressed
        // TODO add your handling code here:
        customerClear();
    }//GEN-LAST:event_txtcustomerKeyPressed

    private void txtpurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurchaseActionPerformed

    private void txtpurchaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpurchaseKeyPressed
        // TODO add your handling code here:
        purchaseClear();        
    }//GEN-LAST:event_txtpurchaseKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Stocks().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        new Purchases().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        new Sales().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        new TotalSales().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        new Holdings().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void txtpurchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpurchaseMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpurchaseMouseEntered

    private void txtstockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtstockMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockMouseEntered

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void txtstockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyPressed
        // TODO add your handling code here:
        
        stockClear();
    }//GEN-LAST:event_txtstockKeyPressed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        new Deposit().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        new Withdraw().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void txtcustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcustomerKeyReleased
        // TODO add your handling code here:
        
        try {
            if("".equals(txtcustomer.getText())){
                txtcustomerval.setText(null);
                fetch();
            }
            else{
            String id = txtcustomer.getText();
            pst = conn.prepareStatement("select name from customers where customerid = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next() == false){
                txtcustomerval.setText("customerid not found");
                fetch();
            }else{
                txtcustomerval.setText(null);
                String name = rs.getString(1);
                txtname.setText(name.trim());
                pst = conn.prepareStatement("select p.*,c.*,s.*,p.stockprice * p.shares as total from purchases p inner join stocks s on p.stockid = s.stockid inner join customers c on p.customerid = c.customerid where p.customerid = ?");
            pst.setString(1,id);
            dtm = (DefaultTableModel)tblpurchases.getModel();
            dtm.setRowCount(0);
            rs = pst.executeQuery();
            while(rs.next()){
                 Vector v = new Vector();
                 v.add(rs.getString("p.purchaseid"));
                 v.add(rs.getString("c.username"));
                 v.add(rs.getString("s.name"));
                 v.add(rs.getString("p.date"));
                 v.add(rs.getString("p.time"));
                 v.add(rs.getString("p.stockprice"));
                 v.add(rs.getString("p.shares"));
                 v.add(rs.getString("total"));
                 dtm.addRow(v);
             }
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtcustomerKeyReleased

    private void txtpurchaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpurchaseKeyReleased
        // TODO add your handling code here:
        
        try {
            if("".equals(txtpurchase.getText())){
                txtpurchaseval.setText(null);
                fetch();
            }
            else{
            String id = txtpurchase.getText();
            pst = conn.prepareStatement("select customerid from purchases where purchaseid = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            if(rs.next() == false){
                txtpurchaseval.setText("purchaseid not found");
                fetch();
            }else{
                txtpurchaseval.setText(null);
                String customerid = rs.getString(1);
                pst = conn.prepareStatement("select name from customers where customerid = ?");
                pst.setString(1,customerid);
                rs = pst.executeQuery();
                if(rs.next()){
                    String name = rs.getString(1);
                    txtname.setText(name.trim());
                    pst = conn.prepareStatement("select p.*,c.*,s.*,p.stockprice * p.shares as total from purchases p inner join stocks as s on p.stockid = s.stockid inner join customers c on p.customerid = c.customerid where p.purchaseid = ?");
            pst.setString(1,id);
            dtm = (DefaultTableModel)tblpurchases.getModel();
            dtm.setRowCount(0);
            rs = pst.executeQuery();
            while(rs.next()){
                 Vector v = new Vector();
                 v.add(rs.getString("purchaseid"));
                 v.add(rs.getString("c.username"));
                 v.add(rs.getString("s.name"));
                 v.add(rs.getString("date"));
                 v.add(rs.getString("time"));
                 v.add(rs.getString("stockprice"));
                 v.add(rs.getString("shares"));
                 v.add(rs.getString("total"));
                 dtm.addRow(v);
             }
                }
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtpurchaseKeyReleased

    private void txtstockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyReleased
        // TODO add your handling code here:
        try {  
            if("".equals(txtstock.getText())){
                txtstockval.setText(null);
                fetch();
            }else{
            String id = txtstock.getText();
            pst = conn.prepareStatement("select name from stocks where stockid = ?");
            pst.setString(1, id);
            
            rs = pst.executeQuery();
            
            if(rs.next() == false){
                txtstockval.setText("stockid not found");
                fetch();
            }else{
                txtstockval.setText(null);
                String name = rs.getString(1);
                txtname.setText(name.trim());
                txtstock.requestFocus();
                pst = conn.prepareStatement("select p.*,c.*,s.*,p.stockprice * p.shares as total from purchases p inner join stocks as s on p.stockid = s.stockid inner join customers c on p.customerid = c.customerid where p.stockid = ?");
            pst.setString(1,id);
            dtm = (DefaultTableModel)tblpurchases.getModel();
            dtm.setRowCount(0);
            rs = pst.executeQuery();
            while(rs.next()){
                 Vector v = new Vector();
                 v.add(rs.getString("purchaseid"));
                 v.add(rs.getString("c.username"));
                 v.add(rs.getString("s.name"));
                 v.add(rs.getString("date"));
                 v.add(rs.getString("time"));
                 v.add(rs.getString("stockprice"));
                 v.add(rs.getString("shares"));
                 v.add(rs.getString("total"));
                 dtm.addRow(v);
             }
                
            }
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtstockKeyReleased

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
            java.util.logging.Logger.getLogger(TotalPurchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TotalPurchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TotalPurchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TotalPurchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TotalPurchases().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpurchases;
    private javax.swing.JTextField txtcustomer;
    private javax.swing.JLabel txtcustomerval;
    private javax.swing.JLabel txtname;
    private javax.swing.JTextField txtpurchase;
    private javax.swing.JLabel txtpurchaseval;
    private javax.swing.JTextField txtstock;
    private javax.swing.JLabel txtstockval;
    // End of variables declaration//GEN-END:variables
}
