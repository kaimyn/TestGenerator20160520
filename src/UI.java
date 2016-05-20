/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.table.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.filechooser.*;
import java.io.File;
import javax.swing.JTable;
/**
 *
 * @author kinining
 */
public class UI extends javax.swing.JFrame {

    private static XMLData xml;
    private static ArrayList<TestID> lastDeleted = new ArrayList<TestID>();
    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        testTable.getModel().addTableModelListener(new TableModelListener() {

        public void tableChanged(TableModelEvent e) {
            if(e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                String data = (String)testTable.getValueAt(row, col);
                //System.out.println(data);
                updateXMLData(data, row, col);
                //System.out.println("just changed data: " + BatchGenerator_0516.xml.getTests().get(0).getTestID());
            }
            }
        });
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
        dateField = new javax.swing.JTextField();
        pathField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        functionField = new javax.swing.JTextField();
        targetField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        p1Field = new javax.swing.JTextField();
        p2Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        templateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        p3Field = new javax.swing.JTextField();
        p4Field = new javax.swing.JTextField();
        t1Field = new javax.swing.JTextField();
        t2Field = new javax.swing.JTextField();
        t3Field = new javax.swing.JTextField();
        t4Field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        savetoXML = new javax.swing.JButton();
        undoSave = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton();
        xmlPath = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addTestButton = new javax.swing.JButton();
        undoDeleteButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bash Generator");
        setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setText("Date");

        jLabel2.setText("Path");

        dateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFieldFocusLost(evt);
            }
        });
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        pathField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pathFieldFocusLost(evt);
            }
        });
        pathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathFieldActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Create New Test"));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel1.setSize(new java.awt.Dimension(400, 100));

        jLabel5.setText("Function");

        jLabel6.setText("Point");

        functionField.setText("Function");
        functionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionFieldActionPerformed(evt);
            }
        });

        targetField.setText("Target");

        jLabel7.setText("TIME");

        p2Field.setPreferredSize(new java.awt.Dimension(50, 26));

        jLabel4.setText("Template");

        jLabel3.setText("TestID");

        idField.setText("4 digital");
        idField.setToolTipText("");
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        t2Field.setPreferredSize(new java.awt.Dimension(50, 26));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(templateField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(functionField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(targetField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(templateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(functionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(p1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Template", "TestID", "Function", "Target", "P1", "P2", "P3", "P4", "T1", "T2", "T3", "T4"
            }
        ));
        jScrollPane1.setViewportView(testTable);

        savetoXML.setText("Save to XML");
        savetoXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetoXMLActionPerformed(evt);
            }
        });

        undoSave.setText("Undo Save");
        undoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoSaveActionPerformed(evt);
            }
        });

        reloadButton.setText("Reload");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        xmlPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlPathActionPerformed(evt);
            }
        });

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete Test");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addTestButton.setText("Add Test");
        addTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTestButtonActionPerformed(evt);
            }
        });

        undoDeleteButton.setText("Undo Delete");
        undoDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoDeleteButtonActionPerformed(evt);
            }
        });

        generateButton.setText("Generate Bash");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reloadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xmlPath, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(browseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(savetoXML)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(undoSave)
                                .addGap(18, 18, 18)
                                .addComponent(generateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addTestButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(undoDeleteButton)))
                        .addGap(0, 305, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloadButton)
                    .addComponent(xmlPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTestButton)
                    .addComponent(deleteButton)
                    .addComponent(undoDeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undoSave)
                    .addComponent(savetoXML)
                    .addComponent(generateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Create New Test");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void functionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_functionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_functionFieldActionPerformed

    private void savetoXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetoXMLActionPerformed
        saveXMLtoFile();
    }//GEN-LAST:event_savetoXMLActionPerformed

    private void undoSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoSaveActionPerformed
        xml = FileIO.readXML(backup);
        addXML(xml);
        FileIO.xmlWrite(xml, xmlPath.getText());
    }//GEN-LAST:event_undoSaveActionPerformed

    private void xmlPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xmlPathActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Test Config File", "xml");
        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        int returnval = fc.showOpenDialog(testTable); 
        
        if(returnval == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            xml = FileIO.readXML(file);
            this.addXML(xml);
            xmlPath.setText(file.getPath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        xml = FileIO.readXML(xmlPath.getText());
        this.addXML(xml);
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        xml.setDate(dateField.getText());
    }//GEN-LAST:event_dateFieldActionPerformed

    private void pathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathFieldActionPerformed
        xml.setPath(pathField.getText());
    }//GEN-LAST:event_pathFieldActionPerformed

    private void addTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTestButtonActionPerformed
        if(!idField.getText().isEmpty() && !templateField.getText().isEmpty()) {
            String [] p = {p1Field.getText(), p2Field.getText(), p3Field.getText(), p4Field.getText()};
            String [] t = {t1Field.getText(), t2Field.getText(), t3Field.getText(), t4Field.getText()};
            TestID newTest = new TestID(idField.getText(), templateField.getText(), functionField.getText(), targetField.getText(), p, t);
            xml.addTest(newTest);
            addXML(xml);
        }
    }//GEN-LAST:event_addTestButtonActionPerformed

    private void dateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusLost
        if(xml!=null) xml.setDate(dateField.getText());
    }//GEN-LAST:event_dateFieldFocusLost

    private void pathFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pathFieldFocusLost
        if(xml!=null) xml.setPath(pathField.getText());
    }//GEN-LAST:event_pathFieldFocusLost

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = testTable.getSelectedRow();
        if(row != -1) {
            lastDeleted.add(xml.removeTest(row));
            addXML(xml);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void undoDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoDeleteButtonActionPerformed
        if(!lastDeleted.isEmpty()) {
            xml.addTest(lastDeleted.get(lastDeleted.size()-1));
            addXML(xml);
            lastDeleted.remove(lastDeleted.size()-1);
        }
    }//GEN-LAST:event_undoDeleteButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        if(xml!= null) FileIO.genBash(xml);
    }//GEN-LAST:event_generateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    public void addXML(XMLData xml) {
        
        DefaultTableModel model = (DefaultTableModel)testTable.getModel();
        ArrayList<TestID> tests = xml.getTests();
        int rCount = model.getRowCount();
        
        pathField.setText(xml.getPath());
        dateField.setText(xml.getDate());
        TestID test;
        for(int i = 0; i<tests.size(); i++) {
            if(i+1>rCount) model.addRow((Object[])null);
            test = tests.get(i);
            model.setValueAt(test.getTemplate(), i, 0);
            model.setValueAt(test.getTestID(), i, 1);
            model.setValueAt(test.getFunction(), i, 2);
            model.setValueAt(test.getTarget(), i, 3);
            model.setValueAt(test.getPoint(0), i, 4);
            model.setValueAt(test.getPoint(1), i, 5);
            model.setValueAt(test.getPoint(2), i, 6);
            model.setValueAt(test.getPoint(3), i, 7);
            model.setValueAt(test.getTime(0), i, 8);
            model.setValueAt(test.getTime(1), i, 9);
            model.setValueAt(test.getTime(2), i, 10);
            model.setValueAt(test.getTime(3), i, 11);
        }
        for(int i = tests.size(); i<rCount; i++) {
            model.removeRow(i);
        }
        resizeColumnWidth(testTable);
    }
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    public static void updateXMLData(String data, int row, int col) {
        //xml.updateTest(data, row, col);
        
        System.out.println("changign data");
        ArrayList<TestID> tests = xml.getTests();
        TestID item = tests.get(row);
        switch(col) {
                case 0:
                    item.setTemplate(data);
                    tests.set(row, item);
                    break;
                case 1:
                    item.setTestID(data);
                    tests.set(row, item);
                    xml.setTests(tests);
                    System.out.println("raw data: " + data);
                    System.out.println("change testid");
                    System.out.println("just changed data: " + xml.getTests().get(0).getTestID());
                    break;
                case 2:
                    item.setFunction(data);
                    tests.set(row, item);
                    break;
                case 3:
                    item.setTarget(data);
                    tests.set(row, item);
                    break;
                case 4:
                    item.setPoint(0, data);
                    tests.set(row, item);
                    break;
                case 5:
                    item.setPoint(1, data);
                    tests.set(row, item);
                    break;
                case 6:
                    item.setPoint(2, data);
                    tests.set(row, item);
                    break;
                case 7:
                    item.setPoint(3, data);
                    tests.set(row, item);
                    break;
                case 8:
                    item.setTime(0, data);
                    tests.set(row, item);
                    break;
                case 9:
                    item.setTime(1, data);
                    tests.set(row, item);
                    break;
                case 10:
                    item.setTime(2, data);
                    tests.set(row, item);
                    break;
                case 11:
                    item.setTime(3, data);
                    tests.set(row, item);
                    break;
        }
        xml.setTests(tests);
        System.out.println("just changed data: " + xml.getTests().get(0).getTestID());
    }
    
    private static String backup = "TestConfigBackup.xml";
    public static void saveXMLtoFile() {
        System.out.println("changed data: " + xml.getTests().get(0).getTestID());
        FileIO.xmlWrite(xml, backup);
        System.out.println("saved data");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTestButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField functionField;
    private javax.swing.JButton generateButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField p1Field;
    private javax.swing.JTextField p2Field;
    private javax.swing.JTextField p3Field;
    private javax.swing.JTextField p4Field;
    private javax.swing.JTextField pathField;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton savetoXML;
    private javax.swing.JTextField t1Field;
    private javax.swing.JTextField t2Field;
    private javax.swing.JTextField t3Field;
    private javax.swing.JTextField t4Field;
    private javax.swing.JTextField targetField;
    private javax.swing.JTextField templateField;
    private javax.swing.JTable testTable;
    private javax.swing.JButton undoDeleteButton;
    private javax.swing.JButton undoSave;
    private javax.swing.JTextField xmlPath;
    // End of variables declaration//GEN-END:variables
}
