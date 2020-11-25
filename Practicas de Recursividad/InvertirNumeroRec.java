public class InvertirNumeroRec {
    
    public int invertirNumero(int numero){

        int residuo = 0;

        if(numero == 0){
            return numero;
        }else{
            residuo = numero%10;
            numero = numero/10;
            
            System.out.print(residuo);
            return invertirNumero(numero);
        }
    }

    public static void main(String [] args){
        InvertirNumeroRec prueba = new InvertirNumeroRec();
        prueba.invertirNumero(253);
    }
}
