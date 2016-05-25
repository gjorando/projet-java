/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.delarousse.views;

import com.asinfo.delarousse.models.DB;
import com.asinfo.delarousse.models.ExpressionDelahochienne;
import com.asinfo.delarousse.controllers.ListDataControl;
import java.awt.Color;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Clément
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        
        openMenu = new JFileChooser("../DB");
        openMenu.setFileFilter(new DBFileFilter());
        openMenu.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        manageDBLoading();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        entriesList = new javax.swing.JList<>();
        expressionLabel = new javax.swing.JLabel();
        meaningLabel = new javax.swing.JLabel();
        expressionField = new javax.swing.JTextField();
        meaningField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delarousse interactif");
        setResizable(false);

        entriesList.setModel(new ListDataControl());
        entriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                entriesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(entriesList);

        expressionLabel.setText("Expression");

        meaningLabel.setText("Signification");

        expressionField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                expressionFieldKeyTyped(evt);
            }
        });

        meaningField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                meaningFieldKeyTyped(evt);
            }
        });

        deleteButton.setText("Supprimer");
        deleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modifier");
        modifyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                modifyButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("Fichier");

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        loadMenuItem.setText("Ouvrir");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(meaningLabel)
                            .addComponent(expressionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expressionField)
                            .addComponent(meaningField, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(expressionLabel)
                            .addComponent(expressionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meaningLabel)
                            .addComponent(meaningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(modifyButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_entriesListValueChanged
    {//GEN-HEADEREND:event_entriesListValueChanged
        expressionLabel.setForeground(Color.black);
        meaningLabel.setForeground(Color.black);
                
        if(entriesList.getSelectedIndex() >= 0)
        {
            ExpressionDelahochienne exp = ((ListDataControl)entriesList.getModel()).getEntryAt(entriesList.getSelectedIndex());
            expressionField.setText(exp.getExpression());
            meaningField.setText(exp.getMeaning());
            modifyButton.setEnabled(true);
            expressionField.setEnabled(true);
            meaningField.setEnabled(true);
            activeIndex = exp.getId();
        }
        if(entriesList.getSelectedIndex() == -1)
        {
            modifyButton.setEnabled(false);  
            expressionField.setEnabled(false);
            meaningField.setEnabled(false);
            activeIndex = -2;
        }
    }//GEN-LAST:event_entriesListValueChanged

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadMenuItemActionPerformed
        manageDBLoading();
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
        ((ListDataControl)entriesList.getModel()).deleteEntryAt(entriesList.getSelectedIndex());
        entriesList.repaint();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modifyButtonActionPerformed
    {//GEN-HEADEREND:event_modifyButtonActionPerformed
        ((ListDataControl)entriesList.getModel()).updateEntryAt(entriesList.getSelectedIndex(), expressionField.getText(), meaningField.getText());
        expressionLabel.setForeground(Color.black);
        meaningLabel.setForeground(Color.black);
        entriesList.setSelectedIndex(((ListDataControl)entriesList.getModel()).getListIndexFromDBIndex(activeIndex));
        entriesList.repaint();
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void expressionFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_expressionFieldKeyTyped
    {//GEN-HEADEREND:event_expressionFieldKeyTyped
        expressionLabel.setForeground(Color.red);
    }//GEN-LAST:event_expressionFieldKeyTyped

    private void meaningFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_meaningFieldKeyTyped
    {//GEN-HEADEREND:event_meaningFieldKeyTyped
        meaningLabel.setForeground(Color.red);
    }//GEN-LAST:event_meaningFieldKeyTyped

    private void manageDBLoading()
    {
        modifyButton.setEnabled(false);
        expressionLabel.setForeground(Color.black);
        meaningLabel.setForeground(Color.black);
        meaningField.setEnabled(false);
        expressionField.setEnabled(false);
        activeIndex = -2;
        
        int result = openMenu.showDialog(this, "Charger");
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = openMenu.getSelectedFile();
            if(DB.getConnection() != null) try {
                if(!DB.getConnection().isClosed()) DB.closeConnection();
            }
            catch (SQLException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                DB.createConnection(file.getAbsolutePath());
                entriesList.setModel(new ListDataControl());
                expressionField.setText("");
                meaningField.setText("");
            }
            catch (ClassNotFoundException | SQLException ex)
            {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private JFileChooser openMenu;
    int activeIndex;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> entriesList;
    private javax.swing.JTextField expressionField;
    private javax.swing.JLabel expressionLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JTextField meaningField;
    private javax.swing.JLabel meaningLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton modifyButton;
    // End of variables declaration//GEN-END:variables
}
