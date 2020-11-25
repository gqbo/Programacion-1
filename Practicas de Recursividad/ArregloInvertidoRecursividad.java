public class ArregloInvertidoRecursividad {

    public void arregloInvertido(int [] array, int indice){

        if(indice != array.length){
            arregloInvertido(array, indice+1);
            System.out.print(array[indice]+" ");
        }
    }

    public static void main(String [] args){
        ArregloInvertidoRecursividad prueba = new ArregloInvertidoRecursividad();
        int [] array = {1,2,3,4,5};
        prueba.arregloInvertido(array, 0);
    }
    
}
