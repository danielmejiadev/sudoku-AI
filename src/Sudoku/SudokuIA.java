package Sudoku;

import java.util.List;

public class SudokuIA {
    
    HeuristicaPosibilidades heuristicaPosibilidades=new HeuristicaPosibilidades();
    HeuristicaNumerosUnicos heuristicaNumerosUnicos=new HeuristicaNumerosUnicos();


    public int[][] copiarMatriz(int[][]matriz)
    {
        int[][] matrizNueva=new int[9][9];
        for(int i=0;i<matriz.length;i++)
        {
            for(int j=0;j<matriz.length;j++)
            {
                matrizNueva[i][j]=matriz[i][j];
            }
        }
        return matrizNueva;
    }
    
    
    public boolean todasCasillasLlenas(int[][]matriz)
    {
        boolean valor = true;
        for(int fila=0;fila<matriz.length;fila++)
        {
            for(int columna=0;columna<matriz.length;columna++)
            {
                if(matriz[fila][columna]==0)
                {
                    valor=false;
                }
            }
        }
        return valor;
    }
    
    
    public int[][] aplicarAlgoritmoAvara(int[][] matrizInicial)
    {
      Heuristica heuristicaInicial = heuristicaPosibilidades.filaColumnaCajaNumeroMinimoPosibilidades(matrizInicial);
      Nodo raiz=new Nodo();
      raiz.setMatriz(matrizInicial);
      raiz.setHeuristica(heuristicaInicial);
      
      ColaPrioridad colaPrioridad = new ColaPrioridad();
      colaPrioridad.encolar(raiz);
      
      Nodo nodoExpandir;
      int[][] matrizExpandir;
      Heuristica heuristicaExpandir;
                
      boolean jugar=true;
      int[][] matrizSolucion =  null;
      
      while(jugar)
      {      
        nodoExpandir=colaPrioridad.desencolar();
        if(nodoExpandir!=null)
        {
            matrizExpandir=heuristicaNumerosUnicos.heuristicaNumerosUnicos(nodoExpandir.getMatriz());
            heuristicaExpandir = heuristicaPosibilidades.filaColumnaCajaNumeroMinimoPosibilidades(matrizExpandir);
            matrizSolucion=matrizExpandir;
            
            if(heuristicaExpandir.getValor()==0)
            {   
                if(todasCasillasLlenas(matrizExpandir))
                {
                    jugar=false;
                }
            }
            else
            {
                List<Posibilidad> posibilidades;
                if(heuristicaExpandir.getTipo().equals("fila"))
                {
                  posibilidades = heuristicaPosibilidades.posibilidadesFila(heuristicaExpandir.getIndice(),nodoExpandir.getMatriz()); 
                }
                else
                {
                    if(heuristicaExpandir.getTipo().equals("columna"))
                    {
                        posibilidades = heuristicaPosibilidades.posibilidadesColumna(heuristicaExpandir.getIndice(),nodoExpandir.getMatriz());
                    }
                    else
                    {
                       posibilidades = heuristicaPosibilidades.posibilidadesCaja(heuristicaExpandir.getIndice(),nodoExpandir.getMatriz());
                    }    
                }

                for(int i=0;i<posibilidades.size();i++)
                {
                    int fila=posibilidades.get(i).getFila();
                    int columna=posibilidades.get(i).getColumna();
                    int numero=posibilidades.get(i).getNumero();
                    int[][] matriz = copiarMatriz(matrizExpandir);
                    matriz[fila][columna]=numero;
                    Heuristica heuristica = heuristicaPosibilidades.filaColumnaCajaNumeroMinimoPosibilidades(matriz);
                    Nodo nodoHijo= new Nodo(nodoExpandir,matriz,heuristica);
                    colaPrioridad.encolar(nodoHijo);
                }   
            }
        }
        else
        {
           System.out.println("No tiene solucion, sudoku mal diseñado");
           jugar=false;
        }
        
      }
      return matrizSolucion;
    }
    
//    public static void main(String[] args) 
//    {
//        SudokuIA sudoku = new SudokuIA(); 
//        int[][] matrizSolucion = sudoku.aplicarAlgoritmoAvara();
//        
//        String a="";
//        System.out.println(a); 
//        a="";
//        for(int i=0;i<9;i++)
//        {
//            for(int j=0;j<9;j++)
//            {
//                a+=" "+matrizSolucion[i][j];
//            }
//            System.out.println(a); 
//            a="";
//        }
//       
//    }
    
}