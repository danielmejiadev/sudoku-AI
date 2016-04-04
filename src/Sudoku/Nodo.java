package Sudoku;


public class Nodo {
    
    private  Nodo padre;
    int[][] matriz;
    Heuristica heuristica;

    public Nodo()
    {
        
    }

    public Nodo(Nodo padre,int[][] matriz,Heuristica heuristica)
    {
        this.padre = padre;
        this.matriz = matriz;
        this.heuristica=heuristica;
    }
    
   
    public Nodo getPadre() 
    {
        return padre;
    }

    public void setPadre(Nodo padre) 
    {
        this.padre = padre;
    }
 
    public int[][] getMatriz()
    {
        return matriz;
    }

    public void setMatriz(int[][] matriz) 
    {
        this.matriz = matriz;
    }

    public Heuristica getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(Heuristica heuristica) {
        this.heuristica = heuristica;
    }

   
        
}
