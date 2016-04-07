package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class Casilla extends JLabel {
   
    public Casilla() 
    {
        super("", CENTER);     
        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }

  
    public void setNumero(int numero, boolean entrada) 
    {
        setForeground(entrada ? Color.BLUE : Color.BLACK);
        setText(numero > 0 ? numero + "" : "");
    }

}