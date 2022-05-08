/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication7;

import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author CHIRAG VOHRA
 */
public class SignuUpPage extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public SignuUpPage() {
        initComponents();
    }
    String studentName,rollNumber,contactNumber,fatherName,email,password,confirmPassword;
    Date dateOfBirth;
        int id = 0;
    
            public int getId(){
                ResultSet rs = null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
             String sqlcon = "select max(id) from signup";
                  Statement st = con.createStatement();
                  rs = st.executeQuery(sqlcon);
                  while(rs.next()){
                      
                      id=rs.getInt(1);
                      id++;
                  }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
              return id;
            }
        public boolean validation()
        {
            studentName=txt_StudentName.getText();
            rollNumber = txt_RollNumber.getText();
            dateOfBirth = txt_DateOfBirth.getDate();
            fatherName=txt_FatherName.getText();
            contactNumber=txt_ContactNumber.getText();
            email=txt_Email.getText();
            password=txt_Password.getText();
            confirmPassword=txt_ConfirmPassword.getText();
            if(studentName.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter Student Name");
                return false;
            }
            if(rollNumber.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter Your College Roll Number");
                 return false;
            }
            if(dateOfBirth==null){
                JOptionPane.showMessageDialog(this,"Please Enter Student's Date Of Birth");
                 return false;
            }
            if(fatherName.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter your father's Name");
                 return false;
            }
            if(contactNumber.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter your mobile number");
                 return false;
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter your email address");
                 return false;
            }
            if(password.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter a strong password");
                 return false;
            }
            if(confirmPassword.equals("")){
                JOptionPane.showMessageDialog(this,"Please confirm your password");
                 return false;
            }
               
            return true;
        }
        
         void checkRollNumber(){
             rollNumber = txt_RollNumber.getText();
             if(rollNumber.length()<7 || rollNumber.length()>7){
                 lbl_RollNumber.setText("Roll number Should be 7 digits");
                
             }
             else{
                 lbl_RollNumber.setText("");
             }
        }
         void checkContactNumber(){
    contactNumber=txt_ContactNumber.getText();
    if(contactNumber.length()<10 || contactNumber.length()>10){
                 lbl_ContactNumber.setText("Contact number Should be 10 digits");
             }
    else{
        lbl_ContactNumber.setText("");
    }
        }
         void checkPAssword(){
             password=txt_Password.getText();
             
             if(password.length()<8)
             {
                 lbl_Password.setText("Password should be of 8 Character");
             }
             else{
                 lbl_Password.setText("");
             }
            
         }
         void checkConfirmPAssword(){
              password=txt_Password.getText();
              confirmPassword=txt_ConfirmPassword.getText();
               if(password.equals(confirmPassword)){
                 lbl_ConfirmPassword.setText("");
             }
               else{
                   lbl_ConfirmPassword.setText("It should Be matched");
               }
         }
         
         
        
         
         
       void insertDetails(){
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          String mydateOfBirth =format.format(dateOfBirth );
              try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
             String sqlcon = "insert into signup values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sqlcon);
            stmt.setInt(1, getId());
           stmt.setString(2,studentName );
           stmt.setString(3, rollNumber);
           stmt.setString(4, mydateOfBirth);
            stmt.setString(5, fatherName);
             stmt.setString(6, contactNumber);
             stmt.setString(7, email);
             stmt.setString(8, password);
          int i =  stmt.executeUpdate();
          if(i>0){
              JOptionPane.showMessageDialog(this, "New Student Registered");
          }
          else{
              JOptionPane.showMessageDialog(this, "Failed! Try Again");
          }
        } catch (Exception ex) {
           ex.printStackTrace();
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_RollNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_DateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_FatherName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ContactNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        txt_ConfirmPassword = new javax.swing.JPasswordField();
        btn_SignUp = new javax.swing.JButton();
        btn_Login = new javax.swing.JButton();
        lbl_ContactNumber = new javax.swing.JLabel();
        lbl_Password = new javax.swing.JLabel();
        lbl_RollNumber = new javax.swing.JLabel();
        lbl_ConfirmPassword = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 3));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/full-logo.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 180));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/admin.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STUDENT SIGNUP PAGE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 690, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Name : ");

        txt_StudentName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(0, 0, 204));
        txt_StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Roll Number :");

        txt_RollNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_RollNumber.setForeground(new java.awt.Color(0, 0, 204));
        txt_RollNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RollNumberActionPerformed(evt);
            }
        });
        txt_RollNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_RollNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_RollNumberKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date Of Birth :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact No. :");

        txt_FatherName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_FatherName.setForeground(new java.awt.Color(0, 0, 204));
        txt_FatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FatherNameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Father's Name :");

        txt_ContactNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_ContactNumber.setForeground(new java.awt.Color(0, 0, 204));
        txt_ContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContactNumberActionPerformed(evt);
            }
        });
        txt_ContactNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ContactNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ContactNumberKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail :");

        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Email.setForeground(new java.awt.Color(0, 0, 204));
        txt_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmailActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password : ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Confirm - Password :");

        txt_Password.setForeground(new java.awt.Color(0, 51, 204));
        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyReleased(evt);
            }
        });

        txt_ConfirmPassword.setForeground(new java.awt.Color(0, 51, 204));
        txt_ConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ConfirmPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ConfirmPasswordKeyReleased(evt);
            }
        });

        btn_SignUp.setBackground(new java.awt.Color(0, 102, 102));
        btn_SignUp.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btn_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        btn_SignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/signup.png"))); // NOI18N
        btn_SignUp.setText("Sign-Up");
        btn_SignUp.setBorder(null);
        btn_SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SignUpActionPerformed(evt);
            }
        });

        btn_Login.setBackground(new java.awt.Color(0, 102, 102));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/login.png"))); // NOI18N
        btn_Login.setText("Login");
        btn_Login.setBorder(null);
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        lbl_ContactNumber.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        lbl_ContactNumber.setForeground(new java.awt.Color(255, 0, 102));

        lbl_Password.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        lbl_Password.setForeground(new java.awt.Color(255, 0, 102));

        lbl_RollNumber.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        lbl_RollNumber.setForeground(new java.awt.Color(255, 0, 102));

        lbl_ConfirmPassword.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        lbl_ConfirmPassword.setForeground(new java.awt.Color(255, 0, 102));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Created By Chirag Vohra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11)
                            .addGap(7, 7, 7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btn_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_StudentName)
                            .addComponent(txt_RollNumber)
                            .addComponent(txt_DateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(txt_FatherName)
                            .addComponent(txt_ContactNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Email)
                            .addComponent(txt_Password)
                            .addComponent(txt_ConfirmPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_RollNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_Password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_ContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_RollNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_RollNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_FatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_ContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 690, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentNameActionPerformed

    private void txt_RollNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RollNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RollNumberActionPerformed

    private void txt_FatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FatherNameActionPerformed

    private void txt_ContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNumberActionPerformed

    private void txt_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmailActionPerformed

    private void btn_SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SignUpActionPerformed
        
        if(validation())
    {
    insertDetails();}// TODO add your handling code here:
    }//GEN-LAST:event_btn_SignUpActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
       LoginPage loginpage = new LoginPage();
       loginpage.show();
       this.dispose();
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void txt_RollNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RollNumberKeyPressed
checkRollNumber();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RollNumberKeyPressed

    private void txt_RollNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RollNumberKeyReleased
checkRollNumber();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RollNumberKeyReleased

    private void txt_ContactNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactNumberKeyPressed
checkContactNumber();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNumberKeyPressed

    private void txt_ContactNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactNumberKeyReleased
checkContactNumber();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNumberKeyReleased

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
checkPAssword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void txt_PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyReleased
checkPAssword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordKeyReleased

    private void txt_ConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConfirmPasswordKeyPressed
checkConfirmPAssword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ConfirmPasswordKeyPressed

    private void txt_ConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConfirmPasswordKeyReleased
checkConfirmPAssword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ConfirmPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(SignuUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignuUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignuUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignuUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignuUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_SignUp;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel lbl_ConfirmPassword;
    private javax.swing.JLabel lbl_ContactNumber;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_RollNumber;
    private javax.swing.JPasswordField txt_ConfirmPassword;
    private javax.swing.JTextField txt_ContactNumber;
    private com.toedter.calendar.JDateChooser txt_DateOfBirth;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_FatherName;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_RollNumber;
    private javax.swing.JTextField txt_StudentName;
    // End of variables declaration//GEN-END:variables
}
