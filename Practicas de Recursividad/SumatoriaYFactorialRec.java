public class SumatoriaYFactorialRec {

    public int sumaRecursiva(int numero){

        if(numero == 1){
            return 1;
        }else{
            return numero + sumaRecursiva(numero-1);
        }
    }

    public int factorialRecursivo(int n){

        if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursivo(n-1);
        }
    }
    
    public static void main(String [] args){

        SumatoriaYFactorialRec prueba = new SumatoriaYFactorialRec();

        int n = 6;
        int resultado = prueba.sumaRecursiva(n);
        System.out.println(resultado);

        System.out.println(prueba.factorialRecursivo(4));

    }
    
}
