package Vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class SudokuPanel extends JPanel  {

    private Casilla[][] casilla;       
    private JPanel[][] panel;      

    public SudokuPanel() 
    {
        super(new GridLayout(3, 3));

        panel = new JPanel[3][3];
        for (int y = 0; y < 3; y++) 
        {
            for (int x = 0; x < 3; x++) {
                panel[y][x] = new JPanel(new GridLayout(3, 3));
                panel[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                add(panel[y][x]);
            }
        }

        casilla = new Casilla[9][9];
        for (int y = 0; y < 9; y++) 
        {
            for (int x = 0; x < 9; x++) 
            {
                casilla[y][x] = new Casilla();
                panel[y / 3][x / 3].add(casilla[y][x]);
            }
        }
    }

    public Casilla[][] getCasillas() 
    {
        return casilla;
    }

    public void setCasillas(Casilla[][] fields) 
    {
        this.casilla = fields;
    }

   
}