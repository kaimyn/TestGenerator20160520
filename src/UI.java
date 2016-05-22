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
import javax.swing.AbstractCellEditor;
import javax.swing.JScrollPane;
import java.awt.event.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author kinining
 */
public class UI extends javax.swing.JFrame {

    private boolean DEBUG = false;
    private boolean ALLOW_COLUMN_SELECTION = false;
    private boolean ALLOW_ROW_SELECTION = true;
    private static boolean ACTION_TABLE_RELOAD = false;
    private static MyMouseMotionListener mListener;
    private static ArrayList<JTable> actionTables;
    private static XMLData xml;
    private static ArrayList<TestID> lastDeleted = new ArrayList<TestID>();
    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        actionTables = new ArrayList<JTable>();

        testTable.getModel().addTableModelListener(new TableModelListener() {

        public void tableChanged(TableModelEvent e) {
            if(e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                //System.out.println(data);
                String data = null;
                System.out.println("testTable changed");
                if(col!=4) data = (String)testTable.getValueAt(row, col);
                else if(actionTable.getModel().getRowCount() >= 0) {
                    System.out.println("update action table");
                    int arow = actionTables.get(row).getSelectedRow();
                    int acol = actionTables.get(row).getSelectedColumn();
                    if(arow != -1) {
                    String adata = (String)actionTables.get(row).getValueAt(arow, acol);
                    actionTable.setValueAt(adata, arow, acol);
                    }
                }
                updateXMLData(data, row, col);
            }
            }
        });
        
        actionTable.getModel().addTableModelListener(new TableModelListener() {

        public void tableChanged(TableModelEvent e) {
            if(e.getType() == TableModelEvent.UPDATE && ACTION_TABLE_RELOAD == false) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                //System.out.println(data);
                String data = (String)actionTable.getValueAt(row, col);
                actionTables.get(testTable.getSelectedRow()).setValueAt(data, row, col);
                updateXMLData("unused", testTable.getSelectedRow(), 4);
            }
            }
        });
        
        testTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (ALLOW_ROW_SELECTION) { // true by default
            ListSelectionModel rowSM = testTable.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;
 
                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row " + selectedRow
                                           + " is now selected.");
                        ACTION_TABLE_RELOAD = true;
                        updateActionTable(selectedRow);
                        ACTION_TABLE_RELOAD = false;
                    }
                }
            });
        } else {
            testTable.setRowSelectionAllowed(false);
        }
 
        if (ALLOW_COLUMN_SELECTION) { // false by default
            if (ALLOW_ROW_SELECTION) {
                //We allow both row and column selection, which
                //implies that we *really* want to allow individual
                //cell selection.
                testTable.setCellSelectionEnabled(true);
            }
            testTable.setColumnSelectionAllowed(true);
            ListSelectionModel colSM =
                testTable.getColumnModel().getSelectionModel();
            colSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;
 
                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No columns are selected.");
                    } else {
                        int selectedCol = lsm.getMinSelectionIndex();
                        System.out.println("Column " + selectedCol
                                           + " is now selected.");
                    }
                }
            });
        }
        
        testTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mListener = new MyMouseMotionListener();
        //testTable.addMouseMotionListener(mListener);
        // Enable the ability to select a single cell 
        testTable.setColumnSelectionAllowed(true); 
        testTable.setRowSelectionAllowed(true); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        pathField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        functionField = new javax.swing.JTextField();
        targetField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        templateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
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
        addActionButton = new javax.swing.JButton();
        delActionButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        actionTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

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

        functionField.setText("Function");
        functionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionFieldActionPerformed(evt);
            }
        });

        targetField.setText("Target");

        jLabel4.setText("Template");

        jLabel3.setText("TestID");

        idField.setText("4 digital");
        idField.setToolTipText("");
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(templateField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(functionField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(targetField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Template", "TestID", "Function", "Target", "Action List"
            }
        ));
        jScrollPane1.setViewportView(testTable);
        if (testTable.getColumnModel().getColumnCount() > 0) {
            testTable.getColumnModel().getColumn(3).setCellRenderer(null);
        }

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

        addActionButton.setText("Add Action");
        addActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionButtonActionPerformed(evt);
            }
        });

        delActionButton.setText("Delete Action");
        delActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionButtonActionPerformed(evt);
            }
        });

        actionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Action", "Data"
            }
        ));
        jScrollPane3.setViewportView(actionTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(undoDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(generateButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addTestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(undoDeleteButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(addActionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delActionButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undoSave)
                    .addComponent(savetoXML)
                    .addComponent(generateButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

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
        testTable.clearSelection();
        actionTable.clearSelection();
        for(int i=0; i<actionTables.size(); i++) {
            actionTables.get(i).clearSelection();
        }
        ((DefaultTableModel)actionTable.getModel()).setRowCount(0);
        
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
            TestID newTest = new TestID(idField.getText(), templateField.getText(), functionField.getText(), targetField.getText(), new ArrayList<Action>());
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

    private void addActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionButtonActionPerformed
        int row = testTable.getSelectedRow();
        ArrayList<TestID> tests = xml.getTests();
        tests.get(row).getActions().add(new Action("new", "data"));
        xml.setTests(tests);
        addXML(xml);
    }//GEN-LAST:event_addActionButtonActionPerformed

    private void delActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionButtonActionPerformed
        int row = actionTable.getSelectedRow();
        if(row != -1) {
            xml.removeAction(testTable.getSelectedRow(), row);
            addXML(xml);
        }
    }//GEN-LAST:event_delActionButtonActionPerformed

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
        ACTION_TABLE_RELOAD = true;
        DefaultTableModel model = (DefaultTableModel)testTable.getModel();
        ArrayList<TestID> tests = xml.getTests();
        //actionTables.clear();
        ArrayList<Action> actions;
        
        pathField.setText(xml.getPath());
        dateField.setText(xml.getDate());
        TestID test;
        TableColumn tc = testTable.getColumnModel().getColumn(4);
        
        //testTable.changeSelection(testTable.getSelectedRow(), 0, false, false);
        updateActionTable(testTable.getSelectedRow());
        
        model.setRowCount(tests.size());
        for(int i = 0; i<tests.size(); i++) {
            actions = tests.get(i).getActions();
            test = tests.get(i);
            model.setValueAt(test.getTemplate(), i, 0);
            model.setValueAt(test.getTestID(), i, 1);
            model.setValueAt(test.getFunction(), i, 2);
            model.setValueAt(test.getTarget(), i, 3);
            
            if(i>=actionTables.size()) {
            actionTables.add(i, new javax.swing.JTable());
            actionTables.get(i).setModel( new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Action", "Data"
                }
            ));
            
            actionTables.get(i).getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.UPDATE && !ACTION_TABLE_RELOAD && testTable.getSelectedRow() != -1) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    //System.out.println(data);
                    String data = (String)actionTables.get(testTable.getSelectedRow()).getValueAt(row, col);
                    ACTION_TABLE_RELOAD=true;
                    actionTable.setValueAt(data, row, col);
                    ACTION_TABLE_RELOAD=false;
                    updateXMLData("unused", testTable.getSelectedRow(), 4);
                }
                }
            });
            }
            
            DefaultTableModel actionModel = (DefaultTableModel) actionTables.get(i).getModel();
            actionModel.setRowCount(actions.size());
            System.out.println("adding action table: " + actionModel.getRowCount());
            for(int j=0; j<actions.size(); j++) {
                if(j+1>actionModel.getRowCount()) actionModel.addRow((Object[])null);
                actionModel.setValueAt(actions.get(j).getType(), j, 0);
                actionModel.setValueAt(actions.get(j).getData(), j, 1);
            }

            model.setValueAt(actionTables.get(i), i, 4);
            
            
            tc.setCellRenderer(new CustomTableCellRenderer(actionTables.get(i)));
            tc.setCellEditor(new CustomTableCellEditor(actionTables.get(i)));
            testTable.setRowHeight(100);
            //actionTables.get(i).addMouseMotionListener(mListener);
            // Enable the ability to select a single cell 
            actionTables.get(i).setColumnSelectionAllowed(true); 
            actionTables.get(i).setRowSelectionAllowed(true); 
            ACTION_TABLE_RELOAD = false;
            /*model.setValueAt(test.getPoint(0), i, 4);
            model.setValueAt(test.getPoint(1), i, 5);
            model.setValueAt(test.getPoint(2), i, 6);
            model.setValueAt(test.getPoint(3), i, 7);
            model.setValueAt(test.getTime(0), i, 8);
            model.setValueAt(test.getTime(1), i, 9);
            model.setValueAt(test.getTime(2), i, 10);
            model.setValueAt(test.getTime(3), i, 11);*/
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
        
        //System.out.println("changing data");
        
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
                    JTable table = actionTables.get(row);
                    ArrayList<Action> actions = new ArrayList<Action>();
                    for(int i =0; i<table.getRowCount(); i++) {
                        actions.add(new Action((String)table.getValueAt(i, 0), (String)table.getValueAt(i, 1)));
                    }
                    item.setActions(actions);
                    tests.set(row, item);
                    break;
        }
        xml.setTests(tests);
    }
    
    private void updateActionTable(int row) {
        if(row!=-1 && row<xml.getTests().size()) {
            ArrayList<Action> actions = xml.getTests().get(row).getActions();
            DefaultTableModel actionModel = (DefaultTableModel) actionTable.getModel();

            actionModel.setRowCount(actions.size());
            for(int j=0; j<actions.size(); j++) {
                actionModel.setValueAt(actions.get(j).getType(), j, 0);
                actionModel.setValueAt(actions.get(j).getData(), j, 1);
            }
        } else if(row>=xml.getTests().size()) {
            ((DefaultTableModel)actionTable.getModel()).setRowCount(0);
        }
    }
    
    private static String backup = "TestConfigBackup.xml";
    public static void saveXMLtoFile() {
        System.out.println("changed data: " + xml.getTests().get(0).getTestID());
        FileIO.xmlWrite(xml, backup);
        System.out.println("saved data");
        lastDeleted.clear();
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 4415155875184525824L;
        JTable table;
         
        CustomTableCellRenderer(JTable table){
            this.table=table;
            this.table.setOpaque(true);
            this.table.setAlignmentY(JTable.LEFT_ALIGNMENT);
        }
         
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            this.table=(JTable)value;
            return this.table;
        }
    }
    
    class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor{
 
        JTable table;
        
        CustomTableCellEditor(JTable table){
            this.table=table;
            this.table.setOpaque(true);
            this.table.setAlignmentY(JTable.LEFT_ALIGNMENT);
        }
         
        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            this.table=(JTable)value;
            return new JScrollPane(this.table);
        }
 
        @Override
        public Object getCellEditorValue() {
            return this.table;
        }
         
    }
     
    class MyMouseMotionListener implements MouseMotionListener{
         
        @Override
        public void mouseDragged(MouseEvent e) {
        }
 
        @Override
        public void mouseMoved(MouseEvent e) {
            if(e.getComponent() instanceof JTable){
                JTable tempTable = (JTable)e.getComponent();
                 
                TableColumnModel columnModel = tempTable.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column = columnModel.getColumn(viewColumn).getModelIndex();
                int row = tempTable.rowAtPoint(e.getPoint());
                 
                // change the if-statement to the columns you want to programmatically 
                // enter edit mode of, when the mouse is over it.
                if(column==0 || column==1 || column==2 || column==3 || column==4){
                    // Set the cell on the row and column in edit mode 
                    boolean success = tempTable.editCellAt(row, column);
                    if (success) {
                      boolean toggle = false;
                      boolean extend = false;
                      // Select cell 
                      tempTable.changeSelection(row, column, toggle, extend);
                    }
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable actionTable;
    private javax.swing.JButton addActionButton;
    private javax.swing.JButton addTestButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton delActionButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField functionField;
    private javax.swing.JButton generateButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pathField;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton savetoXML;
    private javax.swing.JTextField targetField;
    private javax.swing.JTextField templateField;
    private javax.swing.JTable testTable;
    private javax.swing.JButton undoDeleteButton;
    private javax.swing.JButton undoSave;
    private javax.swing.JTextField xmlPath;
    // End of variables declaration//GEN-END:variables
}
