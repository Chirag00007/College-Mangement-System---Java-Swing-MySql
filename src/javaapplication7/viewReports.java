/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication7;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author CHIRAG VOHRA
 */
public class viewReports extends javax.swing.JFrame {

    /**
     * Creates new form viewReports
     */
    public viewReports() {
        initComponents();
        fillComboBox();
        
    }
    public void exportToExcel(){
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet();
         model = (DefaultTableModel)jTable1.getModel();
        TreeMap<String,Object[]> map =new TreeMap<>();
        map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)} );
//   
for(int i = 1; i <model.getRowCount();i++)
{
    map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3),model.getValueAt(i, 4),model.getValueAt(i, 5)});
}

 for(Map.Entry<String,Object[]> entry: map.entrySet()){
        String key = entry.getKey();
        Object[] value = entry.getValue();
        System.out.println(Arrays.toString(value));
    }
 
    Set<String> id = map.keySet();
    XSSFRow fRow;
     int  rowId = 0;
     for(String key : id){
         fRow =ws.createRow(rowId);
         rowId++;
         Object[] value = map.get(key);
         int cellId=0;
         for(Object object : value){
             XSSFCell cell = fRow.createCell(cellId++);
             cell.setCellValue(object.toString());
         }
     }
     try(FileOutputStream fos=new FileOutputStream(new File(txt_path.getText()))){
     //FileOutputStream fos=new FileOutputStream(new File(txt_path.getText()));
     wb.write(fos);
    // fos.close();
    JOptionPane.showMessageDialog(this,"File Exporedted Successfully");
     }
     catch(Exception e){
         
     }
    }
    public final void fillComboBox(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            PreparedStatement pst = con.prepareStatement("select coursename from coursedb");
          ResultSet rs =  pst.executeQuery();
          while(rs.next()){
              combo_course.addItem(rs.getString("coursename"));
          }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
     public void clearData(){
            model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(1);
    }
     DefaultTableModel model;
    public void setRecordstoTable(){
        String cname1=combo_course.getSelectedItem().toString();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = dateformat.format(date_from.getDate());
        String toDate = dateformat.format(date_to.getDate());
        Float totalAmount = 0.0f;
            try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_mange_sys","root","Chirag@123");
            PreparedStatement pst = con.prepareStatement("select * from feess where dateoffees between ? and ? and coursenaam = ?");
           pst.setString(1, fromDate);
           pst.setString(2, toDate);
           pst.setString(3, cname1);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String receiptNo = rs.getString("receiptno");
               
                String rollNo=rs.getString("rolllnoo");
                String studentName = rs.getString("studentnaam");
                String courseName =rs.getString("coursenaam");
                float amount = rs.getFloat("totalMoney");
                totalAmount = totalAmount+amount;
                String remark = rs.getString("remarkss");
                Object[] obj = {receiptNo,rollNo,studentName,courseName,amount,remark};
               model = (DefaultTableModel)jTable1.getModel();
               model.addRow(obj);
            }
            lbl_amount.setText(totalAmount.toString());
            lbl_course1.setText(cname1);
            lbl_amountinwords.setText(NumberToWordsConverter.convert(totalAmount.intValue()));
            
            }catch(Exception e){
                e.printStackTrace();
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

        panelsidebar = new javax.swing.JPanel();
        viewrecordpanel = new javax.swing.JPanel();
        homelabel = new javax.swing.JLabel();
        searchpanel = new javax.swing.JPanel();
        homelabel7 = new javax.swing.JLabel();
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
        homelabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        combo_course = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date_to = new com.toedter.calendar.JDateChooser();
        date_from = new com.toedter.calendar.JDateChooser();
        btn_export = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        txt_path = new javax.swing.JTextField();
        btn_print1 = new javax.swing.JButton();
        btn_browse1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_amountinwords = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_course1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        panelsidebar.add(viewrecordpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 330, 70));

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

        homelabel7.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        homelabel7.setForeground(new java.awt.Color(255, 255, 255));
        homelabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/search2.png"))); // NOI18N
        homelabel7.setText("Search Record");
        homelabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel7MouseClicked(evt);
            }
        });
        searchpanel.add(homelabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        panelsidebar.add(searchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 330, 70));

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
        homelabel2.setText(" Courses");
        homelabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homelabel2MouseClicked(evt);
            }
        });
        editcoursepanel.add(homelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, 60));

        panelsidebar.add(editcoursepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 330, 70));

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
        homepanel.add(homelabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 50));

        panelsidebar.add(homepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 330, 70));

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

        panelsidebar.add(backpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 330, 70));

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

        panelsidebar.add(logoutpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 330, 70));

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

        panelsidebar.add(contactpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 330, 70));

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 153));
        jLabel16.setText("Remarks : ");
        panelsidebar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, -1, 40));

        homelabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        homelabel1.setForeground(new java.awt.Color(255, 102, 0));
        homelabel1.setText("Financial Reports");
        panelsidebar.add(homelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 330, 90));
        panelsidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 380, 10));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 1040));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/images/full-logo.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(869, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 1450, 180));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo_course.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        jPanel2.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel3.setText("To Date : ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel5.setText("From Date : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 40));
        jPanel2.add(date_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 140, 30));
        jPanel2.add(date_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 30));

        btn_export.setBackground(new java.awt.Color(51, 0, 153));
        btn_export.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn_export.setForeground(new java.awt.Color(255, 255, 255));
        btn_export.setText("Export in Excel");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });
        jPanel2.add(btn_export, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, 40));

        btn_submit.setBackground(new java.awt.Color(51, 0, 153));
        btn_submit.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 40));

        txt_path.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jPanel2.add(txt_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 320, 40));

        btn_print1.setBackground(new java.awt.Color(51, 0, 153));
        btn_print1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn_print1.setForeground(new java.awt.Color(255, 255, 255));
        btn_print1.setText("Print");
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, 40));

        btn_browse1.setBackground(new java.awt.Color(51, 0, 153));
        btn_browse1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn_browse1.setForeground(new java.awt.Color(255, 255, 255));
        btn_browse1.setText("Browse");
        btn_browse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_browse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No.", "Roll Number", "Student Name", "Course ", "Amount", "Remarks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 880, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel4.setText("In Words :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, 40));

        lbl_amountinwords.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        lbl_amountinwords.setForeground(new java.awt.Color(255, 0, 51));
        jPanel3.add(lbl_amountinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 350, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel8.setText("Select Course :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        lbl_course1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        lbl_course1.setForeground(new java.awt.Color(255, 0, 51));
        jPanel3.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 320, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel9.setText("Total Amount :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 40));

        lbl_amount.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        lbl_amount.setForeground(new java.awt.Color(255, 0, 51));
        jPanel3.add(lbl_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 320, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 520, 160));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel6.setText("Select Course :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Select Date:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 1450, 810));

        setSize(new java.awt.Dimension(1886, 1007));
        setLocationRelativeTo(null);
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

    private void homelabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel5MouseClicked
        LoginPage lp = new LoginPage();
       lp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_homelabel5MouseClicked

    private void logoutpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseClicked
        SignuUpPage signup = new SignuUpPage();
        signup.show();
        this.dispose();
    }//GEN-LAST:event_logoutpanelMouseClicked

    private void logoutpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseEntered
        Color clr = new Color(48,0,178);
        logoutpanel.setBackground(clr);
    }//GEN-LAST:event_logoutpanelMouseEntered

    private void logoutpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutpanelMouseExited
        Color clr = new Color(51,0,153);
        logoutpanel.setBackground(clr);
    }//GEN-LAST:event_logoutpanelMouseExited

    private void contactpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseClicked
        ContactUs contact = new ContactUs();
        contact.show();
    }//GEN-LAST:event_contactpanelMouseClicked

    private void contactpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseEntered
        Color clr = new Color(48,0,178);
        contactpanel.setBackground(clr);
    }//GEN-LAST:event_contactpanelMouseEntered

    private void contactpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseExited
        Color clr = new Color(51,0,153);
        contactpanel.setBackground(clr);
    }//GEN-LAST:event_contactpanelMouseExited

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
exportToExcel();        
    }//GEN-LAST:event_btn_exportActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        clearData();
        setRecordstoTable();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed
        SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom=  Date_Format.format(date_from.getDate());
      String dateto=  Date_Format.format(date_to.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 
    }//GEN-LAST:event_btn_print1ActionPerformed

    private void btn_browse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse1ActionPerformed
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.showOpenDialog(this);
       SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
       String date = dateFormat.format(new Date());
       try{
           File f =fileChooser.getSelectedFile();
           String path = f.getAbsolutePath();
           path = path+" "+date+""+".xlsx";
           txt_path.setText(path);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_btn_browse1ActionPerformed

    private void homelabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel3MouseClicked
       HomePage hm =new HomePage();
       hm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_homelabel3MouseClicked

    private void homelabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homelabel7MouseClicked
 SearchRecords sr = new SearchRecords();
      sr.setVisible(true);
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_homelabel7MouseClicked

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
            java.util.logging.Logger.getLogger(viewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backpanel;
    private javax.swing.JButton btn_browse1;
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_print1;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JPanel contactpanel;
    private com.toedter.calendar.JDateChooser date_from;
    private com.toedter.calendar.JDateChooser date_to;
    private javax.swing.JPanel editcoursepanel;
    private javax.swing.JLabel homelabel;
    private javax.swing.JLabel homelabel1;
    private javax.swing.JLabel homelabel2;
    private javax.swing.JLabel homelabel3;
    private javax.swing.JLabel homelabel4;
    private javax.swing.JLabel homelabel5;
    private javax.swing.JLabel homelabel6;
    private javax.swing.JLabel homelabel7;
    private javax.swing.JPanel homepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_amountinwords;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JPanel logoutpanel;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel searchpanel;
    private javax.swing.JTextField txt_path;
    private javax.swing.JPanel viewrecordpanel;
    // End of variables declaration//GEN-END:variables
}
