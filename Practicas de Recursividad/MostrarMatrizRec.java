public class MostrarMatrizRec {

    public void mostrarMatriz(int [][] matriz, int f, int c){

        System.out.print(matriz[f][c]+" ");

        if(f != matriz.length-1 || c != matriz[f].length-1){

            if(c == matriz.length-1){
                f++;
                c=0;
                System.out.println("");
            }else{
                c++;
            }
            mostrarMatriz(matriz, f, c);
        }

    }

    public static void main(String [] args){
        MostrarMatrizRec prueba = new MostrarMatrizRec();
        int [][] matriz = {
            {7,5,3},
            {5,7,0},
            {3,4,1}
        };
        prueba.mostrarMatriz(matriz, 0,0);
        



    }
    
}
