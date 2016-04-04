
package Sudoku;


public class Heuristica {
    
    private String tipo;
    private int indice;
    private int valor;

    public Heuristica(String tipo, int indice, int valor)
    {
        this.tipo = tipo;
        this.indice = indice;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
}
