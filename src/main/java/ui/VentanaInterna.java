/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;

/**
 *
 * @author izyde
 */
public class VentanaInterna extends javax.swing.JInternalFrame {
    JFileChooser fc = new JFileChooser();
    
    /**
     * Creates new form VentanaInterna
     */
    public VentanaInterna() {
        initComponents();
        this.Base();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new ui.ImagePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveImage = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closeWindow = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        umbraOption = new javax.swing.JMenuItem();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        saveImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveImage.setText("Guardar");
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });
        jMenu1.add(saveImage);
        jMenu1.add(jSeparator1);

        closeWindow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        closeWindow.setText("Cerrar");
        closeWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindowActionPerformed(evt);
            }
        });
        jMenu1.add(closeWindow);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        umbraOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        umbraOption.setText("Umbrar");
        umbraOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbraOptionActionPerformed(evt);
            }
        });
        jMenu2.add(umbraOption);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageActionPerformed
        int res = fc.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            imagePanel.SaveImage(fichero);
        }
    }//GEN-LAST:event_saveImageActionPerformed

    private void closeWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindowActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres cerrar esta ventana?", "Cerrar", JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_closeWindowActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres cerrar esta ventana?", "Cerrar", JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void umbraOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbraOptionActionPerformed
         String res = JOptionPane.showInputDialog(rootPane, "Introduzca un valor de umbralizado", "Umbralizado", JOptionPane.QUESTION_MESSAGE);
        
        if(res != null){
            try {
                int um = Integer.parseInt(res);
                Mat img = imagePanel.Umbrar(um);
                VentanaInterna ventana = new VentanaInterna();
                ventana.setTitle(imagePanel.GetName() + "-" + um);
                this.getDesktopPane().add(ventana);
                ventana.setLocation(new Point(60,60));
                ventana.getImagePanel().SetMat(img);
                ventana.setVisible(true);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(rootPane, "Introduzca un valor entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_umbraOptionActionPerformed

    private void Base() {
        this.setPreferredSize(new Dimension(100,80));
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setResizable(true);
    }
    
    public ImagePanel getImagePanel(){
        return imagePanel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeWindow;
    private ui.ImagePanel imagePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem saveImage;
    private javax.swing.JMenuItem umbraOption;
    // End of variables declaration//GEN-END:variables
}
