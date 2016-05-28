/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.delarousse.views;

import com.asinfo.delarousse.models.DB;
import com.asinfo.delarousse.models.ExpressionDelahochienne;
import com.asinfo.delarousse.controllers.ListDataControl;
import com.asinfo.delarousse.models.ImageBlobManager;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

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
        openMenu.setMultiSelectionEnabled(false);
        imageMenu = new JFileChooser();
        imageMenu.setFileFilter(new ImageFileFilter());
        imageMenu.setFileSelectionMode(JFileChooser.FILES_ONLY);
        imageMenu.setMultiSelectionEnabled(false);
        imageMenu.setAcceptAllFileFilterUsed(false);
        entriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
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
        addButton = new javax.swing.JButton();
        imagePathField = new javax.swing.JLabel();
        loadImageButton = new javax.swing.JButton();
        imagePanel = (ImagePanel) new ImagePanel(null);
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

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

        addButton.setText("Nouvelle entrée");
        addButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addButtonActionPerformed(evt);
            }
        });

        imagePathField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imagePathField.setText("jLabel1");

        loadImageButton.setText("Image...");
        loadImageButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        quitMenuItem.setText("Quitter");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

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
                            .addComponent(meaningField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addButton))
                            .addComponent(imagePathField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(meaningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imagePathField)
                            .addComponent(loadImageButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(modifyButton)
                    .addComponent(addButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriesListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_entriesListValueChanged
    {//GEN-HEADEREND:event_entriesListValueChanged
        expressionLabel.setForeground(Color.black);
        meaningLabel.setForeground(Color.black);
        modifyButton.setText("Modifier");     
        
        if(entriesList.getSelectedIndex() >= 0)
        {
            ExpressionDelahochienne exp = ((ListDataControl)entriesList.getModel()).getEntryAt(entriesList.getSelectedIndex());
            expressionField.setText(exp.getExpression());
            meaningField.setText(exp.getMeaning());
            modifyButton.setEnabled(true);
            deleteButton.setEnabled(true);
            imagePathField.setText("(blob)");
            BufferedImage tmp;
            try
            {
                tmp = ImageBlobManager.createImage(ExpressionDelahochienne.retrieveIllustration(exp.getId()));
                ((ImagePanel)imagePanel).setImg(tmp, exp.getExtension());
                if(tmp == null)
                {
                    imagePathField.setText("(aucune image)");
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((ImagePanel)imagePanel).repaint();
            expressionField.setEnabled(true);
            meaningField.setEnabled(true);
            loadImageButton.setEnabled(true);
            activeIndex = exp.getId();
        }
        if(entriesList.getSelectedIndex() == -1)
        {
            modifyButton.setEnabled(false);  
            expressionField.setEnabled(false);
            deleteButton.setEnabled(false);
            meaningField.setEnabled(false);
            expressionField.setText("");
            meaningField.setText("");
            if(activeIndex!=-1)
            {
                imagePathField.setText("(aucune sélection faite)");
                loadImageButton.setEnabled(false);

            }
            else
            {
                imagePathField.setText("(aucun fichier spécifié)");
                loadImageButton.setEnabled(true);
            }
            ((ImagePanel)imagePanel).setImg(null, "");
            ((ImagePanel)imagePanel).repaint();
            if(activeIndex!=-1) activeIndex = -2;
        }
    }//GEN-LAST:event_entriesListValueChanged

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadMenuItemActionPerformed
        manageDBLoading();
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
        ((ListDataControl)entriesList.getModel()).deleteEntryAt(entriesList.getSelectedIndex());
        entriesList.clearSelection();
        activeIndex = -2;
        ((ImagePanel)imagePanel).setImg(null, "");
        ((ImagePanel)imagePanel).repaint();
        entriesList.repaint();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modifyButtonActionPerformed
    {//GEN-HEADEREND:event_modifyButtonActionPerformed
        String errString = "";
        int hasErr = 0;
        if(expressionField.getText().isEmpty())
        {
            hasErr++;
            errString = "d'expression";
        }
        if(meaningField.getText().isEmpty())
        {
            hasErr++;
            errString+= (!errString.isEmpty()?" et ":"") + "de signification";
        }
        if(!((ImagePanel)imagePanel).isImgSet())
        {
            hasErr++;
            errString+= (!errString.isEmpty()?" et ":"") + "d'illustration";
            System.out.println("ldzfzk");
        }

        errString = "Merci de compléter " + (hasErr>1?"les champs ":"le champ ") + errString;
        
        if(hasErr == 0)
        {
            if(activeIndex >= 0)
            {
                ((ListDataControl)entriesList.getModel()).updateEntryAt(entriesList.getSelectedIndex(), expressionField.getText(), meaningField.getText(), ((ImagePanel)imagePanel).getImg(), ((ImagePanel)imagePanel).getExtension());
                expressionLabel.setForeground(Color.black);
                meaningLabel.setForeground(Color.black);
                entriesList.setSelectedIndex(((ListDataControl)entriesList.getModel()).getListIndexFromDBIndex(activeIndex));
                entriesList.repaint();
            }
            else if(activeIndex == -1)
            {
                ((ListDataControl)entriesList.getModel()).addEntry(expressionField.getText(), meaningField.getText(), ((ImagePanel)imagePanel).getImg(), ((ImagePanel)imagePanel).getExtension());
                entriesList.setModel(new ListDataControl());
                expressionField.setText("");
                ((ImagePanel)imagePanel).setImg(null, "");
                ((ImagePanel)imagePanel).repaint();
                meaningField.setText("");
                activeIndex = -2;
                entriesList.repaint();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, errString, "Certains champs sont incomplets !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void expressionFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_expressionFieldKeyTyped
    {//GEN-HEADEREND:event_expressionFieldKeyTyped
        if(activeIndex != -1) expressionLabel.setForeground(Color.red);
    }//GEN-LAST:event_expressionFieldKeyTyped

    private void meaningFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_meaningFieldKeyTyped
    {//GEN-HEADEREND:event_meaningFieldKeyTyped
        if(activeIndex != -1) meaningLabel.setForeground(Color.red);
    }//GEN-LAST:event_meaningFieldKeyTyped

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addButtonActionPerformed
    {//GEN-HEADEREND:event_addButtonActionPerformed
        activeIndex = -1; // -1 : mode d'ajout
        entriesList.clearSelection();
        modifyButton.setText("Ajouter");
        imagePathField.setText("(aucun fichier spécifié)");
        ((ImagePanel)imagePanel).setImg(null, "");
        ((ImagePanel)imagePanel).repaint();
        modifyButton.setEnabled(true);
        expressionField.setEnabled(true);
        meaningField.setEnabled(true);
        loadImageButton.setEnabled(true);
        deleteButton.setEnabled(false);
        expressionLabel.setForeground(Color.green);
        meaningLabel.setForeground(Color.green);
        expressionField.setText("");
        meaningField.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadImageButtonActionPerformed
    {//GEN-HEADEREND:event_loadImageButtonActionPerformed
        int result = imageMenu.showDialog(this, "Ouvrir");
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = imageMenu.getSelectedFile();
                
                String ext = null;
                String s = file.getName();
                int i = s.lastIndexOf('.');
                if(i > 0 && i < s.length())
                {
                    ext = s.substring(i+1).toLowerCase();
                }
                
                ((ImagePanel)imagePanel).setImg(ImageIO.read(file), ext);
                imagePanel.repaint();
                imagePathField.setText(file.getName());
            }
            catch (IOException ex)
            {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitMenuItemActionPerformed
    {//GEN-HEADEREND:event_quitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void manageDBLoading()
    {   
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
                entriesList.clearSelection();
                addButton.setEnabled(true);
                expressionField.setText("");
                meaningField.setText("");
                meaningField.setEnabled(false);
                ((ImagePanel)imagePanel).setImg(null, "");
                ((ImagePanel)imagePanel).repaint();
                expressionField.setEnabled(false);
                imagePathField.setText("(aucune sélection faite)");
                loadImageButton.setEnabled(false);
            }
            catch (ClassNotFoundException | SQLException ex)
            {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION && DB.getConnection() == null)
        {
            modifyButton.setEnabled(false);
            addButton.setEnabled(false);
            deleteButton.setEnabled(false);
            modifyButton.setText("Modifier");
            expressionLabel.setForeground(Color.black);
            meaningLabel.setForeground(Color.black);
            meaningField.setEnabled(false);
            loadImageButton.setEnabled(false);
            expressionField.setEnabled(false);
            imagePathField.setText("");
            activeIndex = -2; // -2 : aucune entrée sélectionnée
        }
    }
    
    private final JFileChooser openMenu, imageMenu;
    int activeIndex;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> entriesList;
    private javax.swing.JTextField expressionField;
    private javax.swing.JLabel expressionLabel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel imagePathField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JTextField meaningField;
    private javax.swing.JLabel meaningLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton modifyButton;
    private javax.swing.JMenuItem quitMenuItem;
    // End of variables declaration//GEN-END:variables
}
