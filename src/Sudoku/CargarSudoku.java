
package Sudoku;

import Vista.Vista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CargarSudoku extends javax.swing.JDialog {

    Vista parent;
    int[][] matrizInicial = new int[9][9];
    
    public CargarSudoku(Vista parent, boolean modal) 
    {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto", "txt");
        jFileChooser1.setFileFilter(filtro);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\Documents"));
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        JFileChooser selector = (JFileChooser)evt.getSource();
        String boton = evt.getActionCommand();
        if(boton.equals(JFileChooser.APPROVE_SELECTION)){
            File archivoseleccionado = selector.getSelectedFile();
            
            try {
                FileReader fr = new FileReader(archivoseleccionado);
                BufferedReader br = new BufferedReader(fr);
                matrizInicial = tomarDatos(br);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CargarSudoku.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CargarSudoku.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
        }else
        {
            if(boton.equals(JFileChooser.CANCEL_SELECTION)){
                JOptionPane.showMessageDialog(rootPane, "Acción Cancelada");
                
            }
        }
        this.setVisible(false);
        
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed
    
    public int[][] getMatrizInicial()
    {
        return matrizInicial;
    }

    public int[][] tomarDatos(BufferedReader bf ) throws IOException
    {
        int[][] datos = new int[9][9];
        for (int i = 0; i < 9; i++) 
        {
            String s = bf.readLine();
            for (int j = 0; j < 9; j++) 
            {
                datos[i][j] = s.charAt(j)-48;
            }
        }
        return datos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
