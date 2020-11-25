public class BuscarElementoRec {

    public int buscarElemento(int[] v, int e, int c){
        int direccion = -1;

        if(c<v.length){
            if(v[c]==e){
                direccion = c;
                return direccion;
            } 
        }
        return buscarElemento(v, e, c+1);
    }

    public static void main(String[] arg){
        BuscarElementoRec prueba = new BuscarElementoRec();
        int[] arreglo = {1,2,3,4,5,6,7,8,9};
        int indice = prueba.buscarElemento(arreglo, 3, 0);
        System.out.println("El elemento 3 esta en la posicion: "+ indice);
    }
}

