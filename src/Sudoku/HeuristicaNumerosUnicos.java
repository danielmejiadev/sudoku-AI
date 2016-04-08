
package Sudoku;

import java.util.ArrayList;
import java.util.List;


public class HeuristicaNumerosUnicos {
    
    public List<Integer> numerosFila(int fila,int[][]matriz)
    {
        List<Integer> numeros = new ArrayList<>();
        for(int i=0;i<matriz.length;i++)
        {
                if(matriz[fila][i]!=0)
                {
                   numeros.add(matriz[fila][i]);
                }
        } 
        
        return numeros;
    }
    
    public List<Integer> numerosColumna(int columna,int[][]matriz)
    {
        List<Integer> numeros = new ArrayList<>();
        for(int i=0;i<matriz.length;i++)
        {
                if(matriz[i][columna]!=0)
                {
                   numeros.add(matriz[i][columna]);
                }
        } 
        
        return numeros;
    }
    
    public List<Integer> numerosCaja(int fila, int columna,int[][]matriz)
    {
        List<Integer> numeros = new ArrayList<>();
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        
        if(fila >= 0 && fila < 3)
        {
            minimo_fila = 0;
            maximo_fila = 2;
        }
        else 
        {
            if(fila>=3 && fila < 6)
            {
              minimo_fila = 3;
              maximo_fila = 5;  
            }
            else
            {
               minimo_fila = 6;
               maximo_fila = 8;
            }
        }

        if(columna >= 0 && columna < 3)
        {
            minimo_columna = 0;
            maximo_columna = 2;
        }
        else 
        {
            if(columna>=3 && columna < 6)
            {
              minimo_columna = 3;
              maximo_columna = 5;  
            }
            else
            {
               minimo_columna = 6;
               maximo_columna = 8;
            }
        }
        
        for (int f = minimo_fila; f <= maximo_fila; f++ )
        {
             for (int c = minimo_columna; c <= maximo_columna; c++)
             {
                 if ( matriz[f][c] != 0 )
                 {
                     numeros.add(matriz[f][c]);
                 }  
             }
        }   
        
        return numeros;
    }
     
    public List<Integer> numerosFaltanFilaColumnaCaja(int fila, int columna, int[][]matriz)
    {
        List<Integer> numerosFaltanFilaColumnaCaja = new ArrayList<>();
        if(matriz[fila][columna]==0)
        {
            List<Integer> numerosFilaColumnaCaja = new ArrayList<>();
            List<Integer> numerosFila = numerosFila(fila, matriz);
            List<Integer> numerosColumna = numerosColumna(columna, matriz);
            List<Integer> numerosCaja = numerosCaja(fila,columna, matriz);
            numerosFilaColumnaCaja.addAll(numerosFila);
            numerosFilaColumnaCaja.addAll(numerosColumna);
            numerosFilaColumnaCaja.addAll(numerosCaja);
            for(int i=0;i<numerosFilaColumnaCaja.size();i++)
            {
                for(int j=i+1;j<numerosFilaColumnaCaja.size();j++)
                {
                    if((int)numerosFilaColumnaCaja.get(i)==(int)numerosFilaColumnaCaja.get(j))
                    {
                        numerosFilaColumnaCaja.remove(j);
                        j=numerosFilaColumnaCaja.size();
                    }
                }
            }

            for(int numero=1;numero<=9;numero++)
            {
                if(!numerosFilaColumnaCaja.contains((Integer)numero))
                {
                    numerosFaltanFilaColumnaCaja.add(numero);
                }
            }
        }
        return numerosFaltanFilaColumnaCaja;
    }
       
    
    public Posibilidad posicionUnicas(int[][]matriz)
    {
        Posibilidad posible = null;
        for(int i=0;i<matriz.length;i++)
        {
            for(int j=0;j<matriz.length;j++)
            {
                if(numerosFaltanFilaColumnaCaja(i, j, matriz).size()==1)
                {
                     posible = new Posibilidad(numerosFaltanFilaColumnaCaja(i, j, matriz).get(0), i, j);
                     i=matriz.length;
                     j=matriz.length;
                }
            }
        }
               
        return posible;
    }
        
     
     
    public int[][] heuristicaNumerosUnicos(int[][]matrizExpandir)
    {
        Posibilidad unico = posicionUnicas(matrizExpandir);
        while(unico != null)
        { 
            int fila=unico.getFila();
            int columna=unico.getColumna();
            int numero=unico.getNumero();
            matrizExpandir[fila][columna]=numero;
            unico = posicionUnicas(matrizExpandir);
        }
        return matrizExpandir;
    }
    
}
