/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hp
 */
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import dao.ConnectionProvider;
import java.sql.*;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.Calendar;
import dao.PharmacyUtils;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import java.io.FileOutputStream;


public class SellMedicine extends javax.swing.JFrame {
    public String numberPattern="^[0-9]*$";
    private int finalTotalPrice=0;
    private String billId="";
    private String username="";

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }
     public SellMedicine(String tempUsername) {
        initComponents();
        username=tempUsername;
        setLocationRelativeTo(null);
        
    }
    private void medicineName(String nameOrUniqueId){
        DefaultTableModel model=(DefaultTableModel) medicinesTable.getModel();
        model.setRowCount(0);
        try{
             Connection con=ConnectionProvider.getCon();  
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select *from medicine where name like'"+nameOrUniqueId+"%' or uniqueId like '"+nameOrUniqueId+"%'");
          while(rs.next()){
              model.addRow(new Object[]{rs.getString("uniqueId")+"-"+rs.getString("name")});
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void clearMedicineFields(){
        txtUniqueId.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPricePerunit.setText("");
        txtNoOfUnits.setText("");
        txtTotalPrice.setText("");
        
        
        
    }
    public String getUniqueId(String prefix){
        return prefix+System.nanoTime();
        
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
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerunit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoOfUnits = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 255));
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 6, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 6, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 850, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 88, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 104, 194, -1));

        medicinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicines"
            }
        ));
        medicinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicinesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicinesTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 138, 241, 251));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medicine ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 88, -1, -1));

        txtUniqueId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 110, 191, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 167, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 195, 245, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 251, -1, -1));

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 285, 245, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price Per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 88, -1, -1));

        txtPricePerunit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPricePerunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 116, 163, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No.of Units");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 167, -1, -1));

        txtNoOfUnits.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNoOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfUnitsKeyReleased(evt);
            }
        });
        getContentPane().add(txtNoOfUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 195, 195, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 251, -1, -1));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 294, 190, -1));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Price Per Unit", "No.of Units", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 428, 543, 207));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 359, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 204));
        jLabel9.setText("RS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 687, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(102, 255, 204));
        lblFinalTotalPrice.setText("00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 687, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        jButton3.setText("Purchase and Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 695, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adminDashboardBackground.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1510, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        medicineName("");
        txtUniqueId.setEditable(false);
        txtName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPricePerunit.setEditable(false);
        txtTotalPrice.setEditable(false);
        
        
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String search=txtSearch.getText();
        medicineName(search);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void medicinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicinesTableMouseClicked
        // TODO add your handling code here:
        int index=medicinesTable.getSelectedRow();
        TableModel model=medicinesTable.getModel();
        String nameOrUniqueId=model.getValueAt(index,0).toString();
        String uniqueId[]=nameOrUniqueId.split("-",0);
        try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select *from medicine where uniqueId ="+uniqueId[0]+"");
          while(rs.next()){
               txtUniqueId.setText(uniqueId[0]);
        txtName.setText(rs.getString("name"));
        txtCompanyName.setText(rs.getString("companyName"));
        txtPricePerunit.setText(rs.getString("price"));
        txtNoOfUnits.setText("");
        txtTotalPrice.setText("");
          }

    }//GEN-LAST:event_medicinesTableMouseClicked
     catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    private void txtNoOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfUnitsKeyReleased
        // TODO add your handling code here:
        String noOfUnits=txtNoOfUnits.getText();
        if(!noOfUnits.equals("")){
            String price=txtPricePerunit.getText();
            if(!noOfUnits.matches(numberPattern)){
                JOptionPane.showMessageDialog(null,"number of units field is invalid" );
            }
            int totalPrice=Integer.parseInt(noOfUnits)+Integer.parseInt(price);
            txtTotalPrice.setText(String.valueOf(totalPrice));
            
        }
        else{
            txtTotalPrice.setText("");
        }
    }//GEN-LAST:event_txtNoOfUnitsKeyReleased

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String noOfUnits=txtNoOfUnits.getText();
        String uniqueId=txtUniqueId.getText();
        if(!noOfUnits.equals("")&& !uniqueId.equals("")){
            String name=txtName.getText();
           String companyName=txtCompanyName.getText();
           String pricePerUnit=txtPricePerunit.getText();
           String totalPrice=txtTotalPrice.getText();
           int checkStock=0;
           int checkMedicineALreadyExistInCart=0;
           try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select *from medicine where uniqueId ="+uniqueId+"");
                while(rs.next()){
                    if(rs.getInt("quantity")>=Integer.parseInt(noOfUnits)){
                       checkStock=1;
                       
                    }else{
                        JOptionPane.showMessageDialog(null,"medicine is out of stock.only "+rs.getInt("quantity")+"Left");
                    }
                }
                
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
           }
           if(checkStock==1){
              DefaultTableModel dtm=(DefaultTableModel) cartTable.getModel();
              if(cartTable.getRowCount()!=0){
                 for(int i=0;i<cartTable.getRowCount();i++){
                     if(Integer.parseInt(dtm.getValueAt(i, 0).toString())==Integer.parseInt(uniqueId)){
                         checkMedicineALreadyExistInCart=1;
                         JOptionPane.showMessageDialog(null,"medicine already exists in the cart");
                     }
                 } 
              }
              if(checkMedicineALreadyExistInCart==0){
                dtm.addRow(new Object[]{uniqueId,name,companyName,pricePerUnit,noOfUnits,totalPrice}); 
                finalTotalPrice=finalTotalPrice+Integer.parseInt(totalPrice);
                lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                JOptionPane.showMessageDialog(null,"added succesfully");
                
              }
              clearMedicineFields();
           }
        }else{
            JOptionPane.showMessageDialog(null,"no of units and medicine ID fields are required");
        }
        
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        // TODO add your handling code here:
        int index=cartTable.getSelectedRow();
        int a=JOptionPane.showConfirmDialog(null,"do you want to remove this medicine","Select ",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model=cartTable.getModel();
            String total=model.getValueAt(index,5).toString();
            finalTotalPrice=finalTotalPrice-Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel)cartTable.getModel()).removeRow(index);
            
        }
        
    }//GEN-LAST:event_cartTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(finalTotalPrice!=0){
            billId=getUniqueId("Bill-");
            DefaultTableModel dtm=(DefaultTableModel) cartTable.getModel();
            if(cartTable.getRowCount()!=0){
                for(int i=0;i<cartTable.getRowCount();i++){
                    try{
                        Connection con=ConnectionProvider.getCon();
                        Statement st=con.createStatement();
                        st.executeUpdate("update medicine set quantity=quantity-"+Integer.parseInt(dtm.getValueAt(i, 4).toString()) +" where uniqueId="+Integer.parseInt(dtm.getValueAt(i,0).toString()));
                        
                        
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
                
            }
            try{
               SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy");
               Calendar cal=Calendar.getInstance();
               Connection con=ConnectionProvider.getCon();
               PreparedStatement ps=con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy) values(?,?,?,?)");
               ps.setString(1,billId);
                    ps.setString(2,myFormat.format(cal.getTime()));
                    ps.setInt(3,finalTotalPrice);
                    ps.setString(4,username);
                    ps.executeUpdate();
               
               
               
               
            }
            catch(Exception e){
                 JOptionPane.showMessageDialog(null,e);
            }
            //create bill
            com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
            try{
                PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath+""+billId+".pdf"));
                doc.open();
                Paragraph pharmacyName=new Paragraph("                                Pharmacy Mangement System\n");
                doc.add(pharmacyName);
                Paragraph starLine=new Paragraph("*****************************************************************");
                doc.add(starLine);
                Paragraph details= new Paragraph("\tBill ID: "+billId+"\nDate:"+ new Date()+"\nTotal Paid:"+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tbl=new PdfPTable(6);
                tbl.addCell("Medicine ID");
                 tbl.addCell("Name");
                  tbl.addCell("Company Nam");
                   tbl.addCell("Price Per Unit");
                    tbl.addCell("No .Of Units");
                     tbl.addCell("Sub Total Price");
                for(int i=0;i<cartTable.getRowCount();i++){
                    String a=cartTable.getValueAt(i,0).toString();
                    String b=cartTable.getValueAt(i,1).toString();
                    String c=cartTable.getValueAt(i,2).toString();
                    String d=cartTable.getValueAt(i,3).toString();
                    String e=cartTable.getValueAt(i,4).toString();
                    String f=cartTable.getValueAt(i,5).toString();
                    tbl.addCell(a);
                    tbl.addCell(b);
                    tbl.addCell(c);
                    tbl.addCell(d);
                    tbl.addCell(e);
                    tbl.addCell(f);
                    
                }
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg=new Paragraph ("Thank you ,please visit again");
                doc.add(thanksMsg);
                OpenPdf.openById(String.valueOf(billId));
                
                     
                
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
            
        

        doc.close();
        setVisible(false);
        new SellMedicine(username).setVisible(true);
        
        
        
        
   
    }//GEN-LAST:event_jButton3ActionPerformed
        else{
            JOptionPane.showMessageDialog(null,"Please add some medicine to cart");
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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicinesTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoOfUnits;
    private javax.swing.JTextField txtPricePerunit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;
    // End of variables declaration//GEN-END:variables
}
