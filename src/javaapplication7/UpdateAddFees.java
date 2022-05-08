/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication7;

import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author CHIRAG VOHRA
 */
public final class UpdateAddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
     public final void displaycashfirst(){
        lbl_dd.setVisible(false);
        lbl_cheque.setVisible(false);
        lbl_bank.setVisible(false);
        
        txt_dd.setVisible(false);
        txt_chequeno.setVisible(false);
        txt_bankname.setVisible(false);
    }

    /**
     *
     */
    public UpdateAddFees() {
        initComponents();
        displaycashfirst();
        fillComboBox();
      int receipt = getReceiptNo();
      txt_receipt.setText(Integer.toString(receipt));
     
      getRecords();
    }
    public boolean validationAddFees(){
        if(txt_received.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter Your Name");
            return false;
        }
        if(txt_date.getDate()==null){
            JOptionPane.showMessageDialog(this,"Please select Date");
            return false;
        }
        if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this,"Please enter amount in numbers only");
            return false;
        }
        
      
        if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            if(txt_chequeno.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the correct cheque number");
            return false;
        }
            if(txt_bankname.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        }
         if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("dd")){
            if(txt_dd .getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the correct DD number");
            return false;
        }
            if(txt_bankname.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        }
         if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("Debit/Credit card")){
//            if(txt_dd .getText().equals("") || txt_chequeno.getText().matches("[0-9]+")==false){
//            JOptionPane.showMessageDialog(this,"Please enter the correct DD number");
//            return false;
//        }
            if(txt_bankname.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        } 
        return true;
    }

    /**
     *
     */
    public final void fillComboBox(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            PreparedStatement pst = con.prepareStatement("select coursename from coursedb");
          ResultSet rs =  pst.executeQuery();
          while(rs.next()){
              dd_course.addItem(rs.getString("coursename"));
          }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }

    /**
     *
     * @return
     */
    public int getReceiptNo(){
        int reciept_no=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            PreparedStatement pst = con.prepareStatement("select max(receiptno) from feess");
          ResultSet rs =  pst.executeQuery();
            if(rs.next()){
         reciept_no= rs.getInt(1);
         
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return reciept_no+1;
    }

    
        public void getRecords(){
            try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            
            PreparedStatement stmt = con.prepareStatement("select * from feess order by receiptno desc limit 1");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            txt_receipt.setText(rs.getString("receiptno"));
             txt_received.setText(rs.getString("studentnaam"));
            txt_rollno.setText(rs.getString("rolllnoo"));
            txt_date.setDate(rs.getDate("dateoffees"));
            txt_amount.setText(rs.getString("initialMoney"));
            txt_totalamount.setText(rs.getString("totalMoney"));
            txt_totalinwords.setText(rs.getString("moneyInWords"));
            combo_paymentmode.setSelectedItem(rs.getString("paymentMode"));
           txt_bankname.setText(rs.getString("bankName"));
            txt_gst.setText(rs.getString("gstnoo"));
            txt_cgst.setText(rs.getString("cgstt"));
             txt_sgst.setText(rs.getString("sgstt"));
             txt_coursename.setText(rs.getString("coursenaam"));
           txt_remarks.setText(rs.getString("remarkss"));
             txt_year.setText(rs.getString("year11"));
            txt_year2.setText(rs.getString("year22"));
            txt_dd.setText(rs.getString("ddnoo"));
            txt_chequeno.setText(rs.getString("chequenoo"));
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
   public void updateData(){
       String status = "";
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      int receiptNo = Integer.parseInt(txt_receipt.getText());
        String studentname= txt_received.getText();
       
       String paymentmode = combo_paymentmode.getSelectedItem().toString();
    String chequeno = (txt_chequeno.getText());
        String bankName = txt_bankname.getText();
        String ddNO = (txt_dd.getText());
        String courseName = txt_coursename.getText();
        String gstint = txt_gst.getText();
        float totalAmount = Float.parseFloat(txt_totalamount.getText());
        
        String date = format.format(txt_date.getDate());
      String initialamount = (txt_amount.getText());
        float cgst = (float)Float.parseFloat(txt_cgst.getText());
        float sgst = (float) Float.parseFloat(txt_sgst.getText());
        String totalinwords = txt_totalinwords.getText();
        String remark = txt_remarks.getText();
        int year1 = Integer.parseInt(txt_year.getText());
        int year2 = Integer.parseInt(txt_year2.getText());
       String rollno =(txt_rollno.getText());
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            PreparedStatement pst = con.prepareStatement("update feess set studentnaam=?,rolllnoo=?,dateoffees=?,initialMoney=?,totalMoney=?,moneyInWords=?,paymentMode=?,chequenoo=?,bankName=?,ddnoo=?,gstnoo=?,cgstt=?,sgstt=?,coursenaam=?,remarkss=?,year11=?,year22=? where receiptno=?" );
         
        pst.setString(1, studentname); 
        pst.setString(2, rollno);
        pst.setString(3, date);
        pst.setString(4, initialamount);
         pst.setFloat(5, totalAmount);
         pst.setString(6,totalinwords);
        pst.setString(7, paymentmode);
        pst.setString(8, chequeno); 
        pst.setString(9, bankName);
         pst.setString(10, ddNO); 
         pst.setString(11, gstint);
         pst.setFloat(12, cgst); 
        pst.setFloat(13, sgst);
         pst.setString(14, courseName);
         pst.setString(15, remark); 
        
         pst.setInt(16, year1);
         pst.setInt(17  , year2);
         pst.setInt(18,receiptNo);
         
        
         
        
       
       int rowCount =  pst.executeUpdate();
       if(rowCount>0){
           JOptionPane.showMessageDialog(this, "Update successful");
       }
       else{
           JOptionPane.showMessageDialog(this, "Not updated");
       }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        viewrecordpanel = new javax.swing.JPanel();
        homelabel = new javax.swing.JLabel();
        searchpanel = new javax.swing.JPanel();
        homelabel1 = new javax.swing.JLabel();
        editcoursepanel = new javax.swing.JPanel();
        homelabel2 = new javax.swing.JLabel();
        homepanel = new javax.swing.JPanel();
        homelabel3 = new javax.swing.JLabel();
        backpanel = new javax.swing.JPanel();
        homelabel4 = new javax.swing.JLabel();
        logoutpanel = new javax.swing.JPanel();
        homelabel5 = new javax.swing.JLabel();
        contactpanel = new javax.swing.JPanel();
        homelabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        parentpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_cheque = new javax.swing.JLabel();
        txt_chequeno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_dd = new javax.swing.JLabel();
        txt_gst = new javax.swing.JLabel();
        txt_date = new com.toedter.calendar.JDateChooser();
        txt_dd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_receipt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_child = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_coursename = new javax.swing.JTextField();
        txt_received = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_year = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dd_course = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_totalinwords = new javax.swing.JTextField();
        txt_rollno = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        txt_totalamount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remarks = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        combo_paymentmode = new javax.swing.JComboBox<>();
        lbl_bank = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(51, 0, 153));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewrecordpanel.setBackground(new java.awt.Color(51, 0, 153));
        viewrecordpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        viewrecordpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewrecordpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewrecordpanelMouseExited(evt);
            }
        });
        viewrecordpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel.setForeground(new java.awt.Color(255, 255, 255));
        homelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/view all record.png"))); // NOI18N
        homelabel.setText("View Records");
        homelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabelMouseClicked(evt);
            }
        });
        viewrecordpanel.add(homelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelsidebar.add(viewrecordpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 330, 70));

        searchpanel.setBackground(new java.awt.Color(51, 0, 153));
        searchpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        searchpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchpanelMouseExited(evt);
            }
        });
        searchpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel1.setForeground(new java.awt.Color(255, 255, 255));
        homelabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/search2.png"))); // NOI18N
        homelabel1.setText("Search Record");
        homelabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel1MouseClicked(evt);
            }
        });
        searchpanel.add(homelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        panelsidebar.add(searchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 330, 70));

        editcoursepanel.setBackground(new java.awt.Color(51, 0, 153));
        editcoursepanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        editcoursepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editcoursepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editcoursepanelMouseExited(evt);
            }
        });
        editcoursepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel2.setForeground(new java.awt.Color(255, 255, 255));
        homelabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/edit2.png"))); // NOI18N
        homelabel2.setText("Edit Courses");
        homelabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel2MouseClicked(evt);
            }
        });
        editcoursepanel.add(homelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, 60));

        panelsidebar.add(editcoursepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 330, 70));

        homepanel.setBackground(new java.awt.Color(51, 0, 153));
        homepanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        homepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homepanelMouseExited(evt);
            }
        });
        homepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel3.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel3.setForeground(new java.awt.Color(255, 255, 255));
        homelabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/home.png"))); // NOI18N
        homelabel3.setText("  Home");
        homelabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel3MouseClicked(evt);
            }
        });
        homepanel.add(homelabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, 50));

        panelsidebar.add(homepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 330, 70));

        backpanel.setBackground(new java.awt.Color(51, 0, 153));
        backpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        backpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backpanelMouseExited(evt);
            }
        });
        backpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel4.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel4.setForeground(new java.awt.Color(255, 255, 255));
        homelabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/back-button.png"))); // NOI18N
        homelabel4.setText("Back");
        homelabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel4MouseClicked(evt);
            }
        });
        backpanel.add(homelabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 70));

        panelsidebar.add(backpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 330, 70));

        logoutpanel.setBackground(new java.awt.Color(51, 0, 153));
        logoutpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        logoutpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutpanelMouseExited(evt);
            }
        });
        logoutpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel5.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel5.setForeground(new java.awt.Color(255, 255, 255));
        homelabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/logout.png"))); // NOI18N
        homelabel5.setText("Logout");
        homelabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel5MouseClicked(evt);
            }
        });
        logoutpanel.add(homelabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 320, 70));

        panelsidebar.add(logoutpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 330, 70));

        contactpanel.setBackground(new java.awt.Color(51, 0, 153));
        contactpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        contactpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contactpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contactpanelMouseExited(evt);
            }
        });
        contactpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homelabel6.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel6.setForeground(new java.awt.Color(255, 255, 255));
        homelabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/admin.png"))); // NOI18N
        homelabel6.setText("Contact Us");
        contactpanel.add(homelabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 250, 70));

        panelsidebar.add(contactpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 330, 70));

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 153));
        jLabel16.setText("Remarks : ");
        panelsidebar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, -1, 40));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 1040));

        parentpanel.setBackground(new java.awt.Color(204, 204, 255));
        parentpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 3, true));
        parentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("CEC -");
        parentpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 30));

        lbl_cheque.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_cheque.setForeground(new java.awt.Color(51, 0, 153));
        lbl_cheque.setText("Cheque No  :");
        parentpanel.add(lbl_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        txt_chequeno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_chequeno.setForeground(new java.awt.Color(51, 0, 153));
        txt_chequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chequenoActionPerformed(evt);
            }
        });
        parentpanel.add(txt_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 153));
        jLabel3.setText("Date : ");
        parentpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, 30));

        lbl_dd.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_dd.setForeground(new java.awt.Color(51, 0, 153));
        lbl_dd.setText("DD No :");
        parentpanel.add(lbl_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        txt_gst.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txt_gst.setForeground(new java.awt.Color(255, 0, 51));
        txt_gst.setText("04AABCU9603R1ZV");
        parentpanel.add(txt_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 140, 30));
        parentpanel.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 130, -1));

        txt_dd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_dd.setForeground(new java.awt.Color(51, 0, 153));
        txt_dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ddActionPerformed(evt);
            }
        });
        parentpanel.add(txt_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 153));
        jLabel7.setText("Mode Of Payement :");
        parentpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        txt_receipt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_receipt.setForeground(new java.awt.Color(51, 0, 153));
        txt_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptActionPerformed(evt);
            }
        });
        parentpanel.add(txt_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 153));
        jLabel8.setText("Receipt No. : ");
        parentpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 153));
        jLabel9.setText("GSTIN : ");
        parentpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, 30));

        panel_child.setBackground(new java.awt.Color(204, 204, 255));
        panel_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 153));
        jLabel4.setText("The following payment in the collge 0ffice for the year");
        panel_child.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 153));
        jLabel11.setText("To");
        panel_child.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 20, 30));

        txt_coursename.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_coursename.setForeground(new java.awt.Color(51, 0, 153));
        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        panel_child.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 430, 30));

        txt_received.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_received.setForeground(new java.awt.Color(51, 0, 153));
        txt_received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receivedActionPerformed(evt);
            }
        });
        panel_child.add(txt_received, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 240, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 153));
        jLabel12.setText("Received From :");
        panel_child.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        txt_year.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_year.setForeground(new java.awt.Color(51, 0, 153));
        txt_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_yearActionPerformed(evt);
            }
        });
        panel_child.add(txt_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 70, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 153));
        jLabel10.setText("Amount ");
        panel_child.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, 40));

        dd_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dd_courseActionPerformed(evt);
            }
        });
        panel_child.add(dd_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 110, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 153));
        jLabel13.setText("Roll NO :");
        panel_child.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, 30));

        txt_year2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_year2.setForeground(new java.awt.Color(51, 0, 153));
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panel_child.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 70, 30));
        panel_child.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 420, 20));
        panel_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1280, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 0, 153));
        jLabel15.setText("Course : ");
        panel_child.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 0, 153));
        jLabel17.setText("Head");
        panel_child.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, 50));

        txt_totalinwords.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_totalinwords.setForeground(new java.awt.Color(51, 0, 153));
        txt_totalinwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinwordsActionPerformed(evt);
            }
        });
        panel_child.add(txt_totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 430, 30));

        txt_rollno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_rollno.setForeground(new java.awt.Color(51, 0, 153));
        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });
        panel_child.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 90, 30));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_amount.setForeground(new java.awt.Color(51, 0, 153));
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panel_child.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 140, 30));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_cgst.setForeground(new java.awt.Color(51, 0, 153));
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panel_child.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 140, 30));
        panel_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1280, 50));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_sgst.setForeground(new java.awt.Color(51, 0, 153));
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panel_child.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 140, 30));

        txt_totalamount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_totalamount.setForeground(new java.awt.Color(51, 0, 153));
        txt_totalamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalamountActionPerformed(evt);
            }
        });
        panel_child.add(txt_totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 140, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 0, 153));
        jLabel18.setText("Account Office Signature : ");
        panel_child.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 0, 153));
        jLabel19.setText("SR No :");
        panel_child.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 0, 153));
        jLabel20.setText("CGST 9% :");
        panel_child.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 0, 153));
        jLabel21.setText("Remarks:");
        panel_child.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, 40));

        txt_remarks.setColumns(20);
        txt_remarks.setRows(5);
        jScrollPane1.setViewportView(txt_remarks);

        panel_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 430, 110));
        panel_child.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 180, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 0, 153));
        jLabel22.setText("Total Amount :");
        panel_child.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, 40));

        btn_print.setBackground(new java.awt.Color(51, 0, 153));
        btn_print.setFont(new java.awt.Font("Segoe UI Emoji", 3, 18)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panel_child.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 153));
        jLabel23.setText("SGST 9% :");
        panel_child.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 0, 153));
        jLabel24.setText("Total in Words : ");
        panel_child.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, 40));

        parentpanel.add(panel_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1300, 800));

        txt_bankname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_bankname.setForeground(new java.awt.Color(51, 0, 153));
        txt_bankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_banknameActionPerformed(evt);
            }
        });
        parentpanel.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 240, 30));

        combo_paymentmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "UPI/Cash", "Debit/Credit card" }));
        combo_paymentmode.setSelectedIndex(2);
        combo_paymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentmodeActionPerformed(evt);
            }
        });
        parentpanel.add(combo_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 100, -1));

        lbl_bank.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lbl_bank.setForeground(new java.awt.Color(51, 0, 153));
        lbl_bank.setText("Bank Name :");
        parentpanel.add(lbl_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));

        getContentPane().add(parentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 1310, 1040));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewrecordpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewrecordpanelMouseEntered
Color clr = new Color(48,0,178);
viewrecordpanel.setBackground(clr);// TODO add your handling code here:
    }//GEN-LAST:event_viewrecordpanelMouseEntered

    private void viewrecordpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewrecordpanelMouseExited
        Color clr = new Color(51,0,153);
viewrecordpanel.setBackground(clr);
    }//GEN-LAST:event_viewrecordpanelMouseExited

    private void searchpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchpanelMouseEntered
      Color clr = new Color(48,0,178);
searchpanel.setBackground(clr);
    }//GEN-LAST:event_searchpanelMouseEntered

    private void searchpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchpanelMouseExited
        Color clr = new Color(51,0,153);
searchpanel.setBackground(clr);
    }//GEN-LAST:event_searchpanelMouseExited

    private void editcoursepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editcoursepanelMouseEntered
        Color clr = new Color(48,0,178);
editcoursepanel.setBackground(clr);
    }//GEN-LAST:event_editcoursepanelMouseEntered

    private void editcoursepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editcoursepanelMouseExited
       Color clr = new Color(51,0,153);
editcoursepanel.setBackground(clr);
    }//GEN-LAST:event_editcoursepanelMouseExited

    private void homepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanelMouseEntered
        Color clr = new Color(48,0,178);
homepanel.setBackground(clr);
    }//GEN-LAST:event_homepanelMouseEntered

    private void homepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanelMouseExited
       Color clr = new Color(51,0,153);
homepanel.setBackground(clr);
    }//GEN-LAST:event_homepanelMouseExited

    private void backpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backpanelMouseEntered
        Color clr = new Color(48,0,178);
backpanel.setBackground(clr);
    }//GEN-LAST:event_backpanelMouseEntered

    private void backpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backpanelMouseExited
      Color clr = new Color(51,0,153);
backpanel.setBackground(clr);
    }//GEN-LAST:event_backpanelMouseExited

    private void logoutpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseEntered
        Color clr = new Color(48,0,178);
logoutpanel.setBackground(clr);
    }//GEN-LAST:event_logoutpanelMouseEntered

    private void logoutpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseExited
      Color clr = new Color(51,0,153);
logoutpanel.setBackground(clr);
    }//GEN-LAST:event_logoutpanelMouseExited

    private void contactpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseEntered
       Color clr = new Color(48,0,178);
contactpanel.setBackground(clr);
    }//GEN-LAST:event_contactpanelMouseEntered

    private void contactpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseExited
        Color clr = new Color(51,0,153);
contactpanel.setBackground(clr);
    }//GEN-LAST:event_contactpanelMouseExited

    private void txt_chequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chequenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chequenoActionPerformed

    private void dd_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dd_courseActionPerformed
        txt_coursename.setText(dd_course.getSelectedItem().toString());
    }//GEN-LAST:event_dd_courseActionPerformed

    private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursenameActionPerformed

    private void txt_ddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ddActionPerformed

    private void txt_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptActionPerformed

    private void txt_banknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_banknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_banknameActionPerformed

    private void txt_receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receivedActionPerformed

    private void txt_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_yearActionPerformed

    private void combo_paymentmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentmodeActionPerformed
       if(combo_paymentmode.getSelectedIndex()==0){
           lbl_dd.setVisible(true);
           txt_dd.setVisible(true); 
           lbl_bank.setVisible(true);
           txt_bankname.setVisible(true);
           lbl_cheque.setVisible(false);
           txt_chequeno.setVisible(false);
       }
        if(combo_paymentmode.getSelectedIndex()==1){
           lbl_dd.setVisible(false);
           txt_dd.setVisible(false); 
           lbl_bank.setVisible(true);
           txt_bankname.setVisible(true);
           lbl_cheque.setVisible(true);
           txt_chequeno.setVisible(true);
       }
         if(combo_paymentmode.getSelectedIndex()==2){
           lbl_dd.setVisible(false);
           txt_dd.setVisible(false); 
           lbl_bank.setVisible(false);
           txt_bankname.setVisible(false);
           lbl_cheque.setVisible(false);
           txt_chequeno.setVisible(false);
       }
         if(combo_paymentmode.getSelectedIndex()==3){
           lbl_dd.setVisible(false);
           txt_dd.setVisible(false); 
           lbl_bank.setVisible(true);
           txt_bankname.setVisible(true);
           lbl_cheque.setVisible(false);
           txt_chequeno.setVisible(false);
       }
    }//GEN-LAST:event_combo_paymentmodeActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_totalinwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinwordsActionPerformed

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        Float amnt = Float.parseFloat(txt_amount.getText());
        Float cgst = (float) (amnt * 0.09);
        Float sgst = (float) (amnt * 0.09);
        txt_cgst.setText(cgst.toString());
        
        txt_sgst.setText(sgst.toString());
        float total = amnt+cgst+sgst;
        txt_totalamount.setText(Float.toString(total));
       txt_totalinwords.setText(NumberToWordsConverter.convert((int)total) + " only ");
        
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_totalamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalamountActionPerformed
        
    }//GEN-LAST:event_txt_totalamountActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed

if(validationAddFees()){
    updateData();
     PrintReceipt pr = new PrintReceipt();
        pr.setVisible(true);
}
    }//GEN-LAST:event_btn_printActionPerformed

    private void logoutpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseClicked
SignuUpPage signup = new SignuUpPage();
signup.show();
this.dispose();
    }//GEN-LAST:event_logoutpanelMouseClicked

    private void homelabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel5MouseClicked
      LoginPage lp = new LoginPage();
       lp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_homelabel5MouseClicked

    private void contactpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseClicked
       ContactUs contact = new ContactUs();
       contact.show();
    }//GEN-LAST:event_contactpanelMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked

       
        
    }//GEN-LAST:event_btn_printMouseClicked

    private void homelabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel3MouseClicked
 HomePage hm =new HomePage();
       hm.setVisible(true);
       this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabel3MouseClicked

    private void homelabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel1MouseClicked
        // TODO add your handling code here:
 SearchRecords sr = new SearchRecords();
      sr.setVisible(true);
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabel1MouseClicked

    private void homelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabelMouseClicked
viewAllRecords vi = new  viewAllRecords();
vi.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabelMouseClicked

    private void homelabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel4MouseClicked
 HomePage hm =new HomePage();
       hm.setVisible(true);
       this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabel4MouseClicked

    private void homelabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel2MouseClicked
EditCourse ec = new   EditCourse();
ec.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        UpdateAddFees a = new UpdateAddFees();
        a.displaycashfirst();
        
        java.awt.EventQueue.invokeLater(() -> {
            new UpdateAddFees().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backpanel;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> combo_paymentmode;
    private javax.swing.JPanel contactpanel;
    private javax.swing.JComboBox<String> dd_course;
    private javax.swing.JPanel editcoursepanel;
    private javax.swing.JLabel homelabel;
    private javax.swing.JLabel homelabel1;
    private javax.swing.JLabel homelabel2;
    private javax.swing.JLabel homelabel3;
    private javax.swing.JLabel homelabel4;
    private javax.swing.JLabel homelabel5;
    private javax.swing.JLabel homelabel6;
    private javax.swing.JPanel homepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bank;
    private javax.swing.JLabel lbl_cheque;
    private javax.swing.JLabel lbl_dd;
    private javax.swing.JPanel logoutpanel;
    private javax.swing.JPanel panel_child;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JPanel searchpanel;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_chequeno;
    private javax.swing.JTextField txt_coursename;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JLabel txt_gst;
    private javax.swing.JTextField txt_receipt;
    private javax.swing.JTextField txt_received;
    private javax.swing.JTextArea txt_remarks;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_totalamount;
    private javax.swing.JTextField txt_totalinwords;
    private javax.swing.JTextField txt_year;
    private javax.swing.JTextField txt_year2;
    private javax.swing.JPanel viewrecordpanel;
    // End of variables declaration//GEN-END:variables
}
