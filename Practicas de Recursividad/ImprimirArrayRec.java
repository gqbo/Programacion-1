public class ImprimirArrayRec{

    public int elementosVector(int[] array, int indice){
        if(indice == array.length){
            return 0;
        }else{
            System.out.print(array[indice]);
            System.out.print(" ");
            return elementosVector(array, indice+1);
        }

    }

    public static void main(String [] args){
        ImprimirArrayRec prueba = new ImprimirArrayRec();
        int[] array = {3,6,7,12,32,45};
        prueba.elementosVector(array, 0);
    }
}
