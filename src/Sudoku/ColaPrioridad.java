package Sudoku;

import java.util.ArrayList;
import java.util.List;

public class ColaPrioridad {
    
     List<Nodo> colaPrioridad;
    
    public ColaPrioridad()
    {
        colaPrioridad=new ArrayList<>();
    }
        
    public boolean igualMatriz(int[][] matriz1, int[][]matriz2)
    {
        boolean valor=true;
        for(int fila=0;fila<matriz1.length;fila++)
        {
            for(int columna=0;columna<matriz1.length;columna++)
            {
                if(matriz1[fila][columna]!=matriz2[fila][columna])
                {
                    valor=false;
                    columna=matriz1.length;
                    fila=matriz1.length;
                }
            }
        }
        return valor;
    }
    
    public boolean  existeNodo(Nodo nodo)
    {
        boolean valor=false;
        int [][] matriz1;
        int [][] matriz2 = nodo.getMatriz();
        Heuristica h1;
        Heuristica h2 = nodo.getHeuristica();
        for(int i=0;i<colaPrioridad.size();i++)
        {
            matriz1=colaPrioridad.get(i).getMatriz();
            h1=colaPrioridad.get(i).getHeuristica();
            if((igualMatriz(matriz1, matriz2)) && (h1.getValor()==h2.getValor()))
            {
                valor=true;
                i=colaPrioridad.size();
            }
        }
        return valor;
    }
		
    public Nodo desencolar()
    {
        Nodo nodo = null;
        if(!colaPrioridad.isEmpty())
        {
            nodo=colaPrioridad.get(0);
            colaPrioridad.remove(0);
        }
        
        return nodo;
    }

    
    public void encolar(Nodo nodo)
    {
        if(colaPrioridad.isEmpty())
        {
            colaPrioridad.add(nodo);
        }
        else
        {
            if(!existeNodo(nodo))
            {
                int posicion_a_ingresar = 0;
                int i=0;
                while(i < colaPrioridad.size())
                {
                    if(nodo.getHeuristica().getValor()<colaPrioridad.get(posicion_a_ingresar).getHeuristica().getValor())
                    {
                        i=colaPrioridad.size();
                    }
                    else
                    {
                        posicion_a_ingresar++;
                        i++;
                    }
                }
                
                colaPrioridad.add(posicion_a_ingresar,nodo);  
            }
        }
    }
    
}
