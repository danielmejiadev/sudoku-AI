
package Vista;

import Sudoku.CargarSudoku;
import Sudoku.SudokuIA;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Vista extends javax.swing.JFrame {
    
    private int[][] matrizInicial;
    SudokuIA sudokuIA;
    SudokuPanel sudokuPanel;
    
    
    public Vista() 
    {
        initComponents(); 
        sudokuPanel = new SudokuPanel();
        sudokuIA = new SudokuIA();
        
        jPanelContenedor.setLayout(new BorderLayout());
        jPanelContenedor.add(sudokuPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }
    
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        cargar = new javax.swing.JButton();
        resolver = new javax.swing.JButton();
        relojLabel = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku - IA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUDOKU ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 180, -1));

        jPanelContenedor.setBackground(new java.awt.Color(153, 153, 153));
        jPanelContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 360, 360));

        cargar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cargar.setText("Cargar ");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });
        getContentPane().add(cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 120, 40));

        resolver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resolver.setText("Resolver ");
        resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resolverActionPerformed(evt);
            }
        });
        getContentPane().add(resolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 120, 40));
        getContentPane().add(relojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 50, 50, 20));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\OneDrive\\Univalle\\NetBeansProjects\\SudokuIA\\src\\fondo.jpg")); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        CargarSudoku cargarSudoku = new CargarSudoku(this, true);
        cargarSudoku.setVisible(true);
        matrizInicial=cargarSudoku.getMatrizInicial();
        llenarCamposIniciales(matrizInicial);
    }//GEN-LAST:event_cargarActionPerformed

    private void resolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resolverActionPerformed
        if(matrizInicial!=null)
        {
            resolver(matrizInicial);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Por favor, cargue un sudoku");
        }
    }//GEN-LAST:event_resolverActionPerformed

   
     public void resolver(int[][] matrizInicial)
    {
        llenarCamposSolucion(sudokuIA.aplicarAlgoritmoAvara(matrizInicial));    
    }
     
     
   
    public void llenarCamposIniciales(int[][] matriz)
    {
        Casilla[][] casillas = sudokuPanel.getCasillas();
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
               casillas[i][j].setNumero(matriz[i][j],true);
            }
        }
        sudokuPanel.setCasillas(casillas);
    }
    
    public void llenarCamposSolucion(int[][] matriz)
    {
        Casilla[][] casillas = sudokuPanel.getCasillas();
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                if(casillas[i][j].getText().equals(""))
                {
                   casillas[i][j].setNumero(matriz[i][j],false);
                }
            }
        }
        sudokuPanel.setCasillas(casillas);
    }

    public JLabel getRelojLabel() {
        return relojLabel;
    }

    public void setRelojLabel(JLabel relojLabel) {
        this.relojLabel = relojLabel;
    }
    
    
    
    public static void main(String args[])
    {
        
               Vista vista = new Vista();
               vista.setVisible(true);   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanelContenedor;
    private javax.swing.JLabel relojLabel;
    private javax.swing.JButton resolver;
    // End of variables declaration//GEN-END:variables
}
