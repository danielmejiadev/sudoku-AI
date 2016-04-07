
package Sudoku;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;


public class Vista extends javax.swing.JFrame {
    
    public static int[] numeros;
    private JTextField[] campos = new JTextField[81];
    SudokuIA sudokuIA = new SudokuIA();
    
    public Vista() {
        initComponents();
        jPanelContenedor.setLayout(new GridLayout(9, 9));
        agregarMatriz();
        this.add(jPanelContenedor);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public Vista(int[] numbers) {
        initComponents();
        jPanelContenedor.setLayout(new GridLayout(9, 9));
        agregarMatrizNumeros(numbers);
        this.add(jPanelContenedor);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemReiniciar = new javax.swing.JMenuItem();
        jMenuItemCargar = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuItemJuegaMaquina = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku - IA");

        jPanelContenedor.setBackground(new java.awt.Color(153, 153, 153));
        jPanelContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jMenuArchivo.setText("Archivo");

        jMenuItemReiniciar.setText("Reiniciar");
        jMenuItemReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReiniciarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemReiniciar);

        jMenuItemCargar.setText("Cargar");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemCargar);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuOpciones.setText("Opciones");

        jMenuItemJuegaMaquina.setText("Juega Máquina");
        jMenuItemJuegaMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJuegaMaquinaActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemJuegaMaquina);

        jMenuBar1.add(jMenuOpciones);

        jMenuAyuda.setText("Ayuda");

        jMenuItemAcercaDe.setText("Acerca de");
        jMenuAyuda.add(jMenuItemAcercaDe);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarActionPerformed
        CargarSudoku cargarSudoku = new CargarSudoku(this, true);
        cargarSudoku.setVisible(true);
        while (cargarSudoku.isVisible()) {            
            
        }
        refrescar();
        
    }//GEN-LAST:event_jMenuItemCargarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReiniciarActionPerformed
        refrescar();
    }//GEN-LAST:event_jMenuItemReiniciarActionPerformed

    private void jMenuItemJuegaMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJuegaMaquinaActionPerformed
        juegaMaquina();
    }//GEN-LAST:event_jMenuItemJuegaMaquinaActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    
    public void agregarMatriz(){
        for (int i = 0; i < 81; i++) {
            campos[i] = new JTextField("");
            campos[i].setFont(new Font("tahoma", 1, 36));
            campos[i].setHorizontalAlignment(JTextField.CENTER);
            campos[i].setFocusable(false);
            jPanelContenedor.add(campos[i]);
        }
    }
    
    public void agregarMatrizNumeros(int[] num){
        for (int i = 0; i < 81; i++){
            if(num[i]==0){
                 campos[i] = new JTextField("");
            }else{
                 campos[i] = new JTextField(num[i]+"");
            }
            campos[i].setFont(new Font("tahoma", 1, 36));
            campos[i].setHorizontalAlignment(JTextField.CENTER);
            jPanelContenedor.add(campos[i]);
        }
        jPanelContenedor.setLayout(new GridLayout(9, 9));
        this.add(jPanelContenedor);
    }
    
    public int[] convertirMatriz(int[][] matriz){
       int[] retorno = new int[81];
        for (int i = 0, k=0; i < 9; i++) {
            for (int j = 0; j < 9; j++, k++) {
                retorno[k] = matriz[i][j];
                
            }
            
        }
        return retorno;
    }
    
    public int[][] convertirArreglo(int[] arreglo){
        int[][] retorno = new int[9][9];
        for (int i = 0, k = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++, k++) {
                retorno[i][j] = arreglo[k];
            }
            
        }
        return retorno;
    }
    
    public void juegaMaquina(){
        int[] copiaNumeros = numeros;
        int[][] matrizSolucion = sudokuIA.aplicarAlgoritmoAvara(convertirArreglo(copiaNumeros));
        Vista vp = new Vista(convertirMatriz(matrizSolucion));
        this.setVisible(false);
        vp.setVisible(true);
    }
    
    public void refrescar(){
        this.setVisible(false);
        Vista vp = new Vista(numeros);
        vp.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAcercaDe;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemJuegaMaquina;
    private javax.swing.JMenuItem jMenuItemReiniciar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuOpciones;
    public javax.swing.JPanel jPanelContenedor;
    // End of variables declaration//GEN-END:variables
}
