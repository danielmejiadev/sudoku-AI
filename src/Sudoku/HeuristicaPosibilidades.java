
package Sudoku;

import java.util.ArrayList;
import java.util.List;

public class HeuristicaPosibilidades {
    
      /*Metodo que verifica si un numero ya esta dentro de una fila
    Parametros: 
                int numero -> numero a verificar, 
                int fila   -> fila que se desea evaluar, 
                int [][] matriz -> matriz de la cual se evaluara la fila
    Salida:
            true-> Si el numero ya esta dentro de la fila
            false-> si el numero no esta dentro de la fila
    */
    public boolean existeFila(int numero, int fila, int[][]matriz)
    {  
        boolean valorVerdad = false;

        for ( int i = 0; i < matriz.length; i ++ )
        {
            if ( matriz[fila][i] == numero)
            {
                 valorVerdad = true;
                 break;
            }   
        }        
        return valorVerdad; 
    }
    
    /*Metodo que verifica si un numero ya esta dentro de una columna
    Parametros: 
                int numero -> numero a verificar, 
                int columna  -> columna que se desea evaluar, 
                int [][] matrix -> matrix de la cual se evaluara la columna
    Salida:
            true-> Si el numero ya esta dentro de la columna
            false-> si el numero no esta dentro de la columna
    */
    public boolean existeColumna(int numero, int columna, int[][]matrix)
    {
        boolean valorVerdad = false;

        for ( int i = 0; i < matrix.length; i ++ )
        {
            if ( matrix[i][columna] == numero)
            {
                 valorVerdad = true;
                 break;
            }   
        }        
        return valorVerdad; 
    }
     
    /*Metodo que verifica si un numero ya esta dentro de una caja 
    Parametros: 
                int numero -> numero a verificar, 
                int fila   -> fila perteneciente a la caja que se desea evaluar
                int columa -> columna perteneciente a la caja que se desea evaluar
                int [][] matriz -> matriz de la cual se evaluara la caja
    Salida:
            true-> Si el numero ya esta dentro de la caja
            false-> si el numero no esta dentro de la caja
    */
    public boolean existeCaja (int numero, int fila, int columna, int[][] matrix)
    {
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean valorVerdad = false;

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
                 if ( matrix[f][c] == numero )
                 {
                      valorVerdad = true;
                      break; 
                 }  
             }
        }   
        return valorVerdad;
    }
    
    /*Metodo que verifica si un numero existe en una fila, columna o caja
    Parametros: 
                int numero -> numero a verificar, 
                int fila   -> fila 
                int columa -> columna 
                int [][] matriz -> matriz que se evaluara
    Salida:
            true-> Si el numero ya esta dentro de la fila y la columna y la caja
            false-> si el numero no esta dentro de la fila y la columna y la caja
    */
    public boolean existeFilaColumnaCaja(int numero, int fila, int columna, int[][]matrix)
    {
        boolean valorVerdad = true;
        if(!existeFila(numero,fila,matrix) && 
           !existeColumna(numero, columna, matrix) && 
           !existeCaja(numero, fila, columna, matrix))
        {
            valorVerdad=false;
        }
        return valorVerdad;
    }
    
    /*Metodo que evalua todas las posibilidadades de los numeros del 1 al 9 dentro de una fila
    Parametros: 
                int fila   -> fila que se desea evaluar
                int [][] matriz -> matriz de la cual se evaluara la fila
    Salida:
            List<Posibilidad>-> una lista de todas las posibilidades, donde una posibilidad es:
                                fila-> fila de la posibilidad
                                columna-> columna de la posibilidad
                                numero-> numero que puede ir dentro de la fila y la columna
    */
    public List<Posibilidad> posibilidadesFila(int fila, int[][] matrix)
    {
        List<Posibilidad> posibles = new ArrayList<>();
        
        for(int numero=1;numero<9;numero++)
        {
            for(int columna=0;columna<matrix.length;columna++)
            {
                if(matrix[fila][columna]==0)
                {
                    if(!existeFilaColumnaCaja(numero,fila,columna,matrix))
                    {
                        Posibilidad posible = new Posibilidad(numero,fila,columna);
                        posibles.add(posible);
                    }
                }
            } 
        }
        return posibles;
    }
    
    /*Metodo que evalua todas las posibilidadades de los numeros del 1 al 9 dentro de una columna
    Parametros: 
                int columna   -> columna que se desea evaluar
                int [][] matriz -> matriz de la cual se evaluara la columna
    Salida:
            List<Posibilidad>-> una lista de todas las posibilidades, donde una posibilidad es:
                                fila-> fila de la posibilidad
                                columna-> columna de la posibilidad
                                numero-> numero que puede ir dentro de la fila y la columna
    */
    public List<Posibilidad> posibilidadesColumna(int columna, int[][] matrix)
    {
        List<Posibilidad> posibles = new ArrayList<>();
        for(int numero=1;numero<9;numero++)
        {
            for(int fila=0;fila<matrix.length;fila++)
            {
                if(matrix[fila][columna]==0)
                {
                    if(!existeFilaColumnaCaja(numero,fila,columna,matrix))
                    {
                       Posibilidad posible = new Posibilidad(numero,fila,columna);
                       posibles.add(posible);
                    }
                }
            } 
        }
        return posibles;
    }
        
    /*Metodo que evalua todas las posibilidadades de los numeros del 1 al 9 dentro de una caja
    Parametros: 
                int caja   -> caja que se desea evaluar, donde la cajas se enumeeran de 0 a 8 de derecha a izquierda 
                int [][] matriz -> matriz de la cual se evaluara la 
    Salida:
            List<Posibilidad>-> una lista de todas las posibilidades, donde una posibilidad es:
                                fila-> fila de la posibilidad
                                columna-> columna de la posibilidad
                                numero-> numero que puede ir dentro de la fila y la columna
    */
    public List<Posibilidad> posibilidadesCaja(int caja, int[][] matrix)
    {
        List<Posibilidad> posibles = new ArrayList<>();
        int filaMinima = 0;
        int columnaMinima = 0;
        int contador=0;
        for(int i=0;i<=6;i+=3)
        {
          for(int j=0;j<=6;j+=3)
          {
            if(caja==contador)
            {
                filaMinima=i;
                columnaMinima=j;
                i=7;
                j=7;
            }
            else
            {
                contador++; 
            }
          }  
        }
          
        int filaMaxima=filaMinima+3;
        int columnaMaxima=columnaMinima+3;
       
        for(int numero=1;numero<9;numero++)
        {
            for(int fila=filaMinima; fila < filaMaxima;fila++)
            {
                for(int columna=columnaMinima;columna < columnaMaxima;columna++)
                {
                    if(matrix[fila][columna]==0)
                    {
                        if(!existeFilaColumnaCaja(numero,fila,columna,matrix))
                        {
                              Posibilidad posible = new Posibilidad(numero,fila,columna);
                              posibles.add(posible);
                        }
                    }
                }
            } 
        }
        return posibles;
    }
    
     public Heuristica filaColumnaCajaNumeroMinimoPosibilidades(int[][]matrix)
    {
        List<Heuristica> heuristicasFila = new ArrayList<>();
        List<Heuristica> heuristicasColumna = new ArrayList<>();
        List<Heuristica> heuristicasCaja = new ArrayList<>();
      
        for(int i=0;i<matrix.length;i++)
        {
            if(!posibilidadesFila(i, matrix).isEmpty())
            {
              Heuristica heuristica = new Heuristica("fila",i,posibilidadesFila(i, matrix).size());
              heuristicasFila.add(heuristica);
            }
            
            if(!posibilidadesColumna(i, matrix).isEmpty())
            {
              Heuristica heuristica = new Heuristica("columna",i,posibilidadesColumna(i, matrix).size());
              heuristicasColumna.add(heuristica);
            }
            
            if(!posibilidadesCaja(i, matrix).isEmpty())
            {
              Heuristica heuristica = new Heuristica("caja",i,posibilidadesCaja(i, matrix).size());
              heuristicasCaja.add(heuristica);
            }
        }
       
        Heuristica resultado;
        if(!heuristicasFila.isEmpty() && !heuristicasColumna.isEmpty() && !heuristicasCaja.isEmpty())
        {
            Heuristica minimoFila=heuristicasFila.get(0);
            for(int i=1;i<heuristicasFila.size();i++)
            {
                if(heuristicasFila.get(i).getValor()<minimoFila.getValor())
                {          
                    minimoFila=heuristicasFila.get(i);
                }      
            } 

            Heuristica minimoColumna=heuristicasColumna.get(0);
            for(int i=1;i<heuristicasColumna.size();i++)
            {
                if(heuristicasColumna.get(i).getValor()<minimoColumna.getValor())
                {          
                    minimoColumna=heuristicasColumna.get(i);
                }      
            } 

            Heuristica minimoCaja=heuristicasCaja.get(0);
            for(int i=1;i<heuristicasCaja.size();i++)
            {
                if(heuristicasCaja.get(i).getValor()<minimoCaja.getValor())
                {          
                    minimoCaja=heuristicasCaja.get(i);
                }      
            } 

            if(minimoFila.getValor()<=minimoColumna.getValor() && minimoFila.getValor()<=minimoCaja.getValor())
            {
                resultado= minimoFila;
            }
            else
            {
                if(minimoColumna.getValor()<=minimoCaja.getValor())
                {
                    resultado=minimoColumna;
                }
                else
                {
                    resultado=minimoCaja;
                }
            } 
        }
        else
        {
           resultado = new Heuristica("FIN", -1, 0);
        }
        return resultado;
    }
    
}
