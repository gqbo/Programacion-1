public class ArraysIgualesRec {

    boolean respuesta;

    public boolean vectPrac(int[] arrayA, int[] arrayB, int indice){

        if((indice == arrayA.length)){
           return respuesta;
        } 

        if(arrayA[indice] == arrayB[indice]){
            respuesta = true;
            vectPrac(arrayA, arrayB, indice+1);
        }else{
            respuesta = false;
            return respuesta;   
        }
        return respuesta;
    }

    
    public static void main(String [] args){
        ArraysIgualesRec prueba = new ArraysIgualesRec();
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};
        boolean resultado = prueba.vectPrac(array1, array2, 0);
        System.out.println(resultado);
    }
}
