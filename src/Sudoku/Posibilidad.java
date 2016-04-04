
package Sudoku;

public class Posibilidad {
    
    private int numero;
    private int fila;
    private int columna;
    
  
    public Posibilidad(int numero, int fila, int columna) 
    {
        this.numero = numero;
        this.fila = fila;
        this.columna = columna;
    }
    
  
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

 
   
    
    
    
    
    
          
    
}
